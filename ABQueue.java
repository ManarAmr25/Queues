package eg.edu.alexu.csd.datastructure.queue;

public class ABQueue implements IQueue , IArrayBased{
	
	private Object[] Q;
	private int size;
	private int maxCapacity;
	private int front;  //front points to the first element in the Q , initialized with value 0
	private int rear; //rear points to the last element in the Q , initialized with value -1
	
	//constructor
	public ABQueue(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		this.size = 0;
		Q = new Object[maxCapacity];
		front = 0;
		rear = -1;
	}
	
	
	public Object front() {
		if(size() == 0) {
			throw new RuntimeException("Queue is Empty!");
		}
		return Q[front];
	}
	
	public Object rear() {
		if(size() == 0) {
			throw new RuntimeException("Queue is Empty!");
		}
		return Q[rear];
	}
	
	
	@Override
	public void enqueue(Object item) {
		if(item == null) {
			throw new RuntimeException("Can not enqueue null.");
		}
		if(size == maxCapacity) {
			throw new RuntimeException("Queue is full!");
		}
		rear = (rear + 1) % maxCapacity;
		Q[rear] = item;
		size++;
	}

	@Override
	public Object dequeue() {
		if(size == 0) {
			throw new RuntimeException("Queue is empty!");
		}
		int temp = front;
		front = (front + 1) % maxCapacity;
		size--;
		return Q[temp];
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public boolean isFull() {
		return (size == maxCapacity);
	}

	@Override
	public int size() {
		return this.size;
	}

}
