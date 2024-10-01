package algolessona22insertnodeinsinglylinkedlistinagivenposition;

public class Singlylinkedlists {
	
	private ListNode head; // se metti head insieme a data e next, diventa una CARATTERISTICA di un node, NON UNA ISTANZA DI DEFAULT;
	
	private static class ListNode {		
		private int data;
		private ListNode next;
		
		public ListNode(int nodeDataInputValue) {
			this.data = nodeDataInputValue;
			this.next = null;
		}		
	}
	
	// METHOD TO INSERT A NODE IN A GIVEN POSITION:
	public void insertNode(int nodeData, int nodePosition) {   // to insert a new node you need to parameters as input: the data stored, the position integer representing where in the linked list you want the node to be positioned at;
		ListNode newNode = new ListNode(nodeData);
		ListNode previous = head;
		
		if (nodePosition == 1) {
			newNode.next = head;
			head = newNode;
		} else {
			int count = 1;            			// NOT 0-indexed as an array.
			while (count < nodePosition - 1) {
				previous = previous.next;
				count++;             			//!!!FORGOT TO ITERATE count
			}
			ListNode current = previous.next;   // only now you can initialize current without iterating, because you already reached previous position.
			previous.next = newNode;
			newNode.next = current;
		}
	}
	
	public void display() {
		ListNode iterator = head;
		while (iterator.next != null) {
			System.out.print(iterator.data + " --> ");
			iterator = iterator.next;
		}
		System.out.println("null\n");
	}

	public static void main(String[] args) {
		Singlylinkedlists listInstance = new Singlylinkedlists();
		listInstance.head = new ListNode(1111);
		ListNode bar = new ListNode(2222);
		ListNode foo = new ListNode(3333);
		ListNode baz = new ListNode(4444);
		ListNode ish = new ListNode(5555);
		
		listInstance.head = bar;
		bar.next = foo;
		foo.next = baz;
		baz.next = ish;
		listInstance.display();
		
		listInstance.insertNode( 44444444, 3);
		listInstance.insertNode(1100, 1);
		listInstance.insertNode(2200, 6);
//		listInstance.insertNode(4321, 9);   // Thread [main] (Suspended (uncaught exception NullPointerException))	
											//		Singlylinkedlists.insertNode(int, int) line: 31	
											//		Singlylinkedlists.main(String[]) line: 63	

		listInstance.display();
	}
}