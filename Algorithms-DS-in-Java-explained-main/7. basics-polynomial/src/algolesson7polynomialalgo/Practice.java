package algolesson7polynomialalgo;
// non solo una classe, anche un metodo puo' chiamare un altro metodo, come arrayDemo() che chiama printArray()

public class Practice {
	
	public void printArray(int[] arr) {   // this method prints the array which receives as argument on call from the main()
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public void arrayDemo() {         // this method creates and stores an array;
		int[] myArray = new int[5];   // default values of [0, 0, 0, 0, 0];
		
		printArray(myArray);          // arrayDemo() method can call the printArray() method;		
		myArray[0] = 55;
		printArray(myArray);
		myArray[1] = 66;
		printArray(myArray);
		myArray[2] = 43;
		printArray(myArray);
		myArray[3] = 8;
		printArray(myArray);
		myArray[4] = 5;
		printArray(myArray);
		
		myArray[3] = 654;
		printArray(myArray);
	}	
	
	public static void main(String[] args) {
		// in order to see things happen, you must call the arrayDemo from here, the main():
		// since it's a non-static method, you must initialize an object instance of the public class first
		Practice classInstance = new Practice();
		// and then make a call of arrayDemo() THROUGH its public class:
		classInstance.arrayDemo();   // call the nonstatic method ->create the array -> call the print array method
		
	}
}