// EXPLANATION:
// move the data from a x sized array to an y sized array. assign the y sized array to the x sized array.
// il method per resize non puo' essere void. in tal caso nel fare return, java farebbe garbage collection del nuovo array
// quando ritorni al main() l'array resized, tale array deve essere conservato nella variabile: devi ridichiararla
// VEDI ln 33;S
package algolessona14resizearray;

import java.lang.reflect.Array;
public class SizeReSizer {     
	public static int[] arrayResizer(int[] arr, int capacity) {    // DEVI FARE RETURN DI UN int[] resized. e conservarlo nella variabile array ridichiarata (non crearne una nuova)
		int[] temp = new int[capacity];		
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}		
		arr = temp;
		return arr;                         // finche' resta in questo scope, arr.length e' il doppio. ma quando accedi dal main() resta quella di default;                   
//		return temp;		                // the caller will get a reference to this arr in the HEAP memory;
	}	
	
	public void printer(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("|\tPRINTED.\n");
	}	
	
	public static void main(String[] args) {
		SizeReSizer instance = new SizeReSizer();		
		int[] arrayTest = {4,5,6,3};
		instance.printer(arrayTest);	
		
//		instance.arrayResizer(array, 10);					// !!!BUG devi ASSEGNARE la call all'array che devi ridimensionare;
		arrayTest = instance.arrayResizer(arrayTest, arrayTest.length * 2); // !!!SOLVED REDECLARE arrayTest;
		instance.printer(arrayTest);		                 
	}
}