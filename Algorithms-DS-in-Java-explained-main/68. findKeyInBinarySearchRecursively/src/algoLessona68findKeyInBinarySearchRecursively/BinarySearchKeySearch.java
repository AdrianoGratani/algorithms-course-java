package algoLessona68findKeyInBinarySearchRecursively;

/*				HOW TO SEARCH FOR A GIVEN KEY IN A BINARY SEARCH TREE.		(RECURSIVE APPROACH)											*/
//Classes: Binary search tree, Node, Queue. Methods: create Binary search tree, insert a Node, find a key in tree, output the binary search tree (level order traversal);

public class BinarySearchKeySearch {	private Node rt;		public BinarySearchKeySearch() { this.rt = null; }

	private class Node {  private Node l;	private Node r;   private Node n;   private int d;
		public Node(int in) { this.d = in; this.l = null; this.r = null; this.n = null; }
	}
	private class Queue { private Node f; private Node l; private Node n;	public Queue() { this.f = null; this.l = null; this.n = null; }
		public void o(Node n) {   if (f == null ) { f = n; l = n; }   else { l.n = n; l = n; }   }
		public Node p() { if(f == null && l == null){ return null; }  if(f == l){Node one = f; f = null; l = null; return one;}  Node ret = f;  f = f.n;  return ret;  }
		public boolean e() { return f == null; }
	}
	
	public boolean isEmpty() { return rt == null; }
	public void c(int rootData) { if (isEmpty()) { rt = new Node(rootData); }  else { return; }	}
	public Node ins(Node tRoot, int v) { if(tRoot == null){ tRoot = new Node(v); return tRoot; } if (v < tRoot.d) { System.out.println(tRoot.d + " " + v); tRoot.l = ins(tRoot.l, v); } if (v > tRoot.d) { System.out.println(tRoot.d + " " + v); tRoot.r = ins(tRoot.r, v); } return tRoot;}
	public void d(Node root) { Queue q = new Queue();  q.o(root);  
		while (!q.e()) { Node t = q.p(); System.out.print(t.d + " " + q.e() + " ->> "); if(t.l != null) { q.o(t.l); } if(t.r != null)  {q.o(t.r); }   }
	}

	// today's algorithm:
	public Node findKeyInBinaryTreeRecursively(Node tempRoot, int keyValueToFind) {
		if(tempRoot == null) {  System.out.println("Key not found.");	return tempRoot;  }
		if(keyValueToFind == tempRoot.d) {  System.out.println("Key found."); return tempRoot;  }
		if (keyValueToFind < tempRoot.d) {  findKeyInBinaryTreeRecursively(tempRoot.l, keyValueToFind);  }
		if (keyValueToFind > tempRoot.d) {  findKeyInBinaryTreeRecursively(tempRoot.r, keyValueToFind);  }
		return null;
	}
	public static void main(String[] args) {
		BinarySearchKeySearch b = new BinarySearchKeySearch();
		b.c(50);	b.ins(b.rt, 15);	b.ins(b.rt, 70);	b.ins(b.rt, 74);	b.ins(b.rt, 30);	b.ins(b.rt, 3);       
		b.d(b.rt);    // "binary search display algorithm in LEVEL ORDER TRAVERSAL";
		int keyNotFound = b.findKeyInBinaryTreeRecursively(b.rt, 574).d;
		int keyFound = b.findKeyInBinaryTreeRecursively(b.rt, 50).d;
		System.out.println("/n" + keyFound + " " + keyNotFound);
	}
}
