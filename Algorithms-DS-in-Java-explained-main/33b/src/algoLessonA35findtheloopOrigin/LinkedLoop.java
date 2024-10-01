package algoLessonA35findtheloopOrigin;

public class LinkedLoop {
	
	private No head;								// a Node instance variable to start;
	private static class No { 						// the node class:  default data and constructor
		private int data;
		private No next;
		
		public No(int inData) { 					// the constructor of the Node class
			this.data = inData;
			this.next = null;
		}
	}
	
	
	
//
	public No t(int dataIn) {						// create a new Node and place it last in the List
		No tail = new No(dataIn);
		No i = head;
		while(i.next != null) {
			i = i.next;
		}
		i.next = tail;
		return tail;
	}
	
	public void d(No in) {             				// display in the console each Node in the List
		No i = in;
		while(i != null) {
			System.out.print(i.data + " ->> ");
			i = i.next;
		}
		System.out.println("null");
	}
	
	public int l(No start) {					    // find the length of the List by counting each node of the List until null is found;
		int c = 0;
		No i = start;
		while (i != null) {
			c = c + 1;
			i = i.next;
		}		
		return c;
	}
	
	public void cl(int p, No t) {  					 // create a loop   [call con  .data del startNode che hai scelto;]
		No i = head;
		while(i.data != p) {
			i = i.next;
		}
		t.next = i;
	}
	
	public No g(No s) {                              // get the last Node of the List (if is not a loop)
		No i = s;
		while(i.next != null) {
			i = i.next;
		}
		No t = i;		
		return t;
	}
	
	public Boolean is(No h) {                        // is this List containing a loop?
		No s = h;
		No f = h;
		while(s != null && f != null) {
			s = s.next;			
			f = f.next;
			f = f.next;			
			if(s.data == f.data) {
				return true;
			} 
		}		
		return false;
	}
	
	
///////////////////////////////////////////////////////////////////////////////
/*
 * 	TASK: find in which node the loop gets generated; use this loop ONLY if you already know the LinkedList is a loop;
 * 
 * 		  the method should return the .data of that particular node
 * 		  use Floyd's turtle and hare algorithm to find the meeting Node of the two pointers (if the loop is infinite they're gonna meet, sooner or later)
 * 		  both pointer Nodes start at head;
 * 		  once they meet, the loop stops. now you have both pointers at the same x node;
 * 			
 * 		  create another loop;
 * 		  one of the pointers goes back to start of the List, at Node head;
 * 		  now, these two nodes have to meet again. but they move at same speed now: one step at the time;
 * 
 * 		  the loop stops once they meet. mathematically, no matter the length of the List, they're going to meet at the starting Node of the loop;
 * 			
 *        return the startingLoopNode;
 * 
 */	
	 
	// MY GUESS:        
	public No findStartLoop() {
		No slowPointer = head;
		No fastPointer = head;
		while(fastPointer != null && slowPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			if(fastPointer.data == slowPointer.data) {
				slowPointer = head;
				break;			                                      //!!! IMP  break non esce solo dall'if, esce anche dal while	
			}		
		}
		
		while(fastPointer.data != slowPointer.data) {
			fastPointer = fastPointer.next;
			slowPointer = slowPointer.next;
		}
		return slowPointer;                                           // oppure fastPOinter, sono nella stessa posizione tannto
	}	
	
	// MATHEMATICAL DEMONSTRATION AT 8h  https://www.youtube.com/watch?v=2ZLl8GAk1X4
	
	// TEACHERS':        [[both mine and teachers work only in a SORTED looping linked list without duplicates. otherwise both pointers could end up in different pointers sharing same .data, pretending is the same node;]]
	// two methods: first public second private, BOTH return Node; 
	//              the first finds a meeting point of rabbit and hare pointers, using a loop until they share same .data
    //              and returns the call of the second with the meeting node as argument
	//              the second argument uses the two pointers and a loop to find the starting Node (remember, both pointer now move one step at the time.)
    //                  RETURN the starting Node;	
	
	public No teacherFinderLoop(No turtle, No rabbit) {          // ... you already know there is a loop...
		while(true) {                                            // ... (turtle != null && rabbit != null)    // return null;
			turtle = turtle.next;
			rabbit = rabbit.next.next;			
			if (turtle.data == rabbit.data) {
				return teacherFinderNode(turtle, head);          // if you find the meeting point in the loop, return a call to another method (that will return a Node, so no error)
			}
		}		
	}
	
	private No teacherFinderNode(No met, No start) {        
		while(start != met) {
			start = start.next;
			met = met.next;
		} 		
		return start; 									  // send this node to teacherFinderLoop: it will return it to main()
	}
	
///////////////////////////////////////////////////////////////////////////////

	
	public static void main(String[] args) {
		LinkedLoop ll = new LinkedLoop();
		ll.head = new No(1);
		No one = ll.t(2);
		No two = ll.t(3);
		No three = ll.t(4);
		No four = ll.t(5);
		No five = ll.t(6);
		No six  = ll.t(7);		
		
		No tailNode = ll.g(ll.head);					// get the tail.
//		ll.cl(two.data, tailNode); 						//  7 ->> !!3 ->> 4 ->> 5 ->> 6 ->> 7 ->> 3 ->> 4 ->> 5 ->> 6 ->> 7 ->> 3  etc;
		
		ll.cl(one.data, tailNode);                      // now at 2.              
		boolean loop = ll.is(ll.head);                  // is a loop.
//		ll.findStartLoop();
		
		No theStartingNode = ll.findStartLoop();
		System.out.println(theStartingNode.data);       // 3  //  2   ====>  Mine works
		
//		int l = ll.l(ll.head);
		
		System.out.println(ll.teacherFinderLoop(ll.head, ll.head).data); // ok
	}
}