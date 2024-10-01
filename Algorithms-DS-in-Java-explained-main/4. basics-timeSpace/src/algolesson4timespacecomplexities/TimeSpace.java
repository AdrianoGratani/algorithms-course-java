package algolesson4timespacecomplexities;

public class TimeSpace {
	public static void main(String[] args) {
		TimeSpace ts = new TimeSpace();            // create the instance of the public class using the constructor;
				
		//ramesh
		double now = System.currentTimeMillis();   // STARTS HERE counter for the time
		int ramesh = ts.findSum(999999);           // you can access the method findSum() from the ts instance.
		System.out.println(ramesh);
		System.out.println("\n time evaluation. it took this time to perform the task using Ramesh algorithm: " 
							+ (System.currentTimeMillis() - now));
			
		// suresh
		double nowTwo = System.currentTimeMillis();
		int suresh = ts.findSumTwo(999999);
		System.out.println(suresh);	
		System.out.println("\n time evaluation. it took this time to perform the task using Suresh algoritm: " 
							+ (System.currentTimeMillis() - nowTwo));
		}
	
	public int findSum(int n) {    // ramesh
		return n * (n+1) / 2;
	}
	
	public int findSumTwo(int n) { // suresh
		int sum = 0;		
		for (int i = 0; i <= n; i++) {
			sum = sum + i;
		}		
		return sum;
	}
}