/*
									java: Queue data structure: how to represente a queue in Java


a queue is a LINEAR data structure. It is used for storing data;

	It's an ORDERED list: insertions and deletions are performed at ONE END ONLY;				 (it's a singly linked list)
		it follows the FIRST IN - FIRST OUT rule: first elements inserted
	is the first to be removed;

		it's a TWO REFERENCES ds: you need a pointer to the start of the queue and one for the rear:
		Node base    Node rear/peek
		
		pop() using base Node as reference;
		pop() BASE Node and give rear to its .next;
		
		push() using rear Node as reference;
		push() a new Node having PEEK as his .next;
		give peek to the new Node;
		
		[ the proper name for push into a queue is ENQUEUE. it's a method ]
		[ the proper name for pop  from a queue is DEQUEUE. it's a method ]


	example:	an int queue ds:    (base) 13 -> 65 -> 72 (peek) -> (null)

		push():         data = 44;          (base) 13 -> 65 -> 72 (peek reference) -> 44 (peek) -> null
		pop():          popped = 13;        (base) 65 -> 72 -> 44 (peek) -> (null)
		
		
		iterate from base to last inserted item;    (.next Node instance variable, same as Stacks, but in opposite direction)



												IMPLEMENTATION OF A QUEUE IN JAVA	


you need:

	a file class;
	
	a class to generate a blueprint of the data structure, having:
	instance variables;
	methods;	[queue(), dequeue(), display() etc etc]
	CONSTRUCTOR method of the Queue;
	
	a class to generate a blueprint of Node data structures
	( they will store each data singularly )
	instance variables;
	methods (eventually);
	CONSTRUCTOR method of the Node;
	
	a main() method to instantiate the class
	and use the methods, and eventually store
	results in variables;

 */

//IMPORTANT: in case you want to implement a Queue ds by importing the premade Java Util, you don't have to create one more class for the queue, just instantiate an obj using the constructor;
package algoLessonA54QueueBasicImplementation;

public class QueueBasicImplement {                  // START OF THE FILE CLASS

	private static class Queue {     // START OF THE QUEUE CLASS
		private ListNode front;
		private ListNode rear;
		private int length;

		public Queue() {
			this.front = null;
			this.rear = null;
			this.length = 0;
		}	

		private static class ListNode {
			private int data;
			private ListNode next;

			public ListNode(int dataIn) {
				this.data = dataIn;
				this.next = null;
			}
		}

		//      QUEUE METHODS:
		public int length() {
			return length;
		}

		public boolean isEmpty() {
			return length == 0; 
		}	

	}															 // END OF THE QUEUE CLASS


	public static void main(String[] args) {      


	}

}											            // END OF THE FILE CLASS

