package eg.edu.alexu.csd.datastructure.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LBQtest {

	@Test
	void test0() {
		LBQueue Q = new LBQueue();
		
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
		LBQueue Q = new LBQueue();
		
		Q.enqueue("Hello world!");
		Q.enqueue("Data");
		Q.enqueue("Java");
		Q.enqueue(520);
		Q.enqueue(3.5f);
		
		assertFalse(Q.isEmpty());
		assertEquals(5,Q.size());
		
		Q.clear();
		
		assertTrue(Q.isEmpty());
		assertEquals(0,Q.size());
		
	}
	

}
