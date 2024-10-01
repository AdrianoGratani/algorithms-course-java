/*
dai la head
se la list e'  nll fai return
altrimenti assenna al previous di head.next null e dagli head
la ex head deve avere null come next

dai come argument la head al method

public void ddeleteHead(Node h) {

	if (n == nul) {
		return;
	}
	n.next.previous = null
   	head = n.next;
	n.next = null;
}


teacher:
check if it's empty, in that case throw a NoSuchElementException();;

// ti serve un pointer per eliminare definitivamente la vecciha head, 
// perche' eliminarerai la .previous del node successivo, e darai head al node successivo:
//    se non avessi il seguent pointer headToDeete, non potresti eliminare l'ultima reference, ovvero il .next di tale vecchia head;
Node headToDelete = n;

check if there's only one element in the list, in thant case head is equal to tail,
	in that case, tail is equal to null;
ELSE assign as .previous value of the .next of head a null value;
( ovvero: se tail e' == head dagli null, ALTRIMENTI NON TOCCARE tail, e dai null al .previous del .next di head);

// riassegna head; canella la .next reference alla nuova head di quella che era la vechia head;
head = headToDelete.next;
headToDelete.next = null;

// at the end, RETURN the deleted node;


prima di tutto elimina il previous del node .next di head;
poi assegna head a tale node;
poi assegna, come .next della vecchia head che accedi con il node che hai creato, il valore null

*/



package algoLessonA45deleteLastNodeFromDoublyLinkedList;

public class DoubliesDeleteTail {
	
	private int length;
	private Node head;
	private Node tail;
	
	public DoubliesDeleteTail() {
		this.length = 0;
		this.head = null;
		this.tail = null;
	}
	

	private static class Node {
		private int data;
		private Node previous;
		private Node next;
		
		public Node(int dataIn) {
			this.data = dataIn;
			this.previous = null;
			this.next = null;
		}
	}
	
////////////////////////////////////////////////////////
	
	public boolean empty() {
		return length == 0;
	}
	
	public int length() {
		return length;
	}
	
	public void display() {
		if (empty()) {
			System.out.println("current List object is empty.");
			return;
		} 
		
		Node iterator = head;
		
		while (iterator != null) {
			System.out.print(iterator.data + " --> ");
			iterator = iterator.next;
		}
		System.out.println("null");
	}
	
	
	public void insertHead(int value) {
		
		Node newHead = new Node(value);
		
		if (head == null) {
			tail = newHead;		
		}
		else {
			head.previous = newHead;
		}
		
		newHead.next = head;
		head = newHead;
		length = length + 1;
	}
	
//////////////////////////////
	
	public Node deleteTail() {		
		if (empty()) {
			System.out.println("list is already empty. nothing to delete.");
			return null;
		}
		
		Node currentTail = tail;
		
		if (head == tail) {
			head = null;
		}
		else {
			tail.previous.next = null;
		}
		
		tail = tail.previous;
		currentTail.previous = null;
		length = length - 1;
		
		return null;
	}

////////////////////////////////////////////////////////	
	
	public static void main(String[] args) {
		DoubliesDeleteTail ddt = new DoubliesDeleteTail();
		
//		System.out.println(ddt.empty());
//		System.out.println(ddt.length())
//		ddt.display();
		
		for (int i = 10; i > 0; i--) {                      // 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7 --> 8 --> 9 --> 10 --> null
			ddt.insertHead(i);
		}
		
//		ddt.deleteTail();
		ddt.display();										// 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7 --> 8 --> 9 --> null		
	}
}