/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		//System.out.println(isAnagram("silent","listen"));  // true
		//System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		//System.out.println(isAnagram("Madam Curie","Radium came")); // true
		//System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "silent";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		if(str1.length()!=str2.length()){
			return false; 
		}
		boolean are_equal = true;
		int len = str1.length();
		boolean[] check = new boolean[str2.length()];
		for(int i=0 ; i<len ; i++){
			for(int j=0 ; j<len ; j++){
				if(str1.charAt(i) == str2.charAt(j) && check[j] == false){
					check[j] = true ;
					break;

				}
				else if (j == len-1 ){
					are_equal = false;
					break;
				}

			}
		}
		// Replace the following statement with your code
		return are_equal;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		String new_str ="";
		for(int i=0 ; i<str.length(); i++){
			// check if character is an upper case letter, and if so we transform it to new_str
			if(((str.charAt(i) >= 65 && str.charAt(i)<=90))){
				new_str = new_str + (char)(str.charAt(i)+32);
			}
			// check if character is lower case letter or space, if so we add it to new_str 
			else if (str.charAt(i)>=97 && str.charAt(i)<=122||str.charAt(i) == 32){
				new_str = new_str + (char)(str.charAt(i));
			}
		
		}
		return new_str;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-asrranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		
		int strlen = str.length();
		int j;
		char[] char_arr = str.toCharArray();
		char temp = ' ';
		for ( int i = strlen-1  ; i>0 ; i-- ){
			j = (int) (Math.random() * (double) (i+1));
			temp        = char_arr[i];
			char_arr[i] = char_arr[j];
			char_arr[j] = temp ;

		}
		String my_str ="";
		for(int i=0 ;  i<strlen; i++){
			my_str = my_str + char_arr[i];

		}
		return my_str;
	}
}
