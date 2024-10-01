package algoLessonA60preOrderTraversalBinaryTreeByRecursion;

/*
HOW TO PRINT EACH NODE IN A BINARY TREE
	 (PRE-ORDER TRAVERSAL)


public void preOrder(TreeNode root) {
if(root == null) {return;}			// base case;

System.out.println(root.data + " ";
preOrder(root.left);
preOrder(root.right);
}        


left <- root -> right          // each root: new call. root is just a pointer, an iterator, the real root of the binary tree is fixed
 |		  |
 V                V
l <- root -> r   l <- root -> r

// and so on... until you reach leaf of the binary tree;

 */

/*
	// ITERATIVE, NON-RECURSIVE binary tree traversal


use a stack instead of recursive call of the method;
you basically use a stack to extrapolate, step by step, children of each node in the binary tree, starting from root Node
don't mistake stack for the binary tree, you are using the first ds to just iterate over the latter.
when you pop() the peek from the stack, binary tree is still untouched;

start from the root: push the root in the stack, now the stack contains one element;

check if the stack is empty: if it's not empty pop() the current peek into a temporary node;
now you can print the .data stored in the current temp Node you just created;			

now, check first if the .right Node of temp is null or not. If not null, push it in the stack. then, do the same for .left;
*/

public class BinaryT {

	private Node binRoot;

	public BinaryT() {
		this.binRoot = null;		
	}

	private class Node {

		private Node left;
		private Node right;
		private int data;

		public Node(int dataIn) {
			this.data = dataIn;
			this.right = null;
			this.left = null;
		}

	}

	public void createBinaryTree() {
		binRoot = new Node(1);

		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);

		binRoot.left = second;
		binRoot.right = third;
		second .left = fourth;
	}

	public void printNodeBinaryTree(Node currentRoot) {        // RECURSIVE pre-order binary tree traversal
		if (currentRoot == null) {return;}

		System.out.print(currentRoot.data + " ->> ");

		printNodeBinaryTree(currentRoot.left);            // you are implicitly implementing a stack ds
		printNodeBinaryTree(currentRoot.right);
	}

	public static void main(String[] args) {
		BinaryT b = new BinaryT();

		b.createBinaryTree();
		b.printNodeBinaryTree(b.binRoot);
	}
}
