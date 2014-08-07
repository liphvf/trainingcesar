package treinamento.collection;

import java.util.Collection;
import java.util.Iterator;

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
		return true;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
}