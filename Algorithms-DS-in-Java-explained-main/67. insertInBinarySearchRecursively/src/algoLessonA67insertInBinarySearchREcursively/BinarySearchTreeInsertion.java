package algoLessonA67insertInBinarySearchREcursively;

/*
INSERT A NODE IN A BINARY SEARCH WITH RECURSION METHOD


a binary search is just like a common binary tree made of nodes.
each node stores data, and each node has to be stored in the tree accordingly to its value.
starting from the root, value which are lower than the root will go under the LEFT subtree.
while values which are greater than the root will be stored under the RIGHT subtree:


				binary search example:

a) new Node (value 5) will go on the LEFT subtree of the ROOT;
its .data is 5, 5 is greater than 2, so the new Node has to be on the RIGHT subtree of node(2);

b) new Node (value 15) has .data greater than the root node. it has to go towards RIGHT;
this node has .data which is less than the right subtree(value: 20), so it will go to its left;

	
left subtree (value: 2)		<-	|	ROOT NODE (value: 10)	|   ->   right subtree (value: 20) 
	|									 |
	V									 V
	RIGHT: new Node(value: 5)					     LEFT: new Node(value: 15)	



the question now is: how to iterate over the binary tree?  you want to find an empty spot for the new Node to be placed inside; 
which means that you must iterate over the tree until you reach a null (empty) Node;
this null Node may be a either LEFT or RIGHT subtree: depending on the .value, you must insert it on the proper subtree;
we'll use recursive method calls to call the following algorithm each time from a new position in the binary tree, starting from the root;
if the node you are currently in has a .data bigger than your .value for the new Node, then call the method recursively, assigning as argument
the currentNode.left, otherwise do the same call but using as argument the currentNode.right;
(IMPORTANT, consider current Node as a temporary root of a new subtree: the algorithm, because of its recursive nature, will call itself over and
over, so the logic implemented never changes since the very first call (using the REAL root of the tree);

1. call the method, assign as first parameter the .root of the binary tree; you also want to store a new value (int) so 
this new value has to be declared as second argument;
2. inside the method: check first if the node you are currently in is null: this is a base case, if this is true, the binary tree
is null or you reach the end of one of the last leaf in the binary tree. this means that no other choices left are left given the
value you sent as argument. so, for both cases, you just declare a new Node and you assign 'value' as argument to be sent as .data;
3. if the base case is false, it means either that the binary tree is not empty or that that you had not reached yet a leaf of the binary tree;
4. if the .data of the current 'root' is greater than the .value arg, call again the method recursively: this time, as argument, provide the .LEFT
subtree of the current 'root';
5. otherwise, in case the .data of the current 'root' is less than the value, call the method providing as arg the .RIGHT subtree;



things you need: - a binary tree class, with a root, and its constructor, in which you'll declare that the root instance of 'this.' class 
	 - has to be instantiated to 'null';
		- a method to positionate the new Nodes in the binary tree (this is the current topic);
		- a method to output the content of the binary tree;
		
	 - a Node class, with Node private variables for .left and .right subtrees, and an int variable for .data stored in each Node;
	 - also the constructor: on initialization, you must provide a valid int argument to the Node you want to create;

*****	mistakes to avoid: this method must return the Node to the caller; otherwise you are not inserting the new node in the tree;
at every recursion, if the value is bigger or smaller than the current root data, REASSIGN the tempRoot.right or .left to a recursive call
using as argument the Node tempRoot.right (or .left) itself: this will not affect the data stored, since this algorithm only stores new Node
with the new value in null Node leafs of the tree;

*/


public class BinarySearchTreeInsertion {	private Node root;		
	public BinarySearchTreeInsertion() { this.root = null; }

	private class Queue {    private Node first;	private Node last;
		public boolean emptyQ() { return first == null; }
		public void offerQ(Node newInsertion) { if (first == null) {first = newInsertion;	last = newInsertion;	last.nextQ = null;  return;} else {last.nextQ = newInsertion;	last = newInsertion;} }
		public Node pullQ() { if (first == null && last == null) { return null; }    else { Node nodeReturned = first; first = first.nextQ; return nodeReturned; } }
		public void displayQ() { if (first == null) {System.out.println("queue is currently empty;"); }  else { Node iterator = first; while(iterator != null) {System.out.print(iterator.data + " -> "); iterator = iterator.nextQ; }  }  }
	}

	private class Node{    private Node left;	private Node right;	  private int data;	  private Node nextQ;
		public Node(int dataIn) { this.left = null;	this.right = null;	this.data = dataIn;	this.nextQ = null; }
	}

	public void createRoot(int rootData) {  if (root == null) { root = new Node(rootData); }     else { return; }  }
	
	public Node insertNode(Node tempRoot, int newValue) {   // *****
		if (tempRoot == null) { tempRoot = new Node(newValue); System.out.println("data inserted: " + tempRoot.data); 	return tempRoot; }
		else if (newValue < tempRoot.data) { tempRoot.left = insertNode(tempRoot.left, newValue); }  else if (newValue > tempRoot.data) { tempRoot.right = insertNode(tempRoot.right, newValue); } return tempRoot;
	}
	public void treeOutputIterationQueue(Node root) {
		Queue q = new Queue();		q.offerQ(root);
		while(q.emptyQ() == false) {  Node temp = q.pullQ();  System.out.print(temp.data + " "); if(temp.left != null) { q.offerQ(temp.left); }  if(temp.right != null) { q.offerQ(temp.right); }  }
	}

	public static void main(String[] args) {
		BinarySearchTreeInsertion bs = new BinarySearchTreeInsertion();
		bs.createRoot(10);
		bs.insertNode(bs.root, 15);
		bs.insertNode(bs.root, 16);
		bs.insertNode(bs.root, 12);
		bs.insertNode(bs.root, 11);
		bs.treeOutputIterationQueue(bs.root);                              
	}
}