// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
		System.out.println(minus(7,-2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4 
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(21,7));   // 25 / 7
		/*
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
		 */
	    
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
		int res =  x1 ;
		int counter = x2; 

		while(counter>0){
			res++;
			counter--;
		}
		while(counter<0){
			res--;
			counter++;
		}
		return res;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		int res =  x1 ;
		int counter = x2; 

		while(counter>0){
			res--;
			counter--;
		}
		while(counter<0){
			res++;
			counter++;
		}
		return res;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if(x1 == 0 || x2==0){
			return 0;
		}
		int x1_abs = x1;
		int x2_abs = x2;
		if(x1<0){
			x1_abs = minus(0,x1);
		}
		if(x2<0){
			x2_abs = minus(0,x2);	
		}
		boolean result_is_negative = false;
		if ((x1<0 && x2>0) || (x1>0 && x2<0)){
			result_is_negative = true;
		}

		int multiplicand = x1_abs;
		int multiplier   = x2_abs;
		int result = 0;

		for(int i=0 ; i< multiplier;i++){
				result = plus(result,multiplicand);
			}
		if(result_is_negative){
			result = minus(0,result);
		}
		return result;

	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if(n==0){
			return 1;
		}
		if(n==1){
			return x;
		}
		int result = x;
		for(int i=0 ; i<n-1; i++){
			result = times(result,x);
		} 
		return result;
	
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if(x1 == 0){
			return 0; 
		}
		if(x2 == 1){
			return x1;
		}
		int x1_abs = x1;
		int x2_abs = x2;
		if(x1<0){
			x1_abs = minus(0,x1);
		}
		if(x2<0){
			x2_abs = minus(0,x2);
		}

		int dividend = x1_abs ;
		int divisor  = x2_abs ; 
		
		int result = 0;

		while(dividend>=divisor){
			dividend = minus(dividend,divisor);
			result++;
			
		}
		boolean result_is_negative = false;
		if ((x1<0 && x2>0) || (x1>0 && x2<0)){
			result_is_negative = true;
		}

		if(result_is_negative){
			result = minus(0, result);
		}


		return result;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
		if(x2 == 0){
			return -1; 
		}
		if(x2 == 1){
			return 0;
		}
		if(x1<x2){
			return x1;
		}
		int temp = x1;
		boolean flag = true;
		while(flag){
			for(int i=0 ; i<x2 ; i++){
				temp--;
			
			}
			if(temp == x2){
				return 0;
		
			}
			if(temp<x2){
				flag = false;

			}
		}
		return temp;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if(x==0){
			return 0;
		}
		if(x==1){
			return 1;
		}
		int previous = 1 ;
		for(int i=2 ; ;i++){
			int current = pow(i,2);
			if(x > previous && x < current){
				return i-1;
			}
			if(x==current){
				return i;
			}
			else{
				previous = current ;
			}
			
		}
		
		// Replace the following statement with your code
		
	}	  	  
}