

package algolessona22insertnodeinsinglylinkedlistinagivenposition;

public class SinglyLinkedList {
	
	private ListNode head;	            // this is a instance variable to initialize the head
	private static class ListNode {     // the blueprint, the class ListNode, data and constructor;
		private int data;
		private ListNode next;
		
		public ListNode(int data) {     ///constructor
			this.data = data;           ///on call initialize the data only
			this.next = null;           ///.next is a ListNode you'decide each time using the = operator
		}
	}
	
	public void display() {             ///a method to display each node.
		ListNode iterator = head;       ///this method creates a node iterator which 'moves' along the list from head to tail (in reality it stores each of their data and their .next LISTnODE reference on loop,)
		System.out.print("Linked list: ");
		while (iterator != null) {      ///if the iterator stores a null, it reached the .next of LAST node. linkedList is finished then.
			System.out.print(iterator.data + " --> ");
			iterator = iterator.next;   /// after the print, the ListNode discard .data and takes the .next, so it 'moves' using the reference data to next ListNode
		}
		System.out.println("null\n");   ///print the end of the linked list
	}
	
	public void length() {         ///this method is used to measure the length (which means, how many nodes are stored in the linked list)
		ListNode counter = head;   /// in a linked list, made of nodes, you need a ListNode to iterate over each node on loop. instead of variables such as 'int i = 0'
		int count = 0;            
		while (counter != null) {
			count = count +1;      ///every time the counter Node contains a Node, or 'moves' to a node, as to say, increment count by one;
			counter = counter.next;///after completing the task, move the counter Node to the next Node (if any), by discarding its data, and assigning the referenct to next node, stored as .next;
		} 
		System.out.println("length: " + count);
	}
	
	public void insertHead(int dataValue) {         ///this method is used to insert a Node as new head of the singly linked list.
		ListNode newNode = new ListNode(dataValue); ///create the new Node;
		newNode.next = head;                        ///assign as .next reference to the new Node, the head instance variable
		head = newNode; 							///now that the new node is linked to the head Node, you can reassign the default head variable to the newNode. 
	}												///the newNode becomes the head then
	
	public void insertTail(int dataValue) {        ///this method assigns a node to the linkedlist, it becomes a new tail
		ListNode newTail = new ListNode(dataValue);/// initialize a new Node. it needs data. this method takes the int data as argument on call 
		ListNode counter = head;                   ///you need to iterate from head to tail, to reassign the tail. create another ListNode called counter;
		
		if (head == null) {						   ///if head is still the empty, default instance variable, it means that the list is empty, it stores no Node at all;
			head = newTail;                        ///assign the 'tail' to the head. this node is the first and last element, so store it in the head... the head is also the tail, as to say;
			return;								   ///no other ListNodes in the Linked List yet, so there's no need to access the loop to iterate over the SinglyLinkedList;
		}		
		while(counter.next != null) {              ///in case the SinglyLinkedList is populated. move from one node to the next until the .next reference of the last node is null.which means you reached the tail of the list.
			counter = counter.next;                ///until you haven't reached the tail, which means, the current node hase to contain a reference to a ListNode in its .next data, reassign the current.next reference to current.
		}										   /// so: current doesn't contain .data anymore, but .next ListNode, so it is the next Node itself; is like the increment of an iterator : i = i + 1;  counter = counter.next;
		counter.next = newTail;					   ///whileloop finished: now counter is set to the tail. its counter.next is null. assign the Node you created to counter.next, so that the new Node is the NEW tail;
	}
	
	
	// MY GUESS
	public void insertNode(int dataValue, int position) {
		ListNode newNode = new ListNode(dataValue);
		ListNode iterator = head;
		int count = 1;
		while(count < position) {
			iterator = iterator.next;
			count = count + 1;
		}
		newNode.next = iterator.next;
		iterator.next = newNode;		
	}
	
	// solution (one of many)
	public void insert(int data, int position) {
		ListNode newNode = new ListNode(data);     //il node che vuoi inserire
		if (position == 1) {
			newNode.next = head;
			head = newNode;
		} else {
			ListNode previous = null;           // il node precedente a quello che vuoi inserire
			int count = 1;
			while (count < position-1) {        //??? se fosse (count < position), previous = previous.NEXT assegnerebbe a previoius il Node dove VUOI METTERE newNode, mentre tu vuoi tenere questo iteratore alla posizione precedente.
				previous = previous.next;       //??? finish at the NODE before where you want to put newNode
				count++; 						//???
			}
			ListNode current = previous.next;   // counter e' il node DOVE vuoi inserire newNode. previous.next e' la reference a tale posizione. quindi assegna ad essa newNode;
			              					    // ADESSO HAI CONSERVATO IN DUE NODES LE REFERENCE PER PREVIOUS E CURRENT
			previous.next = newNode;			// assegna newNode a previous.next: ecco la situazione:   previous | previous.next -----> newNode | newNode.next ----> current | current.next
			newNode.next = current;             // assegna current come .next the newNode: stai spostando il current node della position dove vuoi inserire Newnode alla next position;         
		}		
	}
	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		
//		sll.head = new ListNode(1); 
//		ListNode second = new ListNode(2);
//		ListNode third = new ListNode(3);
//		ListNode fourth = new ListNode(4);
//		
//		sll.head.next = second;
//		second.next = third;
//		third.next = fourth;

//		sll.insertHead(1234);
//		sll.display();
		
		sll.insertTail(7645);
		sll.display();		
		sll.insertTail(5432);
		sll.insertTail(654);
		sll.insertTail(8765);
		sll.insertTail(54645);
		sll.display();		
		sll.insertNode(10101010, 2);    //!!! SOLVE BUG
		
	}
}