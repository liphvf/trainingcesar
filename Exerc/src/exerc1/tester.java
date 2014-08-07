/*
 * 1) crie uma classe para representar uma disciplina. Uma disciplina possui um código e um nome
2) crie uma classe para representar uma avaliação (prova). Uma avaliação está relacionada (possui) uma disciplina e possui um número (1.a, 2.a, etc.) e um resultado (nota)
3) crie uma classe para representar um aluno. Um aluno possui um número de matrícula, nome e uma lista de avaliações.
4) crie um método que recebe uma coleção de alunos e imprime a média global dos alunos por disciplina

Abraços,
Saulo
 */

package exerc1;

import java.util.*;

public class tester {

	public static void main(String[] args) {

		Collection<aluno> turma = new LinkedList();

		// add matematica
		disciplina matematica = new disciplina("Matemática", 1);

		// add portugues
		disciplina portugues = new disciplina("português", 2);

		// add ingles
		disciplina ingles = new disciplina("inglês", 3);

		// add avaliacao
		avaliacao mat = new avaliacao(matematica, 1, 8);
		avaliacao mat2 = new avaliacao(matematica, 2, 5);
		avaliacao mat3 = new avaliacao(matematica, 3, 8);
		avaliacao port = new avaliacao(portugues, 1, 8);
		avaliacao port2 = new avaliacao(portugues, 2, 8);
		avaliacao port3 = new avaliacao(portugues, 3, 8);
		avaliacao eng = new avaliacao(ingles, 1, 9);
		avaliacao eng2 = new avaliacao(ingles, 2, 8.5);
		avaliacao eng3 = new avaliacao(ingles, 3, 8.75);

		// cria aluno
		aluno a = new aluno("Filiphe", 201210248);
		aluno ph = new aluno("Phellype", 123456);

		a.getLista().add(mat);
		a.getLista().add(port);
		a.getLista().add(port2);
		a.getLista().add(port3);
		a.getLista().add(mat2);
		a.getLista().add(mat3);

		ph.getLista().add(mat);
		ph.getLista().add(eng);
		ph.getLista().add(eng2);
		ph.getLista().add(eng3);

		// add alunos

		turma.add(a);
		turma.add(ph);

		alunosmedia(turma);

	}

	public static void alunosmedia(Collection<aluno> c) {

		Iterator<aluno> iter = c.iterator();

		while (iter.hasNext()) {

			iter.next().mediaglobal();

		}
	}

}
