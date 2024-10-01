package algoLessona40returnsumlistOfTwoLinkedLists;


// remainder logic has to be perfected;

/*
SCENARIO: 
	there are two linked list storing INTEGERS. there is NO EMPTY list, there are NO negative integers.
	in this list, digits are stored in REVERSE order.
	each of the nodes of the list store ONLY ONE digit.
	
TASK:   
	add two numbers, one from each of the lists, and return the sum as a new linked list 
	you may assume none of the possible lists contains any leading zero.
	


GENERAL DESCRIPTION: I want to iterate through each node of these two lists, and store the sum of their .data in a new List;

STEP BY STEP:					 
					 tools:
					 use a method to perform the algorithm;
					 the method should take two lists a and b as ARGUMENTS (one for each number to add);
					 each lists has nodes, each node has .data to store an int digit.
					 In order to move along each of these lists, you need pointer Nodes. create one pointer for listA and one pointer for list b;
	
					 inside the method, create a new Node, this node will be linked to nodes that will store the RESULT of the addition
					 to link this "head" node to .next nodes, and create by doing so a new LinkedList "result", you need a pointer Node;
					 
					 I need a while loop to automatically move each pointer to their next node in their list;
						use a condition to prevent nullPointerException;
					the method shoud RETURN a Node, specifically the head Node of a newly created list;
					
					actions:
						initialize two pointers a and b to the head of lists a and b you received as args;
						initialize a dummy Node to 0;
						initialize a dummy pointer to one of the lists;
						initialize a new Node called remainder to 0;
					
					WHILE BOTH of the list pointers are NOT null, do these things:         !!! I NEED A NEW LIST FIRST TO INSERT VALUES
																						   !!! OR CAN I JUST USE DUMMY POINTER .DATA TO
																						   !!! SUM UP BOTH LIST .DATA???	
																							
					    IF the sum .data of the pointer A PLUS .data of pointer B
						is LESS THAN 10:
							store the sum in the current dummy pointer;                    /// this pointer has NO .next yet. wait to move it;
							
						OTHERWISE:
							IF .next of pointer B is null AND .next of pointer A:									
								add +1 to .data of the .next of pointer A;                    !!! SOLVED   WHAT IF .next of list A is null??
								subtract -10 from the sum and store the result in the current dummy pointer;
								initialize .next of dummy pointer to .next of A;
								move dummy pointer to its .next;
							
							ELSE IF BOTH .next of pointers A and B are null:
								add +1 to the remainderNode .data;
								store the complete sum in the dummy pointer;
								then subtract 10 or 20 from the complete sum;
								initialize .next of dummy pointer to remainderNode;
								move dummy pointer to its .next;
								
							ELSE add +1 to .data of the .next of pointer B;                 // if a. is null is true, and both a and b are null is false, then b.next is not null is true     
								 do the sum of .data of A and B,
								 store it in dummy pointer .data;
								 subtract -10 from the sum and store the result in the 
								 current dummy pointer;
								 initialize the .next of dummy pointer to .next of B;
								 move dummy pointer to its .next;
							
					
							
						IF .
						INITIALIZE .next of dummy pointer to .next of pointer A;
						MOVE dummy pointer to its .next;
						MOVE pointer A to its .next;
						MOVE pointer B to its .next;
						
					
					IF pointer A is null AND  pointer B is NOT null:
						// while(pointerB is not null)
							initialize dummy pointer .next to .next of B;
							
					ELSE IF pointer B is null AND POINTER A is NOT null:
						// while(pointer A is NOT null)
							initialize the .next of dummy pointer to the .next of pointer A;
							
					END;
					
					RETURN the .next of dummy NodeList;
					
					////////////
					in the main()
					
					create a new instance of a list 'sum';
					initialize a new head instance variable for 'sum';
						as value, assign the call of this method;
							arguments on call should be: head of list A and head of list B;

*/


public class SumLists {
	
	// MY GUESS:

	private Node head;        // static:

	private static class Node {
		private int data;
		private Node next;
		
