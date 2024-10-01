// Q. given an array of inteers, write a function to move all 0's to
//    end of it while maintaining the relative order of the non-zero elements.
//  EX: arr {1,2,0,3,2,0,0,4,5,6}   -> {1,2,3,2,4,5,6,0,0,0}
//
//  FOR loop; loop until reach end of loop; increment i by 1 at each loop; // j per sua natura si trovera' INDIETRO rispetto ad i. i incrementa di default. j solo se si trova in posizione non-0. 
//                                                                           // una volta che j trova uno zero, l'unico modo per spostarsi e' che i trovi un valore non-0; appena lo trova, swappa con j
//                                                                          // a questo punto, j non ha piu' un valore 0, quindi il punto 2. sara' vero
//  INITIALIZE one more iterator j which starts at 0;
// 	1. IF the value at i is NOT 0  AND  the value at j IS 0:    // i e j partono nella stessa posizione, ma quando j trova uno 0, ci resta finche i non trova loop dopo loop una posizione in cui vi e' un valore NOT 0
//  	       DO the swap (use a temp variable)                // se i si trova in valore NOT 0 e j si trova in un valore 0, fai lo swap;
// 	2. IF the value at j is NOT 0:                              // se i ha swappato j
//             INCREMENT j by one; // quindi se j si trova in uno 0, in questo loop non incrementa, quindi resta ferma a 0
																	 

																		


																		// {1,2,3,0,0,4,5,0,1}	-> ORIGINAL INPUT ARRAY
																		// {1,2,3,4,0,0,5,0,1}  -> first swap
																		// {1,2,3,4,5,0,0,0,1}  -> second swap
																		// {1,2,3,4,5,1,0,0,0}  -> last swap
																		// _______ ALGORITHM ___________________________
package algolessona13moveallzerostotheendofthearray;                    //  0 -->                temp = 4 -> 5 -> 1
public class Definitive {         										//  j j j j j j j - - 
	                 													//  i i i i i i i i i i->loop condition == false -> end of the loop
	public int[] zHeroes(int[] arr) {	                                // {1,2,3,4,5,1,0,0,0}		
		                                            // two pointers, i focuses on non-0, while j focuses on 0
		                                            // if j finds a 0, it stays there until i founds a non-0, then a swap will occur;
		int j = 0;                                  // j incrementa SOLO se NON e' 0, i incrementa sempre: j cerca lo 0, i cerca il valore non-0
													// quando j trova uno 0, resta in posizione finche' i non trova un non-0; a quel punto avviene lo swap;
		         									// a questo punto, j non contiene piu' un valore 0. ma un valore non-0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0  &&  arr[j] == 0) {     // ... finche' i e j sono nella stessa partizione, questa condizione NON PUO' avverarsi.
				// do swap i with j = 0 goes next right and the non-0 goes next left
				int temp = arr[i];                  // duplica il non-0;
				arr[i] = arr[j];                    // manda lo 0 a destra; ovvero sovrascrivi lo 0 dove sta i ovvero in un non-0; la copia di tale valore l'hai conservata in temp;
				arr[j] = temp;                      // manda il non-0 a sinistra;
			}
			if (arr[j] != 0) {j++;} // se hai appena fatto uno swap, questa condizione e' vera per forza, j contiene un non-0, quindi fara' j++
		}		                    // quindi: a swap avvenuto, j contiene un non-0 (riprendera' a muoversi) e i contiene un 0;
		return arr;
	}
	
	public void printer(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\tPRINTED");
	}	

	public static void main(String[] args) {
		Definitive instance = new Definitive();
		
		int[] test_one = {1,2,3,0,0,4,5,0,1};
		instance.printer(test_one);                   // original array;
		instance.zHeroes(test_one);                   // do swap;
		instance.printer(test_one);		              // swapped array;
	}
}