package eg.edu.alexu.csd.datastructure.queue;

import eg.edu.alexu.csd.datastructure.linkedList.SinglyLinkedList;

public class LBQueue implements IQueue , ILinkedBased{

	private SinglyLinkedList Q = new SinglyLinkedList();
	
	public Object front() {
		if(size() == 0) {
			throw new RuntimeException("Queue is Empty!");
		}
		return Q.getFirst();
	}
	
	public Object rear() {
		if(size() == 0) {
			throw new RuntimeException("Queue is Empty!");
		}
		return Q.getLast();
	}
	
	public void clear() {
		Q.clear();
	}
	
	@Override
	public void enqueue(Object item) {
		if(item == null) {
			throw new RuntimeException("Can not enqueue null.");
		}
		Q.add(item);
	}

	@Override
	public Object dequeue() {
		if(size() == 0) {
			throw new RuntimeException("Queue is Empty!");
		}
		Object temp = Q.getFirst();
		Q.remove(0);
		return temp;
	}

	@Override
	public boolean isEmpty() {
		return Q.isEmpty();
	}

	@Override
	public int size() {
		return Q.size();
	}

}
