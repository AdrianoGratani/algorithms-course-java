package algolesson7polynomialalgo;
//https://www.youtube.com/watch?v=2ZLl8GAk1X4&ab_channel=freeCodeCamp.org
// from 57'

public class Poly {
	public static void main(String[] args) {
		poly(3);
	}	
	public static void poly(int n) {     // n = 3
		// outer loop declaration line UNIT TIME is: 6n + 4
		// inner loop declaration line UNIT TIME IS: 6n^2 + 4n  =  n(6n + 4)
		// sop inner loop is (access i, access j, print) = 3 operations times n innerloop times n outer loop:
		// 		n(n(1 + 1 + 1))   =   n^2(3)
		// sop end inner loop (print) = 1 operation times n outer loop  =  n(1)
		// sop end outer loop (print) = 1 operation;
		// T = 6n + 4  6n^2 + 4n + 3(n^2) + n + 1     add together squares, and the constants:
		// T = 11n + 9n^2 + 5     ignore the constants value and all the constans multipliers:
		// T = n^2
		// time complexity of this polynomial algorithm is: O(n^2)		
		
		System.out.println("\t\t===== poly starts =====\nn = " + n + "\n\n");		
		for (int i = 1; i <= n; i++ ) {  // (1; (3n+1); n) operations, executed n times, ---->   n(1 + (n+1) + n)
			for (int j = 1; j <= n; j++) {  // (1; (n+1); n) operations, executed n times, for n outer loop times n(n( + (n+1) + n))
											// 3(n^2)
				System.out.println("i: " + i + ", j: " + j);
				if (j == n) {System.out.println("end of INNER loop, j: " + j + ", n: " + n);}						
			}
			if (i == n) {System.out.println("end of OUTER loop, i: " + i + ", n: " + n);}
		}
		System.out.println("\n\n\t\t===== poly ends =====");
	}
}