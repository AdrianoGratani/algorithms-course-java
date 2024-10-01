package algolessona24deletelastnodeofasinglylinkedlist;

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
	
	public void display() {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + " ->> ");
			current = current.next;
		}
		System.out.println("null\n");
	}
	
	public void length() {
		ListNode iterator = head;
		int count = 0;
		while(iterator != null) {
			count = count + 1;
			iterator = iterator.next;
		}
		System.out.println("length: " + count);
	}
	
	public void newHead(int data) {
		ListNode newH = new ListNode(data);
		if (head == null) {
			head = newH;
		} else {
			newH.next = head;
			head = newH;
		}
	}
	
	public void newTail(int data) {   // create a new node with some data argument. iterate from head to current tail, give new node as tail.next.
		ListNode newT = new ListNode(data);		
		ListNode currentTail = head;
		while (currentTail.next != null) {
			currentTail = currentTail.next;
		} 
		currentTail.next = newT;
		return;				
	}
									// to iterate , use a while loop. count in 1-index; condition is (count < position-1) {you assign .next to previous, so -1 will be nullified, you end up just before the newNode position}
	public void newN(int d, int p) {// create temporary nodes: previous, current; put the newNode as .next of previous; assign current as .next of newNode;
		ListNode currentNode = null;
		ListNode previous = head;
		ListNode newNode = new ListNode(d);
		
		if (p == 1) {
			// it works same as newH: assign to newNode.next head; then reassign head to newNode;
			newNode.next = head;
			head = newNode;
			return;
		} else {		
			int count = 1;             // 1-indexed iteration;
			while(count < p - 1) {     //!!!BUG FIXED I accidentally put a 'return' statement inside WHILE. SO ITERATION ABORTED IMMEDIATELY.
				previous = previous.next;
				count = count + 1;
	        }                              // WHEN YOU ASSIGN node.next to a new node, this node will receive BOTH .data and .next of the reference;
			currentNode = previous.next;   //!!!FIXED I forgot to assign previous.next to currentNode, so currentNode resulted as .next-empty, so list finished abruptly with it even though I created more nodes.
			previous.next = newNode;
			newNode.next = currentNode;
		  }
	}
	
	public ListNode deleteHead() {
		if (head == null) {
			return null;
		} else {
			ListNode temporaryNode = head;
			head = head.next;
			temporaryNode.next = null;
			return temporaryNode;        // you can sysout  .data on call of this method to print the deleted one
		} 		
	}
	
///////////////////  TODAY'S ALGORITHM  //////////////////////
/*
 * task: delete a specific node in the linkedlist. you are given its position as argument on call;
 *       create too versions: one void method: everything is null,  and a ListNode method, and return the deleted.
 *       call both method, the second one: print with some test the deleted data;
 *       
 * todo: ListNode iterator init. at head,  a count variable initialized at 1; 
 * 		 a previousNode to head, a currentToDeleteNode to head.next, and a nextNode to null;
 * 
 *       a while loop to assign to iterator its .next;
 *       	condition of the loop (count has to be less than position - 2 argument.
 *          
 *          inside the loop: 1. previousNode becomes previousNode.next;  
 *                           2. currentToDeleteNode becomes its .next
 *                           3. do count ++;
 *        
 *          if the condition becomes false = you reached the node you want to delete and its previous;
 *          
 *   ---->> create a ListNode temp = currentToDeleteNode
 *   		current = current.next;
            ListNode next = current.next;
 *          previous.next = current;
 *          temp.next = null;
 *          return temp;                
 */
	// MY GUESS:	
	public ListNode deleteNode(int position) {
		ListNode temp = null;
		
		if (position == 1) {
			temp = head;
			head = head.next;
			temp.next = null;
			return temp;
		} else if (position != 1) {
			ListNode previous = head;
			ListNode current = head.next;
			ListNode next = null;
			
			int count = 1;
			while (count < position - 1) {  // io inizio a contare current come head.next quindi sono gia' avanti di uno. quindi deve arrivare alla poszione PRIMA DI position-1 col loop in quanto current sara' a position -1 e fara' current.next per l'ultima volta,
				previous = previous.next;   // two pointers, previous and current
				current = current.next;
				count = count + 1;
			}			
			temp = current;                 // even a third node;
			current = current.next;
			previous.next = current;
			temp.next = null;
		}		
		return temp;		
	}	
	
	// TEACHERS: better algorithm, avoids the use of two pointers in the whileloop:
	            // once the loop is finished, assign to a ListNode current the previous.next;
	            // then, reassigns to previous.next the current.next.
	            // now, current is a node separated by the List;
				// in this algorithm you want to garbage collect the node; you don't want to return it;
	            // if a node is NOT a reference .next of any other node (except head, which is declared as a instance variable in the class scope)
				// so, after losing the reference, (previous.next = current.next) the node is just garbage collected;
	
	public void delete(int position) {
		if (position == 1) {
			head = head.next;
		} else {
			ListNode previous = head;
			int count = 1;
			while (count < position -1) {
				previous = previous.next;
				count = count + 1;
			}
			ListNode current = previous.next;
			previous.next = current.next;
			/// no need to set current.next to null now: since current has lost its reference status, whichmeans that NO previous node points to it, it gets garbage collected automatically;
		}
	}
//////////////////////////////////////////////////////////////	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head = new ListNode(1);
		ListNode sec = new ListNode(2);
		
		sll.head.next = sec;
		sll.newHead(11);
		sll.newTail(22);
		sll.newN(5555, 4);
		sll.newN(1111, 1);
		sll.newN(2222, 2);            //!!!BUG [SOLVED ln 71] this becomes the LAST item in the list. somehow next elements are not linked anymore.
		sll.newN(4444, 4);	
		sll.display();
		sll.length();
		for (int i = 0; i < 4; i++) {
			System.out.println("node deleted: " + sll.deleteHead().data); 
		}
		
		sll.display();
		System.out.println("deleted node at position : " + sll.deleteNode(1).data);   // mine works!!!
		sll.display();
		sll.length();
	}
}