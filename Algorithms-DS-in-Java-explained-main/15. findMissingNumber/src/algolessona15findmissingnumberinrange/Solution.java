// ti viene fornito un array avente un range di numeri da 1 a length+1.
// se array ha length partizioni, ma il range arriva a length+1, 
// evidentemente non puo' contenere tutti i numeri nel range.
// se il range max arriva a 5+1, significa che SOLO UN numero manca. TROVALO.
//
// public static int .... un metodo statico, e con un return, non ha bisogno di istanze, 
// ne di inizializzazioni in variabili. puoi performarlo anche in un sysout.
package algolessona15findmissingnumberinrange;
public class Solution {
	
	public static int findMissingNum(int[] arr) {              
		int sumRange = ( (arr.length + 1) * (arr.length + 2)) / 2;             // this is a mathematical formula; arr.length + 1 is RANGE max
		for (int i = 0; i < arr.length; i++) { sumRange = sumRange - arr[i]; } // alla fine del loop ti rimane il numero mancante
		return sumRange;		
	}

	public static void main(String[] args) {		
		int[] array = {6,3,2,4,1};    
		System.out.println(findMissingNum(array));		
	}
}