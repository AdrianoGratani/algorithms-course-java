package algoLessonA48deleteFirstNodeCircularSinglyLinkedList;

///
//INSERT A NEW NODE IN THE FIRST POSITION
//		OF A
//     CIRCULAR SINGLY LINKED LIST
//
//
//
//
//
//create a public method to solve the task;
//this method should return null or a Node;
//and receive .data for the new node as parameter;
//
//the list is empty or not?   > check it first
//
//[ also, you should double check if the list is REALLY circular or not (i.e. if the last of the list is not properly assigned, the .next may be
//just another node in the list... who knows) ]
//
//if the list is not empty:
//create a new node with data argument;
//link this node to the current first of the list  (> if the list is proven to be circular, then the .next of last Node is the first Node)
//		    so link .next of the new Node to the .next of last
//
//change .next of last from the previous first node to new Node   (> last.next = newNode)
//
//
//
//visualization:
//newNode = 5;
//
//before:
//1 -> 2 -> LAST -> 1
//
//after:
//5 -> 1
//LAST -> 5
//
//==    5 -> 1 -> 2 -> LAST -> 5
//
//
//
//
//
//
//DELETE THE FIRST NODE FROM A
//	                CIRCULAR SINGLY LINKED LIST
//
//
//
//first check if the list is empty;
//you can use a isEmpty() method to do so;
//or if the current last is null, it means that the list is empty (altough there may be an issue in the way .last is being assigned)
//
//[ double check if the list is circular or not ]
//
//assign the first node to a newly declared node          i.e. > last.next = first;
//why is this necessary?
//
//change the .next of the .last Node from the current firstNode to the .next of the firstNode
//i.e.     >  last.next = first.next                                                          1(last)  .   2(first)   .  3(first.next)   =>  1(last)   .    3
//
//
//set to null the .next of first Node: now is removed from the list;
//
//return firstNode to the caller in main()


public class DeleteFirstNodeCircularList{

private Node last;
private int length;

public DeleteFirstNodeCircularList(){

this.last = null;
this.length = 0;
}

private class Node {

private Node next;
private int data;

public Node(int dataIn) {
this.next = null;
this.data = dataIn;
}
}

////////////////////////////////     METHODS	////////////////////////////////////////////////////////


public boolean isEmpty() {
return length == 0;
}

public String display() {

if (isEmpty()) {
return "The current list has no content;";
}

Node iterator = last.next;

while (iterator != last) {
System.out.print(iterator.data + " ->> ");
iterator = iterator.next;
}

return " \'last\': " + iterator.data + " ->> " + iterator.next.data + " ->> (infinite loop)";
}

public void createLast(int dataIn) {
Node newLast = new Node(dataIn);

if (isEmpty()) {
last = newLast;
newLast.next = last;
}

else {
newLast.next = last.next;
last.next = newLast;
last = newLast;
}
length = length + 1;

System.out.println("New .last Node added. data: " + last.data + ". Current length of the list is: " + length);

System.out.println("This is the current list: " + display());
}

public Node deleteFirst() {

if (isEmpty()) {
return null;
}

if (length == 1) {
last = null;
return last;
}

Node first = last.next;
last.next = first.next;
first.next = null;
length = length - 1;

System.out.println("firstNode in the list deleted, with data: " + first.data + ". current length of the list is: " + length + ". this is the list: " + display());
return first;
}

////////////////////////////////////////////////////////////////////////////////////////////////////////



public static void main(String[] args) {
DeleteFirstNodeCircularList dfn = new DeleteFirstNodeCircularList();


System.out.println(dfn.isEmpty());

dfn.createLast(5);
dfn.createLast(6);
dfn.createLast(7);
dfn.createLast(8);
dfn.createLast(9);
dfn.createLast(10);
dfn.createLast(11);

dfn.deleteFirst();
dfn.deleteFirst();
dfn.deleteFirst();
}

}