		public Node(int inputData) {
			this.data = inputData;
			this.next = null;
		}
	}
	
	public int findLengthList(Node ListHead) {	
		Node nodeCounter = ListHead;
		int count = 0;
		
		while(nodeCounter != null) {          
			count = count + 1;
			nodeCounter = nodeCounter.next;
		}		
//		System.out.println("length of this list is: "+ count);
		return count;
	}
	
	

	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public Node sumLists(Node A_head, Node B_head, Node sumHead) {
		Node A_pointerList = A_head;
		Node B_pointerList = B_head;
//		Node dummyListSumHead  = new Node(0);
		Node dummyListSumTail = sumHead;
		Node remainder = new Node(0);                   
		
//		dummyListSumTail.next = A_head;						// now I have my list.
		
		
		while(A_pointerList != null && B_pointerList != null) {
			
			int sum = A_pointerList.data + B_pointerList.data;
//			System.out.println(sum);
			if (sum < 10) {                                                          // no-remainder logic
				dummyListSumTail.data = sum;
			}
			else if (sum >= 10) {                                                    // remainder logic
				if (B_pointerList.next == null && A_pointerList.next != null) {
					A_pointerList.next.data = A_pointerList.next.data + 1;
					dummyListSumTail.data = sum - 10;
					dummyListSumTail.next = A_pointerList.next;
				}
				
				if (B_pointerList.next == null && A_pointerList.next == null) {
					remainder.data = 1;
					dummyListSumTail.data = sum - 10;
					dummyListSumTail.next = remainder;
				}
							
				if (A_pointerList.next == null && B_pointerList.next != null) {
					B_pointerList.next.data = B_pointerList.next.data + 1;
					dummyListSumTail.data = sum - 10;
					dummyListSumTail.next = B_pointerList.next;
				}
			}
			
			//debug:						
			A_pointerList = A_pointerList.next;
			B_pointerList = B_pointerList.next;
			dummyListSumTail = dummyListSumTail.next;
		}
		
		if (A_pointerList == null && B_pointerList != null) {
			dummyListSumTail.next = B_pointerList.next;	
		}
		
		if (B_pointerList == null && A_pointerList != null) {
			dummyListSumTail.next = A_pointerList.next;
		}		
		
		return sumHead;
	}
	
////////////////////////////////////////////////////////////////////////////
	
	public void display(Node h) {                      
		Node iterator = h;
		
		while(iterator != null) {
			System.out.print(iterator.data + " ->> ");
			iterator = iterator.next;
		}
		System.out.println("null");
	}
	
	public void createLast(Node headList) {
		Node n = new Node(0);
		Node i = headList;
		while (i.next != null) {
			i = i.next;
		}
		i.next = n;		
	}
	
	
////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {                        
		SumLists lsA = new SumLists();
		SumLists lsB = new SumLists();
		SumLists sum = new SumLists();
		SumLists lsS = new SumLists();
		
		// try sum of 10 + 10
		lsA.head = new Node(2);
		lsB.head = new Node(5);	
		Node secondA = new Node(2);
		Node secondB = new Node(3);	
		lsA.head.next = secondA;
		lsB.head.next = secondB;	
		
		sum.head = new Node(0);                                       // a new list with 0-data nodes, same length as the biggest List; refactor the algorithm to store result in this list. use the dummy pointer to iterate in this list;
		int lengthLongestList = lsA.findLengthList(lsA.head);
//		System.out.println(lengthLongestList);
		for (int i = 1; i < lengthLongestList; i++) {        // ricorda, questa lista ha gia un Node di default quindi inizializza i a 1; 
			sum.createLast(sum.head); 
		}		
		
		lsS.head = lsS.sumLists(lsA.head, lsB.head, sum.head);
		
		
		lsA.display(lsA.head);
		lsB.display(lsB.head);
		System.out.println("sum: ");
		lsS.display(lsS.head);	
		
		
//		lsA.findLengthList(lsA.head);		

	}
}