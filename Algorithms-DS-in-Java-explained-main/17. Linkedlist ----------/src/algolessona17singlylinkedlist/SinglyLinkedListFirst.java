/*
 * a singly-linked list is a data structure. it stores a collection of data.
 * each data is stored in a node. each node is linked to the next node and the previous.
 * the first node has NULL previous node. the last node has NULL next node.
 * the first node is commonly referred to as HEAD, while the last node is commonly referred to as TAIL.

 * a node stores two properties: data, and reference to the next node.
 * 
 * 1. CREATE NODES      2. LINK THE NODES using .next
 * 
 * 1.                                   node || node.next
 * at first...							head -> nullk
 * head = new ListNode(10);    			head -> 10 -> null
 * ListNode second = new ListNode(1)    1  -> null
 * ListNode third = new ListNode(8)     8  -> null  
 * 
 * 2.
 * head.next = second                   head -> second -> null
 * second.next = third                  head -> second -> third -> null
 * */
package algolessona17singlylinkedlist;

public class SinglyLinkedListFirst {            // the "main" class, defines the node and the structure and the method to initialize;
	
	// head  instance variable:
	private ListNode head;           // DECLARE the HEAD: una istanza;
	
	// ListNode class,and constructor:
	private static class ListNode{   // questa e' la classe di un node
		private int data;			 // the node data
		private ListNode next;       // the node reference to next node;
		
		// the constructor:
		public ListNode(int data) {  // definisce come inizializzare la struttura un node
			this.data = data;        // quando usi il constructor puoi dare solo data come parametro,
			this.next = null;        //   non puoi inizializzare next: prima devi creare i node separati, poi potrai assegnare la reference a .next;
		}
	}

	public static void main(String[] args) {
		// 1a. initialize an object from the SinglyLinkedList:
		SinglyLinkedListFirst sll = new SinglyLinkedListFirst();
		// 1b. initialize the data at head.
		//     access the head instance variable from the class;
		//     assign to it a new ListNode using the constructor public ListNode(int data)
		//     as parameter of the constructor, assign an integer: the head is instantiated and stores a number.
		sll.head = new ListNode(10);    // put data in this instance, not next, you don't have any other node yet.
		
		// 1c. create three more ListNode, you already assigned a node to head, so just use the constructor for ListNode;
		ListNode second = new ListNode(1);
		ListNode third  = new ListNode(8);
		ListNode fourth = new ListNode(11);
		
		// 2. assign the .next to each node, remember you must access the object first, 
		//       the ListNode  and finally the .next property, 
		//       then you can assign the reference to a listnode as next
		sll.head.next = second;
		second.next = third;
		third.next = fourth;		
	}
}