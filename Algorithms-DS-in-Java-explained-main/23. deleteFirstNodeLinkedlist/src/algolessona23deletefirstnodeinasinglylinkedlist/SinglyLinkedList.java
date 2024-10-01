package algolessona23deletefirstnodeinasinglylinkedlist;

public class SinglyLinkedList {
/////////////////////  RECAP  ///////////////////////////////
	
	private ListNode head;
	
	private static class ListNode {
		private int data;
		private ListNode next;
		
		public ListNode(int nodeData) {  // constructor
			this.data = nodeData;
			this.next = null;
		}
	}
	
	public void displayList() {
		ListNode iterator = head;
		while (iterator != null) {              //!!!BUG SOLVED ho un solo node. ma display() fa solo "null": come condizione di iterazione avevo messo iterator.next != null !!! se hai un solo node, il suo ListNode .next punta a null. 
			System.out.print(iterator.data + " --> ");     // <---
			iterator = iterator.next;
		}
		System.out.println("null\n");
	}
	
	public void insertHeadNode(int dataValue) {
		ListNode newHead = new ListNode(dataValue);
//		newHead = head;     ERROR. this way you lose the .next reference
		newHead.next = head;        // <---
		head = newHead;             // <---
	}
	
	public void insertTailNode(int dataValue) {
		ListNode newTail = new ListNode(dataValue);
		ListNode iterator = head;
		if (head == null) {
//			newTail.next = head;
//			head = newTail;        // or, just:
			head = newTail;
		}
		while (iterator.next != null) {         // se facessi newTail !- null come condizione, raggiungerebbe il null, a quel punto non potrei inserire newTail
			iterator = iterator.next;
		}
		iterator.next = newTail;   //  <---
	}
	
	public void displayLength() {
		int lengthCounter = 0;
		ListNode iterator = head;
		while (iterator != null) {
			lengthCounter = lengthCounter + 1;
			iterator = iterator.next;
		}
		System.out.println("length: " + lengthCounter);
	}
	
	public void insertNode(int dataValue, int newNodePosition) {
		ListNode newNode = new ListNode(dataValue);
		
		if (newNodePosition == 1) {
			newNode.next = head;
			head = newNode;
			return;
		} else {
			int count = 1;
			int previousNodePosition = newNodePosition - 1;
			ListNode previous = head;
			while (count < previousNodePosition) {    // fermati PRIMA di raggiungere con il loop la previous Node;
				previous = previous.next;             // l'ultimo loop in cui la condizione e' vera, inizia nella posizione PRIMA del node PRECEDENTE a dove metterai newNode.
				count = count + 1;
			}                                         // finito il loop, il node counter previous si trova nel node prima di dove vuoi mettere il newNode;
			ListNode current = previous.next;         // current e' il ListNode originale. lo sostituirai con newNode a breve.

			previous.next = newNode;        // <---
			newNode.next = current;         // <---		
		}		
	}
///////////////////////// deleteFirstNode()	METHOD	/////////////////////////////////////
	/*
	 * task: delete the first node in a linked list; use a method, develop an algorithm to do so;
	 * 
	 * the first node in a linked list is the head
	 * a node contains data and a reference .next to the linked ListNode;
	 * ??? delete? you mean .data becomes null and .next becomes null?
	 * 
	 * ~ you don't need to find the head since is declared in the class as a static reference variable. and is the first item in the list.
	 * ~ 1 assign head.next to a temp ListNode: you will need to do a 'swap' (you only need a temp ListNode to set data and next to null); 
	 * ~   give the data of the head to temp   temp = head
	 * ~ 2 give head.next to head              head = head.next
	 * ~ 3 delete temp                         temp = null    temp.next = null
	 * in case head is null?   just return null;
	 * */	
	// my guess:
	public void deleteFirstNode() {
		if (head == null) {
			return;
		}
		ListNode temp = head;        // <--- se non usassi temp ListNode: do head.next a head, MA RESTA ANCORA IL data e soprattutto il .next del node prima di head; 
		head = head.next;            // <--- quindi, head diventa head.next
		temp.next = null;            // <--- il node che ERA head e che ora si chiama temp, lo separo da head.
		temp = null;                 // <--- poi, elemino il suo data.
									 // in alteranativa potrei usare un public ListNode method invece di un void, e ritornare il temp data ...
	} 
	
	// solution:
	public ListNode deleteFirst() {
		if (head == null) {
			return null;
		}
		ListNode temp = head;
		head = head.next;
		temp.next = null;		
		return temp;     
	}
////////////////////////////////////////////////////////////////////	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		
		sll.insertHeadNode(1);
		sll.insertHeadNode(-1);
		sll.insertHeadNode(-2);
		sll.insertTailNode(2);
		sll.insertTailNode(3);
		sll.insertNode(1000, 3);
		sll.insertNode(2000, 7);
		sll.insertNode(3000, 1);
		sll.displayList();
//		sll.deleteFirstNode();            // mine works!!;
		System.out.println("deleted node data: " + sll.deleteFirst().data + "\n"); // questo metodo fa un return. quindi posso usare la dot notation per accedere a cosa ha 'cancellato' in realta' lo sta ritornando quindi lo ha solo tolto dalla lista;
		
		
		sll.displayList();
		sll.displayLength();		
	}
}