package algoLessonA57DecToBinaryqueue;



/*				CORRECT SOLUTION


	[ to solve this task you are gonna use String data type; ]

	store 1 in the queue first;

	initialize a String array 'arr' with size as the input int 'n'

	enter the for loop; it will finish once you reach n;

		give the front (1) to the array at i;

		initialize two new variables 'a' and 'b': 'a' takes arr[i] and adds "0", while 'b' takes arr[i] and adds "1";

		enqueue 'a' first, and then 'b';    now the queue is:    10 11    and the arr is [1];
*/



public class DecToBins {

	private static class Queue {
		private int length;
		private Node front;
		private Node rear;

		public Queue() {
			this.length = 0;
			this.front = null;
			this.rear = null;
		}

		private class Node {
			private String data;
			private Node next;

			public Node(String dataIn) {
				this.data = dataIn;
				this.next = null;
			}
		}


		public boolean isEmpty() {
			return length == 0;
		}

		public int length() {
			return length;
		}

		public void display() {
			if(isEmpty()) {
				System.out.println("Queue is currently empty.");
				return;
			}	
			
			Node iterator = front;
			while(iterator != null) {
				System.out.print(iterator.data + " ->> ");
				iterator = iterator.next;
			}				
			System.out.println("null");	
		}

		public String pickFront() {
			return front.data;
		}

		public String pickRear() {
			return rear.data;
		}

		public void enqueue(String dataIn) {
			Node newNode = new Node(dataIn);

			if(isEmpty()) {
				front = newNode;
			}
			else {
				rear.next = newNode;
			}

			rear = newNode;
			length++;
		}

		public String dequeue() {
			if(isEmpty()) {
				return "NO ELEMENTS IN THE ARRAY";
			}

	
			String frontDequeued = front.data;
			front = front.next;
			
			if (front == null) {
				front = null;
				rear = null;
			}		
				
			length--;
			return frontDequeued;
		}

		///////////////////////////////////////////////////

		public String[] decToBinary(int n) {
			String[] output = new String[n];

			enqueue("1");

			for(int i = 0; i < n; i++) {
				output[i] = front.data;
				dequeue();
				String iAndZero = output[i] + "0";
				String iAndOne  = output[i] + "1";
				enqueue(iAndZero);
				enqueue(iAndOne);
			}
			return output;			
		}		



	}


	public static void main(String[] args) {

		Queue q = new Queue();

		String[] binaries = q.decToBinary(1000);
		for(int i = 0; i < binaries.length; i++) {
			System.out.print(binaries[i] + ", ");
		}	
	}

}


/*
 * 
 * 
 * `		MY FIRST GUESS (HORRIBLY WRONG)
			GENERATE BINARY NUMBERS FROM 1 TO n USING QUEUE DS



	TASK: given an integer n, generate binary numbers, from 1 to n (included);


 
	i.e.    
	        n = 9;
		methodBinaryList(n) =  [0, 1, 10, 11, 100, 101, 110, 111, 1000];              // in the example data seems to be stored as String...


	
	~ start with simple task in order to solve a bigger problem, non cercare l'algoritmo perfetto, cercane uno funzionante. poi lo perfezioni;
	~ this method should be void;
	~ this method should take int n as argument;
	~ store each number in an array;
		the length of this array is same as n;

	~~~ why do I need a queue? 
	~~~ how to implement a queue to solve this problem?

	~~~ how to count in binary? SEARCH ON THE INTERNET FOR BUILT-IN METHODS


	COME PENSO DI RISOLVERLO:   la MIA queue conserva un solo numero binario, lo incrementa di 1 fin quando il loop dell'algoritmo e' valido,
				    a fine step lo mette nella partizione corrente dell'array;

	n ti serve solo come reference per quando finire il loop: tanto ad ogni step devi solo incrementare di 1;
	questo algoritmo non fa operazioni aritmetiche;
	questo algoritmo usa operazioni logiche per risolvere il problema;
	'se tutta la queue contiene solo 1, aggiungi uno 0'
	'se cio' e' falso:
		se rear e' uguale a 0, diventa 1;
		se rear e' uguale a 1, diventa 0;
	un nuovo loop: vale finche il mio .next e' 0;					1 0 0 0 0 0 0 1
											1 0 0 0 0 0 1 0
											1 0 0 0 0 0 1 1
											1 0 0 0 0 1 0 0
											1 0 0 0 0 1 0 1
																		
										

	devo inserire numeri in un array: quindi inizializzo un array e ad ogni step metto l'ultimo valore inserito nella queuein un a;

	una queue fatta di nodi int. ogni .data puo' essere 0 o 1:
		se la lista e' vuota ci metto 1 e do il valore di front nell'array;;
		se la lista ha un element aggiungo un nodo con 0

		else
	

	~~~ a.se front e rear sono null, enqueue(1);
	~~~ b.se front e' uguale a rear, enqueue(0);

	altrimenti:
		~~~ 1. loop, da front a rear:
		        se da front a rear (compreso) sono tutti 1, enqueue(0) e fallo diventare rear, ovviamente;
		        esci dal loop

	        ~~~ loop da front.next a rear:
	
	        
		~~~ se il mio .next e' 1 e io sono 0, divento 1;

		~~~ la partizione corrente di outputArray riceve il .data appena creato

		\\\ try with decimal firsts... no queue needed to solve this task
		
		method(int n) {
			create an empty array

			create a for loop
				loop until iterator is less than n;
				at each step of the loop, insert i+1 in each partition                    // remember that iterator is 0-indexed in loops
		}
	

// non funziona....;

	


 */
