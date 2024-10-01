package algolessona28b;

public class Singly {
	
	private Node head;
	private static class Node {		
		private int data;
		private Node next;
		public Node(int dataIn) {
			this.data = dataIn;
			this.next = next;
		}
	}
	
	public void d(Node nHead) {
		Node i = nHead;
		while(i != null) {
			System.out.print(i.data + " --> ");
			i = i.next;
		}
		System.out.println("null\n");
	}
	
	public Node r(Node hh) {  // ritorni un node che conservi nel main. tale node devi affidarlo come parametro al metodo d();ss
		Node current = hh;
		Node previous = null;
		Node next = null;
		
		while (current != null) {
			next = current.next;
			current.next = previous;      //  <------
			previous = current;
			current = next;
		}
		return previous;                 // ...che si e' fermato a current, quindi e' il primo elemento del NUOVO loop;
	}

	public static void main(String[] args) {
		Singly s = new Singly();
		
		s.head = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		
		s.head.next = two;
		two.next = three;
		three.next = four;
		
		//s.r();   // il method r() ritorna un Node. devi assegnare tale node ad un nuovo node qui nel Main(); e poi fare d(NodeReversion).
		         // altrimenti, se fai la call di r() senza assegnarlo ad un Node, non ottieni nulla;
		
		Node reversionHead = s.r(s.head);
		s.d(reversionHead);
	}
}