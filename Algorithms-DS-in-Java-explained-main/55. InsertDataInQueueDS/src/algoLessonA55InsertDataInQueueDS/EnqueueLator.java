
package algoLessonA55InsertDataInQueueDS;

/*
HOT TO INSERT AN ELEMENT INTO A QUEUE



decide data type of the element in advance;
create a class Queue with its own instance variable to store:
length of the Queue;
first item in the Queue (a Node);
last item in the Queue (a Node);
lastly: the constructor for the Queue:
you need the constructor to get an actual object
out of this blueprint;


create a Node class inside the Queue Class
the node stores the data: is a container;
for each data create a new Node;
to create an instance of the Node you need also the constructor,
as you needed one for the queue class;


create a new method to insert an element into the queue;
it has to take the data you want to insert, as ARGUMENT;
it should check if the queue is currently empty or not;
if yes, front class instance variable has to be redeclared as newNode;

otherwise, declare .next of the newNode as rear,

in any case, redeclare rear as NewNode and  dont'forget 
to increment by 1 the length of the Queue;


*/


public class EnqueueLator {

	private static class Queue {
		private int length;
		private ListNode front;
		private ListNode rear;

		public Queue() {
			this.length = 0;
			this.rear = null;
			this.front = null;
		}

		private class ListNode {
			private int data;
			private ListNode next;

			public ListNode(int dataIn) {
				this.data = dataIn;
				this.next = null;
			}
		}

		public int length() {
			return length;
		}

		public boolean isEmpty() {
			return length == 0;
		} 

		public void display() {

			if (isEmpty()) {
				System.out.println("empty queue.");
				return;
			}

			System.out.print("\t\t\t\tfront => ");
			ListNode iterator = front;   //QUITE THE OPPOSITE, ACTUALLY!!!  the queue is linked in a rear-to-front direction. you can only iterate by assigning next from last item to previous, from rear to front;

			while (iterator != null) {
				System.out.print(iterator.data + " --> ");
				iterator = iterator.next;
			}

			System.out.println(" null ");		
		}

		public void enqueue(int dataIn) {
			ListNode newNode = new ListNode(dataIn);

			if(isEmpty()){
				front = newNode;
			}
			else {
				rear.next = newNode;
			}
			rear = newNode;
			length++;
		}

	}


	public static void main(String[] args) {
		Queue queue = new Queue();

		System.out.println(queue.isEmpty());
		System.out.println(queue.length());
		queue.display();

		queue.enqueue(11);
		queue.enqueue(22);
		
		System.out.println(queue.isEmpty());
		System.out.println(queue.length());
		queue.display();


	}

}
