package algolessona30removeduplicatesfromsortedlinkedlistinjava;

public class SinLinListDuplicated {

	private Noodles head;
	
	private static class Noodles {
		private int data;
		private Noodles next;
		public Noodles(int inputData) {
			this.data = inputData;
			this.next = null;
		}
	}
	
	public void d() {
		Noodles h = head;
		while (h != null) {
			System.out.print(h.data + " ->> ");
			h = h.next;
		}
		System.out.println("null");
	}
	
/////////////////////////////////////////////////////////////////////////
/* 
 * TASK: you got a sorted linkedList with n Nodes. it may contain some duplicate data. Find the duplicate data, remove it;
 * 
 * 
 * !!! ERROR: I CREATED A VALID (very heavy though) ALGORITHM, BUT FOR UNSORTED SINGLY LINKED LIST.
 *        
 * remove: delete the Node containing the duplicate data; to do so, remove the reference to the duplicate and change its .next to null,
 *         Java will automatically perform garbage collection;
 *         
 * my idea: create an empty array 'nodeData'.    
 *          iterate from head to tail Nodes of the List.	 condition: Node.next != null;
 *          	each step: initialize a partition of 'NodeData' with the node.data; you need an int i, initialized at 0;
 *                     increment 'i' by one,     move Node to Node.next;
 *                     
 *          now create an algorithm to find the doubles in the array, using two pointers i and j;
 *              create another empty array, 'duplicatesPositions'
 *              loop over NodeData array, if you find a duplicate, store the position (i + 1: List is 1-indexed, starts at 1) inside 'duplicatesPositions';
 *          
 *          loop again over the Node LinkedList.             
 *              at each step, loop over nodeData, i <= duplicatesPosition.length
 *              	inside it, compare current Node with nodeData[duplicatesPosition[i]
 *                      if NodePosition.data is equal to nodeData[duplicatesPosition[i]:
 *              		    remove the Node from the LinkedList;
 *                          move to .next item;
 *                       
 * */	
	// MY GUESS:
	public void removeDuplicates(Noodles head) {
		Noodles current = head;
		while(current != null && current.next != null) {      // non sai a priori se current.next.next sara' null; quindi condizione necessaria e' accertarsi che non sia null quando ci capiti.
			if (current.data == current.next.data) {          //!!! SOLVED if e' vero elimini il duplicate, ~~ELSE~~ fai current.next: dopo aver eliminato il duplicate, current si trova un NUOVO current.next. va controllato anch'esso.
				current.next = current.next.next;             // dupplicates is not a .next reference anymore, so it gets garbace collected, no need to do current.next.next = null;
			}			
//			current = current.next;                           //!!! ERR 1 ->> 2 ->> 3 ->> 3 ->> 4 ->> null
															  //!!! ERR ti sposti di default ad ogni loop: ma se trovi 3 3 3 4 , solo il primo duplicate viene eliminato...
															  //!!! ERR ... al prossimo loop ti trovi al secondo duplicate 3, ma lo confronti con 4;

			else {current = current.next;}  				  //!!! SOLVED 1 ->> 2 ->> 3 ->> 4 ->> null
		}
	}
		
/////////////////////////////////////////////////////////////////////////	
	public static void main(String[] args) {
		SinLinListDuplicated ll = new SinLinListDuplicated();
		
		ll.head = new Noodles(1);
		Noodles s = new Noodles(2);
		Noodles t = new Noodles(3);
		Noodles f = new Noodles(3);
		Noodles fi = new Noodles(3);
		Noodles si = new Noodles(4);		
		ll.head.next = s;
		s.next = t;
		t.next = f;
		f.next = fi;
		fi.next = si;
		
		ll.d();
		ll.removeDuplicates(ll.head);		
		ll.d();
	}
}