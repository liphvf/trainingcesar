package collection;

import java.util.HashMap;
import java.util.Map;

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
		
		Map<String, Integer> mapa = new HashMap<>();
		mapa.put("Saulo", 10);
		mapa.put("Araujo", 1000);
		System.out.println(mapa.get("Saulo"));
		System.out.println(mapa.get("Medeiros"));
	}
}













