package algoLessonA69ValidityBinarySearchThroughRecursionMinMax;

/*
						VALIDATE A BINARY SEARCH TREE, USING RECURSION AND MINMAX
						
	this algorithm has the followng purposes: check a binary search to evaluate its validity.
	A binary search is a Data Structure, so it's a coded structure which stores data.
	A binary search has to follow specific rules, which are the following:
		1. a binary search must have a root;
		2. a binary search root must have two subtrees: one left subtree, and one right subtree, they can be either null or initialized with data;
		3. each subtree of the binary search is a root itself;
		4. a binary search tree must store in the left subtree only data which is lower than the root;
		5. a binary search tree must store in the right subtree only data which is greater than the root;
		
	this algorithm main purpose is to evaluate if the data stored in every node of a given binary search tree sticks to these rules;
	
	
	VALID SUBTREE
	i.e.: 				main root:        					 50
											  20			 	    100
										10		   22                   80         120
		                             				       5   12            21   24           null     85    null  1000

	the binary search above is valid. let's see why;
		- the main root is 50;
		- its left subtree is 20, which is less than 20. Its right subtree is 100, which is greater than 50;
			- left subtree of the main root is a root itself: it stores two subtrees, right and left.
			- each subtree, left and right, of the left subtree of the main root (and we proved it's a root itself), respect the same rules as the main root;
				- the left subtree of the left subtree of the main root ... 
				- [...] if we check each subtree, every rule is follwed: so this binary search tree is VALID;
				
				
	NON-VALID SUBTREE
	i.e.: 				main root:        					 50
											  2000(x)			 				100
										10		   22                   8(x)         120
		                              5   12     21   24          null     85    null  1000
			
	the binary search  above is NOT valid: let's see why:
	- the main root is 50;
	- the left subtree of the main root is 2000, which is greater than 50, which means that the rule of validity is not followed;
	
	
	THE ALGORITHM:
		- the algorithm has to the same, automatically;
		- to use the algorithm we need a function, or a method: a series of actions stored in a private scope and performed line by line
			with an input (arguments) and which returns an output;
			
		- our method needs three arguments and a return statement:
			- one argument is a Node, the root;
			- another argument stores an int, the MINIMUM data that the current root node can store without being invalid
				(if we call a method over a root which has data 70, over a LEFT subtree, the minimum can be -infinitum);
				(instead, calling a method from the same root (70), over a right subtree, the minimum is the PARENT (70));
			- the last argument stores an int, the MAX data that the current root node can store without being invalid;
				(if we call a method over a root which has data 70, over a LEFT SUBTREE, the maximum is the PARENT (70));
				(if we call a method over a root which has data 70, over a RIGHT SUBTREE, the maximum is +infinitum);
				
			- the return statement: this method returns a boolean: if the method founded only valid nodes, is true, otherwise it returns false;

		the method has to be recursive: you call the method over left subtree of the current node (which is the ROOT of this recursive call: 
		- call the recursion two times: first call over the left subtree, second over the right subtree;
		- each of the call has to be stored has a boolean: since this method returns a boolean true in case the current nodes checked are valid, or false;


		THE ALGORITHM IN PSEUDOCODE:
		
		boolean isTheBinarySearchValid( Node temporaryRoot, int minimumValueAccepted, int maxValueAccepted) {
			if (the current temporaryRoot Node is equal to 'null') { return 'true' from this call; }
			
			store a recursive call in  boolean isLeftSubtreeValid = isTheBinarySearchVAlid(Node left subtree of temporaryRoot, minimumValueAccepted, maximum value: the data of the temporaryRoot);
			(... you just triggered a recursive call, before going further in this call, is accessed this recursion over the left subtree, this 
			''fractal'' goes on and on until you reach the last left subtree of the first leaf found in this binary search;
			and then, you will access the next line of code: the recursive call over the right subtree...)
			
			// THIS ASPECTS CAN BE COUNTERINTUITIVE, RECURSIVE CALLS IN THE CALL STACK... 
			
			if (the boolean stored in isLeftSubtreeValid, returned from that recursive call, is equal to true) {
				you can do the same with another boolean isRightSubtreeValid = isTheBinarySearchValid(Node right subtree of temporaryRoot, the .data of the temporaryRoot as minimum data, max)
			}
			
			if (the boolean stored in isRightSubtreeIsValid is true, means that both subtrees are valid, so) {return true}
			
			if you reach this line it means that one of the subtree is valse, so return false;
		}





////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * 
 * 
// RECAP, display binary search nodes, recursive method:

method(Node rootCall, int newNodeData) {
if (rootCall == null) { Node newNodeBS = new Node (newNodeData);   return newNodeBS;  }
else {
if (newNodeData < rootCall.data) { rootCall.left = method(rootCall.left, newNodeData); }
else { rootCall.right = method(rootCall.right, newNodeData); }
}
return rootCall;
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////// GUESSES, beforehand: the following section was the preliminary study, it shows the thinking process...

task: given a binary search tree, elaborate an algorithm to check if the given ds is valid or not;
a valid binary search tree has to branches: a left subtree and a right subtree.
the left subtree only stores data smaller than its root. 
the right subtree only stores data greater than its root.
each subtree is itself a binary search tree;


to inspect the whole binary tree you can use recursion, through recursive calls of the main method,
or you can choose to implement a stack, or a queue;

a basic implementation may just outputs on console in case a non valid bst has been found;
in case you want the data returned you may want to use return statements, and return the root of non valid bst;


GUESS 1
the following algorithms employs recursion.
my method returns a Node in case a non-valid bst Node is found, otherwise returns null;
when you call this method on the main() method, assign the bst.root as arg;

pseudocode:  public Node validation(TreeNode root) {

check IF (the left subtree is NOT null, AND its data is LESS THAN the data stored in the root itself){ RECURSIVE CALL(root.leftSubtree to continue searching further in the bst); }
    otherwise, IF (is NOT null AND its data is GREATER THAN the stored in the root) { RETURN the root; this return will be the proof that this bst is not a valid one; }

otherwise IF (the right subtree is NOT null, AND its data is  GREATER THAN the data stored in the root itself){ RECURSIVE CALL(root.rightSubtree, same as for the left one); }
otherwise, IF (is NOT null AND its data is GREATER THAN the stored in the root) { RETURN the root; same as for the left  }

}

ELSE, RETURN null;
 }


ISSUES with this code: a binary tree may look correct: left subtree smaller than the root, right subtree greater etc etc, but how to detect if a right subtree
is storing data greater than the root of the whole tree ITSELF?

to solve this issue we must use the MIN MAX approach. minmax is an integer argument for every recursive call. in case you call a left subtree,
minmax is equal to data of the caller root minus 1 (MAX value accepted), in case of the right subtree, minmax is equal to data of caller root plus one (MIN value accepted)


	15
7				30
3             10	         18            60
1    6        8      14           16   29       31  65                    
							root = 15: 
							left has to be minmax = root.data - 1;
							right has to be minmax = root.data + 1;
							call method(root.left, root.data);  |
							call method(root.right, root.data); |
											            |
								LEFT S.TREE RECURSIVE CALL          V			            
							root = 7;    previousRoot =     root.data arg;
							left has to be minmax = root.data - 1;
							right has to be minmax = previousRoot - 1 AND bigger than current root

							RIGHT S.TREE RECURSIVE CALL
							root = 30; previousRoot = root.data arg;
							left has to be minmax =root.data arg + 1 AND smaller than the current root
							right in right subtree must be greater than the current root;										




- explanation:
if you go towards the left subtree, min is same, while max is parent root || parent root - 1
if you go towards the left subtree, max is same, while min is parent root || parent root + 1

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


 */								



