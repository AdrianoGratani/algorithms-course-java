/*		CIRCULAR SINGLY LISTS


there is no head or tail. you keep track of the last Node before the
beginning of the loop;


    1 -->  2 --> 3 (last) --> 1  ...


	// if list is empty:

	1)  last --> null

	2)  firstNode --> 1 --> null

	3) last = firstNode

	4) firstNode(last) -> 1 --> last

	   =	1 --> 1 --> 1 --> ...

	new Circular singly list created, one Node;

	
	// if list has one item:

	1)  last --> 1 --> last    ...

	2)  new Node 2 --> null

	3)  new Node 2 --> last 	// set .next of new Node to last

	4)  new Node 2 --> last --> newNode  	// set .next of last as new Node

	5)  assign new Node pointer to last:
	     1 --> 2 (last) --> 1  ...
	
	now, last pointer is updated;


*/

/*
		HOW TO IMPLEMENT A CIRCULAR SINGLY LIST

	
	public class CircularSinglyLinkedList {

		private ListNode last;
		private int length;

		public CircularSinglyLinkedList() {
			
			last = null;
			length = 0;
		}



		private class ListNode{
			
			private ListNode next;
			private int data;

			public ListNode(int data) {
				this.data = data;
				this.next = null
			}
		}


		public int length() {
			return length;
		}

		public boolean isEmpty() {
			return length == 0;
		}
		

		public void createCircularLinkedList() {

			ListNode iterator = new ListNode(0);

			for (int i = 5; i > 0; i++) {
				ListNode new = new ListNode(i);
				iterator.next = iterator;
				last = new;
			}

		}

		public void display() {
			ListNode iterator = last;

			while (iterator != null) {
				System.out.print(iterator.data + " --> ");
				iterator = iterator.next;
			}
			System.out.println("null");
			
		}

		public static void main(String[] args) {
			CircularSinglyLinkedList csll = new CircularSinglyLinkedList
			
			csll.createCircularLinkedList();

			csll.display();
						
			
		}

	}	

*/


package algoLessonA46CreateCircularSinglyLinkedLIst;

public class CreateCirculars {

	private ListNode last;
	private int length;

	public CreateCirculars() {		
		last = null;
		length = 0;
	}

	private class ListNode{		
		private ListNode next;
		private int data;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}


	public int length() {
		return length;
	}

	public boolean isEmpty() {
		return length == 0;
	}
	

	public void createCircularLinkedList() {  // I need a momentary pointer to first Node, the iterator to move in the newly created list, and the new Node at each step; move the iterator at the new Node
		ListNode first = new ListNode(0);	//1. create a starting Node and link an iterator Node to it; use the iterator to assign nodes to this list;
		ListNode iterator = first;

		for (int i = 5; i > 0; i--) {		
			ListNode n = new ListNode(i);
			iterator.next = n;
			last = n;						// at the end of this loop, this pointer will be assigned to the last created Node;
			iterator = iterator.next;
//			System.out.println(i);
		}
		
		last.next = first;					// you have a last pointer to the last  Node, and the first pointer to first Node, assign .next of last as: first
	}

	public void display() {
		ListNode iterator = last;

		while (iterator != null) {
			System.out.print(iterator.data + " --> ");
			iterator = iterator.next;
		}
		System.out.println("null");
		
	}
	
	////////////////////////////////////////////////////////////////
	
	public void displayCircularFromLast() {		
		if ( last == null ) { return; }
		
		boolean seen = false;
		ListNode iterator = last;
		System.out.println("startin from .last: " + last.data);
		
		while(iterator != null && !seen) {
			System.out.print(iterator.data + " --> ");
			if (iterator.next.data == last.data) {
				seen = true;
			}
			iterator = iterator.next;
		}
		System.out.println("null");		                            // !!! WHY null? 
	}	
	
	
	public void teachersDisplay() {
		if ( last == null ) { return; }
		ListNode first = last.next;
		
		while(first.data != last.data) {
			System.out.print(first.data + " --> ");
			first = first.next;
		}
		System.out.println(first.data + " ");
	}
	
    ////////////////////////////////////////////////////////////////
	

	public static void main(String[] args) {
		CreateCirculars csll = new CreateCirculars();
		
		csll.createCircularLinkedList();

//		csll.display();
		csll.displayCircularFromLast();
		
		System.out.println("============================");
		csll.teachersDisplay();
					
	}
}	