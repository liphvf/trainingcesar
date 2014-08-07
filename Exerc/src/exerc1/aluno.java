package exerc1;

import java.util.*;

public class aluno {

	public aluno(String nome, int nmatricula) {
		this.nome = nome;
		this.nmatricula = nmatricula;
		// List<avaliacao> l this.l = l;

		lista = new LinkedList();

	}

	private String nome;
	private int nmatricula;
	private List<avaliacao> lista;

	public List qtdmateria() {
		List<Integer> vec = new LinkedList();

		vec.add(lista.get(0).getDis().getCodigo());

		for (int i = 0; i < lista.size(); i++) {

			if (!(vec.contains(lista.get(i).getDis().getCodigo()))) {

				vec.add(lista.get(i).getDis().getCodigo());
				// vec.get(i) == lista.get(j).getDis().getCodigo()

			}

		}

		// varrer tudo, soma os iguais, imprimir

		return vec;
	}

	public void mediaglobal() {

		double sum = 0;
		double navaliacao = 0;
		double media = sum / navaliacao;
		String nomeCadeira = "";

		List<Integer> qtdmateria = qtdmateria();
		
		//nome do aluno
		System.out.println(nome);
		
		for (int i = 0; i < qtdmateria.size(); i++) {
			sum = 0;
			navaliacao = 0;

			for (int j = 0; j < lista.size(); j++) {

				if (qtdmateria.get(i) == lista.get(j).getDis().getCodigo()) {
					sum = sum + lista.get(j).getNota();
					navaliacao++;
					media = sum / navaliacao;
					// System.out.println(media);
					nomeCadeira = lista.get(j).getDis().getNome();

				}

			}

			System.out.println(nomeCadeira + "    " + media);

		}

	}

	public List<avaliacao> getLista() {
		return lista;
	}

	public void setLista(List<avaliacao> l) {
		this.lista = l;
	}

}
