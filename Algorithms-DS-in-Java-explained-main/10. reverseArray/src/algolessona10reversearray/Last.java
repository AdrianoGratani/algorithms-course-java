package algolessona10reversearray;

public class Last {

	public static void inverter(int arr[], int si, int li) {
		while (si < li) {
			int temp = arr[si];   // bug: arr[0]. temp keep staying at [0] so arr[li] will be 4 '4ever' (!punIntended)
			arr[si] = arr[li];
			arr[li] = temp;
			si++;
			li--;
		}		
	}	
	public static void printer(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}	
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		
		Last instance = new Last();
		instance.printer(a);
		instance.inverter(a, 0, a.length -1);
		instance.printer(a);	
		
	}
}
