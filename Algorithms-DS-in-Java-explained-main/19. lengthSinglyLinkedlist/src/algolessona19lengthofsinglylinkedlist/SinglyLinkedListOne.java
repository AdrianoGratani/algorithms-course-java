package algolessona19lengthofsinglylinkedlist;

public class SinglyLinkedListOne {

	private ListNode head;
	
	private static class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data = data;                    // data is required to be given on call of this constructor;
			this.next = null;                    // null by default
		}		
	}
	
	//methods to use over ListNodes linkedlists:    OUT OF THE ListNode SCOPE;
	public void display() {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;              // ogni ListNode e' linkato, ovvero ha una proprieta ListNode next che contiene una reference, quindi puoi iterarre lungo la LinkedList;
		}
		System.out.print("null\n");
	}
	
	public int counter(ListNode h) {   			// give the 'head' ListNode as a parameter 'h' for starting point;   // public void counter(ListNode h)   or public void counter() is fine as well;
		int count = 0;
		ListNode current = h;
		while(current != null) {
			count++;
			current= current.next;
		}
		return count;
	}
	
	public static void main(String[] args) {
		SinglyLinkedListOne sll = new SinglyLinkedListOne();           // constructor of the publi class. now I can access Node constructor and methods;            
		
		sll.head = new ListNode(10);                             // uso il constructor() di ListNode class, per far cio' uso l'instance sll;
		ListNode second = new ListNode(1);                       // second si trova in main() quindi per accedervi NON devo usare sll.second
		ListNode third = new ListNode(8);
		ListNode fourth = new ListNode(11);
		
		sll.head.next = second;
		second.next = third;
		third.next = fourth;                                     // fourth.next is NULL by default since is not declared;
		
		sll.display();		
		int sllLength = sll.counter(sll.head);                   // this method returns the result as part of the task. store it in a variable.
		System.out.println("length of the SinglyLinkedList nodes is: " + sllLength);
	}
}