package eg.edu.alexu.csd.datastructure.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ABQtest {

	@Test
	void test0() {
		ABQueue Q = new ABQueue(30);
		
		assertTrue(Q.isEmpty());
		assertEquals(0,Q.size());
		assertThrows(RuntimeException.class, ()->{Q.dequeue();});
		assertThrows(RuntimeException.class, ()->{Q.front();});
		assertThrows(RuntimeException.class, ()->{Q.rear();});
		
		Q.enqueue("Hello world!");
		Q.enqueue("Data");
		Q.enqueue("Java");
		Q.enqueue(520);
		Q.enqueue(3.5f);
		assertThrows(RuntimeException.class, ()->{Q.enqueue(null);});
		
		assertEquals(5,Q.size());
		assertFalse(Q.isEmpty());
		assertEquals("Hello world!",Q.front());
		assertEquals(3.5f,Q.rear());
		
		assertEquals("Hello world!" , Q.dequeue());
		assertEquals("Data" , Q.dequeue());
		assertEquals("Java" , Q.dequeue());
		
		assertEquals(2,Q.size());
		assertFalse(Q.isEmpty());
		assertEquals(520,Q.front());
		assertEquals(3.5f,Q.rear());
		
		assertEquals(520 , Q.dequeue());
		assertEquals(Q.front(),Q.rear());
		assertEquals(3.5f,Q.front());
		assertEquals(3.5f,Q.rear());
		
		assertEquals(3.5f , Q.dequeue());
		assertTrue(Q.isEmpty());
		assertEquals(0,Q.size());
		assertThrows(RuntimeException.class, ()->{Q.dequeue();});
		assertThrows(RuntimeException.class, ()->{Q.front();});
		assertThrows(RuntimeException.class, ()->{Q.rear();});
		
	}
	
	@Test
	void test1() {
		ABQueue Q = new ABQueue(10);
		
		assertTrue(Q.isEmpty());
		assertEquals(0,Q.size());
		assertFalse(Q.isFull());
		
		Q.enqueue("Hello world!");
		Q.enqueue("Data");
		Q.enqueue("Java");
		Q.enqueue(520);
		Q.enqueue(3.5f);
		assertFalse(Q.isFull());
		Q.enqueue("String");
		Q.enqueue(500);
		Q.enqueue("integers");
		Q.enqueue("42.5");
		Q.enqueue(0);
		
		assertFalse(Q.isEmpty());
		assertEquals(10,Q.size());
		assertTrue(Q.isFull());
		
		assertThrows(RuntimeException.class, ()->{Q.enqueue(0);});
		
		assertEquals("Hello world!" , Q.dequeue());
		assertEquals("Data" , Q.dequeue());
		assertEquals("Java" , Q.dequeue());
		
		assertFalse(Q.isEmpty());
		assertEquals(7,Q.size());
		assertFalse(Q.isFull());
		
		assertEquals(520,Q.front());
		assertEquals(0,Q.rear());
		
		Q.enqueue("Hello world!");
		Q.enqueue("Data");
		Q.enqueue("Java");
		
		assertEquals(520,Q.front());
		assertEquals("Java",Q.rear());
		
		assertFalse(Q.isEmpty());
		assertEquals(10,Q.size());
		assertTrue(Q.isFull());
		
		assertThrows(RuntimeException.class, ()->{Q.enqueue(0);});
		
	}
	
}
