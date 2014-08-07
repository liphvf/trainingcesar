package treinamento.collection;

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
}
