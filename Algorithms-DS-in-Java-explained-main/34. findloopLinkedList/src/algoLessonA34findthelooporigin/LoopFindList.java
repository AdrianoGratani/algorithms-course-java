package algoLessonA34findthelooporigin;

public class LoopFindList {

	private Noodez head;
	private static class Noodez {
		private boolean alreadySeen;
		private int data;
		private Noodez next;
		
		public Noodez(int data) {
			this.alreadySeen = false;
			this.data = data;
			this.next = null;
		}
	}
	
	public void createT(int dataArg) {
		Noodez tailNode = new Noodez(dataArg);
		Noodez i = head;
		while (i.next != null) {
			i = i.next;
		}
		i.next = tailNode;	    
	}
	
	public Noodez returnN(int positionArg) {
		Noodez i = head;
		while(i.data != positionArg) {
			i = i.next;
		}		
		return i;
	}
	
	public Noodez createInfiniteLoop(Noodez origin) {
		Noodez tail = head;
		while(tail.next != null) {
			tail = tail.next;
		}
		tail.next = origin;		
		return tail;
	}
	
	public void d() {
		Noodez i = head;
		while(i != null) {
			System.out.print(i.data + " --> ");
			i = i.next;
		}
		System.out.println("null");
	}
	
	/////////////////////////////////////////////////////
	/*
	 * TASK: CHECK WHERE THE INFINITE LOOP STARTS IN A SINGLYLINKEDLIST;
	 * 
	 * every node should have a bool alreadySEen to false
	 * loop through the list. until you find a null;
	 * 		 if the bool is true return  the .data of the current node. END THE LOOP(false is default)
	 * 		 ELSE, each boppl, turn it to true.
	 * 			   set iterator Node to iterator.next; 
	   [end of the while loop] return null;
	 * */	
	/////////////////////////////////////////////////////
	
	public Noodez isLoopChecker() {		
		Noodez i = head;
		while (i != null) {
			if (i.alreadySeen == true) {          //default false hai trovato lo starter;
				System.out.println(String.format("found loop, starting at %d node. [this method also returns the node.]", i.data));
				Noodez nodeStarter = i;		      // lo assegni a questo Node;		
				//now turn everything to false again;
				i = head;
				while(i.alreadySeen == true) {
					i.alreadySeen = false;
					i = i.next;					
				}				
				return nodeStarter;               // ritorna il node da cui si origina il loop; 
			}
			i.alreadySeen = true;                 // se non sei passato in questo node, tieni nota del fatto che ci sei passato ora;
			i = i.next;                           // ...e vai al node successivo
		}		
		// se il loop finishe, non hai trovato un loop.
		System.out.println("not a loop. [null is returned.]");
		//rimetti tutto su false.
		Noodez j = head;
		while (j.alreadySeen == true && j != null) {
			j.alreadySeen = false;
			j = j.next;
		}
		// finito di riordinare, ritorna un null;
		return null;
	}
	
	
	public static void main(String[] args) {
		LoopFindList classInstance = new LoopFindList();
		
		classInstance.head = new Noodez(1);
		classInstance.createT(2);
		classInstance.createT(3);
		classInstance.createT(4);
		classInstance.createT(5);
		classInstance.createT(6);
		classInstance.createT(7);
		
		Noodez loopOrigin = classInstance.returnN(2);
		System.out.println(loopOrigin.data);
		
		Noodez lastToOrigin = classInstance.createInfiniteLoop(loopOrigin);      // inf loop is generated;
		
		Noodez loopMaybe = classInstance.isLoopChecker();
		System.out.println(classInstance.isLoopChecker().data);					  // mine works perfectly with different scenarios;		
	}
}