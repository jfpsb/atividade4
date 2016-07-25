package arquivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ManipulaArquivo {
	private static void CriarDiretorio(String pasta) {
		File dir = new File(pasta);
		dir.mkdir();
	}

	/**
	 * Salva em arquivo serializado o objeto passado como parâmetro.
	 * @param objeto Objeto a ser salvo.
	 * @param pasta Pasta onde arquivo irá ficar.
	 * @param nomeArquivo Nome do arquivo, geralmente a id utilizada para identificar objeto.
	 * @return Retorna True se foi salvo com sucesso.
	 */
	public static <T> boolean SalvarObjArquivo(T objeto, String pasta, String nomeArquivo) {
		CriarDiretorio(pasta);

		try {
			FileOutputStream outputStream = new FileOutputStream(pasta + "\\" + nomeArquivo + ".ser");
			ObjectOutputStream outputObject = new ObjectOutputStream(outputStream);
			outputObject.writeObject(objeto);
			outputObject.close();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return false;
	}

	/**
	 * Retorna objeto salvo em arquivo passado como parâmetro.
	 * @param id Nome do arquivo é o número que identifica o objeto (id).
	 * @param pasta Pasta onde estão arquivos.
	 * @return Objeto serializado do tipo especificado.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T RetornaObjArquivo(String id, String pasta) {
		CriarDiretorio(pasta);

		try {
			T objeto;

			FileInputStream inputStream = new FileInputStream(pasta + "\\" + id + ".ser");
			ObjectInputStream inputObject = new ObjectInputStream(inputStream);
			objeto = (T) inputObject.readObject();
			inputObject.close();

			return objeto;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return null;
	}
	
	/**
	 * Lista todos os arquivos de extensão .ser da pasta indicada.
	 * @param pasta
	 */
	public static void ListarArquivos(String pasta) {
		File dir = new File(pasta);
		int pos;
		FilenameFilter filtro = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".ser");
			}
		};

		File[] arquivos = dir.listFiles(filtro);

		if (arquivos != null) {
			for (File f : arquivos) {
				if (f.isFile()) {
					String s = f.getName();
					
					pos = s.lastIndexOf('.');
					
					s = s.substring(0, pos);
					
					System.out.println(s);
				}
			}
		}
	}
}
