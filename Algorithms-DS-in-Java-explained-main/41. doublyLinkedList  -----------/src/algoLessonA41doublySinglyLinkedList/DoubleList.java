/*
		DOUBLY LINKED LIST

it is callled two way linked list. 
It contains BOTH .next and .previous Nodes in the class.



	.previous <-----  NodeInTheList.data  -----> .next



while in a Singly Linked List you can only delete a Node if you have a pointer
in the previous one, in a Doubly Linked List this is not necessary.

------------------------------------------->
 null   1     10     15     65      null      ||||| head - tail
<-------------------------------------------


public class ListNode {
	int data;
	ListNode previous;
	ListNode next;

	public ListNode(int dataInput) {
		this.data = data;
		this.previous = null;
		this.next = null;
	}

}

*/
///////////////////////////////////////////////////////////////////////////
/*

	HOW TO IMPLEMENT DOUBLY LINKED LIST IN JAVA


public class DoublyLinkedList {
	
	private ListNode head;
	private ListNode previous;
	private int length;

	private class ListNode {
		private int data;
		private ListNode next;
		private ListNode previous;
		
		public ListNode(int dataIn) {
			this.data = dataIn;
			
		}

	}
	
	

	public DoublyLinkedList() {                 //!!! perche' questo??????
		this.head = null;
		this.tail = null;
		this.length = 0;
	}

	

	public boolean isEmpty() {
		return length == 0;  // if (head == null) then length == 0;
	}

	public int length() {
		return length;
	}


///////////////////////////////////////////////////////////////////////
/*
	HOT TO PRINT A DOUBLY LINKED LIST

is the same method as a doubly linked list;
start from the head Node and iterate using a pointer to each node until you find a null;
at each step print the current pointer Node .data, then move the pointer to the .next Node position


	ListNode temp = head;
	while (temp != null) {
		sysout(temp.data + " -> ");
		temp = temp.next;
	}
	sysout("null");



OR:



	ListNode temp = tail;
	while (temp != null){
		sysout(temp.data + " --> ");
		temp = temp.previous;
	}
	sysout("null");

*/


///////////////////////////////////////////////////////////////////////

package algoLessonA41doublySinglyLinkedList;

public class DoubleList {

		private Node head;
		private Node tail;
	
		private static class Node {
			private int data;
			private int length;
			private Node next;
			private Node previous;
			
			public Node(int dataIn) {
				this.data = dataIn;
				this.next = null;
				this.previous = null;
			}
		}
		
		
		public void display(Node headTail) {
			
			if(headTail.next != null && headTail.previous == null) {
				Node pointer = head;
				while(pointer != null) {
					System.out.print(pointer.data + " --> ");
					pointer = pointer.next;
				}
				System.out.println("null");
				
			} else {
				Node pointer = tail;
				while(pointer != null) {
					System.out.print(pointer.data + " <-- ");
					pointer = pointer.previous;
				}
				System.out.println("null");				
			}			
		}		
		
		
		public static void main(String[] args) {			
			DoubleList example = new DoubleList();
			example.head = new Node(2);                    // se class Node fosse non-static dovresti chiamare l'istanza e dargli .new:   example.new Node();
			example.tail = new Node(4);	
			Node a = new Node(3);

			example.head.next = a;
			a.previous = example.head;
			a.next = example.tail;
			example.tail.previous = a;
			
			example.display(example.head);                // 2 --> 3 --> 4 --> null
			example.display(example.tail);                // 4 <-- 3 <-- 2 <-- null
		}
}