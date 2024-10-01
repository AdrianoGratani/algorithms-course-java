package algolessona10reversearray;
import java.util.Random;

public class Definitive {	
	public static int randomLengthGen(int min, int max) {
		Random rand = new Random();
		int length = rand.nextInt(min, max);
		System.out.println("random length for array generated, size:" + length);
		return length;
	}	
	public static int[] arrayGen(int l, int minNum, int maxNum) {
		Random rand = new Random();
		int[] array = new int[l];		
		for (int i = 0; i < l; i++) {
			array[i] = rand.nextInt(minNum, maxNum);
			System.out.println("generated a new random integer in the array, at position: " + i + ", \nvalue stored in curren partition: " + array[i]);
		}		
		return array;
	}		
	
	public static int[] swahpperoo(int[] input, int s, int e) {
		System.out.println("\n\n swapping started...\n\n");				
		while (s < e) {
			int temp = input[s];
			input[s] = input[e];
			input[e] = temp;
			s++;
			e--;
		}
		System.out.println("swapping done\n\n");
		return input;
	}
	
	public static void printer(int[] arrToPrint) {
		System.out.println("printing the swapped array...\n\n");
		for (int i = 0; i < arrToPrint.length; i++) {
			System.out.println(arrToPrint[i]);
		}
	}
	
	public static void elapse(long start, long finish) {
		long elapsedTime = finish - start;
		System.out.println("program finished. time elapsed: " + elapsedTime + "ms.");
	}

	public static void main(String[] args) {
		long startTimer = System.currentTimeMillis();
		
		System.out.println("program starts...");
		Definitive instance = new Definitive();		
		int length = instance.randomLengthGen(100, 1000);
		int[] array = instance.arrayGen(length, 0, 5000);
		
		///!!!ERROR
		// i RETURN ANOTHER ARRAY, SO I CREATE A NEW ONE.
		int[] swap = instance.swahpperoo(array, (array.length - array.length), array.length-1);		
		instance.printer(swap);		
		
		long endTimer = System.currentTimeMillis();
		instance.elapse(startTimer, endTimer);
	}
}