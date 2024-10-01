package algoLessonA33detectALoopInTheLinkedList;

public class LoopList {
	
	private Nonna head;
	private static class Nonna {
		private int nonnaData;
		private Nonna next;
		
		public Nonna(int inputData) {
			this.nonnaData = inputData;
			this.next = null;			
		}
	}
	
	public void show() {
		Nonna iterator = head;
		while(iterator != null) {
			System.out.print(iterator.nonnaData + " ->> ");
			iterator = iterator.next;
		}
		System.out.println("null");
	}
	
	public void createHead(int newHeadData, Nonna h) {
		if (h == head) {
			Nonna newNonnaHead = new Nonna(newHeadData);
			newNonnaHead.next = head;
			head = newNonnaHead;
			return;
		}		
	}
	
	public void insertNonna(int newNonnaData, Nonna head) {
		Nonna newTail = new Nonna(newNonnaData);
		
		if (head == null) {
			newTail.next = head;
			head = newTail.next;
		}
		
		Nonna iterator = head;
		while(iterator.next != null) {
			iterator = iterator.next;
		}
		iterator.next = newTail;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////
	
	// voglio raggiungere un Node che contiene il data == all'argument. quando lo trovo, prendo la tail della List, e come tail.next gli do il node nel quale mi trovo ora;
	//  mi serve creare un metodo che trovi la tail e faccia RETURN della tail cosi' che posso usarla qui.
	public Nonna getTail() {
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return head;
		}
		
		Nonna iterator = head;
		while(iterator.next != null) {
			iterator = iterator.next;
		}
		
		return iterator;
	}
	
	public void createInfiniteNonnaLoop(int nodePositionStartLoop, Nonna lastNode) {
		Nonna startLoopAtPosition = null;
		if (head == null) {
			System.out.println("List empty");
			return;
		}
		
		Nonna iterator = head;
		while(iterator.nonnaData != nodePositionStartLoop) {
			iterator = iterator.next;
		}
																//		now, iterator is at position argument == position 4,  is at Node 4
		lastNode.next = iterator;                               //      last Node.next is not a null anymore, but a previous Node: Node with data 4 
	}
	
	// MY GUESS:
	
	public Boolean LoopFinder() {
		Nonna fastptr = head;
		Nonna slowptr = head.next;
		
		while((fastptr.nonnaData != slowptr.nonnaData) && (fastptr != null || slowptr != null)) {
			fastptr = fastptr.next.next;
			slowptr = slowptr.next;
		}
		if (fastptr != null || slowptr != null) {          // se arrivi alla fine del loop e ti trovi in null, vuol dire che hai perlustrato fino alla fine la lista senza trovare nessun loop;
			return false;
		}
		return true;                                       // se NON sei in null con i ptr, vuol dire che il loop si e' fermato in una posizione dove entrambi i nodeptr combaciano == e' un loop;
	}	
	
	// TEACHERS:
	public Boolean teach() {
		Nonna slow = head;
		Nonna fast = head;
		while (slow != null && fast != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow.nonnaData == fast.nonnaData) {
				return true;
			}
		}		
		return false;
	}
	
	public void createLoop() {
		Nonna first = new Nonna(1);
		Nonna second = new Nonna(2);
		Nonna third = new Nonna(3);
		Nonna fourth = new Nonna(4);
		Nonna fifth = new Nonna(5);
		
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;      // no infinite loop;
//		fourth.next = second;     // generate an infiniteloop
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		LoopList ll = new LoopList();
// mine
//		ll.head = new Nonna(5);                          // la class di Nonna deve essere static... altrimenti non puoi usarla qui nel main, ne assegnarle data;
//		ll.createHead(4, ll.head);
//		ll.createHead(3, ll.head);
//		ll.createHead(2, ll.head);
//		ll.createHead(1,  ll.head);
//		ll.createHead(0, ll.head);
		
//		ll.insertNonna(6, ll.head);
//		ll.insertNonna(7, ll.head);
		
//		Nonna lastNodeInTheList = ll.getTail();
//		System.out.println(lastNodeInTheList.nonnaData);
//		ll.createInfiniteNonnaLoop(4, lastNodeInTheList);     // it works, now you have to create a method to know if there is a loop in the Node List.
//		ll.show();	 // 0 ->> 1 ->> 2 ->> 3 ->> 4 ->> 5 ->> 6 ->> 7 ->> 4 ->> 5 ->> 6 ->> 7 ->> 4 ->> 5 ->> 6 ->> 7 ->> 4 ->> 5 ->> 6 ->> 7 ->> 4 ->> 5 -
		
//		boolean is_loop = ll.LoopFinder();                    // mine works!! false is not working
//		System.out.println(is_loop);
		
		//teacher
		ll.createLoop();
		System.out.println(ll.teach());
	}
}