package treinamento;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionImpl<T> implements Collection<T> {

	private Object elementos[];

	public CollectionImpl() {
		elementos = new Object[0];
	}

	@Override
	public int size() {
		return elementos.length;
	}

	@Override
	public boolean isEmpty() {
		return elementos.length == 0;
	}

	@Override
	public boolean contains(Object o) {

		for (int i = 0; i < elementos.length; i++) {

			if (elementos[i] == null) {
				i++;

			} else if (elementos[i].equals(o)) {

				return true;

			}

		}

		return false;
	}

	@Override
	public Iterator<T> iterator() {
		//codigo gerado pelo eclipse, para poder passar a elementos.
		List<T> asList = (List<T>) Arrays.asList(elementos);
		return new IteratorImpl<T>(asList);
	}

	@Override
	public Object[] toArray() {

		return elementos.clone();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T e) {
		Object[] novosElementos = new Object[elementos.length + 1];
		for (int i = 0; i < elementos.length; ++i) {
			novosElementos[i] = elementos[i];
		}
		novosElementos[novosElementos.length - 1] = e;
		elementos = novosElementos;
		return true;
	}

	@Override
	public boolean remove(Object o) {

		if (contains(o) == false) {
			return false;
		}

		Object aux[] = new Object[elementos.length - 1];
		int posicao = 0;
		int k = 0;

		for (int i = 0; i < elementos.length; i++) {

			if (elementos[i].equals(o)) {
				posicao = i;
			}

			for (int j = 0; j < i; j++) {

				aux[j] = elementos[j];
			}

			for (int j = posicao + 1; j < elementos.length; j++) {

				// porque essa posição foi pulado pelo elementos =)
				aux[j - 1] = elementos[j];
			}

		}

		elementos = aux;

		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {

		int contador = 0;

		for (Object a : c) {

			if (contains(a)) {

				contador++;
			}
		}

		if (contador == c.size()) {

			return true;
		}

		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {

		for (T x : c) {
			// só ele, porque ele já coloca dentro do add a lista de elementos
			add(x);
		}

		// esse de baixo também funciona...

		// for (int i = 0; i < c.size(); i++) {
		//
		// elementos[i] = c.iterator();
		// }
		//
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {

		// afinal como posso remover um elementos que não tenho
		if (containsAll(c) == false) {
			return false;
		}

		for (Object x : c) {

			remove(x);

		}

		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {

		if (containsAll(c)) {
			clear();
			// cast
			addAll((Collection<? extends T>) c);

			return true;
		}

		return false;
	}

	@Override
	public void clear() {

		for (Object x : elementos) {
			remove(x);
		}

	}
}