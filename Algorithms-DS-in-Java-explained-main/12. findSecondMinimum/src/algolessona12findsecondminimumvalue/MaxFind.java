package algolessona12findsecondminimumvalue;

public class MaxFind {
	
	public int secondMax(int[] arr) {
		int maxValue = Integer.MIN_VALUE;
		int secondMaxValue = Integer.MIN_VALUE;
		
		for (int i=0; i<arr.length; i++) {
			if (arr[i] > maxValue) {
				secondMaxValue = maxValue;
				maxValue = arr[i];
			} else if ( arr[i] < maxValue && arr[i] > secondMaxValue ) {
				secondMaxValue = arr[i];
			}
		}		
		return secondMaxValue;
	}

	public static void main(String[] args) {
		MaxFind instance = new MaxFind();
		int[] test_one = {0,1,2,3,4,5};
		int[] test_two = {5,4,3,2,1};
		int[] test_three = {66,33,55,8,99,10};		
		int one = instance.secondMax(test_one);
		int two = instance.secondMax(test_two);
		int three = instance.secondMax(test_three);
		
		System.out.println(one + " " + two + " " + three);
	}
}