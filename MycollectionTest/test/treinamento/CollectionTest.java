package treinamento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class CollectionTest {
	@Test
	public void testaColecaoVazia() {
		Collection<String> colecao = new CollectionImpl<>();

		Assert.assertTrue(colecao.isEmpty());
		Assert.assertEquals(0, colecao.size());
	}

	@Test
	public void testaColecaoUnitaria() {
		Collection<String> colecao = new CollectionImpl<>();
		colecao.add("Saulo");

		Assert.assertTrue(colecao.contains("Saulo"));
		Assert.assertFalse(colecao.contains("Araujo"));
		Assert.assertFalse(colecao.isEmpty());
		Assert.assertEquals(1, colecao.size());
	}

	@Test
	public void testaContains() {

		Collection<String> colecao = new CollectionImpl<>();
		colecao.add("Saulo");
		colecao.add("Araujo");
		colecao.add("Menedes");
		colecao.add("Da Silva");

		Assert.assertTrue(colecao.contains("Saulo"));
		Assert.assertTrue(colecao.contains("Araujo"));
		Assert.assertTrue(colecao.contains("Menedes"));
		Assert.assertTrue(colecao.contains("Da Silva"));
		Assert.assertFalse(colecao.contains("Araujo3"));

	}

	@Test
	public void testaContainsAll() {
		Collection<String> colecao = new CollectionImpl<>();
		colecao.add("Saulo");
		colecao.add("Araujo");
		colecao.add("Menedes");
		colecao.add("Da Silva");

		// iterator já ta implementado no ArrayList, por isso se passar um
		// CollectionImpl<>, dá erro.
		Collection<String> colecao2 = new ArrayList();
		colecao.add("Saulo");
		colecao.add("Da Silva");

		Assert.assertTrue(colecao.containsAll(colecao2));

	}

	@Test
	public void testaAddAll() {

		Collection<String> colecao = new CollectionImpl<>();
		colecao.add("Saulo2");

		Collection<String> colecao2 = new ArrayList();
		colecao.add("Saulo");
		colecao.add("Da Silva");

		Assert.assertTrue(colecao.addAll(colecao2));
		Assert.assertTrue(colecao.containsAll(colecao2));
		Assert.assertTrue(colecao.contains("Saulo"));
		Assert.assertTrue(colecao.contains("Saulo2"));
	}

	@Test
	public void testaRemove() {

		Collection<String> colecao = new CollectionImpl<>();
//		colecao.add("Saulo");
//
//		colecao.remove("Saulo");
//
//		Assert.assertTrue(colecao.isEmpty());
//		Assert.assertFalse(colecao.contains("Saulo"));

		colecao.add("Saulo");
		colecao.add("Araujo");
		colecao.add("Menedes");
		colecao.add("Da Silva");

		colecao.remove("Saulo");

		Assert.assertFalse(colecao.contains("Saulo"));

	}
	
	@Test
	public void testaRemoveAll() {
		
		Collection<String> colecao = new CollectionImpl<>();
		colecao.add("Saulo");
		colecao.add("Araujo");
		colecao.add("Menedes");
		colecao.add("Da Silva");
	
		Collection<String> colecao2 = new ArrayList();
		colecao2.add("Saulo");
		colecao2.add("Araujo");
		colecao2.add("Menedes");
		colecao2.add("Da Silva");
		
		colecao.removeAll(colecao2);
		
		
		
		Assert.assertFalse(colecao.contains("Saulo"));
		Assert.assertFalse(colecao.contains("Araujo"));
		Assert.assertFalse(colecao.contains("Menedes"));
		Assert.assertFalse(colecao.contains("Da Silva"));
		
		//Assert.assertTrue(colecao.isEmpty());
		
	}

	@Test
	public void testaClear() {

		Collection<String> colecao = new CollectionImpl<>();
		colecao.add("Saulo");
		colecao.add("Araujo");
		colecao.add("Menedes");
		colecao.add("Da Silva");

		colecao.clear();

		Assert.assertEquals(0, colecao.size());
		Assert.assertTrue(colecao.isEmpty());

	}
	
	@Test
	public void testaRetainAll() {
		
		Collection<String> colecao = new CollectionImpl<>();
		colecao.add("Saulo2");
		colecao.add("Saulo");
		colecao.add("Araujo");
		colecao.add("Menedes");
		colecao.add("Da Silva");

		Collection<String> colecao2 = new ArrayList();
		colecao2.add("Saulo");
		colecao2.add("Araujo");
		
		colecao.retainAll(colecao2);

		Assert.assertTrue(colecao.contains("Saulo"));
		Assert.assertTrue(colecao.contains("Araujo"));
		Assert.assertFalse(colecao.contains("Da Silva"));
		Assert.assertTrue(colecao.containsAll(colecao2));
		
		
		
	}
	
	@Test
	public void testaIterator() {

		Collection<String> colecao = new CollectionImpl<>();
		
		colecao.add("Saulo");
		colecao.add("Araujo");

		
		Iterator <String> iterator = colecao.iterator();
		
		Assert.assertTrue(iterator.hasNext());
		Assert.assertEquals("Saulo", iterator.next());
		Assert.assertEquals("Araujo", iterator.next());
		Assert.assertFalse(iterator.hasNext());
		
	}

}
