package algoLessonA64LevelOrderTraversalBinaryTreeByQueue;

/*
LEVEL ORDER TRAVERSAL OF A BINARY TREE, USING QUEUES



root 

 */


public class BeeTree {
	private Node root;
	public BeeTree() { this.root = null; }
	public boolean isEmpty() { return root == null; }  

	public void p() {						/// 'p' stands for 'populate' the binary tree;  1. create the nodes 2. use the nodes in the bt;
		this.root = new Node(1);				
		Node a = new Node(2);  Node b = new Node(3);  Node c = new Node(4);
		Node d = new Node(5);  Node e = new Node(6);  Node f = new Node(7);
		root.l = a;  root.r = b; 	a.l = c;  a.r = d;		b.l = e;  b.r = f;
	}

	public void levelOrderTraversalofBinaryTreeUsingQueues(Node r) {                // 'r' arg stands for the root of the binarytree you want to explore;
		if (r == null) { return; }		// base case;
		Queue q = new Queue();                  // no further declaration needed: the queue you created implicitly deploys int Nodes only;
		q.offer(r);
		while (!q.emptyQ()) {
			Node t = q.pull();              //  't' is a temporary node;
			System.out.print(t.d + " ");
			if(t.l != null) { System.out.print(" -- offered: " + t.l.d + " -- ");  q.offer(t.l); }
			if(t.r != null) { System.out.print("offered: " + t.r.d + " -- "); q.offer(t.r); }
		}
	}

	private class Queue {
		private Node first;
		private Node last;
		public Queue() { this.first = null; }
		public boolean emptyQ() { return first == null; }
		public void offer(Node newQueueNode) {
			if (emptyQ()) { first = newQueueNode; last = newQueueNode; }
			else { last.n = newQueueNode; last = newQueueNode; }
		}
		public Node pull() { Node p = first; first = first.n; return p; }
	}	

	private class Node {
		private int d;   private Node l;  private Node r;  private Node n;                    // n stands for 'next'; is used only for the Nodes in the Queue;
		public Node (int dataIn) {  this.d = dataIn;  this.l = null;  this.r = null;  this.n = null;
		}		
	}


	public static void main(String[] args) {
		BeeTree bt = new BeeTree();
		bt.p();
		bt.levelOrderTraversalofBinaryTreeUsingQueues(bt.root);
	}	
}

