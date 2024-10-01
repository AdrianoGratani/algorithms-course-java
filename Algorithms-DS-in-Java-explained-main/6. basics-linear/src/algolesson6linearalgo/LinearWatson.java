package algolesson6linearalgo;
// https://www.youtube.com/watch?v=2ZLl8GAk1X4&ab_channel=freeCodeCamp.org
// minute 49

public class LinearWatson {

	public static void main(String[] args) {
		String input = "benvenuti a tutti";     
		int inputLen = input.length();
		
		String lastChar = outputLastCharFromString(input, inputLen);
		System.out.println(lastChar);
		}
	// the algorithm implemented by this method is LINEAR.
	// this algorithms performs as many operations according to the lenght of the input String.
	// if the length is bigger, it will perform the same operations, more times,
	// if the length of the string is lower, it will perform the same operations, less times.
	// IGNORE THE CONSTANTS WHEN calculating time complexity of linear algorithms
	
	public static String outputLastCharFromString(String in, int l) {
		char last = ' '; // 1 operation    constant
		
		// int i = 0  1 operation   constant
		// i < l;    linear operation 3(l)    
		// i ++;     linear operation, as many times as  l
		
		// UNIT TIME = 
		for (int i = 0; i < l; i++) {  // 3 operations constants * n times based on input l   linear
			// linear algorithm: operations are the same, but how many times will they get performed?
			                           // this depends on the number of characters in the input STring;
			char currentChar = in.charAt(i); // ---> c constant operation executed for n steps = c(n times):   get i, call .charAt() method, store the char in currentChar
			System.out.println("found a char... " + currentChar);	 // n operations based on input   linear
			if (i == l-1) {last = currentChar;}     
		}		
		return "last char is: " + last; // 1 operation     constant
	}
}