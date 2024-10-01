package algoLessonA36deleteLoopInASingledList;

public class DelLoopList {	
	private N h;	
	private static class N {		
		private int da;
		private N ne;
		
		private boolean o;
		
		public N(int in) {
			this.da = in;
			this.ne = null;
			this.o = false;
		}
	}
	
//
	
public void d(N s) {
	N i = s;
	while(i != null) { 
		System.out.print(i.da + " --> "); 
		i = i.ne;
		}
	System.out.println("null");
}	

public void nn(int in) {
	N i = h;
	N n = new N(in);	
	while(i.ne != null) { i = i.ne; }
	i.ne = n;
}
	
public N l() {
	N i = h;
	while(i.ne != null) { i = i.ne; }
	return i;
}

public N ff(int p) {                     							  // find a Node by .data da per scontato che inserisci un input corretto;
	N i = h;
	while(i.da != p) { i = i.ne; }
	return i;
}

public void cl(N b, N e) {              							  // create a loop, by conjunction of last and sixth node in the list,(provided by ff() l() methods call-on-call ;
	e.ne = b;	
}

public N o() {     													  // trova l'origin da per scontato che tu sappia se il loop esiste o meno;
	N i = h;
	N j = h;
	while(true) {
		i = i.ne;
		j = j.ne.ne;	
		if (i.da == j.da) {break;}
	}
	i = h;
	while(i.da != j.da) {
		i = i.ne;
		j = j.ne;
	}
	return i;
}

///////////////////////////////////////////////////////////////////////////////////////
/*	TASK: remove the loop from a sorted Linked List;
 * 
 * 	~ iterate to the Node THE LAST NODE of the loop, the one before the Node 'origin' found with o(), and delete the link to 'origin';
 * 	  
 *  ~ two options: 1. do the same as o() but one more Node as previous. once you find the origin, assign to the previous node.next null;
 *                 2. create a new instance variable, boolean, false by default. 
 *                 	
 *                 	  a method removeLoop() uses an infinite while loop: once you find the origin it stops (it takes for granted that the List contains a loop and that sooner or later you'll find it.)
 *                    this method takes to Node pointers, one points at the originNode, the other pointing at the position BEFORE
 *                    at each loop turn the false to true and check if the current originNode holds a true
 *                    	if not, move previousNode to originiNode, and originNode to its next,. 
 *                    you'll find the first true at the very origin of the loop;
 *                    SET the .next of previous to null: now you removed the loop from the list;
 */

	//MY GUESS   2.:

public void r() {
	N or = h;
	N pr = null;
	while(true) {                    // takes for granted you'll find a way to remove the loop...
		if (or.o == true) {
			pr.ne = null;
			or = h;
			while(or != null) {      // reset .o to default;
				or.o = false;
				or = or.ne;
			}
			return;                  // very important other wise you get a nullpointerexc (prev delets its .next until you find the last null: you deleted all the list!)
		}
		or.o = true;
		pr = or;
		or = or.ne;
	}
}

	//TEACHERS':         very intuitive..

	public void t() {                                        // a.
		N rr = h;
		N tt = h;
		while (rr.ne != null && tt.ne != null) {
			rr = rr.ne.ne;
			tt = tt.ne;
			if (rr.da == tt.da) {							 // b.
				rl(tt);
				return;										 // e.
			}
		}
	}
	
	public void rl(N n) {									 // c.
		N s = h;
		while (s.ne != n.ne) {
			s = s.ne;
			n = n.ne;
		}
		n.ne = null;      								 	// d.
	}

	
///////////////////////////////////////////////////////////////////////////////////////
		
	
	public static void main(String[] args) {
		DelLoopList dll = new DelLoopList();		
		dll.h = new N(0);		
		
		for(int i = 1; i <= 20; i ++) {	dll.nn(i); }
		dll.cl(dll.ff(5), dll.l());
//		dll.d(dll.h);				
		dll.r(); 										// ...mine works!
//		dll.t();
		dll.d(dll.h);
	}
}