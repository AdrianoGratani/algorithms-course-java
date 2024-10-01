package algoLessonA62InOrderRecursiveTraversalBinaryTree;

/*

RECURSIVE IN-ORDER TRAVERSAL OF BINARY TREE DS



in-order traversal: this algorithm is used to display data stored in a binary tree;
    a binary tree is a data structure where each node is provided by
    default with TWO links to two separate directtions (nodes);
    whereas LinkedLists, Stacks, Queues, are made out of node that only
    point to one next (or previous) Node only;



steps: 1. start the method from a starting point, the root of the binary tree i.e.
  (get the root as argument of the method)
// this example is recursive, so no need for loops;

BASE CASE: IF THE CURRENT NODE YOU GOT AS ARGUMENT BY THE CALLER IS == NULL, RETURN;	
2. go the the node on the left;
3. only now, print the .data of the current node;
4. now move to the Node on the .right;
[ once you are done with each step, the program finishes
 this algorithm is recursive by nature: i.e. before printing
 data in the current root Node, you'll move to the left, and so on and so forth,
 until eventually you'll find a node leaf: a node which points to null, then you 
 you'll just return from that specific recursive call, 'going back' to the caller
 which in turn is the recursive call of a previous caller... ]


I suppose there are two main types of in order traversal approaches,
by recursion, or by iteration;

if you don't want to resolve the task by implementing recursive calls, just implement a stack instead;
within a while loop which exists until the stack is not empty, at each step push both .left 
and .right of the current node, inside the stack;

[ warmly suggested to implemement your own stack instead of importing the one provided
by Java ]


 */


public class BeanTree 
{

	private Node root;

	public BeanTree()				// bt constructor
	{
		this.root = null;
	}

	public boolean emptyBean()
	{
		return root == null;
	}

	public void displayBinaryTree(Node currentRoot, String pos) {
		if(currentRoot == null) {
			return;
		}
		System.out.print(pos + " " + currentRoot.data + " ||| ");
		displayBinaryTree(currentRoot.left, "left: ");
		displayBinaryTree(currentRoot.right, "right: ");
	}

	public void populateBeanTree() {
		Node first = new Node(0);
		root = first;

		Node second = new Node(1);
		Node third = new Node(2);
		Node fourth = new Node(3);
		Node fifth = new Node(4);
		Node sixth = new Node(5);
		Node seventh = new Node(6);

		root.left = second;
		root.right = third;
		second.left = fourth;
		second.right = fifth;
		third.left = sixth;
		third.right = seventh;		
	}

	public void preOrderTraversalRecursion(Node rootTemp)
	{
		if (rootTemp == null)
		{
			return;
		}
		System.out.println(rootTemp.data);
		preOrderTraversalRecursion(rootTemp.left);
		preOrderTraversalRecursion(rootTemp.right);
	}

	public void inOrderTraversalRecursion(Node tempRoot)
	{
		if (tempRoot == null)
		{
			return;
		}
		inOrderTraversalRecursion(tempRoot.left);
		System.out.print(tempRoot.data);
		inOrderTraversalRecursion(tempRoot.right);
	}


	public void preOrderTraversalIterative(Node rootTree) 
	{
		Stack s = new Stack();
		s.push(rootTree);

		while(!s.isEmpty()) 
		{
			Node temp = s.pop();
			System.out.print(temp.data);

			if(temp.right != null)
			{
				s.push(temp.right);
			}
			if(temp.left != null)
			{
				s.push(temp.left);
			}
		}
	}


	private class Node 
	{
		private int data;
		private Node left;
		private Node right;

		public Node (int dataIn)	       // node constructor;
		{
			this.data = dataIn;
			this.left = null;
			this.right = null;
		}
	}

	private class Stack                             // for memory saving purposes, this stack reuses the .left pointer node like a .next pointer;
	{
		private Node peek;
		private int length;

		public Stack()
		{
			this.peek = null;
			this.length = 0;
		}

		public boolean isEmpty()
		{
			return length == 0;
		}

		public void push(Node n)
		{
			Node newPeek = n;

			newPeek.left = peek;	
			peek = newPeek;
			length++;
		}

		public Node pop()
		{
			if (isEmpty())
			{
				return null;
			}
			Node poppedNode = peek;
			peek = peek.left;
			length--;
			return poppedNode;

		}
	}

	public static void main(String[] args)
	{
		BeanTree bt = new BeanTree();
		System.out.println(bt.root);		
		System.out.println(bt.emptyBean());

		bt.populateBeanTree();
		bt.displayBinaryTree(bt.root, "root: ");		
	}		
}
