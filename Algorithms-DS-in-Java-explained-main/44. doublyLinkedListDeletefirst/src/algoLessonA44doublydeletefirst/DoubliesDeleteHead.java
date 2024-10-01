package algoLessonA44doublydeletefirst;

public class DoubliesDeleteHead {
	
	private int length;					  // class variables;
	private Node head;
	private Node tail;

	public DoubliesDeleteHead() {  		  // the class constructor;
		this.head = null;
		this.tail = null;
		this.length = 0;		
	}
	
	
	private static class Node {
		
		private int data;
		private Node next;
		private Node previous;            // .length is a List constructor instance varaible, not of the Node;

		public Node (int dataIn) {
			this.data= dataIn;
		}		
	}
	
	
	///////////////////////////////////////////////////////////////////////
	// METHODS:
	
	public boolean emptyOrNot() {
		return length == 0;
	}
	
	public int len() {
		return length;
	}
	
	public void displayFromHead() {
		if (head == null) {
			return;
		}
		
		Node iterator = head;		
		while (iterator != null) {
			System.out.print(iterator.data + " ->> ");
			iterator = iterator.next;
		}
		System.out.println("null");
	}
	
	public void displayFromTail() {
		if (tail == null) {
			return;
		}
		Node iterator = tail;
		
		while(iterator != null) {
			System.out.print(iterator.data + " ->> ");
			iterator = iterator.previous;
		}
		System.out.println("null");
	}
	
	
	public void newHead(int valueIn) {
		Node newH = new Node(valueIn);
		
		if (emptyOrNot()) {
			tail = newH;
		}
		else {
			head.previous = newH;
		}
		newH.next = head;
		head = newH;
		length = length +1;
	}
	
	public void newTail(int valueIn) {
		Node newT = new Node(valueIn);
		
		if (emptyOrNot()) {
			head = newT;
		}
		else {
			tail.next = newT;
			newT.previous = tail;
		}
		tail = newT;
		length = length + 1;
	}
	
	
	/////////////////////////////////
	
	public Node deleteHead( ) {
		if (emptyOrNot()) {
			System.out.println("List is empty. Head is null.");
			return null;
		}		
		
		Node deleteThisHead = head;
		
		if (head == tail) {
			tail = null;
		} 
		else {
			head.next.previous = null;
		}
		
		head = head.next;
		deleteThisHead.next = null;	
		
		length = length - 1;		
		return deleteThisHead;
		
	}
	
	
	
	
	///////////////////////////////////////////////////////////////////////
	
	
	public static void main(String[] args) {
		DoubliesDeleteHead ddh = new DoubliesDeleteHead();
		
//		System.out.println(ddh.emptyOrNot());
		
		for (int i = 10; i > 0; i--) {
			ddh.newHead(i);
		}
		
		System.out.println(ddh.len());		
		ddh.displayFromHead();				// 1 ->> 2 ->> 3 ->> 4 ->> 5 ->> 6 ->> 7 ->> 8 ->> 9 ->> 10 ->> null
		
		ddh.deleteHead();
		

		System.out.println(ddh.len());		
		ddh.displayFromHead();     			// 2 ->> 3 ->> 4 ->> 5 ->> 6 ->> 7 ->> 8 ->> 9 ->> 10 ->> null                
		
	}
}
