/*
 * 

   11          < - carry = 8 + 2 + 1 = 11
    21 +
    89 =
    ____
   110		

		 A	            1  ->  2  ->  null          in reverse order: linked list moves only in one direction, you can create a carry node ONLY AFTERWARDS. 
		 B                  9  ->  8  ->  null                                      
		result	            0  ->  1  ->   1  ->   null           display:  110

		dummy
		tail

each int is stored as .data inside a Node
result is the head of a new List. result is its pointer. at each step, if at least A or B contain .data, result creates a new Node with that data, or with a sum+carry
A and B are pointers.




public Node add(Node A, Node B) {                      // return the head of the dummy list you create;   A and B are HEAD of their respective lists;
	Node dummy = new Node(0);
	Node tail = dummy;
	int carry = 0;

	while (A != null || B != null) {
		// fai la somma;
		int x = (A != null) ? A.data : null;
		int y = (B != null) ? B.data : null;
		int sum = carry + x + y;

		// occupati di come gestire il riporto e dai il data al tail node;
		if (sum >= 10) {carry = sum / 10;};           //
		 tail.next = (sum >= 10) ? new Node(sum % 10) : new Node(sum);
		tail = tail.next;
		if (a != null) {a = a.next;}
		if (b != null) {b = b.next;}		
	}
	if (carry > 0) { tail.next = new Node(carry);}                          // 90 + 10: both a and b have two nodes, but the result needs one more for the 1 carry
} 
return dummy.next;

 * */


package algoLessonA40solution;

public class AddListSum {
	
	private N h;
	
	private static class N{
		
		private int data;
		private N next;
		
		public N(int dataInput) {
			
			this.data = dataInput;
			this.next = null;
		}
	}

	
	public void d(N h) {
		N i = h;
		while (i != null) {
			System.out.print(i.data + " ->> ");
			i = i.next;
		}
		System.out.println("null");
	}
	
	
	public int l(N headList) {
		int len = 0;
		
		N iterator = headList;
		
		while(iterator != null) {
			len = len+ 1;
			iterator = iterator.next;
		}
		
		return len;
	}
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public N add(N a, N b) {                        // it takes for granted that .data is only integer;
		N dummy = new N(0);
		N tailPtr = dummy;                        
		
		int x = 0;
		int y = 0;
		int sum = 0;
		int carry = 0;		
		
		while(a != null || b != null) {
			if (a != null) {x = a.data;} else {x = 0;}
			if (b != null) {y = b.data;} else {y = 0;}
			sum = carry + x + y;
			if (sum >= 10) {carry = sum / 10;}
			
//			solo ora crei il .next di tail, della dummy list:
			tailPtr.next = new N(sum % 10);			
			tailPtr = tailPtr.next;
			
			if (a != null) {a = a.next;}                        // altrimenti resta in null;
			if (b != null) {b = b.next;}			
		}
		
		if (carry > 0) {tailPtr.next = new N(carry);}		
		return dummy.next;                                      // return the HEAP, NOT the stack;
	}
	

//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		
		AddListSum A = new AddListSum();
		AddListSum B = new AddListSum();
		
													// A = 749     B = 56
		A.h = new N(7);
		N sa = new N(4);
		N ta = new N(9);
		A.h.next = sa;
		sa.next = ta;
		
		B.h = new N(5);
		N sb = new N(6);
		B.h.next = sb;
			
		AddListSum s = new AddListSum();
		s.h = s.add(A.h, B.h);                    // la head di questa lista viene generata dal metodo, dopodiche il pointer aggiunge ad ogni step la somma del .data di a b list in un nuovo node. tali nodes sono collegati alla head della sum list
		System.out.print("sum: ");
		s.d(s.h);	
		
		
	}	
	
	
}
