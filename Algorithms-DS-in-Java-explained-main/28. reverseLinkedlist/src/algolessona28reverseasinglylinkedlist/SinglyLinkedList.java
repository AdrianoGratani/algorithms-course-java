package algolessona28reverseasinglylinkedlist;

public class SinglyLinkedList {
	
	private ListNode head;
	private static class ListNode {
		private int data;
		private ListNode next;
		
		public ListNode(int dataInput) {
			this.data = dataInput;
			this.next = null;
		}		
	}
	
/*
 * TASK: given a singly linked list, turn the order of each node from first to last:
 *       sll:     				n1 -->  n2  -->  n3  -->  n4  -->  null
 *       reverse(sll):          n4 -->  n3  -->  n2  -->  n1  -->  null
 *       
 *       you have to move from head to tail nodes. use a while loop. condition of the loop: current != null
 *       
 *       you use three ListNode pointers: previousNode   currentNode   nextNode;                              x
 *           previous starts as null,  current node as head,  nextNode as current.next;						  x
 *           if previousNode is null,  {do move all three pointers to their respective .next;}
 *           if nextNode is null,  { assign previous to current.next.  assign null to previous.next; }
 *           assign to currentNode.next previousNode.  assign to previousNode currentNode.   assign to  currentNode  nextNode.  assign to nextNode  nextNode.next  *           
 *       return "singlyLinkedList inverted";
 *  */
	// MY GUESS  1:
	public String invertList(ListNode head) {		
		
		if (head == null || head.next == null) {return "Linked List not valid, please insert a Linked List with at least 2 items";}
		
		ListNode previousNode = head;
		ListNode currentNode = previousNode.next;
		
		if (currentNode.next == null) {
			currentNode.next = previousNode;
			previousNode.next = null;
			return "Only two items found. Inversion done.";
		}
		
		ListNode nextNode = null;                           //!!!SOLVED: INIZIALIZZAVO nextNode FUORI dal loop come currentNode.next, quindi dentro il loop prendeva sempre il currenNode riaggiornato e andava al suo next.
		while (nextNode.next != null) {	//still EXIT 1   	//!!!INFINITE LOOP  1 ->> 2 ->> 1 ->> 2
			nextNode = currentNode.next;
			currentNode.next = previousNode;                //
			previousNode = currentNode;
			currentNode = nextNode;
			nextNode = nextNode.next;
			System.out.println("done");
			
		}
		currentNode.next = previousNode;
		previousNode = currentNode;
		currentNode = nextNode;	
		return "List inverted";
	}
	
	public String display(ListNode i) {
		while (i != null) {
			System.out.print(i.data + " --> ");
			i = i.next;
		}
		return "null";
	}
	
	// MY GUESS2:   not working
	public ListNode invertTwo() {
		ListNode previous = null;
		ListNode current = head;
		ListNode next = null;
		
		while (current != null) {             // I chose previous.next instead
			
			next = current.next;              // I assigned current = previous.next AND THEN next = current.next
			current = previous.next;
			current.next = previous;
			previous = current;
			current = next;                   // if you assign next to current.next AT THE BEGINNING, is better than next = next.next
			
		}
		return previous;
	}
	
	// TEACHERS:
	public ListNode solution(ListNode head) {
		if (head == null) {
			return head;
		}
		
		ListNode current = head; 
		ListNode previous = null;
		ListNode next = null;
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
	
	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head = new ListNode(1);
		
		ListNode sec = new ListNode(2);
		ListNode tri = new ListNode(3);
		ListNode fou = new ListNode(4);
		ListNode fif = new ListNode(5);
		
		sll.head.next = sec;
		sec.next = tri;
		tri.next = fou;
		fou.next = fif;
		
//		sll.solution(sll.head);
		
		// sll.invertList(sll.head);	// problems to solve, last invertion, thread management;
		System.out.println(sll.display(sll.head));
		// mine works, but there is a problem: 4 ->> 3 ->> 1 ->> 2 ->>  null
		// Thread [main] (Suspended) (out of synch)	SinglyLinkedList.main(String[]) line: 78 (out of synch)	

	}
}