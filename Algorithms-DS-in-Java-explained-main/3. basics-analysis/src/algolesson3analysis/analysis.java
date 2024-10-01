package algolesson3analysis;
// analysis is to find the best algo.
// the best algorithm is the algorithm
// that runs fast and takes less memory


// you want to find the sum of first n natral numbers.
// input n is 4
// result is 10

// there are several algorithnsm to solve this problem


// prendo n e lo sottraggo a ogni passo di 1
// non mi fermo finche' n >= 0

// if you have to choose between more than one algo, check the TIME COMPLEXITY and SPACE of each one.
public class analysis {

	public static void main(String[] args) {
		
		int factorialMine = sumFactMine(4);
		System.out.println(factorialMine);	
		
		int factorialRamesh = sumFactRamesh(4);
		System.out.println(factorialRamesh);
		
		int factorialSuresh = sumFactSuresh(4);
		System.out.println(factorialSuresh);
	}
	
	public static int sumFactMine(int n) {		     // to fix; recursion is not working
		if (n == 0) {return 0;} // base case		
		int step = sumFactMine(n-1) + (n - 1);
	    return step;
	}
	
	public static int sumFactRamesh(int n) {	  	
		int rameshSolution = n * (n + 1) / 2;
		return rameshSolution;
	}
	
	public static int sumFactSuresh(int n) {
		int sum = 0;
		int sureshSolution;
		for (int i = 0; i <= n; i++) {
			sum = sum + i;
		}
		
		sureshSolution = sum;
		
		return sureshSolution;
	}

}