package algolessona10reversearray;

public class OneArRaypublic {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		int fromStart = 0;
		int fromEnd = array.length-1;
		
		while (fromStart < fromEnd) {
			int temp = array[fromStart];
			array[fromStart] = array[fromEnd];
			array[fromEnd] = temp;
			fromStart++;
			fromEnd--;
		}
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}
}