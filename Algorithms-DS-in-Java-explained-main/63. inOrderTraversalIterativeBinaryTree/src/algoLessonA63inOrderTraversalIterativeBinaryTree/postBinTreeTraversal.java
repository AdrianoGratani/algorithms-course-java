package algoLessonA63inOrderTraversalIterativeBinaryTree;

/*
RECURSIVE POST-ORDER TRAVERSAL OF A BINARY TREE 
		IN JAVA


	steps:
		traverse left subtree in post-order fashion;
		traverse right subtree in post-order fashion;
		visit the node;

	example:
		public void postOrder(Node rootCurr) {
			if (rootCurr == null) {
				return;
			}


		}

 */

/*
ITERATIVE POST-ORDER TRAVERSAL OF A BINARY TREE


use a stack to keep track of seen nodes
 a node is seen when the iterator node steps through it.
 a node is visited when you print its data;



use a loop instead of the recursive call


assign the root of the node to the iterator node. initialize a new Stack;
while loop: if the current iterator node is NOT null, or the stack is NOT empty, repeat it:
{
	check if the current node is null. if is not null, put the data of the current node in the stack,
	and reassign the current to the .left node of the current;

	if the current node IS null:
	{
		create another node iterator, temp. give to temp the peek().right of the stack = go to the .right of the parent node
		(current is in null, so you came here: you want to visit the .right side of the binary tree, thats why.)

		now check if the current right is null or not: if is null, pop the peek from the stack and ouput its data (=== POST order traversal)

		now check if temp is currently in the .right of its parent node: check if the stack is empty (== no parents left) AND 
			also check if the temp node is equal to the Stack.peek().right node (if this is true, temp is in the .right side
			of the binary tree)
	}

}


this is the blueprint:

Node current = rootBinaryTree;
Stack stack = new Stack();

while(current !== null || stack.isNotEmpty())
{
if (current !== null)
{
	stack.push(current);
	current = current.left;
} 
else 
{
		Node temp = Stack.peek().right;
	if (temp == null)
	{
		temp = Stack.push();
		System.out.print(temp.data + " ");

		while (Stack.isNotEmpty() && temp == Stack.peek().right)  // this has to be a while loop, in case you want to traverse back the right side of the binary tree, in the ending part of the traversal;
		{
			temp = Stack.pop();
			System.out.println(temp.data + " ");
		}
	else  // if temp is not in the .right of the peek, it means is in the left;  // so leave temp there and move current there;
	{
		current = temp;
	}
	}
}
}
 */
public class postBinTreeTraversal {
	private Node root;

	public postBinTreeTraversal() {
		this.root = null;
	}

	private class Node {
		private int data;
		private Node l;
		private Node r;
		private Node n;               // .next is only for Stacks ds;a

		public Node(int dataIn) {
			this.data = dataIn;
			this.l = null;
			this.r = null;
			this.n = null;
		}
	}

	private class Stack {
		private Node peek;
		private int length;

		public Stack() {
			this.peek = null;
			this.length = 0;
		}

		public boolean isEmpty() { return length == 0; }
		public Node peek() { if(!isEmpty()){ return peek; } else {return null;} }
		public void push(Node newData) {
			Node newPeek = newData;
			newPeek.n = peek;
			peek = newPeek;
			length++;
		}
		public Node pop() {
			if (isEmpty()){ return null; }
			Node peekPopped = peek;
			peek = peek.n;
			length--;
			return peekPopped;			
		}
	}

	public void createBinaryTree(int rootData) {
		root = new Node(rootData);
		Node first = new Node(2);
		Node second = new Node(3);
		Node third  = new Node(4);
		Node fourth = new Node(5);
		Node fifth = new Node(6);
		Node sixth = new Node(7);
		root.r = first;
		root.l = second;
		first.r = third;
		first.l = fourth;
		second.r = fifth;
		second.l = sixth;		
	}

	public void postOrderTraversalByStackIteration() {
		Node c = root;
		Stack s = new Stack();                                 // 1
		while(s.isEmpty() == false || c != null) {
			if (c != null) {
				s.push(c);
				c = c.l;
			}
			else { 
			Node t = s.peek().r;
			if (t == null) {
				t = s.pop();
				System.out.print(t.data + " ");
				while(!s.isEmpty() && t == s.peek().r) {
					t = s.pop();
					System.out.print(t.data + " ");
				}
			}
			else { c = t; }
			}
		}
	}


	//methods

	public static void main (String[] args) {
		postBinTreeTraversal b = new postBinTreeTraversal();
		b.createBinaryTree(1);
		b.postOrderTraversalByStackIteration();		
	}

}
