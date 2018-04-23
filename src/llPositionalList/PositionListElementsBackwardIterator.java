package llPositionalList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import interfaces.PLIteratorMaker;
import interfaces.Position;
import interfaces.PositionalList;

public class PositionListElementsBackwardIterator<T> implements Iterator<T>, PLIteratorMaker<Integer> {

	private Position<T> current; 
	private PositionalList<T> theList; 
	
	public PositionListElementsBackwardIterator(PositionalList<T> list) { 
		theList = list; 
		try { 
			current = theList.last(); 
		}
	    catch (NoSuchElementException e) { 
	    	current = null; 
	    }
	}
	
	public boolean hasNext() {
		return current != null;
	}

	public T next() throws NoSuchElementException {
		if (!hasNext()) 
			throw new NoSuchElementException("Iterator has past the end.");
		Position<T> ptr = current; 
		try { 
			current = theList.before(current); 
		}
		catch (Exception e) { 
			current = null; 
		}
		return ptr.getElement();
	}

	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<Position<Integer>> makeIterator(PositionalList<Integer> pl) {
		// TODO Auto-generated method stub
		return null;
	}
}
