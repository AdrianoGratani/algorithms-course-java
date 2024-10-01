package algolessona15findmissingnumberinrange;
// se il range e' tra 1 e x, x non puo' essere il missing number
//		int sum = (arr.length * (arr.length + 1)) / 2; // mathematical formula to find the sum in range;

public class Guess {	
	public void findMissingNumber(int[] arr) {
		int sumRange_thenMissing = 0;	
		for (int i = 1; i <= arr.length + 1; i++) {       
			sumRange_thenMissing += i;
		}		
		for (int i = 0; i < arr.length; i++) {
			sumRange_thenMissing = sumRange_thenMissing - arr[i];
		}		
		System.out.println(sumRange_thenMissing);
	}

	public static void main(String[] args) {
		Guess instance = new Guess();		
		int[] rangeArrayMissing  = {1,2,3,5,6};        
		int[] maxArrayMissing  = {1,2,3,5,4};          
		
		instance.findMissingNumber(rangeArrayMissing);    // 4
		instance.findMissingNumber(maxArrayMissing);      // 6		
	}
}

/*                                              
 * hai un array con 5 spazi, il suo range e' da 1 a 6 inclusi. quindi non c'e' lo spazio per un numero del range,
 * trova quel numero;
 * x = length dell'array e anche il numero piu' alto a non eccedere il valore length; i.e.  5
 * (x - (x - 1)) = il primo valore nel range, ovvero 1;                               i.e.  5 - (5-1) = 5 - 4 = 1
 * y = la somma tra loro, di tutti i numeri compresi nel range, da 1 ad x compresi 
 *     i.e. {1,2,3,4,6}    x = 5    y = 1 + 2 + 3 + 4 + 5 = 15
 * 
 *    se la length di un array e' x, l'array deve contenere la somma di tutti i numeri nel range,
 *    da (x - (x-1))  fino a x. calcola tale somma e mettila in una variabile;
 *    loop: se array[i] e' inferiore o uguale al valore length (escludi da tale condizione il valore x+1)
 */ 