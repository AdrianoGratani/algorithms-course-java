package algoLessonA52stackFindPreviousGreaterInArray;

/*        FIND NEXT GREATER / USING STACK IN ARRAY / MOVING FROM START (NOT FROM END)

import the array as arg[]
create a new array r[] with same length as arr[]

for loop 'i' from 0 until .length():
	nested for loop 'j' until  .length();
	if j is bigger than i, push it in the stack;
	else move to next;
	if j is the last item, and is not bigger than i, r[i] is -1;


IF YOU MOVE TO THE RIGHT TO FIND NEXT GREATER, there is no point implementing a stack
because you can directly assign the first item you find. also you are not gonna use the
stack to check and compare with previous data since your goal is to find the NEXT greater
towards right.

you can use the Stack, moving in the array from left to right, ONLY if your goal is to find
the previous greater element. in that case a stack can store previous elements and you pop()
what you don't need and store just the peek() in the resulting array you'll eventually return;

VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
FIND PREVIOUS GREATER INTEGER IN ARRAY, USING A STACK;

given an array of integer, for each integer in the array you must find its previous greater,
NOT the absolute greater in the array, just the first greater you find movin backwards.

use a STACK to find this integer, NOT an inverse for loop.
store the result in an array of same size as the original array. eventually, return this resulting array;
if previous greater has not been found, then store a `-1` instead;


i.e.   inputArr:  [ 1,2,3,1,2,1,4,5,4]    outputArr:   [-1.-1,-1, 3, 3, 2, -1, -1, 5 ]
					stack: [peek>>]  1, 2, 3  1  2  1   4   5  4           ------>> stack ends with 4(peek) ->> 5 ->> null
							/n /2  3  3  3	2  /3  /4  5			/1 means: 'popped Node with data 1 from peek'
                                                                 /1 /1  3  /2				/n means: null stack
								           /1

*/


import java.util.EmptyStackException;

public class StackStraight {

	private static class Stack {
		private int length;
		private Node top;

		public Stack() {
			this.length = 0;
			this.top = null;
		}

		private static class Node {
			private int data;
			private Node next;

			public Node(int dataIn) {
				this.data = dataIn;
				this.next = null;
			}
		}
//METHODS:

		public void push(int dataIn) {
			Node newNode = new Node(dataIn);

			if (isEmpty()) {
				top = newNode;
			}
			else {
				newNode.next = top;
				top = newNode;
			}
			length++;
		}

		public void display() {
			Node i = top;

			while (i != null) {
				System.out.print(i.data + " ->> ");
				i = i.next;
			}
			System.out.println("null");
		}

		public boolean isEmpty() {
			return length == 0;
		}

		public int peek() {
			if(isEmpty()) {
				return -1;
			}
			return top.data;
		}

		public int pop() {
			if(isEmpty()){
				throw new EmptyStackException();
			}
			int poppedData = top.data;
			top = top.next;
			length--;
			return poppedData;
		}

		public int[] findPreviousGreater(int[] inputArr, int inputLength) {
			int[] outputArr = new int[inputLength];

			for (int i = 0; i < inputLength; i++) {
				if(!isEmpty()) {
					while(!isEmpty() && peek() < inputArr[i]) {pop();}
				}
				if(isEmpty()) {outputArr[i] = -1;}
				else {outputArr[i] = peek();}
				push(inputArr[i]);
			}
			return outputArr;
		}
	}

	public static void main(String[] args) {

		Stack s = new Stack();

		int[] arr = {1,5,4,3,7,6,7,9,1,3,2,3,1,22,1,2};
		int[] result = s.findPreviousGreater(arr, arr.length);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");
		}

		System.out.println("==================================================================================================");

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
}