public class BinarySearchValidity {

	private Node root;
	public BinarySearchValidity() {
		this.root = null;
	}

	private class Node {
		private int data;
		private Node left;
		private Node right;
		private Node next;          // I need this Node only for the Queue methods since it works just like a Linked List.

		public Node(int dataIn) {
			this.data = dataIn;
			this.left = null;
			this.right = null;
			this.next = null;
		}

	}

	private class Queue {
		//private Node next;      // this is a common ERROR: you are declaring a Node attribute data in the wrong class. instead, you must declare it in the Node class.
		private Node first;					
		private Node last;

		public Queue() {
			this.first = null;
			this.last = null;
		}

		public boolean emptyQ() {
			return first == null && last == null;
		}

		public void push(Node newLast) {
			if(emptyQ()) {
				first = newLast;
				last = newLast;
			}
			else {
				last.next = newLast;        //  if you don't declare .next property Node in the Node class, program will break since .notation is trying to access the .next of a node... but does'nt know what a next of a Node is!!!
				last = newLast;
			}
		}

		public Node pull() {
			if (emptyQ()) {
				return null;
			}
			if (first == last) {
				Node ret = first;
				first = null;
				last = null;
				return ret;
			}

			Node returned = first;
			first = first.next;
			return returned;
		}
	}

	public boolean isBinSearchEmpty() {
		return root == null;
	}

