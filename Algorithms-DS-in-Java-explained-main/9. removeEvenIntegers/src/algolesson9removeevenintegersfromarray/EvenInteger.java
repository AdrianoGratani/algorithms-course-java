package algolesson9removeevenintegersfromarray;

// remove all the even integers from an int[] array;
// 		create an int[] array. it must store even and odd integers;
//      now that the array is initialized, you need a for loop to iterate through each partition of the DS.
//      inside the loop block, check if the current data (number of the array at index [loopIterator]) is odd or even;
//      use the modulus operator to do this.   if current number % 2 = 0, it means the number is even, otherwise it's odd.

// this algorithm is flawed: instead of deleting the partition, you just redeclare to 0 the even integer; 
// input: {3, 5, 6, 8, 1}      output: {3, 5, 0, 0, 1}       expected output: {3, 5, 1}
// SOLUTION: examineArr() counts non-even integers stored in arr[] using the same for loop.
//			 then it creates a new array of size [count] where it will store the non-even integers.
//           to store these integers it will perform again a for loop;


public class EvenInteger {
	
	public static int[] solutionArr(int[] originalArr) {		
		int oddsCounter = 0;
		for (int i = 0; i < originalArr.length; i++) {              // 1  find how many odds in original array
			System.out.print("\ncurrent int:" + originalArr[i]);
			if (originalArr[i] % 2 >= 1) {
				System.out.println("found an odd integer in originalArr:" + originalArr[i]);
				oddsCounter = oddsCounter + 1;
				}
		}
		System.out.println("oddsCounter is:" + oddsCounter);
		// the new array containing only odds:
		int[] oddsArr = new int[oddsCounter];
		int oddsArrIndex = 0;
		for (int i = 0; i < originalArr.length; i++) {       // 2 loop again in the original: if you find an odd, put it in the new oddsArr[]
			if (originalArr[i] % 2 >= 1) { // !!BUG: oddsArr puts every odd found at origina[i] in the position [0] so the array is [lastoddoriginal, 0,0,0,0,0 etc]
				//int oddsArrIndex = 0;      // !!BUG: this line of code is in wrong scope. it reinitialize everytime the odds arr counter to 0;
				System.out.println("this odd number in original Arr goes into oddsArr: " + originalArr[i]);
				oddsArr[oddsArrIndex] = originalArr[i];
				System.out.println("and this happens:" + oddsArr[oddsArrIndex]);
				oddsArrIndex++;
			}		
		}		
		for (int i = 0; i < oddsArr.length; i++) {           // 3 print (debug) the new oddsArr[]
			System.out.println(oddsArr[i]);
		}
		return oddsArr;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void examineArr(int[] arr) {  // FLAWED
		System.out.print("flawed");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) { arr[i] = 0; }
			System.out.print(arr[i] + " ");
		}
	}
	public int[] insertArrReturnSolution() {
		int[] array = {3, 5, 6, 8, 1,7,8,6,5,5,99};
		examineArr(array);                      // flawed algotithm;
		int[] solution = solutionArr(array);	// correct algorithm;
		
		return solution;
	}
	
	public void printArr(int[] arrToPrint) {
		System.out.print("solution: ");		
		for (int i = 0; i < arrToPrint.length; i++) {
			System.out.print(arrToPrint[i] + " ");
		}
	}

	public static void main(String[] args) {
		EvenInteger instance = new EvenInteger();
		
		int[] s = instance.insertArrReturnSolution();
		instance.printArr(s);
	}
}