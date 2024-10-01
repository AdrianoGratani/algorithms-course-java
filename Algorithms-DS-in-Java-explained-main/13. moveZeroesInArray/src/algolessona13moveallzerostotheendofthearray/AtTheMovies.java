// PSEUDOCODE:
//  this method RETURNS the same array taken as PARAMETER;

//  you need a FOR loop to iterate over the array. from start position to the last. increment at each step by 1:
//  	INITIALIZE two iterators, one 'begin' starts at the beginning, one 'end' at the last position of the array;
//     	WHILE the value stored in the 'end' position IS EQUAL TO 0, DECREASE 'end'
//        	(array in the position of 'end' already contains a 0,
//           you don't want to overwrite this value so you move to the next position);
//     IF the value stored at 'start' position in the array IS EQUAL TO 0, then do a SWAP routine:
//        INITIALIZE a variable 'temp' which stores the value of the array partition at 'start';
//        REDECLARE the array partition at 'start' with the value stored at the 'end' position;
//        REDECLARE the array partition at 'end' with the value stored at the 'start' position;
//        INCREASE 'start' by one;
//NO quando hai raggiunto la meta' dell'array con start, significa che hai swappato meta con meta.

package algolessona13moveallzerostotheendofthearray;
// MY ALGORITHM;  not perfect;
public class AtTheMovies {

	public int[] moveZeros(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		for (int i=0; i<=arr.length-1; i++) {			
			if (arr[start] == 0) {
				while (arr[end] == 0 && end >= 0) {             
					end--;
//					if (end == 0) break;            // implicit;                        
				}			
				System.out.println(arr[end]);
				int temp = arr[start];              // store the zero hero
				arr[start] = arr[end];              // swap the zero at start with the value at 'end'
				arr[end] = temp;                    // store the zero at 'start' in 'end'
				start++;
				end = arr.length-1;                                      //!!! BUG SE LEGGE QUESTA RIGA QUANDO END E' UGUALE A 0, FARA' IL DECREARSE A -1. POI LEGGE LA CONDIZIONE WHILE, E CERCA arr[-1] ==ERRORE
			}
			else if (arr[start] == 1) {start++;}
			// end--  qui sarebbe un errore perche' finiresti per spostare end a prescindere del suo valore, tutte le volte che il loop si ripete.
			//        i.e. arr[start] = 1  MA arr[end] = 1 -> start++ end--  e quell'1 resta li perche' ormai non ci tornerai piu: end puo solo decrementare
		}		
		return arr;
	}
	
	public void printer(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println("\tPRINTED ");
	}
	
//	{0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,1,1,1,1,0,1,0,0,0,1};
//	{0,1};
//	{0,1,1,0,0,1,1,1,1,0,0,0,0};
	public static void main(String[] args) {
		AtTheMovies instance = new AtTheMovies();		
		int[] arrayTest = {0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,1,1,1,1,0,1,0,0,0,1};
		
		instance.printer(arrayTest);          // first print the original;
		instance.moveZeros(arrayTest);
		instance.printer(arrayTest);
		}
}