package algolessona25deletetailsinglylinkedlist;

public class SinglyLinkedList {
	
	private ListNode head;

	private static class ListNode {
		private int data;
		private ListNode next;
		
		public ListNode(int inputData) {
			this.data = inputData;
			this.next = null;
		}
	}
	
	public void display() {
		ListNode iterator = head;
		while(iterator != null) {  //!!!BUG FIXED  was iterator.next != null
			System.out.print(iterator.data + " ->> ");
			iterator = iterator.next;
		}
		System.out.println("null\n");
	}
	
	public void newTail(int dataValue) {
		ListNode newNode = new ListNode(dataValue);
		ListNode iterator = head;
		if(head == null) {
			head = newNode;
		} else if (head.next == null) {
			head.next = newNode;
		} else if (head != null && head.next != null){
			while (iterator.next != null) {
				iterator = iterator.next;				
			}
			iterator.next = newNode;	
//			System.out.println("debug" + iterator.next.data);
			return;
		  }
	}
	
	/*
	 * TASK: create a method() to delete the last node of a linkedList.
	 * 
	 *       create an iterator Node, assign head to it; 
	 *              an iterator previousNode to null
	 *       use a while loop to move to the last node, until iterator.next is null
	 *             at each step: assign previous to current;
	 *                           assign current to current.next;
	 *       now, current is the tail.
	 *       previous.next = null; to cut tail from the linkedlist
	 *       return current;     return the removed tailNode    
	 * */
	//MY GUESS:
	
	public ListNode removeTail() {
		ListNode previous = null;
		ListNode removeThis = head;
		
		if(head == null || head.next == null) {
			System.out.println("only this data was found:" + head.data);
			return head;
		} else {
			System.out.print("Before deleting: ");
			display();
			while(removeThis.next != null) {
				previous = removeThis;
				removeThis = removeThis.next;
				//previous = removeThis    ERR!!!
			}
			previous.next = null;
		}
		System.out.println("last item in the list has been removed: " + removeThis.data);
		System.out.print("after deleting:");
		display();
		return removeThis;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head = new ListNode(1);   //!!!ERR  DON'T FORGET to initialize the ListNode class as STATIC otherwise, as nonstatic yoiu cannot use here;
		ListNode second = new ListNode(2);
		sll.head.next = second;
		
		sll.newTail(22);   //!!!BUG SOLVED if I print the list, '22'  is not visible. it gives me 'null' instead.
		sll.newTail(33);   //!!!BUG SOLVED if I print the list, '33' is not printed, but '22' is now visible.
		sll.removeTail();
		sll.removeTail();	
	}
}