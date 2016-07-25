package aplicacao;

import java.util.HashMap;

import agencia.Agencia;
import agencia.ArquivosAgencia;
import agencia.OperacoesAgencia;
import pessoa.cliente.Cliente;
import pessoa.gerente.Gerente;

public class Programa {
	private Agencia agencia;

	public static void main(String[] args) {
		System.out.println(">>>>> Aplicação Banco <<<<<");
		
		AppBanco aplicacaoBanco = new AppBanco();
		
		Agencia a = new Agencia();
		
		a = new OperacoesAgencia().CadastrarAgencia();
		
//		System.out.println(a.getNumero());
//		System.out.println(a.getGerente().getNome());
	}

	private static void TesteArquivosAgencia() {
		Agencia agencia = new Agencia();
		Agencia agencia2 = new Agencia();
		Gerente gerente = new Gerente();
		HashMap<Integer, Cliente> hash = new HashMap<Integer, Cliente>();

		Cliente c = new Cliente();

		c.setCpf("39746089668");
		c.setNome("Ferreira");

		hash.put(1, c);

		gerente.setCpf("06089861359");
		gerente.setMatricula("12345");
		gerente.setNome("Felipe 2");

		agencia.setNumero(1307);
		agencia.setGerente(gerente);
		agencia.setClientes(hash);

		if (ArquivosAgencia.SalvaAgenciaArquivo(agencia)) {
			System.out.println("Salvou");
		} else {
			System.out.println("Não salvou.");
		}

		agencia2 = ArquivosAgencia.RetornaAgenciaArquivo(1307);

		System.out.println("Nome cliente: " + agencia2.getClientes().get(1).getNome());
	}

}
