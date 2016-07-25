package aplicacao;

import java.util.HashMap;

import agencia.Agencia;
import agencia.ArquivosAgencia;
import input.Ler;
import pessoa.cliente.Cliente;
import pessoa.gerente.Gerente;

public class AppBanco {
	private Agencia banco;
	private AppCliente appCliente;
	private AppGerente appGerente;

	public Agencia getBanco() {
		return banco;
	}

	public void setBanco(Agencia banco) {
		this.banco = banco;
	}

	public AppCliente getAppCliente() {
		return appCliente;
	}

	public void setAppCliente(AppCliente appCliente) {
		this.appCliente = appCliente;
	}

	public AppGerente getAppGerente() {
		return appGerente;
	}

	public void setAppGerente(AppGerente appGerente) {
		this.appGerente = appGerente;
	}

	public AppBanco() {
//		escolherAgencia();
	}

//	private static Agencia escolherAgencia() {
//		int opcao;
//		
//		System.out
//				.println("O n�mero da Ag�ncia precisa ser informado ou criado. Siga o seguinte menu para prosseguir: ");
//		System.out.println("1 - Desejo criar uma nova ag�ncia e utiliz�-la;");
//		System.out.println("2 - J� sei o n�mero da ag�ncia que desejo acessar, deixe-me digitar;");
//		System.out.println("3 - N�o sei o n�mero da ag�ncia, mostre-me a lista de todas as ag�ncias;");
//		System.out.println("4 - N�o desejo mais utilizar a aplica��o;");
//		System.out.println("Qual op��o deseja?");
//
//		opcao = Ler.lerInt();
//
//		switch (opcao) {
//		case 1:
//			
//
//			break;
//		case 2:
//			int numero;
//			System.out.println("Digite o n�mero da ag�ncia: ");
//			numero = Ler.lerInt();
//			agencia = ArquivosAgencia.RetornaAgenciaArquivo(numero);
//
//			if (agencia != null)
//				banco = agencia;
//
//			break;
//		case 3:
//			break;
//		case 4:
//			System.out.println("Aplica��o encerrada.");
//			System.exit(0);
//			break;
//		default:
//			System.out.println("Opc�o inv�lida.");
//			break;
//		}
//	}
}
