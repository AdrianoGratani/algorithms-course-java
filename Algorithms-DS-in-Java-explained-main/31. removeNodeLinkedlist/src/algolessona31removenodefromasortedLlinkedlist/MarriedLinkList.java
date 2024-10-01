package algolessona31removenodefromasortedLlinkedlist;

public class MarriedLinkList {

	private Nudes head;
	private static class Nudes{
		
		private int data;
		private Nudes next;
		
		public Nudes(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void d() {
		Nudes current = head;
		while(current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null");
	}
//////////////////////////////////////////////////////////////////////////////////////////
/*
 * TASK: insert a new node with n data inside a sorted linked list;
 *       
     *   ask: myNode.data is lower than head.data?                         if yes = change the head to myNode.data     a.
     *        if not:																									
	 *       	  myNode.data is equal to currentNode.data?                if yes = put myNode here;                   b.
	 *         //   if not, is greater than currentNode?            
	 *               if yes, is lower than currentNode.next.data:?         if yes = put myNode in between current and current.next;     c.
	 *                 if not lower, move currentNode to currentNode.next          
	 *               
	 *               repeat from ask until you find a 'yes':

//	 myNode = 8        a. ListA = 10 12 14     b. ListB = 8 6 9 9 11 11    c. ListC = 5 11 11 16 20 20;   d. ListD = 7 7 9 11 11
*/	
	public void nodeSorted(int newNodeData) {
		Nudes myNode = new Nudes(newNodeData);		              // the node you want to insert;
		Nudes currentNode = head;                      			  // the iterator node;
		
		while(currentNode != null) {                              // move from head to tail node in the list;	
			if (currentNode.next != null) {
				if (myNode.data == currentNode.data || 
					myNode.data == currentNode.next.data ||
					 (myNode.data < currentNode.next.data && 
					  myNode.data > currentNode.data)) 
				{
					System.out.println("debug1");
					myNode.next = currentNode.next;
					currentNode.next = myNode;
					return;
				} 
		    }
			else if (currentNode.next == null) { 
				System.out.println("debug2");
				currentNode.next = myNode; 
				return;
				}
			else if (myNode.data < currentNode.data) {                      // mettilo alla fine, tanto puo' essere solo la head, non ha senso verificare questo ad ogni loop
				myNode.next = currentNode;
				head = myNode;
				System.out.println("debug3");
				return;
			} 
			else { 
				System.out.println("debug4");
				currentNode = currentNode.next;
				}								
		}
	}
	
	// TEACHERS':
	public Nudes teachMe(int dataNewNode) {
		Nudes temp = null;
		Nudes newNode = new Nudes(dataNewNode);
		Nudes current = head;
		
		while(current != null &&
			  current.data < newNode.data) {
		  temp = current;
		  current = current.next;
		}	
		
		if (temp == null && current == head) {      // !!! SOLVED with my solution; for (5)
			newNode.next = current;
			head = newNode;
			return head;
		}
		else if (temp != null && current == null) { // !!! SOLUTION for (32)
			temp.next = newNode;
			newNode.next = current;
		}
		
		temp.next = newNode;
		newNode.next = current;		
		return head;                      // return the starting point of the changed sorted LinkedLIst;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		MarriedLinkList mll = new MarriedLinkList();
		mll.head = new Nudes(6);
		Nudes a = new Nudes(7);
		Nudes b = new Nudes(9);
		Nudes c = new Nudes(10);		
		mll.head.next = a;
		a.next = b;
		b.next = c;
		
//		mll.nodeSorted(8);              // works, but not deleted     7 --> 8 --> 8 --> 9 --> 10 --> null
		                                // not working:               9 --> 9 --> 9 --> 10 --> null
		
//		mll.teachMe(7);                 // ok 6 --> 7 --> 7 --> 9 --> 10 --> null
		mll.teachMe(6);                 // SOLVED no 6 --> 7 --> 9 --> 10 --> null    instead of 6 ---> 6
        mll.teachMe(5);                 // now is ok!!!        
        mll.teachMe(32);				//!!!SOLVED not working this note should be the tail. check the base cases.
        mll.d();						
	}
}