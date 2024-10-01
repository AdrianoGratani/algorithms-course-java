package algolessona16palindromeornot;

// you can alternatively use  word.toCharArray()  method to turn the input parameter (it is a String) to an array of char you can loop over:
//     char[] inputArray = inputParameter.toCharArray;
// you can perform both a WHILE or a FOR loop. there is no need for the pointer to move from first to last letter,
//     half of the inputString is enough, since you have TWO pointer for char conparison, one from start, one from end:
//     the iteration moves "twice as faster", as to say;
// while (i <= test.length() / 2)                 //.length  with no (), in case you loop over the input.toArrayChar version of the String;

// String input "madam"      input.toCharArray()  -> ['m','a','d','a','m',]   


public class PaliPali {
	
	public static boolean isPalindrome(String test) {	    
	    int end = test.length()-1;
	    for (int start = 0; start <= (test.length() / 2); start++ ) {
	    	if (test.charAt(start) != test.charAt(end)) { return false; }
	    	else {end--;}	    	
	    }		
		return true;
	}

	public static void main(String[] args) {
		String test_one = "madam";
		String test_two = "maddam";
		String test_three = "martpram";
		System.out.println(isPalindrome(test_one));
		System.out.println(isPalindrome(test_two));
		System.out.println(isPalindrome(test_three));		
		}
}