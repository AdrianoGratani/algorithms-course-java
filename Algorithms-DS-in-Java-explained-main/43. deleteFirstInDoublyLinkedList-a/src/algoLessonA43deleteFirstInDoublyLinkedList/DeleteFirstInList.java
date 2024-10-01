package algoLessonA43deleteFirstInDoublyLinkedList;

public class DeleteFirstInList {
	
	private Node head;
	private Node tail;
	private int length;
	
	private static class Node {
			
		private int data;
		private Node next;
		private Node previous;
		
		public Node(int dataIn) {                   // constructor of child class  'Node'  = listNode constructor;
			this.data = dataIn;
		}
	}
	
	public DeleteFirstInList() {					// constructor of the public class 'Delete...'  = list constructor;
		this.head = null;
		this.tail = null;
		this.length = 0; 
	}
	
	public boolean isEmpty() {                      // no args:  sysout(listName.isEmpty());    it will check list.length;
		return length == 0;						    // return the statement AS A BOOLEAN: if list.length IS equal to 0 then return true, otherwise return false;
	} 
	
	public int listLength() {
		return length;								// you call the method like this: listName.length();  the methods knows TO TAKE THE .length specifically for the list you are caling from;
	}
	
	public void displayForward() {
		if (head == null) {
			return;
		}
		
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ->> ");
			temp = temp.next;
		}
		System.out.println("null");		
	}
	
	public void displayBackward() {
		if (tail == null) {
			return;
		}
		
		Node temp = tail;
		while (temp != null) {
			System.out.println(temp.data + " ->> ");
			temp = temp.previous;
		}
		System.out.println("null");
	}
	
	public void insertFirst(int value) {              
		Node newNode = new Node(value);
		
		if (isEmpty()) {
			tail = newNode;
		} else {
			head.previous = newNode;
		}
		newNode.next = head;                  // questo passaggion non serve nel case in cui isWmpty() e' true;
		head = newNode;
		length++;		
	}
}
