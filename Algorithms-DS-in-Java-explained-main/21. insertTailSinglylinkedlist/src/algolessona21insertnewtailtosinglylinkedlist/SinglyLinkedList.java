package algolessona21insertnewtailtosinglylinkedlist;

public class SinglyLinkedList {
	private ListNode head;
	private static class ListNode {
		private int data;
		private ListNode next;
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	// METHODS:
	public void display() {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + " --> ");
			current= current.next;
		}
		System.out.println("null\n");
	}
	
	public void length() {  							
		int length = 0;
		ListNode iterator = head;                           // devi per forza creare un ListNode da usare come iteratore;
		while (iterator != null) {
			length = length + 1;
			iterator = iterator.next;
		}
		System.out.println("length is: " + length);
	}	
	
	public void createNewHead(int valueData) {
		ListNode newNode = new ListNode(valueData);
		newNode.next = head;
		head = newNode;
	}
	 
	// MY GUESS: non sapevo si potesse mettere un return statement in un metodo void;
	public void createNewTail(int valueData) {                 //	 my guess
		ListNode newNode = new ListNode(valueData);            //    the 'wannabe' tail:  an isolated node with .data = 8 and .next = null
		ListNode current = head;                               //    the pointer
		if (head == null) {      							   //    base case: if there is no List, initialize this 'tail' as the head;
			head = newNode;
			return;             // fondamentale. se la linkedList era vuota, metti il node creato, ed esci.
		}
		while (current.next != null) {                         // unico errore: while(current != null): raggiungi una posizione null, POI la condiione diventa falsa. ti trovi in una posizione null e non puoi assegnare nulla.
			current = current.next;                            //      se invece while(current.next != null) questo loop si ferma su un current.data. quindi a loop finito puoi assegnare come .next il newNode 
		}
		current.next = newNode;	                               //      ecco fatto.                              
	}
	// DEFINITIVE ONE:  crea il current dopo, prima del while loop;
	public void insertLast(int value) {  // l'algoritmo del docente
		ListNode newNode = new ListNode(value);
		if (head == null) {
			head = newNode;   // se head e' vuota dalle il newNode;
			return;
		}
		ListNode current = head;         // current e' un iterator, riceve head come starting reference;
		while(current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();

		sll.insertLast(54);   // head == null  quindi crei la head
		sll.display();        // 54 --> null
		sll.insertLast(875);
		sll.insertLast(432);
		sll.insertLast(87659);
		sll.display();        // 54 --> 875 --> 432 --> 87659 --> null
	}
}