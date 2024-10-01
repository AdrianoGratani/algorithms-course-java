package algolesson9removeevenintegersfromarray;
import java.util.Random;

public class Definitive {	
	public static int[] integerArrGen() { // 1. create and return an array of random integers;
		Random rand = new Random();					     //import the Random utility to generate random integers to popolate the array partitions (ength of the array should be random as well)
		int randomLength = rand.nextInt(4, 100);         // genera un numero a caso tra 4 e 100
		int[] randomNumsArr = new int[randomLength];     // genera un array di lunghezza pari al numero casuale generato
		
		for (int i = 0; i < randomNumsArr.length; i++) {
			int randomNum = rand.nextInt(0, 1000);       // genera un numero a caso tra zero e mille
			randomNumsArr[i] = randomNum;                // metti tale numero a caso nell'array in posizione index attuale
		}		
		return randomNumsArr;                            // store the array generated in a variable, in main() create an instance of the class to do so.
	}
	
	public static int[] oddsEvenSeparator(int[] randomIntArray) { // 2. take the array random as argument, find the odd numbers and store them in a new array, return this array;
		int oddsCount = 0;
		for (int i = 0; i < randomIntArray.length; i++) {    // take count of odds number from the array you created at integerarrgen() that you just received as argument on call
			if (randomIntArray[i] % 2 !=0) {
				oddsCount++;
			}
		}
		int[] oddsOnlyArr = new int[oddsCount];             // this array has size equal to the total amount of odds stored in the original array.		
		int oddArrIndex = 0;                     // an index to move in the oddsonly array;
		for (int i = 0; i < randomIntArray.length; i++) {
			if (randomIntArray[i] %2 != 0) {                        // if, while looping in the original array, you find an odd number,
				oddsOnlyArr[oddArrIndex] = randomIntArray[i];    // put it in the odd only array, at the oddcounter position
				oddArrIndex++;                                   // and then move the index of this arr to the next position by incrementing the integer stored in this variable,
			}                                                    // otherwise you keep rewriting odds found in the same position = overwriting of data =  bug
		}				
		return oddsOnlyArr;
	}
	
	public static void printArr(int[] solution) {       // 3. the array printer; is void so you just call it in main() with the array you want to print, that you returned.
		for (int i = 0; i < solution.length; i++) {
			System.out.print(solution[i] + " ");
		}
	}

	public static void main(String[] args) {
		Definitive instance = new Definitive();
	    int[] r = instance.integerArrGen();       // store the array made of random ints, of random length, you created;
	    int[] o = instance.oddsEvenSeparator(r);
	    instance.printArr(r);                     // print the array original
	    System.out.println("\n");
	    instance.printArr(o);                     // print the array odds only
	}
}