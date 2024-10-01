package algolesson8arrayDS;

public class Hooorrays {
	public static void main(String[] args) {
		// three steps to initialize an integer array data structure:
		int[] arrayexample;		   // just declare there is an array. no memory allocated yet
		arrayexample = new int[5]; // memory allocation for the just declared array. 5 spots for data partitioning;
		arrayexample[0] = 3;       // initialization of the data for each partition ...
		arrayexample[1] = 55;      // the number inside [] is your INDEX to move, initialize, redeclare a specific value stored in the partition;
		arrayexample[2] = 54;      // non-initialized data partition of an array, stores a primitive or non-primitive value such as 0, null, false 0.0 etc 
		arrayexample[3] = 5;       // depending on the data type;
		arrayexample[4] = 8;	
		arrayexample[3] = 66;      // REASSIGNMENT --> reassign the value at [3]  it was 5, now it's 66;
//		arrayexample[5] = 43;      // ERROR --> once this line is executed (at runtime), you'll get an IndexOutOfBounds error:
		                           // there is no partition 5, the last partition of the array is the fifth one which is [4]
		                           // remember that an array is zero-indexed, so it counts each partition starting from 0 to n-1,
		                           // where n is the number you chose at initialization, in this case n = 5;
		
		
		// two steps to initialize an integer array data structure:
		int[] arrayexampletwo = new int[5];     // declaration and memory 'allocation' in one line of code
		arrayexampletwo[0] = 4;                 // data initialization for each partition ...
		arrayexampletwo[1] = 7;
		arrayexampletwo[2] = 12;
		arrayexampletwo[3] = 14;
		arrayexampletwo[4] = 9;
		
		// one step to initialize an integer array data structure:
		int[] arrayexamplethree = {1, 44, 55, 22, 11};   // declaration of the array, and memory allocation/initialization in one line	
		}
}