package collection;

import java.util.Comparator;

class ComparadorCodigo implements Comparator<Aluno> {
	@Override
	public int compare(Aluno aluno1, Aluno aluno2) {
/*		
		if (aluno1.codigo < aluno2.codigo) {
			return -1;
		} else if (aluno1.codigo == aluno2.codigo) {
			return 0;
		} else {
			return 1;
		}
*/		
		return (aluno1.codigo - aluno2.codigo) * -1;
	}	
}

public class Aluno implements Comparable<Aluno> {
	public int codigo;
	public String nome;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (codigo != other.codigo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Aluno [codigo=" + codigo + ", nome=" + nome + "]";
	}

	@Override
	public int compareTo(Aluno aluno) {
		return aluno.nome.compareTo(nome);
	}
}












