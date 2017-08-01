public class Q05 {
	// Time: O(n)  Space: O(1)
	public static boolean mySol(String s1, String s2){
		int l1 = s1.length();
		int l2 = s2.length();
		if (Math.abs(l1-l2)>1) return false;
		if (l1 == l2){ // check replace
			boolean replaced = false;
			for (int i=0; i < l1; i++){
				if (s1.charAt(i) != s2.charAt(i)){
					if (replaced) return false;
					replaced = true;
				}
			}
			return true;
		}
		// add/remove
		if (l1 > l2){ // let s1 be smaller one
			String dummy = s1;
			s1 = s2;
			s2 = dummy;
		}
		boolean added = false;
		int j = 0;
		for (int i=0; i < s1.length(); i++){
			if (s1.charAt(i) != s2.charAt(j)){
				if (added) return false;
				added = true;
				j++;
			}
			j++;
		}
		return true;
	}

	//Time: O(n)  Space: O(1)
	public static boolean stdSol(String str1, String str2){
		if (Math.abs(str1.length()-str2.length())>1) return false;
		if (str1.length()>str2.length()) return stdSol(str2,str1); // shorter string first.

		boolean sameLength = str1.length() == str2.length();
		boolean foundDiff = false;
		int j = 0;
		for (int i=0; i<str1.length(); i++){
			if (str1.charAt(i) != str2.charAt(j)){
				if (foundDiff) return false;
				foundDiff = true;
				if (!sameLength) j++;
			}
			j++;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = {"apple", "aple",
				"apple", "apcale",
				"banana", "banaa",
				"","b",
				"orange", "oranga",
				"false", "felsa"
		};
		for (int i=0; i < strings.length; i+=2){
			System.out.println("Text: " + strings[i] + "  " + strings[i+1]);
			System.out.println(mySol(strings[i],strings[i+1]));
			System.out.println(stdSol(strings[i],strings[i+1]));
		}
	}
}
