package exerc1;

public class avaliacao {

	public avaliacao(disciplina dis, int navaliacao, double nota) {

		this.dis = dis;
		this.navaliacao = navaliacao;
		this.nota = nota;

	}

	private disciplina dis;
	private int navaliacao;
	private double nota;

	public disciplina getDis() {
		return dis;
	}

	public int getNavaliacao() {
		return navaliacao;
	}

	public double getNota() {
		return nota;
	}

}