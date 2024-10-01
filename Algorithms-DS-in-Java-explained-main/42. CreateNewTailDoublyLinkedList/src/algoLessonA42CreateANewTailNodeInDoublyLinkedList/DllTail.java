/*   INSERT A NEW NODE IN THE LAST POSITION OF A DOUBLY LINKED LIST

the last position of a dll is called a tail, while the first one is called the 'head' of the linked list


SCENARIO given a dll:  5 <===> 10 <===> 15 <===> 20 <===> 25 <===> 30 ---> null

	where node with .data 5 is the 'head' of the list,
	and the one with .data 30 is the 'tail' of the list,
TASK:	you must insert a new Node, having .data of 35, in this list;
	this new node has to be placed in the last position, after the current 'tail' node;


	in a dll each node object has .data, .previous, and .next instance variables;
	.data is the integer data stored (i.e. has .data of 5);
	.next is a Node = each node (except for the last one), contains a REFERENCE to the next node in the list;
	i.e. Node with .data 10, the second node in this list, stores a reference .next to next node, the ADDRESS
	so, Node.next is the Node with .data of 15;

	.previous is the other instance variable and works just the same;
	
STEPS:  you need a method in your class to perform this task; the method has to be accessible in main() method by
	any potential instance;
	the method takes in two parameters, both as Nodes: first is the 'head' of the instance of List, 
							   second is the 'tail' of the instance of List;	 
	[in this case, the class List has a class variable for the tail, so that each instance of List can initialize the 
	tail of the List;]


	so:	inside the method, check first if the list is empty;p
		if is empty (which means: BOTH 'head' and 'tail' of the list are equals to 'null'):
			assign newNode to Tail
			assign newNode to Head
		
		if the list is NOT empty:
			assign to tail.next the newNode;
			assign to newnode.previous the tail;
			lastly, assign to tail the newNode; 

CODE:  public void createTail(Node headList, Node tailList, int dataInput) {
                Node newNode = new Node(dataInput);

                if (listIsEmpty()) {
                        head = newNode;
                }

                else {
                        tail.next = newNode;
                        newNode.previous = tail;
                }
                tail = newNode;
        }
*/




package algoLessonA42CreateANewTailNodeInDoublyLinkedList;

public class DllTail {
	
	private Node head;
	private Node tail;
	private int listLength;
	
	private static class Node {
		private int data;
		private Node previous;
		private Node next;
		
		public Node(int dataInput) {
			
			this.data = dataInput;
			this.previous = null;
			this.next = null;
			}
	}
	
	
	
	

		
	
	public int len_d(Node n) {                                   // n can be head or tail, this algorithm will sort it out;
		int counter = 0;

		if (head == null && tail == null) {
			System.out.println("null");
			return counter;
		}
		
		Node iterator = n;		
		
		if (n.previous == null) {                                  // it's the head;
			while (iterator.next != null) {
				counter = counter + 1;
				System.out.print(iterator.data + "(" + counter + ")" + " ->> ");
				iterator = iterator.next;
			}
			System.out.println("null");
			System.out.println("LENGTH IS: " + counter);
			return counter;
		}
		else if (n.next == null) {           // it's the head, and you haven't done head to tail iteration yet;
			while (n.previous != null) {
				counter = counter + 1;
				System.out.print(iterator.data + "(" + counter + ")" + " ->> ");
				iterator = iterator.previous;
			}
			System.out.println("null");
		}
		System.out.println("LENGTH IS: " + counter);
		return counter;
	}
	
	public Node createTail(int dataTail, Node originalTail) {   // n e' gia' la TAIL della list;
		boolean b = isEmpty(originalTail);                      // questa call fatta con la head o tail della list fa return di un boolean;
		Node newTail = new Node(dataTail);
		if (b) {
			head = newTail;
			tail = newTail;
			return newTail;
		}
		else {
			System.out.println("original tail: " + originalTail.data);
			originalTail.next = newTail;
			newTail.previous = originalTail;
			tail = newTail;
			System.out.println("new tail generated: " + tail.data );
			return newTail;
		}
		
	}		
	
	public void createTails(int newHeadData, int nNodes) {
		Node newHead = new Node(newHeadData);                 // in case the list is empty;
		if(head == null) {
			head = newHead;
			tail = newHead;
		}			
		
		for (int i = newHeadData + 1; i <= newHeadData + nNodes; i++) {
			Node iterator = newHead;		
			while(iterator.next != null) {                       // reach the tail of the loop;
				iterator = iterator.next;
			}       											 // now iterator is in the tail;
			Node newNode = new Node(i);
			newNode.previous = iterator;
			iterator.next = newNode;
			tail = newNode;
		}		
	}
	
	
	
	public boolean isEmpty(Node n) {              // n is the head;	   true = empty   false = not empty	
		if (n == null) { return true;}
		else { return false;}
	}
	
	public void testIfElse() {		
		int i = 0;
		if (i != 1) {
			i = 1;
			System.out.println("this is the if statement");
		}
		else {
			System.out.println("this is the else statement");
		}
	}
	
	
	public static void main(String[] args) {
		DllTail instance_1 = new DllTail();
		DllTail tryEmpty = new DllTail();
//		System.out.println(tryEmpty.isEmpty(tryEmpty.head));   
//		tryEmpty.testIfElse();
		
		instance_1.len_d(instance_1.head);						// now the list is empty;
		instance_1.createTails(10, 10);		
		Node t = instance_1.createTail(1000, instance_1.tail);			// it works
		System.out.println(t.data);										// 1000
		System.out.println(instance_1.tail.data);                       // 1000
		instance_1.len_d(instance_1.tail);                              // 1000(1) ->> 20(2) ->> 19(3) ->> 18(4) ->> 17(5) ->> 16(6) ->> 15(7) ->> 14(8) ->> 13(9) ->> 12(10) ->> 11(11) ->> 10(12) ->> 
//		instance_1.len_d(instance_1.head); 								//!!! ERR 20 is the tail...
	}

}
