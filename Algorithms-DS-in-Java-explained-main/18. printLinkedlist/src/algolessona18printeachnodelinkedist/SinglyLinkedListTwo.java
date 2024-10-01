package algolessona18printeachnodelinkedist;

public class SinglyLinkedListTwo {
	// sll, object instance of this class, have access only to head
	// head,as ListNode instance, has access to .data and .next;
	private ListNode head;   //  serve una instance variable per la head: l'entry point della list;

	private static class ListNode {
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	// the method to print each node: crei un node 'current' che fa da pointer
	public void display() {               // ??? no parametri == current Node riceve head!!!		
		ListNode current = head;          // come dire int i = 0: head, as 0, acts as reference 'address' for array first partition; 
		while (current != null) {
			System.out.print(current.data + " --> ");   //!!!ERROR  'current' is the node. but you want to print the DATA, so: 'current.data' is correct
			current = current.next;       // same as 'i++';
		}
		System.out.print(" null\n");
	}
	
	public static void main(String[] args) {
		SinglyLinkedListTwo sll = new SinglyLinkedListTwo();
		sll.head = new ListNode(10);   //(10 == .data)
		ListNode second = new ListNode(1);
		ListNode third  = new ListNode(8);
		ListNode fourth = new ListNode(11);
		
		sll.head.next = second;
		second.next = third;
		third.next = fourth;   // !!! there is no 'fourth.next' so it's NULL by default;
		
		// the method display() is inside the class. so call it through the instance sll;
		sll.display();        // ??? NON SERVONO PARAMETRI,come fa display() a sapere cosa cercare 
	                          // display() contiene un ListNode provvisorio, current, che viene inizializzato con head.
	}
}