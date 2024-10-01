package algolessona20insertafirstnodeinsinglylinkedlist;

public class SinglyLinkedList {
	// NODE CLASSES (plus constructor) and the default head:
	private ListNode head;
	private static class ListNode {     // it HAS to be static, otherwise how could I initialize each node in the main();
		private int data;
		private ListNode next;
		
		public ListNode(int data) {    // this param data has the same name as the private int data and this.data, but actually is the number assigned on call;
			this.data = data;
			this.next = null;
		}		
	}
	
	// METHODS:
	public void display() {
		ListNode current = head;
		while(current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null\n");
	}
	public int length() {
		ListNode current = head;
		int lengthCount = 0;
		while(current != null) {
			lengthCount++;
			current = current.next;
		}
		return lengthCount;
	}
	
	public ListNode newHead(int newNodeData) {         // every time you'll call this method, a new ListNode gets initialized with data, and its position in the linked list is set at the beginning as the new head;
		ListNode newNode = new ListNode(newNodeData);
		newNode.next = head;
		head = newNode;                          // il 'pointer' head adesso e' settato su questo node;
		return newNode;                          // by adopting this algorithm, you msut instantiate a ListNode in main() and store the call of this method (plus .data)
	}
	
	// definitive one is void:
	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
	}
	
	public static void main(String[] args) {           //!!!BUG SOLVED if you mispel the main() declaration, java doesn't throw an error but doesn't read this file.
		SinglyLinkedList sll = new SinglyLinkedList();
		
		sll.head = new ListNode(10);
		ListNode second = new ListNode(1);
		ListNode third  = new ListNode(8);
		ListNode fourth = new ListNode(11);
		
		sll.head.next = second;
		second.next = third;
		third.next = fourth;
		sll.display();                      
		
        ListNode fiirst = sll.newHead(56);  // using my version of the method, newHead()   not void, stored in a ListNode in main() like so;
        sll.insertFirst(5);                 // using teacher version, insertFirst()        void, just call the method from the instance;
        sll.display();                      
	}
}