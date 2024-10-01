package algolessona13moveallzerostotheendofthearray;                    
public class DefinitiveClean {         										
	
	public int[] zHeroes(int[] arr) {
		int j = 0;                                  
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0  &&  arr[j] == 0) {    
				int temp = arr[i];                  
				arr[i] = arr[j];                    
				arr[j] = temp;                      
			}
			if (arr[j] != 0) {j++;} 
		}		                    
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
		instance.printer(test_one);                   
		instance.zHeroes(test_one);                   
		instance.printer(test_one);		              
	}
}