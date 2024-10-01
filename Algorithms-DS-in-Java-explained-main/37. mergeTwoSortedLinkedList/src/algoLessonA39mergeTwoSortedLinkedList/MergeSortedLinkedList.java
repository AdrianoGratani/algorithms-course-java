package algoLessonA39mergeTwoSortedLinkedList;

public class MergeSortedLinkedList {

	private Nodo head;
	
	private static class Nodo{
		
		private int data;
		private Nodo next;
		
		public Nodo(int dataInput) {
			this.data = dataInput;
			this.next = null;
		}
	}
	
	public void createLast(Nodo headInput, int lastNodoData) {
		Nodo last = new Nodo(lastNodoData);
		Nodo i = headInput;
		
		while(i.next != null) {
			i = i.next;
		}
		i.next = last;		
	}
	
	public void display(Nodo headList) {
		Nodo i = headList;
		while(i != null) {
			System.out.print(i.data + " ->> ");
			i = i.next;
		}
		System.out.println("null");
	}
	
////////////////////////////////////////////////////////////////////////
/*	TASK: merge two sorted linked list, of equal OR different length, both starting number is more than one;
 * 
 *       [my algorithm was the same as the teacher's, even in head Node c initializing method (only difference: I delegate this to another method call)
 *        BUT I didn't create a dummy node List. so: at each step I re-assigmed c to its next (smallest .data between node in list a or b) leading to 
 *        a null list ...]
 *        
 *        the method takes in TWO node argumens, both are head of respective lists a and b. this method returns a Node;
 *        
/*
1. create a dummy node and an iterator to move across both lists; also initialize iterators on both input lists;

	create a new Node named dummy and initialize it with .data 0
	   this dummy will take all the node from both lists, merged;
	   
	use a Node c to send the reference to next merged Nodes, to this dummy node;
		this Node c starts pointing at dummy;

	also, create two other Node iterators, to iterater respectively across List A and List B;
		you are going to use them to detect which node stores the lowest value by comparison;
			in which case the lowest value will be assigned to the .next reference of c Node;
			
	
2. choose which node, between head of listA and head of listC to assign first to Node c;
	
		compare one head with the other: IF the .data of a is less than or equal to .data of b,
		assign a, as .next reference of c. OTHERWISE, to the same using b Node;
		after doing that, assign the newly created .next reference to c itself: c = c.next;


3. iterate over both list; at each step of the loop assign a new .next reference to the C node;
	
		to iterate over the lists, and create the merged Linked List, you want to use a while loop;
		first and foremost: since you're about to iterate over lists of Nodes, 
		and you are doing so by implementing some iterators specifically created to this method, you
		want to make sure the Nodes you are currently iterating over are NOT null:
			the condition of the loop should be than:
				IF the iterator Node A AND iterator Node B are NOT NULL,
				then execute tasks contained in the while loop one more time;
		
		
	    IF the .data stored in the Node A is less than, or equal to Node B, assign A as .next
		reference to the node C. then, move A to its .next Node reference;
		now you have: C node with a NEW next, and A moved to next spot in the list;
		OTHERWISE assolve the same tasks using Node B instead.
	
		after this if else statemets, move c to its .next;
		
		
4. assign a reference to the remaining portion of the longest List to c Node;

		you have found a null in one of the input lists: the loop is over;
		now you only know that the conditions for the while loop are not valid anymore:
		you have to find though which List is finished and which one is yet to finish;
		you have pointers a and b in last iterated position Node still: use them to check:
		IF a is null, then point .next of c to b,
		OTHERWISE, to the same with b;
		
5.  assign the head of the newly created List to dummy;
	
		remember that dummy has been initilazied to 0 as .data;
		you don't need this dummy .data anymore.
		RETURN from this method with dummy.next;
		if you create a new List, and you assign this dummy Node as head of the List,
		this list is the merged list of the previous two;
		
//  initialize in the main() method a new list named merged. 
		
		initialize the instance variable head with the call of the method you just created.
		provide head of both List A and B as parameters;
		
//  double check if it worked by outputting the result of merged.head;
		
*/
public Nodo merger(Nodo headListA, Nodo headListB) {
//1.
	Nodo dummy = new Nodo(0);
	Nodo tail = dummy;
	
	Nodo listAptr = headListA;
	Nodo listBptr = headListB;
//2.
	if (listAptr.data <= listBptr.data) {
		tail.next = listAptr;
		tail = tail.next;
		listAptr = listAptr.next;
	} else {
	    tail.next = listBptr;
		tail = tail.next;
		listBptr = listBptr.next;
	}
//3.
	while(listAptr != null && listBptr != null) {
		if (listAptr.data <= listBptr.data) {
			tail.next = listAptr;
			listAptr = listAptr.next;
		} else {
			tail.next = listBptr;
			listBptr = listBptr.next;
		}
		tail = tail.next;
	}
//4.
	if(listAptr == null) {
		tail.next = listBptr;
		tail = tail.next;
	} else {
		tail.next = listAptr;
		tail = tail.next;
	}
	
	return dummy.next;
}
////////////////////////////////////////////////////////////////////////
	
	
	
	public static void main(String[] args) {
		MergeSortedLinkedList list_A = new MergeSortedLinkedList();
		MergeSortedLinkedList list_B = new MergeSortedLinkedList();
		MergeSortedLinkedList list_M = new MergeSortedLinkedList();        // la head la inizializzi alla call the merging method delle altre due istanze di lista A e B;
		
		list_A.head = new Nodo(1);
		list_B.head = new Nodo(3);
		
		// prima di inizializzare i nodi, devi inizializzare head variable node, per ogni oggetto lista;
		for(int i = 3; i <= 20; i += 3) {
			list_A.createLast(list_A.head, i);
		}
		for(int j = 4; j <= 40; j += 2) {
			list_B.createLast(list_B.head, j);
		}
		
		list_A.display(list_A.head);
		list_B.display(list_B.head);
		
		list_M.head = list_M.merger(list_A.head, list_B.head);	
		list_M.display(list_M.head);

	}
	
}
