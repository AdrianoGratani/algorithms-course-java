/*
INSERT A NEW NODE AT THE BEGINNING OF A CIRCULAR SINGLY LINKED LIST


[check if the list is empty ]
{if the list is empty, assign a new Node to last, and the same Node to last.next}


1.  if the list is not empty, 
take the .last of the current list: it's a reference node before the first node, and it's linked to the first
	[ last.next == firstNode ]

2.  initialize a pointer named 'first':   first is  last.next;

3.  create a new Node 'newFirst' 
4.  change  last.next to  newFirst
5.  give first as .next of newFirst


//MY GUESS:

public Node newFirst(int newData) {

Node newFirst = new Node(newData);

if (last == null) {              // forgot to make it circular; last.next = newFirst;
	last = newFirst;
	return newFirst;		
}
else if ( last.next == null ) { // forgot here as well;     newFirst.next = last
	last.next = newFirst;
	return newFirst;
}

Node first = last.next;

last.next = newFirst;
newFirst.next = first;
return newFirst;
}

//!!! INCREMENT length by !!!one!!!
*/


package algoLessonA47insertNewNodeBeginningList;

public class NewNodeInAList {

private Node last;
private int length;

public NewNodeInAList() {
	this.last = null;
	this.length = 0;
}


private class Node {

	private int data;
	private Node next;

	public Node(int dataInput) {
		this.data = dataInput;
		this.next = null;
	}
}


// METHODS

public boolean isEmpty() {
	return length == 0;
}

public void createFirst(int dataIn) {

	Node newNode = new Node(dataIn);

	if (isEmpty()) {
		last = newNode;
		//newNode.next = last;
	}

	else {
		newNode.next = last.next;
	}

	last.next = newNode;
	length = length + 1;

	System.out.println("A new Node first successfully created, with data: " + newNode.data + ". Current length of the list: " + length);
}


public void createLast(int dataIn) {

	Node newNode = new Node(dataIn);

	if (isEmpty()) {
		last = newNode;
		newNode.next = newNode;
	}
	else {
		newNode.next = last.next;
		last.next = newNode;
	}

	last = newNode;

	length = length + 1;

	System.out.println("A new Node first successfully created, with data: " + newNode.data + ". Current length of the list: " + length);
}


public int checkLength() {

	if (isEmpty()) {
		System.out.println("The current list is empty.");
		return 0;
	}

	Node iterator = last;
	boolean stop = false;
	int lengthCount = 0;

	while(iterator != null && !stop) {

		lengthCount = lengthCount + 1;
		iterator = iterator.next;

		if(iterator == last) {
			stop = true;
		 }
	}
	System.out.println("Length of the current list calculated successfully: " + length);
	return lengthCount;
}


public Node createNodeAtPosition(int dataIn, int position) {

	if (isEmpty()) {
		System.out.println("Program aborted. Current List is empty.");
		return null;
	}

	if (checkLength() < position) {
		System.out.println("Program aborted. Position received exceeds current size of List.");
		return null;
	}

	Node newNode = new Node(dataIn);
	Node iterator = last.next;
	int currentPosition = 1;

	while (currentPosition < position) {
		iterator = iterator.next;
		currentPosition = currentPosition + 1;
	}

	newNode.next = iterator.next;
	iterator.next = newNode;
	length = length + 1;

	System.out.println("Node create successufully at position: " + currentPosition);
	return newNode;
}


public void display() {
	Node iterator = last.next;

	while (iterator != null && iterator != last) {
		System.out.print(iterator.data + " ->> ");
		iterator = iterator.next;
	}
	System.out.print(iterator.data + " " + iterator.next.data + " ->> (...circular loop). \nlast is: " + last.data);
}




public static void main(String[] args) {

//	System.out.print(0);

	NewNodeInAList  nnl = new NewNodeInAList();
	NewNodeInAList  nnl2 = new NewNodeInAList();

//	System.out.print(nnl.isEmpty());
//	nnl.createFirst(1);
//	nnl.createFirst(2);

//	nnl.checkLength();

	nnl.createLast(1);
	nnl.createLast(2);
	nnl.createLast(3);
	nnl.createLast(4);
	nnl.createLast(5);

//	nnl.createNodeAtPosition(100, 2);

	int len = nnl.checkLength();
	System.out.println(len);

	nnl.display();

	nnl2.createFirst(1);
	nnl2.createFirst(2);
	nnl2.createFirst(3);
	nnl2.createFirst(4);
	nnl2.createFirst(5);
	nnl2.display();

}
}
