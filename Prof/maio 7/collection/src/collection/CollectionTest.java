package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionTest {
	public static void main(String[] args) {
/*				
		String nomes[] = new String[10];

		nomes[0] = "Saulo";
		nomes[1] = "Araujo";
		for (int i = 0; i < nomes.length; ++i) {
			System.out.println(nomes[i]);
		}
		for (String nome : nomes) {
			System.out.println(nome);
		}
		
		ArrayList nomes = new ArrayList();
		nomes.add("Saulo");
		nomes.add("Araujo");
		nomes.add(1);
		for (int i = 0; i < nomes.size(); ++i) {
			Object nome = nomes.get(i);
			String nomeString = (String) nome;
			System.out.println(nomeString.length());
		}
*/

/*		
		Collection<String> nomes = new TreeSet<String>();
		nomes.add("Saulo");
		nomes.add("Araujo");
		nomes.add("Araujo");
		for (String nome : nomes) {
			System.out.println(nome);
		}
		for (Iterator<String> i = nomes.iterator(); i.hasNext(); ) {
			String nome = i.next();
			System.out.println(nome);
		}
*/
		
/*		
		Map<String, Integer> mapa = new HashMap<>();
		mapa.put("Saulo", 10);
		mapa.put("Araujo", 1000);
		System.out.println(mapa.get("Saulo"));
		System.out.println(mapa.get("Medeiros"));
*/		
		
		Aluno saulo = new Aluno();
		saulo.codigo = 1;
		saulo.nome = "Saulo Medeiros de Araujo";
		
		Aluno saulo2 = new Aluno();
		saulo2.codigo = 1;
		saulo2.nome = "Saulo Medeiros de Araujo";
		
		Aluno alice = new Aluno();
		alice.codigo = 2;
		alice.nome = "Alice Falcão de Araujo";
		
/*		
		Collection<Aluno> alunos = new HashSet<>();
		alunos.add(saulo);
		alunos.add(saulo2);
		System.out.println(alunos.size());
*/
		
		List<Aluno> listaAlunos = new ArrayList<>();
		listaAlunos.add(saulo);
		listaAlunos.add(alice);
		Collections.sort(listaAlunos, new ComparadorCodigo());
		System.out.println(listaAlunos);
	}
}













