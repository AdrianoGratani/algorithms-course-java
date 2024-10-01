// PSEUDOCODE 
// take an array as method argument
// initialize a variable to store the minimum;
//    call it 'minimum'; in OUTER SCOPE of the method
//    this value will get tested/updated at each step of loop
//    initialize the value of this variable with FIRST value stored in the first arr partition.

// the loop:
//    starts from [0], it finishes when the array partitions finish; incremented by at each step;
//    DO 'minimum' minus the current array partition value;
//    	IF the result is less than 0 it means the current partition stores
//    	a lower value compared to the one stored in 'minimum'
//      re-declare the value stored in 'minimum' equal to the
//      partition value;
// at the end of the loop you end up with the minimum of the array,
// stored in 'minimum';
// return this value from the method to main();
// print this value; use a printMethod to do so;
package algolesson11afindminimuminarray;
public class First {	
	public int minimumFinder(int[] arr) {
		int minimum = arr[0];		
//		if you start the loop at 0 you waste a step: you already store the arr[0] as minimum
//		for (int i = 0; i < arr.length-1; i++) {
		for (int i = 1; i < arr.length-1; i++) {	
			if (minimum - arr[i] > 0) {
				minimum = arr[i];
			}
		}		
		return minimum;		
	}	
	// ANOTHER WAY:
	// if (current partition IS LESS THAN 'minimum):
	//   redeclare 'minimum' with the value stored in that partition;
	public int anotherFinder(int[] arr) {
		int minimum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] < minimum) {
				minimum = arr[i];
			}
		}		
		return minimum;
	}
	
	public static void main(String[] args) {
		int[] array = {5,3,6,88,99,4,5,6,1,4166,44,33,2,4};
		First instance = new First();		
		int min = instance.minimumFinder(array);
		int min_two = instance.anotherFinder(array);
		System.out.println(min + " " + min_two);  // 1 1
	}
}