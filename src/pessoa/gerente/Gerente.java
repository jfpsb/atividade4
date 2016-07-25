package pessoa.gerente;

import java.io.Serializable;

import pessoa.Pessoa;

public class Gerente extends Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
