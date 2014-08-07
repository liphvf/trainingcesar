package treinamento.collection;

import java.util.ArrayList;
import java.util.Collection;

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
	public void testAddAll() {
		Collection<String> colecao1 = new ArrayList<>();
		colecao1.add("Saulo");
		colecao1.add("Medeiros");
		
		Collection<String> colecao2 = new CollectionImpl<>();
		colecao2.addAll(colecao1);
		
		Assert.assertTrue(colecao2.contains("Saulo"));
		Assert.assertTrue(colecao2.contains("Medeiros"));
		Assert.assertFalse(colecao2.contains("Araujo"));
		Assert.assertEquals(2, colecao2.size());
	}
}
