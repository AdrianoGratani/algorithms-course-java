/*              HOW TO REVERSE A STRING USING A STACK IN JAVA


get the string;   get an array of chars out of the string;

 array and stack are two different things

 stack is a data structure, a class with instance variables and methods;
	it has a top reference int; next to the next data in the array
	methods to check if the stack is empty, or full, and to push and pop
	in and out of the stack;

 you can use the stack to perform actions over the array;



// step--by-step:

	 1. String input = "hello";
	
	 2. char[] inputArr = input.toCharArray();        // ['h','e','l','l','o']
	
	
	 3. push this data from the char[] array to the stack using the push() method;
	        to iterate over the char[] and the stack array you need a for loop;
	 	now, the stacks posses an array, same size as char[], with same data;
	
	                                          // char[]   ['h','e','l','l','o']
	                                          // stack    ['h','e','l','l','o']
	
	 4. iterate over the char[] to subsititute its data with the data at the opposite position
	         			          // i.e.   substitute  'h' with 'o' = put 'o' int partition of char[] which currently storese 'h'
	          to move in the array use a for loop
			with size of .length of char[]
		  at each step use pop() from the stack:
	
	 EXPLANATION: pop() is a method which (in this case) returns a char;
	          if a method is called on declaration/initialization of a variable
	          or arr[] partition, then the value returned from the method called
		  will be assigned to the variable;
	
	      if arr[i] is 'h', stack.top is currently  'o' the stack arr is currently full;
		  so if you call pop(),  arr[i]  will garbage-collect its current value, and store the value returned from the pop() method instead;
	
		for () {
			arr[i] = stack.pop();
		}



PSEUDOCODE IMPLEMENTATION:

		stackChars = new Stack();
	
		1. String input = inputString;                             // "hello"
		2. char inputChar = input.toCharArray();                   // ['h','e','l','l','o']
	
	        3. for (charCurrent : inputChar) {                         // 'h'   <-   'e'   <-   'l'   <-   'l'   <-   'o'(top)
			stack.push(charCurrent);
		}
	
		4. for (int i = 0; i < inputChar.length; i++) {
			inputChar[i] = stack.pop();                        // inputChar[0] = stack top(returns 'o') {now top is -1 = 3 = 'l'}
		}
									   // inputChar[1] = stack top('l') {now top is -1 = 2 = 'l'}
									   // inputChar[2] = stack top('l') {now top is -1 = 1 = 'e'}
									   // inputChar[3] = stack top('e') {now top is -1 = 0 = 'h'}
									   // inputChar[4] = stack top('h') {now top is -1 =-1 = RunTimeException("stack is empty;")}
	
						//	now inputChar is ['o', 'l', 'l', 'e', 'h'];
	
		return String(inputChar);
*/


package algoLessonA50howToReverseAStringInJava;
import java.util.Stack;

public class StackReverseString {

	public static String reverseString(String inStr) {
		Stack<Character> stack = new Stack<>();
		char[] inputStrChar = inStr.toCharArray();

		for (char currentChar : inputStrChar) {
			stack.push(currentChar);
		}

		for (int i = 0; i < inputStrChar.length; i++) {
			inputStrChar[i] = stack.pop();
		}

		return new String(inputStrChar);
	}
	
	public static void main(String[] args) {
		String example = "hello";
		System.out.println("original: " + example);
		System.out.println("reverse : " + reverseString(example));
	}
}