package pessoa.gerente;

import arquivo.ManipulaArquivo;
import input.Ler;

public class OperacoesGerente {
	public static Gerente CadastrarGerente() {
		Gerente gerente = new Gerente();
		String nome, cpf, matricula;

		System.out.printf("Informe o nome do gerente: ");
		nome = Ler.linha();

		System.out.printf("Informe o CPF do gerente: ");
		cpf = Ler.linha();

		System.out.printf("Informe a matrícula do gerente: ");
		matricula = Ler.linha();
		
		gerente.setNome(nome);
		gerente.setCpf(cpf);
		gerente.setMatricula(matricula);
		
		ManipulaArquivo.SalvarObjArquivo(gerente, "Gerentes", gerente.getMatricula());

		return gerente;
	}
}
