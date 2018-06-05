package com.geeksforgeeks.string;

/*
 * https://www.geeksforgeeks.org/longest-common-prefix-set-1-word-by-word-matching/
 * https://www.geeksforgeeks.org/longest-common-prefix-set-2-character-by-character-matching/
 * https://www.geeksforgeeks.org/longest-common-prefix-set-3-divide-and-conquer/
 * https://www.geeksforgeeks.org/longest-common-prefix-set-4-binary-search/
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String arr[] = { "geeksforgeeks", "geeks", "geek", "geezer" };
		lcpWord(arr);
		lcpChar(arr);
	}

	/*
	 * Method 1 : Matching word by word
	 */
	public static void lcpWord(String[] arr) {
		int n = arr.length;
		String prefix = arr[0];
		for (int i = 1; i < n; i++) {
			prefix = prefixUtil(prefix, arr[i]);
		}
		System.out.println("LCP : " + prefix);
	}

	/*
	 * Method 2 : Character by character matching in each word
	 */
	public static void lcpChar(String[] arr) {
		int len = findMinLength(arr);
		String prefix = "";
		char ch;
		for (int i = 0; i < len; i++) {
			ch = arr[0].charAt(i);
			for(int j=1;j<arr.length;j++){
				if(arr[j].charAt(i)!=ch){
					System.out.println("LCP : " + prefix);
					return;
				}
					
			}
			prefix += ch;
		}
		System.out.println("LCP : " + prefix);
	}

	private static int findMinLength(String[] arr) {
		int len = arr[0].length();
		for (int i = 1; i < arr.length; i++)
			len = Math.min(len, arr[i].length());
		return len;
	}

	private static String prefixUtil(String prefix, String string) {
		String res = "";
		for (int i = 0, j = 0; i < prefix.length() && j < string.length(); i++, j++) {
			if (prefix.charAt(i) != string.charAt(j))
				return res;
			res = res + prefix.charAt(i);
		}
		return res;
	}

}
