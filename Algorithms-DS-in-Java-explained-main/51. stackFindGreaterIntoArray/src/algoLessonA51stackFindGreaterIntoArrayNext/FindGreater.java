/*
 	 	ALGORITHM: NEXT GREATER ELEMENT IN AN ARRAY


before even consider solving the problem, it is crucial to have clear in mind the definition of the problem,
and the task assigned:
	1. clarify in your mind the scenario through reasoning and visualization;
	2. clarify the goal, the task, through reasoning and visualization;
	3. find ways to solve the problem; think the logic of each step without forgetting 1. and 2.;
	4. evaluate a pseudocode: after thinking, now it's time to write down for the first time all the mental evaluations;
	5. try out the code in a program; debug and test different scenarios to check if the problem is propersly solved, accordingly to 1. and 2.;


SCENARIO:       An array of integers is given;
                this integer array is NOT sorted;
                integers are positive numbers > 0;

TASK:           for each integer in the given array, find the next greater element in the array;
                        the 'next greater element' is the first element towards right;
                        if no greater integer is found, then store -1 instead;
                store the result in a new array;



EXAMPLE:        input[] = {2,4,6,2,3,55,2,4};             output[] = {4,6,33}


NO STACK
MY GUESS:	use a for loop to iterate over the array from first to last partition included.
		     you use an int i variable, initialized at zero, increment i by one each time the loop reaches the end;
		     then, check if the loop condition is still valid. the condition should be that the value of i should
		     not exceed nor be equal to the size (.length()) of the array;
		 the actual value of the partition in the array you are currently looping can be accessed using the [] sintax:
		 	arrayInput[i];

		 inside this loop create a nested loop. create an integer value j. the starting value of j should be the current
		 	value of i PLUS 1. the loop should go on until j is less and NOT equal to the size (length()) of the inputArray.
		 	at each end of loop, increment j by 1.

		 use the outer loop to access, one by one, each value stored in the inputArray, from first to last partition.
		 use the nested loop to compare values stored in partitions, which are next to the current partition at i;

		  0, 1, 2, 3, 4, 5, 6
		 [4, 5, 6, 7, 4, 2, 8]
		  i  i  i  i  i  i  i
                     j
			j
			   j
                              j  j  j
                                 j  j
                                    j
                                      x[nullPointerException]

                  at this point, make a comparison:
                  	compare the current value stored at i in the array, with the value stored at j in the array.
                  		we only want to do something if the value at j is greater than the value stored at i.
                  	IF [j] is bigger than [i], then move j into i and break the loop to go back in the outer loop.
                  	ELSE, increase j by one. eventually (unless the loop conditions evaluated is not satisfied) you'll
                  	      check again by comparing j with i.


WITH STACK: for each position of the array I push the next value in the stack;
	    when I find a value at j which is greater than i, i pop() the stack at arr[i] (redeclaring the value using the return of stack.pop())



///////////////////////////////////////////////////////////////////////////////////////////////////////////////

//		System.out.println("\n\n\n==== WITHOUT USING STACK =====");
//		for (int i = 0; i < inputArr.length; i++) {
//			System.out.print(inputArr[i] + ", ");
//		}
//
//		System.out.println("\n\n==========================================\n\n");
//		for (int i = 0; i < inputArr.length; i++) {
//			int currentValue = inputArr[i];
//
//			for (int j = i + 1; j < inputArr.length; j++) {
//				int currentNext = inputArr[j];
//
//				if (currentNext > currentValue) {
//					inputArr[i] = inputArr[j];
//					j++;
//					break;
//				}
//			}
//		}
//
//		for (int i = 0; i < inputArr.length; i++) {
//			System.out.print(inputArr[i] + ", ");
//		}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////


 */

//import java.utils.Stack;

package algoLessonA51stackFindGreaterIntoArrayNext;
import java.util.EmptyStackException;

public class FindGreater {

	private static class Stack {

		private int length;
		private Node top;

		public Stack() {
			this.length = 0;
			this.top = null;
		}

		private class Node {

			private int data;
			private Node next;

			public Node(int dataIn) {
				this.data = dataIn;
				this.next = null;
			}
		}


		public boolean isEmpty() {
			return length == 0;
		}

		public boolean isFull(int[] array) {
			return size() == array.length;
		}

		public int size() {
			int stackSize = 0;
			Node iterator = top;
			while(iterator != null) {
				stackSize++;
				iterator = iterator.next;
			}
			return stackSize;
		}

		public void push(int dataIn, int[] arr) {
			Node newNode = new Node(dataIn);

			if(isFull(arr)) {
				System.out.println("Push into current stack failed. Stack is currently full.");
				return;
			}
			if(isEmpty()) {
				top = newNode;
			}
			else {
				newNode.next = top;
				top = newNode;
			}
			length++;
		}

		public int pop() {
			if (isEmpty()) {
				throw new EmptyStackException();
			}

			int thisPeek = top.data;
			top = top.next;
			length--;
			return thisPeek;
		}

		public int peek() {
			if(isEmpty()) {
				System.out.println("Stack is Empty.");
				return 0;
			}

			int stackPeek = top.data;
			return stackPeek;
		}

		public void display() {
			Node iterator = top;

			System.out.print("peek(top) --> ");
			while(iterator != null) {
				System.out.print(iterator.data + " ->> ");
				iterator = iterator.next;
			}
			System.out.println("reached end of stack.");
		}

		public int[] findGreater(int[] inputArray) {					//!!! INFINITE LOOP  MAY BE HERE
			int[] result = new int[inputArray.length];

			for(int i = inputArray.length -1; i >= 0; i--) {
				while(!isEmpty()){
					if(!isEmpty() && (peek() < inputArray[i] == true)) {             // THIS condition has to be refactored: !isEmpty() && (p < inputArray[i] == true)
						pop();
					}
					else{
						break;
					}
				}
				if(!isEmpty()) {
					result[i] = peek();
				}
				else {
					result[i] = -1;
				}

				push(inputArray[i], inputArray);
			}
			return result;
		}

	}

	public static void main(String[] args) {

		int[] inputArr = {1,2,3,6,4,7,2,9,2,1,5,2,3,9,7,4,3,2,4,5,10};

		Stack stack = new Stack();

		int[] x = stack.findGreater(inputArr);

		for(int i = 0; i < x.length; i++) {
			System.out.print(x[i] + ", ");
		}

	}

}
