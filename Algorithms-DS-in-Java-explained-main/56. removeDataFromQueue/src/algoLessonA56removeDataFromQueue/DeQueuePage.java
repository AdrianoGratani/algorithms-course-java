package algoLessonA56removeDataFromQueue;

import java.util.NoSuchElementException;

/*
REMOVE DATA FROM QUEUE DS



the queue class has to emplement a new method to remove data;
it should return the data removed;
it should take no parameters: the class method can automatically pick
and then remove the class instance variable 'front', since this is 
declared in the same class scope;

1. inside the method scope, check if the current queue ds is empty first;
if this is true, throw an error: you can't remove data from empty ds;

otherwise, store the .data of current front Node in a int variable,
and then move the front Node pointer to its .next reference;
[ the java will automatically garbage-collect the previous front node ]

1a. check if front is now pointing to null, in this case redeclare rear = null;             // this happens when the LAST remained item in the queue has been removed;

2. decrease by 1 the value of length class variable;

3. return the variable storing .data of removed Node;


i.e.:    (front) 23 -> 42 -> 54 -> 66 (rear) -> null                             length = 4

dequeue() ==>

23 (garbage-collected)  |||   (front) 42 -> 54 -> 66 (rear) -> null    length-- = 3  /  return 23

 */

public class DeQueuePage {

	private static class Queue {             // NO statiic methods in the queue class; NO static instance or class variables as well;
		private  int length;
		private Node front;
		private Node rear;

		public Queue() {
			this.length = 0;
			this.front = null;
			this.rear = null;
		}

		private class Node {
			private int data;
			private Node next;

			public Node(int dataIn) {
				this.data = dataIn;
				this.next = null;
			}
		}
		
		public  boolean isEmpty() {
			return length == 0;
		}

		public int lenQueue() {
			return length;
		}

		public void enqueue(int dataIn) {
			Node newNode = new Node(dataIn);

			if(isEmpty()) {
				front = newNode;
			}
			else {
				rear.next = newNode;
			}
			rear = newNode;
			length++;
		}

		public void display() {
			if (isEmpty()) {
				System.out.println(" empty queue. no data to display. ");
				return;
			}
			
			Node iterator = front;
			while(iterator != null) {
				System.out.print(iterator.data + " ->> ");
				iterator = iterator.next;
			}
			System.out.println(" null ");
		}

		public int dequeue() {          // this method is to remove int data from the queue;
			if (isEmpty()) {
				throw new NoSuchElementException();
			}
			
			int removedData = front.data;
			front = front.next;
			
			if (front == null) {
				rear = null;
			}
			length--;
			return removedData;
		}
	
	}
	

	public static void main(String[] args) {

		Queue q = new Queue();

		q.display();

		System.out.println(q.isEmpty());		
		System.out.println(q.lenQueue());
		
		q.enqueue(12);
		q.enqueue(17);
		q.enqueue(154);
		q.enqueue(13);
		
		q.display();
		
		q.dequeue();
		q.display();

		q.dequeue();
		q.dequeue();
		q.display();
		
		q.dequeue();
		q.display();
	}
}