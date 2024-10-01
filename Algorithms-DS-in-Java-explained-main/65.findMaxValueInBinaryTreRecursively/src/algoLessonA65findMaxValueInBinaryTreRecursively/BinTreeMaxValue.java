package algoLessonA65findMaxValueInBinaryTreRecursively;

/*
				FIND THE MAXIMUM VALUE IN  A BINARY TREE
							USING RECURSION
			
			
		- this method explores a binary tree made of nodes storing integer data;
		- in order to find the maximum value stored, this method employs recursion;
		- this method returns an integers which is the maximum integer found in the binary tree;
		- the first call of the method is in the main() method of the program,
		from the second method on, the calls are recursive only, and
		each time from a different point in the binary tree: since a binary
		tree is made of nodes each having a left and right subnodes, you must call
		the recursion twice: first for the left subtree, the second for the right 
		subtree;
		
		- this is the algorithm in pseudo-code, step by step:
		initialize the method with the root of the binary tree;
		if the root is null: return from the call with the minimum integer value possible;
		create an int variable 'result', to store the result: you use this variable to store the maximum int;
		at first, store the root data from the node you received in each call: by doing this, this 
		variable will store the data of each node stored in the  binary tree: 
		ex: (call(tempRootNode.left)  ====> int result = tempRootNode.left.data)
		
		create another int variable called 'left' to store the data integer of the left subtree of the current rootNode:
		here is where you need recursion: you call in this variable the method recursively,
		you create a new result integer (or return if the current subtree is null...),
		and in this result integer you will store its integer data, in its result int variable;
		... and if that subtree is not null, then it will be called another recursion once you reach 
		the line of code of the 'left' int variable:
		ex: int left = findMaxValue(tempRootNode.left);
		
		...and then, do the same with the right subtree: you reach this line of code in the LAST call first, so you start
		to explore right subtree very late, only after exploring the last CONSECUTIVE left subtree left in the binary tree;
		
		now that you have result, left, and right int data variables, you can compare them to store the maximum value:
		if the left int is bigger than the result, set result to left; 
		do the same comparison between result and right;
		
		again, this is a recursive method, so this comparison between values will start from the last calls( basically you found a node
		with null subtrees and you will compare them with result of the parent subtree, and then you will move to the right "brother"
		node of the parent subtree, from the parent parent call stack)
		
		in the very end, just return the result int;
*/

//classes binary tree(root), node(left, right, data).   methods: populateBinaryTree(), int findMaximumValueRecursively(){result, right, left};
//no stack, no queue, no linkedList: store data in variable;


public class BinTreeMaxValue 
{
	private Node root;
	public BinTreeMaxValue() { this.root = null; }
	public void createTree()						// intialize the instance root; create nodes; link them, starting from root;
	{
		this.root = new Node(0);
		Node a = new Node(1); Node b = new Node(24); Node  c = new Node(5);  Node d = new Node(9);  Node e = new Node(3);  Node f = new Node(4);
		root.l = a;  root.r = b;  a.l = c;  a.r = d;  b.l = e;  b.r = f;
	}

	public int findMaxValueRecursive(Node tempRoot) {
		if (tempRoot == null) { return Integer.MIN_VALUE; }
		int max = tempRoot.d;
		int left = findMaxValueRecursive(tempRoot.l);
		int right = findMaxValueRecursive(tempRoot.r);
		if(left > max) { max = left; }
		if(right > max) { max = right; }
		return max;
	}

	private class Node 
	{ 
		private int d;   private Node l;   private Node r;   
		public Node(int data) { this.d = data;   this.l = null;   this.r = null; }
	}

	public static void main(String[] args) {
		BinTreeMaxValue bt = new BinTreeMaxValue();
		bt.createTree();
		int maxVal = bt.findMaxValueRecursive(bt.root);
		System.out.print(maxVal + " is the maximum value found in the binary tree.");
	}
}

