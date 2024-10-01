
/*
you need a pointer 		top node
counte the length  		length int

a push void method()
	create a node with input data in
	its next has to be top
	move top pointer to the new node and increment the length of the stack



if the stack is empty, top points tu null


a pop() method to remove node from the stack
        save the data of the top node
        move top to the previous node: the next of the current top
        decrease the length of the stack and return the the data of the
        removed node;
*/


package algoLessonA50StackPeekMethod;
import java.util.EmptyStackException;

public class StackPeek {
        private ListNode top;
        private int length;

        private class ListNode {
                private int data;
                private ListNode next;

                public ListNode(int data) {
                        this.data = data;
                }
        }

        public StackPeek() {
                this.top = null;
                this.length = 0;
        }

        public int length() {
                return length;
        }

        public boolean isEmpty() {
                return length == 0;
        }

        public void push(int data) {
                ListNode temp = new ListNode(data);
                temp.next = top;
                top = temp;
                length++;
        }

        public int pop() {
                if (isEmpty()){
                throw new EmptyStackException();
                }

                int result = top.data;
                top = top.next;
                length--;
                return result;
        }

        public int peek() {
                if (isEmpty()) {
                        throw new EmptyStackException();
                }
                return top.data;
        }

        public static void main(String[] args) {

                StackPeek stack = new StackPeek();
                stack.push(22);
                stack.push(44);
                stack.push(33);
                int p = stack.peek();
                System.out.println(p);
        }
}



////////////////////////////////////////////////////////////////////////////

/*
HOW TO IMPLEMENT A STACK IN ARRAY DS


we've already discussed pop() push() and peek(), and stack basics as well;


suppose you're asked to create a new stack with three new elements;

new Stack(3)              // a new Stack, with three elements;

this creates a new array with three data partitions (nodes...)
each partition stores initially a default value of 0;


top   |    0    0    0

push(3)    ->   top++ =  arr[0] is now 8


like this:
    top8    0    0


again:  push(4)    -->   top++ =  arr[top] = dataArgument = 4

like this:
8     top4    0


push(3)   -->   top = top + 1   arr[top]  = dataArg  = 3

like this:
8	4	top3

NOW THE STACK IS FULL
array has fixed size
so you must check wether you implement a push method over a stack which is full or not

create a method size() to check the size of the stack ds;
size() method checks HOW MANY nodes of data are stored in the array;

compare the size of the stack with the length of the array


in our case size = 3 and array.length = 3 so:
size === .length  =>  array full


use the pop() method if you want to put new data in the array/stack

*/
/*
 * 
import java.util.RuntimeException;


public class arrStack {
// Stack instance variables:
private int top;
private int[] arr;

// Stack constructor:
public arrStack(int arrCapacity) {
top = -1;            //place top pointer at some sort of a 'null' position within the array it iterates over;
arr = new int[arrCapacity];
}


public arrStack() {
this(10);            // what is this???
}


// methods            size() = how many partitions used in the stack array?     isFull =  is the current array of the stack full?

public int size() {                // in the beginning top is -1 so:  -1  + 1 = 0 = no items in the array => no data currently stored in the stack;
return top + 1;		   // top points to the last inserted ata in the array. array is a 0-index ds. so to know the size of the current stack, based on the data stored in the array, just add 1 to the current value of top;
}

public boolean isFull() {	   // IMPORTANT: top AND .length() are BOTH 0 index;  size() method is 1 index;
return size() == arr.length;
}

public boolean isEmpty() {         // top points to the last inserted data in an array partition. array first partition is at 0, so if array is empty, top counts -1;
return top < 0;
}

public void push(int dataIn) {
if (isFull()) {            // which means: if length of array equals top pointer;
	throw new RuntimeException("Stack is full. array.length is equals to top Pointer.");
}
// else:
top = top + 1;             // move the pointer reference within the stack array;
arr[top] = dataIn;	   // the stack provides an array. push the data in this array;
}

public int pop() {
if (isEmpty()) {
	throw RuntimeException("Stack is currently empty.");
}
int result = arr[top];
top = top - 1;                  // data is NOT garbage collected: it stays in the array, but its reference gets lost. next time you use push(), its data gets overwritten;
return result;
}

public int peek() {                 // the peek() method returns the data stored at the top of the stack array;
if (isEmpty()) {
	throw RuntimeException("Stack is currently empty.");
}
return arr[top];
}


public static void main(String[] arr) {


}
}
*/