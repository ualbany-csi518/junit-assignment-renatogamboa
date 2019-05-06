package sampleQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertThrows;


class QueueTest {

	/**
	 * Tests for Queue.
	 */

	private static final String SOME_ITEM = "some-content";
	private Queue<String> q;


	@Test
	@Disabled
	@DisplayName("is instantiated with new Queue()")
	void isInstantiatedWithNew() {
		new Queue<>();
	}

	@BeforeEach
	void init() {
		this.q = new Queue<String>();
	}

	@Test
	@DisplayName("Verify Queue isEmpty when queue is initialized")
	void isEmptyShouldGiveTrueOnQueueInit() {
		assertTrue(q.isEmpty());
	}
	
	@Nested
	@DisplayName("when new")class WhenNew {
		
		@BeforeEach
		void createNewQueue(){
			q = new Queue<>();
		}
		
		@Test
		@DisplayName("is empty")
		void isEmpty(){
			assertTrue(q.isEmpty());
		}
		
		@Test
		@DisplayName("throws EmptyQueueException when dequeued")
		void throwsExceptionWhenDequeued(){
			assertThrows(NoSuchElementException.class, q::dequeue);
		}
		
		@Test
		@DisplayName("throws EmptyQueueException when peeked")
		void throwsExceptionsWhenPeeked(){
			assertThrows(NoSuchElementException.class, q::peek);
		}
		
		@Nested
		@DisplayName("after Enqueing an element")
		class AfterEnqueueing {
			
			String anElement = "an element";
			
			@BeforeEach
			void enqueueAnElement(){
				q.enqueue(anElement);
			}
			
			@Test
			@DisplayName("it is no longer empty")
			void isNotEmpty() {
				assertFalse(q.isEmpty());
			}
			
			@Test
			@DisplayName("returns the element when dqueued and is empty")
			void returnElementWhenDequeued(){
				assertEquals(anElement,q.dequeue());
				assertTrue(q.isEmpty());
			}
			
			@Test
			@DisplayName("returns the element when dequeued but remains not empty")
			void returnElementWhenPeeked(){
				assertEquals(anElement, q.peek());
				assertFalse(q.isEmpty());
			}
			
			@Test
			@DisplayName("return true when queue length is equal to one")
			void returnLength(){
				assertEquals(q.length(), 1);
			}
			
			@Test
			@DisplayName("return true when all of queue is removed")
			void removeAllTest(){
				q.removeAll();
				assertEquals(q.length(),0);
			}
			
			@Test
			@DisplayName("return true when size is empty")
			void queueSizeTest(){
				q.dequeue();
				assertEquals(q.size(),0);
			}
			
			String elements[] = {"a","b","c","d","e"};
			ArrayList<String> elementsList = new ArrayList<String>();
			
			@Test
			@DisplayName("returns proper iterator when tested.")
			void iteratorTest(){
				q.removeAll();
				
				for (String x: elements){
					elementsList.add(x);
				}
				
				for (String x: elements){
					q.enqueue(x);
				}

				
				
				assertEquals(q.iterator().next(),elementsList.get(0));
				
			}
			
			@Test
			@DisplayName("returns if strings values are equal")
			void toStringTest(){
				q.removeAll();
				
				for (String x: elements){
					q.enqueue(x);
				}
				
				String testString = "a b c d e ";
				
				assertEquals(q.toString(),testString);
			}
			
			@Test
			@DisplayName("test constructor")
			void constructorTest(){
				
				Queue<String> q3 = new Queue<String>(3);
				
				String [] arr = {"a","a","b"};
				
				for (String x: arr){
					q3.enqueue(x);
				}
				
				assertFalse(q3.isEmpty());
				
				assertEquals(q3.size(), 3);
				
				
				q3.removeAll();
				
				Iterator<String> queueIterator = q3.iterator();
				
				assertThrows(NoSuchElementException.class,queueIterator::next);
				
				q3.enqueue("a");
				
				q3.enqueue("b");
				
				q3.enqueue("c");
				
				Iterator<String> queueIterator2 = q3.iterator();
				
				
				assertThrows(UnsupportedOperationException.class,queueIterator2::remove);
				
			}
			
			@Test
			@Disabled
			@DisplayName("test bug in enqueue")
			void bugInEnqueueFunction(){
				
				// When its LIFO but demonstrates FIFO properties.
				
				int maxLength = 4;
				
				Queue<String> q4 = new Queue<String>(maxLength); // queue with max length of size 4
				
				String [] orderedArray = {"1","2","3","4","5"};
				
				for (String x: orderedArray){
					q4.enqueue(x);
				}
				
				assertTrue(q4.size() < maxLength);
				
				
				
			}
			
			
			
			
			
		}
		
		
	}

	//Example of Wrong Test! 
	@Test
	@Disabled
	@DisplayName("Verify Queue isEmpty returns false when queue is not empty")
	void isEmptyShouldGiveFalseWhenQueueIsNotEmpty() {
		this.q.enqueue(SOME_ITEM);
		assertFalse(q.isEmpty());
	}
	
	

	
}