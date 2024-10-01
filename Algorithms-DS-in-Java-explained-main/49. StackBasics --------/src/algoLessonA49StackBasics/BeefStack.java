/*
THE STACK

stack is a Data Structure
it represents the structured of organized data;
is an approach to move a data inside a group, and outside as well;

a stack is like a container of data;
a stack contains data just like a singly linked list;

precisely, a stack manages nodes of data;
to store data in a stack ds, first create a node;

stack follows the Last In, First Out principle:
you put a node ON TOP of the last Node;
if you want to push data OUT OF the stack, you must start from the last inserted node;

a stack has a reference pointer, set to the last element added: for sake of semplicity, it's called TOP;
the last node added with the stack is the TOP pointer;
in order to free the stack from one item: pop the top node first;
after that, the prefious node becomes the new top pointer;

time ------------------->>>
nodes:
TOP of the stack;
1    ->   2   ->    3    -> null            // this stack has three nodes;
        // if you push  node  3 out of the stack, node with data 2 becomes TOP node;

TOP of the stack
1    ->   2   ->   null

each node in the stack has:
.data instance variable, to hold a specific data (integer in our case);
.next Node variable, to hold the reference to its next in the list;
the .next of a Node, is ONLY the node previously pushed inside the stack;
at one point it was the TOP of the stack, then, the current node became the TOP,
but in order to the new top to find a place in the stack, it uses the current TOP as reference to its .next;


you need METHODS to push Nodes with data inside / outside the stack:
to push data inside the stack, the method is the push() method;
to pop data outside the stack, the method is the pop() method;

the push() method;
create a new Node;
connect the new Node with the Top node of the stack:
assign .next of newNode as top;
move the top reference to the newNode;

the pop() method:
first, store in a variable the data of the current top node;
assign top to the .next of the current top; soon after, the Java will automatically garbage-collect the removed Node, and its data;
return the .data of the removed node
*/



package algoLessonA49StackBasics;

import java.util.EmptyStackException;

public class BeefStack {

	//instances of the class:
	private int length;
	private Node top;

	//constructor of the class:
	public BeefStack() {

		this.length = 0;
		this.top = null;
	}


	private static class Node {

		// instance variables:
		private int data;
		private Node next;

		//constructor:
		public Node(int dataIn) {
			this.data = dataIn;
			this.next = null;
		}

	}


	/////////////////////////////////////////////////////////////////



	public boolean emptyStack() {
		return length == 0;
	}

	public void displayStack() {

		if (emptyStack()) { // if you print top.data it throws an error of nullPointer. avoid it
			System.out.print("the stack is currently empty.");  // if you don't return, the top.data printed at ln103 will cause a nullPointerException;
			return;
		}

		Node iterator = top;
		System.out.println("displaying data currently stored in stack nodes. top has data: " + top.data);

		while (iterator != null) {
			System.out.print(iterator.data + " --> ");
			iterator = iterator.next;
		}
		System.out.println(" null. end of the stack reached.");
	}


	public void push(int dataIn) {

		Node newNode = new Node(dataIn);

		if (emptyStack()) {
			top = newNode;
			length = length + 1;
			System.out.println("push() performed on currently EMPTY stack; inserted node from top of the stack, with data: " + newNode.data + "==" + dataIn + ". current top of the stack is: " + top.data + ". current length of the stack is: " + length);

			return;
		}
		else {
			newNode.next = top;
			top = newNode;
			length = length + 1;
			System.out.println("push() performed on current stack; inserted node from top of the stack, with data: " + newNode.data + "==" + dataIn + ". current top of the stack is: " + top.data + ". current length of the stack is: " + length);
		}
	}


	public int pop() {
		//if list is empty you better throw an error exception declaration, instead of returning 0. 0 can be .data of a Node eventually;

		if (emptyStack()) {
			throw new EmptyStackException();
//			System.out.println("Current Stack is empty.");
//			return 0;
		}

		int topData = top.data;

		if (length == 1) {
			top = null;
			length  = length - 1;
			System.out.println("pop() performed on current stack; removed node from top of the stack, with data: " + topData + ". current top of the stack is: NULL.. current length of the stack is: " + length);
			return 0;
		}
		
		top = top.next;
		length = length - 1;
		System.out.println("pop() performed on current stack; removed node from top of the stack, with data: " + topData + ". current top of the stack is: " + top.data + ". current length of the stack is: " + length);
		return topData;

	}


	/////////////////////////////////////////////////////////////////



	public static void main(String[] args) {

		BeefStack bsEx = new BeefStack();
		//
		//bsEx.top = new Node(2);
		//bsEx.length = 1;
		//
		//System.out.println(bsEx.top + "--" + bsEx.top.data + "---" + bsEx.top.next );
		//
		//
		//Node s = new Node(3);
		//
		//bsEx.top.next = s;
		//bsEx.top = s;
		//bsEx.length = bsEx.length + 1;
		//
		//System.out.println(bsEx.top + "--" + bsEx.top.data + "---" + bsEx.top.next );

		bsEx.push(1);
		bsEx.push(2);
		bsEx.push(3);
		bsEx.push(4);
		bsEx.push(5);
		bsEx.push(1000);

		bsEx.displayStack();

		bsEx.pop();
		bsEx.pop();
		bsEx.pop();
		bsEx.pop();
		bsEx.pop();
		bsEx.pop();
		bsEx.pop();
	}
}
