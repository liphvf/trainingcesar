package exerc1;

public class disciplina {

	public disciplina(String nome, int codigo) {

		this.nome = nome;
		this.codigo = codigo;

	}

	private String nome;
	private int codigo;

	public String getNome() {
		return nome;
	}

	public int getCodigo() {
		return codigo;
	}

}