	public Node insertNodeInBinarySearch(Node root, int newNodeData) {    System.out.print("INSERT NODE METHOD CALL WITH DATA: " + newNodeData +  ";");
	if (root != null) {System.out.print("PARENT DATA = " + root.data + "\n");}
	if (root == null) {   // DECLARE a NEW Node: Node ...  // and NOT   root ...  :
		Node newRoot = new Node(newNodeData);    // avoid calling this new root same as the arg root to avoid misprinting and unintended note overwriting;
		System.out.println("found empty root, so I put here a node: " + newRoot.data);
		return newRoot;        
	}
	else {
		if (newNodeData < root.data) { System.out.println(newNodeData + " is less than " + root.data);
		root.left = insertNodeInBinarySearch(root.left, newNodeData);   // this part is crucial: do NOT return a new Node, otherwise it will not be linked to the existing bin search. instead assign the recursive call to the .left or .right... it will return a New Node and it will be stored as .left or .right of the parent;        
		System.out.println("root.left after the recursive call: " + root.left.data + ", its parent is: " + root.data);

		}
		else if (newNodeData > root.data) {  
			root.right = insertNodeInBinarySearch(root.right, newNodeData);  // this part is crucial: do NOT return a new Node, otherwise it will not be linked to the existing bin search. instead assign the recursive call to the .left or .right... it will return a New Node and it will be stored as .left or .right of the parent;        
			System.out.println("root.right after the recursive call: " + root.right.data + ", its parent is: " + root.data);
		}
	}
	System.out.println("this call is finished: returning the data inserted: " + newNodeData);
	return root;   //
	}

	public void displayBinarySearchTree(Node root) {           // this algorithms employs Queue data structure to visit the binary search, because of this fact it operates in a LEVEL ORDER TRAVERSAL fashion;
		if(isBinSearchEmpty()) { 
			return; 
		}

		Queue q = new Queue();
		q.push(root);

		while(!q.emptyQ()) {
			Node temporaryDisplayedNode = q.pull();
			System.out.print(temporaryDisplayedNode.data + " ->> ");

			if (temporaryDisplayedNode.left != null) {
				q.push(temporaryDisplayedNode.left);
			}
			if (temporaryDisplayedNode.right != null) {
				q.push(temporaryDisplayedNode.right);
			}
		}
		System.out.println("End of the Binary Search Tree.");
	}

	public boolean isBinarySearchValidMinMaxRecursive(Node rootTemp, long min, long max) {

		if (rootTemp == null) { 
			return true; 
		}

		else {
			if (rootTemp.data <= min || rootTemp.data >= max) { 
				return false; 
			}

			boolean isLeftSubTreeValid = isBinarySearchValidMinMaxRecursive(rootTemp.left, min, rootTemp.data);

			if (!isLeftSubTreeValid) { 
				return false; 
			} 

			boolean isRightSubTreeValid = isBinarySearchValidMinMaxRecursive(rootTemp.right, rootTemp.data, max); 

			if (!isRightSubTreeValid) { 
				return false; 
			}

			return true;
		}
	}



	public static void main(String[] args) {
		System.out.println("This program aims to showcase an algorithm, which has been built with the purpose of checking if the Binary Search Tree is valid or not.");

		//VALID BS TREE:

		BinarySearchValidity bsv = new BinarySearchValidity();

		bsv.root = bsv.insertNodeInBinarySearch(bsv.root, 50);
		Node second = bsv.insertNodeInBinarySearch(bsv.root, 25);		 // ATTENTION: if ...  this gets garbage collected;
		Node third = bsv.insertNodeInBinarySearch(bsv.root, 100);		 // ATTENTION: if ...  this gets garbage collected;
		Node fourth = bsv.insertNodeInBinarySearch(bsv.root, 1000);
		Node fifth = bsv.insertNodeInBinarySearch(bsv.root, 10);

		bsv.displayBinarySearchTree(bsv.root);
		boolean test = bsv.isBinarySearchValidMinMaxRecursive(bsv.root, -1000000, 1000000);
		System.out.println(test);

		//  NOT VALID BS TREE:

		BinarySearchValidity bsvNot = new BinarySearchValidity();
		bsvNot.root = bsvNot.insertNodeInBinarySearch(bsvNot.root, 300);
		Node a = bsvNot.insertNodeInBinarySearch(bsvNot.root, 200);
		Node b = bsvNot.insertNodeInBinarySearch(bsvNot.root, 400);
		Node c = bsvNot.insertNodeInBinarySearch(bsvNot.root, 100);
		Node e = bsvNot.insertNodeInBinarySearch(bsvNot.root, 700);
		Node f = bsvNot.insertNodeInBinarySearch(bsvNot.root, 150);
		Node g = bsvNot.insertNodeInBinarySearch(bsvNot.root, 350);
		g.left = bsvNot.insertNodeInBinarySearch(bsvNot.root, 7000);  // wrong Node

		bsvNot.displayBinarySearchTree(bsvNot.root);
		boolean wrong = bsvNot.isBinarySearchValidMinMaxRecursive(bsvNot.root, -1000000, 1000000);
		System.out.println(wrong);        // false === bsvNot is NOT valid;
	}

}
