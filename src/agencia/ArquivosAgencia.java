package agencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArquivosAgencia {
	public static boolean SalvaAgenciaArquivo(Agencia agencia) {
		String arquivo = agencia.getNumero() + ".ser";

		criaDiretorio();

		try {
			if (agencia.getNumero() == 0)
				throw new IllegalArgumentException("Número de agência inválido.");

			if (agencia.getGerente() == null)
				throw new IllegalArgumentException("Gerente inválido.");

			FileOutputStream outputStream = new FileOutputStream("Agencias\\" + arquivo);
			ObjectOutputStream outputObject = new ObjectOutputStream(outputStream);
			outputObject.writeObject(agencia);
			outputObject.close();
			return true;
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return false;
	}

	public static Agencia RetornaAgenciaArquivo(int numero) {
		Agencia agencia;

		criaDiretorio();

		try {
			FileInputStream inputStream = new FileInputStream("Agencias\\" + numero + ".ser");
			ObjectInputStream inputObject = new ObjectInputStream(inputStream);
			agencia = (Agencia) inputObject.readObject();
			inputObject.close();
			return agencia;

		} catch (FileNotFoundException fnfe) {
			System.out.println("Agência não encontrada.\n" + fnfe.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return null;
	}

	private static void criaDiretorio() {
		File dir = new File("Agencias");
		dir.mkdir();
	}
}
