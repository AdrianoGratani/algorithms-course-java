package algoLessonA58BinaryTreeGuessing;

/*

BINARY TREE. INTRODUCTION AND IMPLEMENTATION



Binary tree is a data structure to hold data;
It's a non-linear data structure, not like linked lists, stacks, queues: whose are linear;
each node in the binary tree can point to 2 to n nodes; those nodes are referred to as 'children';
the first node in the binary tree is the 'root' node;



you want to build a binary tree in Java, so you need:
~ a binaryTree class;
instance variables such as 'root'(Node), size (int to count all items stored)

~ the constructor of the binary tree:
root is null, size is 0;

~ the Node class (inside the binary tree class):
instance variables to store data (according to specific data type you want to store within)
and references to parent Node and to nextRight and nextLeft nodes;
each node has to specify if it's a leaf or not;                          // check by method, or create a isLeaf boolean instance variable;


methods to implement:
~ add new data to the binary tree;
~ remove data from the binary tree(leaf);
~ remove specific data from the binary tree;
~ display the data of each node in the binary tree;
~ find is it's empty or not;
~ find if a node is a leaf or not;




problems: a binary tree is non linear: it has one starting point but multiple ending points:
I want to find a way to define a leaf node;

      I want to 'map' the binary tree  (I am not sure about how to implement this)

      I want to move back and forth in the binary tree just like in a Doubly linked list;
 */
/*
AN ALGORITHM TO DISPLAY EACH NODE OF A BINARY TREE


the goal here is to iterate thoroughly a Binary tree without excluding any Node within it;
you can solve this task by implementing a recursive function;

the method I want to implment is called display(), and takes a Node as argument:
you print the argument,
then you call a recursion of the display() method, on the next node of the current
Node, over and over, until you find at least a next Node either on the right or left;

the method display():
if the current node is the root, and it's null, print "this binary tree is empty";
othewise print the current Node data;

if the next on the left is NOT null, call display() recursevly, assign the next node
    on the left as argument:    display(Node Nodeleft);
otherwise, if the next on the right is NOT null, call display() recursevly but assign
    the next right node as argument:     display(Node noderight);

if none of previous is true, both next right and left of the current node are full,
   so you basically just have to exit the current recursion by stating return;


in pseudocode:

void display(Node current) {
	if current is null, print "current binary tree is empty", then return;

	if you are here: it means the current node has at least a child node;			// only one node: can only be left: each node 
												   receives right only if has already left;
	if nextleft is not null: call display(nextLeft);
	otherwise, if nextright is not null: call display(nextRight);
}
*/


public class BinaryGuess {

	private static class BinaryTree {                   // constructors (both tree and its nodes), instance variables, and methods: all inside the BinaryTree class;
		private int size;
		private Node root;

		public BinaryTree(){							// binary tree constructor;
			this.size = 0;
			this.root = null;
		}

		private class Node {
			private int data;
			private static Node nextRight;
			private static Node nextLeft;

			public Node(int dataIn) {					// node constructor
				this.data = dataIn;
				this.nextRight = null;
				this.nextLeft = null;
			}
		}

		public int sizeTree() {
			System.out.println("size of the tree is:" + size);
			return size;
		}

		public boolean isEmptyTree() {
			if (root == null && size == 0) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isLeaf(Node nodeToExamine) {
			return isEmptyTree() == false && 
					nodeToExamine.nextLeft == null &&
					nodeToExamine.nextRight == null;
		}

		public Node createRoot(int dataIn) {
			if (root != null) {
				System.out.println("root already exists.");
				return root;
			}
			Node newRoot = new Node(dataIn);
			root = newRoot;
			size++;
			return root;
		}

	}


	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		System.out.println(bt.isEmptyTree());                // true       correct
  		System.out.println(bt.isLeaf(bt.root));		         // false      correct, bt is empty, so cannot be a leaf since a leaf is a Node and an empty bt contains any nodes;	
		System.out.println(bt.sizeTree() + ". " + bt.size);

		bt.createRoot(1);			             // success

		System.out.println(bt.isEmptyTree());                // false      correct
		System.out.println(bt.isLeaf(bt.root));              // true       correct

		bt.createRoot(11);				     // "root already exists" null          correct

		System.out.println(bt.sizeTree() + ". " + bt.size);

	}

}