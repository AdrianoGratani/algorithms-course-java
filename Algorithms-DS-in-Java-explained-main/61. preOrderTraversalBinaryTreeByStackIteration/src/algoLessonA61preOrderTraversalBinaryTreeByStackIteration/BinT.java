package algoLessonA61preOrderTraversalBinaryTreeByStackIteration;

/* LINE 60
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

public class BinT 
{
	private Node root;                           // binary tree variables;
	private int lengthTree;

	public BinT() {				     // binary tree constructor;
		this.root = null;
		this.lengthTree = 0;
	}

	public boolean isTreeEmpty() {		     // binary tree methods;
		return lengthTree == 0;
	}
	
	public int printRoot() {
		if(isTreeEmpty()) {
			return -1;
		}
		System.out.println(root.data);
		return root.data;
	}

	public void createBinaryTree() {
		root = new Node(1);
	
		Node first = new Node(2);
		Node second = new Node(3);
		Node third  = new Node(4);
		Node fourth = new Node(5);
		Node fifth = new Node(6);
		Node sixth = new Node(7);

		root.right = first;
		root.left = second;
		first.right = third;
		first.left = fourth;
		second.right = fifth;
		second.left = sixth;
	}

	public void displayBinaryTreeIteration(Node rootTree) {

		if (rootTree == null) {
			return;
		}

		Stack s = new Stack();		
		s.push(rootTree);		

		while(!s.isEmpty()) {

			Node temp = s.pop();
			System.out.print(temp.data + " ->> ");

			if(temp.right != null) {
				s.push(temp.right);
			}
			if(temp.left != null) {
				s.push(temp.left);
			}
		}		
	}

	public void displayBinaryTreeByRecursion(Node temp) {	
		if(temp == null) { return;}
		
		System.out.print(temp.data + " --> ");	
		displayBinaryTreeByRecursion(temp.left);	
		displayBinaryTreeByRecursion(temp.right);	
	}


	/////////////////////////////////////////////////////////////////////////////////////

	private class Node {			     // Node class
		private int data;	             // node instance variables
		private Node right;
		private Node left;
		private Node stackNext;

		public Node(int dataIn) {	     // node constructor
			this.data = dataIn;
			this.right = null;
			this.left = null;
			this.stackNext = null;      // ho due tipi di node: uno per binary tree e uno per stack; ma il node e' definito una volta per tutte qui;
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////

	private class Stack {		             // Stack class;
		private int length;                  // stack variables;
		private Node peek;

		public Stack(){
			this.length = 0;
			this.peek = null;
		}				
		// stack methods:  these methods rely on private variables. 
		// if you try to declare these methods outside stack scope, you'll get an error;
		public boolean isEmpty() {
			return length == 0;          //    =  length is in the stack scope, so this method has to be declared within the stack scope
		}

		public void push(Node dataIn) {
			Node newStackNode = dataIn;

			if(isEmpty()) {
				peek = newStackNode;
			}
			else {
				newStackNode.stackNext = peek;
			}
			peek = newStackNode;
			length++;
		}

		public Node pop() {
			if (isEmpty()) {
				return null;
			}
			Node dataReturn = peek;
			peek = peek.stackNext;
			length--;
			return dataReturn;
		}

		public Node peek() {
			return peek;
		}

		public void displayStack() {
			if(isEmpty()) {
				return;
			}
			Node iterator = peek;
			while(iterator != null) {
				System.out.print(iterator.data + " --> ");
				iterator = iterator.stackNext;
			}
			System.out.println(" null ");			
		}

	}		

	////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////


	static public void main(String...x) {
		BinT b = new BinT();
		b.createBinaryTree();
		b.displayBinaryTreeIteration(b.root);
		
		System.out.println("\n\n\t\tRECURSIVE:\n");
		b.displayBinaryTreeByRecursion(b.root);
	
	}

}