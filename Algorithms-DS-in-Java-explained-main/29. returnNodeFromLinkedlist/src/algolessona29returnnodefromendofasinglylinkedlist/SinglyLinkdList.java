package algolessona29returnnodefromendofasinglylinkedlist;

public class SinglyLinkdList {

	private N h;
	private static class N {
		private int d;
		private N n;
		
		public N(int in) {
			this.d = in;
			this.n = null;
		}
	}
	
	public void d(N hp) {
		System.out.print("DISPLAY NODES FROM HEAD: ");
		N i = hp;
		while(i != null) {
			System.out.print(i.d + " --> ");
			i = i.n;
		}
		System.out.println("null\n");
	}
	
	public void nH(int d) {
		N newHead = new N(d);
		newHead.n = h;
		h = newHead;
	}	
	//////////////////////////////////////////////////////////////
	/*
	 * 	TASK: given an integer 'index' find the node in a SinglyLinkedList at the 'index' position.
	 *  
	 *  in sll you can move forward by definition, which means we have to find a way to simulate a back-counting algorithm;
	 *  i.e. A. you have a node N, which contains 8 nodes:           N =    n1(head) ->> n2 ->> n3 ->> n4 ->> n5 ->> n6 ->> n7 ->> n8 ->> null
	 *       you get an 'integer' index 3, pointing at the 		   	       R (1 != 3)          ^ R (3 == 3)			^target
	 *       \\																			    	     ->	 R  ->  R   -> R  ->  R  ->  R  ->  !R!
	 *       third-to-last node in the list:		       index = 3  M                ->  M  ->  M ->   M  ->  M   ->!M!  [R == NULL: loop finished]
	 *       
	 *       B. use a two-pointers technique. create two nodes, R and M,
		 *      both starting at head. R is an index-pointer, 
		 *      create a counter integer, starting at 1 (1-indexed),
		 *      create a whileloop, iterate through until you reach 'index'
	 *          each step, increment 'count', move R to R.next,
	 *          R reached position 3. 
	 *          
	 *       C. now create another while loop to move
	 *          BOTH R and M at each step, to their respective .next.
	 *          the loop goes on, until R reaches null. at that point, loop stops.
	 *          
	 *       D. return the node found at index;	 *  
	 * */	
	
	public N indexNodeFromLast(N head, int index) {   // you don't go backwards, you just stop the indexNode at the n-last Node, with the help of a pointer Node;
		N pointer = head;
		N indexNode = head;
		int count = 0;                                // better to count from 0;
		
		while(count < index) {                        // if count = 0 and index = 4, count has to reach 3: pointer will reach N4 (first loop, from head)
			pointer = pointer.n;
			count = count + 1;
		}
		
		while(pointer != null) {         
			pointer = pointer.n;
			indexNode = indexNode.n;                  // indexNode finishes INSIDE null;
		}		
		System.out.println(String.format("found Node at index %d from tail. data: %d", index, indexNode.d));
		return indexNode;
	}
	
	// TEACHERS':
	public N getNthNodeFromEnd(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("provide a valid number: n = " + n);            // String.format("invalid number: %d", n);
		}		
		
		N mainPtr = h;
		N refPtr = h;
		int count = 0;
		while(count < n) {
			if (refPtr == null) {                                     // or:   .(String.format("null  Node found at: %d", count));
				throw new IllegalArgumentException("please insert a valid number, iteration stopped at Nodecount: " + count + ". null Node found. " + n + " is greater than number of nodes in list");
			}
			refPtr = refPtr.n;
			count++;
		}
		while(refPtr != null) {
			refPtr = refPtr.n;
			mainPtr = mainPtr.n;
		}		
		return mainPtr;                // ln113 -> it returns a Node, NOT the data itself, so you must store the call in a variable and access its .data using dot notation;
		}
	
	//////////////////////////////////////////////////////////////
		
	public static void main(String[] args) {
		SinglyLinkdList l = new  SinglyLinkdList();		
		l.h = new N(1);
		l.nH(2);
		l.nH(3);
		l.nH(4);
		l.nH(5);
		l.nH(6);
		l.d(l.h);
		l.indexNodeFromLast(l.h, 2);            
		N exampla = l.indexNodeFromLast(l.h, 4);      // call is automatic. sysout implicit in the method;
		N examplb = l.indexNodeFromLast(l.h, 5);      // ...mine works!!		
		
		System.out.println("nth node in the list is: " + l.getNthNodeFromEnd(5).d); 
		N teacherTwo = l.getNthNodeFromEnd(3);
		System.out.println("nth node in the list is: " + teacherTwo.d);
		
		N teacherWrong = l.getNthNodeFromEnd(90);
		System.out.println("data at nth position provided as arg: " + teacherWrong.d);
	}
}