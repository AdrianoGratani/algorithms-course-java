package algoLessonA32removeAGivenKeyFromASortedLinkedList;

public class KeyLinList {
	
	private Nod head;
	private static class Nod {
		private int data;
		private Nod next;
		
		public Nod(int keyArg) {
			this.data = keyArg;
			this.next = null;
		}
	} 
	
	public void d() {
		Nod i = head;
		System.out.print("|||\t ");
		while(i != null) {
			System.out.print( i.data + "  ->>  ");
			i = i.next;
		}
		System.out.println("null \t|||\n");
	}

	public void h(int dataArg) {
		Nod n = new Nod(dataArg);		
		n.next = head;
		head = n;
	}
	
////////////////////////////////////////////////////////
/* 
 * 	TASK: remove a key(a node) from a Singly Linked List;
 * 
 *  MY GUESS:
 *  you are given a key int as argument; check if any of the node of the List contain the same key;
 *  	if that's the case, remove that node from the list. otherwise, don't change anything;
 *  
 *  the method should return void. if you don't find the key, return to main();
 *  
 *  create two nodes. one is the currentNode iterator, the other is the previousNode. why the second one:
 *  	if you find a current.data == to the keyarg, linke the previousNode to the .next of the current, and then delete the .next of current;
 *      so that current will be garbage-collected;
 *       
 *  use a while loop to iterate from head to tail of the List until you find a node containing same .data as the keyarg;
 *  	condition should be: while (current != null && current.data != keyarg)
 *            "if the current Node is not null and is not the node you are looking for: than move on:
 *              move the previousNode to the currentNode, and then move the currentNode to its nextNode; 
*/		
	
//	...MY GUESS:	
	public void f(int k) {
		Nod a = null; 
		Nod b = head;
		
		while(b != null && b.data != k) { // if diff, move to next node with both pointers;
			a = b;
			b= b.next;
		}
		if (a == null && b.data == k) {     //!!! SOLVED
			head = b.next;
			b.next = null;                  // not necessary;
			b = null;						// not necessary;
			System.out.println(String.format("key %d found at 'head' and deleted its node.", k));
			return;
		}
		
		if (b == null) {
			System.out.println("not found."); 
			return;
		} 														   // !!!ERROR: it prints not found EVEN IF the node gets found;  SOLVED: console prints out the result of caling with a 7 key, so it was previous code...   
		a.next = b.next;               						   	   // FOUND: delete reference TO currentNode
		b.next = null;            							       //        and the .next of currentNode;		
		System.out.println(String.format("key %d found and deleted its node.", k));
	}	
	
	// TEACHERS':
	public void t(int k) {
		Nod current = head;
		Nod temp = null;
		
		if (current != null && current.data == k) {                 // if current.data is equal to key, is implicit that is cannot be null. why this double condition?
			head = current.next;
			return;
		}		
		while (current != null && current.data != k) {
			temp = current;
			current = current.next;
		}		
		if (current == null) {
			return;
		}
		
		temp.next = current.next;
		return;		
	}
	
////////////////////////////////////////////////////////	

	public static void main(String[] args) {
		KeyLinList kll = new KeyLinList();
		
		kll.head = new Nod(1);
		kll.h(-1);
		kll.h(-2);
		kll.h(-3);
		
//		kll.f(7);             // mine works!!!      not found.
//		kll.f(-1);		      // key -1 found and deleted its node.
//		kll.f(-3);            //solved !!!ERR no output and debug open. code stops at ln 67 Thread [main] (Suspended (uncaught exception NullPointerException)) KeyLinList.f(int) line: 67  KeyLinList.main(String[]) line: 85	
		
//		kll.t(-2);
//		kll.t(-3);
//		kll.t(-1);
		
		kll.d();		
		
		
	}
}