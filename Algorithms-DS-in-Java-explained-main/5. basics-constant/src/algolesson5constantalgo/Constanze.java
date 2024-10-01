package algolesson5constantalgo;


// constant time complexity is know as O(1); big O of 1
public class Constanze {

	public static void main(String[] args) {
//		int exone = staticSumAlgo(66, 77);
		
		// in case you want to keep a non-static method, create an object of Constanze.
		Constanze ss = new Constanze();
		int extwo = ss.staticSumAlgo(55, 77);		
		System.out.println(extwo);
		
		int array[] = {2, 5, 6, 7, 6, 33, 6, 88, 4};
		int valueAtZero = ss.getValueFromArray(array, 0);
		System.out.println(valueAtZero);
	}
	// the first method: MEASURED TIME COMPLEXITY IN U O T 
//	public static int staticSumAlgo(int a, int b) {          // static = storable without instanting any object
	public int staticSumAlgo(int a, int b) {                 // non static = to store a call in a variable you have to call throu an object, ss in this case.
		int sum = a + b;     // ACCESS a, ACCESS b, DO a + b, ASSIGN the a + b TO sum = 4 UNITS OF TIME
		return sum;          // ACCESS sum, RETURN sum = 2 UNITS OF TIME
		                     // TOTAL U O T = 6UOT
		                     // time = constant  T = C		
	}
		
	// the second method, this method has constant time complexity as well, since units of time are constant: to complete the task they will never grow nor shrink;
	public int getValueFromArray(int[] arr,  int i) {
		int value = arr[i];		
		return value;
	}
}