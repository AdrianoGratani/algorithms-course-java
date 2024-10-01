//package algolessona26searchelementinasinglylinkedlist;
//
//public class SinglyLinkedListt {
//
//	private ListNode head;
//	
//	private static class ListNode {
//		private int data;
//		private ListNode next;
//		
//		public ListNode(int dataValue) {
//			this.data = dataValue;
//			this.next = null;
//		}
//	}
//	
//	public String display() {
//		ListNode iterator = head;
//		while (iterator != null) {
//			System.out.print(iterator.data + " ->> ");
//			iterator = iterator.next;
//		}
//		System.out.println(" null\n");
//		return "\tDisplay() method finished.\n";                  //!!! it cannot be seen on output...
//	}
//	
//	public void insertHead(int dataValue) {
//	    ListNode newHead = new ListNode(dataValue);
//		if (head == null) {
//	    	head = newHead;
//	    } else if (head.next == null || head.next != null) {
//	    	newHead.next = head;
//	    	head = newHead;
//	    } 		
//	}
//	
//    /*
//     * 	TASK: you are asked to create an algorithm to find a specific data inside linkedList;
//     * 
//     *  create a method. this method should return: a string which says "found" or "not found".
//     *       										if found: the data found,  the position in the linked list in which has been found;
//     *       										so, typecast the int data and int position inside the return string;
//     *       
//     *  you need a ListNode iterator to iterate through the list. an int count 
//     *  and a while loop as well. condition: iterate from head to tail;
//     *      inside the while loop, an if statement to check if data argument corresponds to current .data inside the current node;
//     *      if this is true, return "found element: {.data} found in node number {count}
//     *      if it is false, assign iterator.next to iterator and increment count by one;
//     *  if you end the while loop, it means you haven't found that .data: return "data not found";
//     *  
//     *  the data you are looking for should be inserted as argument on call of the method;
//     *  */
//	
//	public  String findNode(int dataToCheck) {  // if this method would have been static, you could not use a non-static value such as head;
//		ListNode iterator = head;
//		int count = 1;
//		while (iterator.next != null) {
//			if (iterator.data == dataToCheck) {
//				return String.format("Data found: %d at position %d", iterator.data, count); //!!!ERR SOLVED, .format accepts only %d argument, is indeed so first %d refers to first arg etc etc...
//			} 
//			iterator = iterator.next;
//			count = count + 1;
//		}		
//		return String.format("%d not found at any position in the linked list.", dataToCheck);
//	}
//	
//	// TEACHERS':
//	public boolean nodeFinder(ListNode head, int searchKey) {
//		if (head == null) {return false;}
//		
//		ListNode current = head;
//		while (current != null) {
//			if (current.data == searchKey) {
//				return true;
//			}
//			current = current.next;
//		}
//		return false;
//	}
//	
//	public static void main(String[] args) {
//		SinglyLinkedListt slll = new SinglyLinkedListt();
//		slll.head = new ListNode(1);		
//		ListNode sec = new ListNode(2);
//		slll.head.next = sec;
//		slll.insertHead(3);
//		slll.insertHead(4);
//		slll.display();
//		
//		System.out.println(slll.findNode(4321));   			// mine works!!!
//		System.out.println(slll.findNode(4));      			// mine works!!!
//		
//		if ( !(slll.nodeFinder(slll.head, 542))  ) {          // teachers';
//			System.out.println("not found!!!");
//		}
//	}	
//}