package treinamento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorImpl<E> implements Iterator<E> {

	public IteratorImpl(List<E> eleiterator) {
		this.eleiterator = eleiterator;
		index = 0;

	}

	private List<E> eleiterator = new ArrayList<E>();
	int index;

	@Override
	public boolean hasNext() {

		// verificar se existe a próxima posição então
		// retorna o resultado de:
		return index < eleiterator.size();
	}

	@Override
	public E next() {

		//recebe o próximo elemento de eleiterator.
		if (hasNext()) {
			E eleiter = eleiterator.get(index);
			index++;
			return eleiter;
		}

		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

}
