package algolessona10reversearray;

//reverse the array.
// take an input array. initialize a new array of same size as the original.
 // using a for loop and two iterators, one from the beginning, the other from the last partition of the original array,
 //   store the last item in the original array in the first array.
 //   increase the new array iterator to move to next position, and decrease the iterator for the original array to move to the before last.
 //   repeat until you reach the end of the new array
 //   at the end of the loop you have the new array with every integer from the original array, but in reverse order.

public class Reverie {	
	public static void main(String[] args) {
		//the arrays:
		int[] orig = {1,2,3,4,5,6};
		int[] rev = new int[orig.length];
		// the counters:
		int end = orig.length-1;     
		int l = orig.length-1;               // devo creare una nuova variabile da usare come condizione del loop. end viene
		  									 // decreased ad ogni step, quindi non verrebbe popolato il loop completamente.
		for (int i = 0; i <= l; i++) {
			rev[i] = orig[end];
			end--;			                 // end e l inizializzate con stesso data, ma end viene -- mentre l no, quindi
			System.out.print(rev[i]);        // l resta stabile e posso usarla per verificare la condizione del loop;
		}
	}
}