/*
SCENARIO: given as input a sorted LinkedList which contains n Nodes, each of the Nodes storing a 1-digit integer as .data,

TASK:     reverse the order of the Node.data in the input LinkedList;

EXAMPLE: Node A, length = 6;   1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null  |||>>  Node reverse = 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null;
							   h             |                                           h
							   s     		 |
							   c			 |
							   S             |


h = head;
S = StartNode        head
c = count            1  (1 <= 3 true)
s = startData        1


! you must know in advance the LENGTH OF THE LIST; calculate the length and send it as argument to this method;


ALGORITHM:
create a Node pointer to iterate over the input list, starting at head;                                                   // the head is the first argument of the method;
create an int variable 'startData' to store the .data of the current Node;
create an int variable 'count' to store the number of the current StartNode;
create an int variable 'last'. initialize it to 0; in the for loop you need this to stop at the 'relative last node';


iterate until you reach half length of the Linked List;                                                                   // the length is the second argument
	take .data from current Node, go to its relative last node, and store the .data there.
	use a for loop to reach its relative last. the position of the relative last is:  i <= listNodeLength - (currentNodePosition - 1)



CODE:
public Node reverse(Node inputListHead, int listNodeLength) {

	Node currentNodePtr = head;
	Node iteratorNode = head;
	int currentNodePosition = 1;
	
	int halfListLength = listNodeLength / 2;
	
	while(currentNodePosition <= halfListLength) {

		for (int i = currentNodePosition; i <= listNodeLength - currentNodePosition; i++) {
			iteratorNode = iteratorNode.next;
		}
		
		int tempLastNodeData = iteratorNode.data;
		iteratorNode.data = currentNodePtr.data;
		currentNodePtr.data = tempLastNodeData;
		
		currentNodePtr = currentNodePtr.next;
		iteratorNode = currentNodePtr;                    //!!!u prima lasciavo questo iterator in ultima pos. quando il loop ricominciava, il for loop generava un nullPointerException;
		currentNodePosition = currentNodePosition + 1;		
	}
	
	currentNodePtr = head;
	
	return currentNodePtr;                  // create a list; this is the head of the reverse version;
	
}

*/




package algoLessonA38reverseDataInALinkedList;


public class reverseNodeListExercise {

	private Node head;
	
	private static class Node{
		
		private int data;
		private Node next;
		
		public Node(int dataIn) {
			this.data = dataIn;
			this.next = null;
		}
	}
	
	
	
	
	
	public void d(Node head) {
		Node iterator = head;
		int count = 0;
		while(iterator != null) {
			System.out.print(iterator.data + " ->> ");
			iterator = iterator.next;
		}
		System.out.println("null");
	}
	
	
	public int length(Node head) {
		
		Node iterator = head;
		int length = 0;
		
		while(iterator != null) {
			length = length + 1;
			iterator = iterator.next;			
		}		
	
		return length;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
public Node reverse(Node inputListHead, int listNodeLength) {          // questo method() NON CREA NULLA, TRASFORMA; RITORNA inputListHead per vedere il risultato
	
	Node currentNodePtr = inputListHead;
	
	Node iteratorNode = inputListHead;
	int currentNodePosition = 1;
	
	int halfListLength = listNodeLength / 2;
	
	while(currentNodePosition <= halfListLength) {
		int c = 0;
		System.out.println(c++);
		for (int i = currentNodePosition; i <= listNodeLength - currentNodePosition; i++) {
			iteratorNode = iteratorNode.next;
		}
		
		int tempLastNodeData = iteratorNode.data;
		iteratorNode.data = currentNodePtr.data;
		currentNodePtr.data = tempLastNodeData;

		
		
		currentNodePtr = currentNodePtr.next;
		iteratorNode = currentNodePtr;                    //!!!u prima lasciavo questo iterator in ultima pos. quando il loop ricominciava, il for loop generava un nullPointerException;
		currentNodePosition = currentNodePosition + 1;		
	}		
	
	return inputListHead;                // create a list; this is the head of the reverse version;
	
}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	public static void main(String[] args) {
		reverseNodeListExercise list = new reverseNodeListExercise();
		
		list.head = new Node(1);
		Node a = new Node(2);
		Node b = new Node(3);
		Node c = new Node(4);
		Node d = new Node(5);
		Node e = new Node(6);
		Node f = new Node(7);
		Node g = new Node(8);
		
		list.head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		
		int listLength = list.length(list.head);

		list.d(list.head);
		
		reverseNodeListExercise reverseList = new reverseNodeListExercise();
		
		reverseList.d(reverseList.reverse(list.head, listLength));
		// prendi la lista originale, dai la head al method reverse() e mostra in console il risultato: reverse ti ritorna la head di una lista al contrario;
		// d() prende tale head come punto di partenza per fare sysout;
		
		
	}
}