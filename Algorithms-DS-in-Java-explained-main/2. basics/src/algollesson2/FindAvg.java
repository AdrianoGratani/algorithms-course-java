package algollesson2;
// you want to find the average number between
// three given numbers. 

//1. create a method which you will call from the main()
//2. this method, to be called, has to be static.
//3. it has to return int, so that you can store its data
//   in a variable, in main().
//4. the method receives the number as arguments on call.
//   from the main()
//5. a) to find the average:
//      sum the three int arguments, store the result in a variable.
//   b) divide the sum by the number of arguments received.
//      store the result of this operation in another variable.
//      return this last variable
//6. back in main(), store the result in a variable.
//   this variable calls the method with three numbers as arguments
//   which will be received as args by the method.
//7. now you can output the result.




public class FindAvg {

	public static void main(String[] args) {
		
		int result = avgMethod(5, 6, 88);
		System.out.println(result);
	}
	
	public static int avgMethod(int a,int b, int c) {
		int sum = a + b + c;
		int avg = sum / 3;
		
		return avg;
	}
}