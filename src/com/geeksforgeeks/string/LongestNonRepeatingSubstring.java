package com.geeksforgeeks.string;

/*
 * https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 */
public class LongestNonRepeatingSubstring {

	public static void main(String[] args) {
		//String str = "ABDEFGABEF";
		String str = "geeksforgeeks";
		maxNonRepeatingStr(str);
		printMaxNonRepeatingStr(str);
	}

	/*
	 * Method 1 : This method finds the length as well as print the longest
	 * non-repeating substring
	 */
	public static void printMaxNonRepeatingStr(String str) {
		int curLen = 0, maxLen = 0, n = str.length(), prevInd, startInd = 0;
		int visited[] = new int[256];
		// Populate visited array with the index of the characters
		// Also, initialize with -1
		for (int i = 0; i < n; i++)
			visited[i] = -1;
		visited[str.charAt(0)] = 0;
		curLen++;
		for (int i = 1; i < n; i++) {
			prevInd = visited[str.charAt(i)];
			// If the current character is not visited or is visited at index
			// not included in the current substring, then increase the length
			// of
			// current substring
			if (prevInd == -1 || i - curLen > prevInd)
				curLen++;
			else {
				if (curLen > maxLen) {
					maxLen = curLen;
					startInd = prevInd + 1;
				}
				curLen = i - prevInd;
			}

			// Add index of current char to visited array
			visited[str.charAt(i)] = i;
		}
		maxLen = Math.max(maxLen, curLen);
		System.out.println("Max length of non repeating substring : " + maxLen);
		System.out.println("Longest non-repeating substring : "
				+ str.substring(startInd, startInd + maxLen));
	}

	/*
	 * Method 2 : This method only finds the length of the longest non-repeating
	 * substring
	 */
	public static void maxNonRepeatingStr(String str) {
		int curLen = 0, maxLen = 0, n = str.length(), prevInd;
		int visited[] = new int[256];
		// Populate visited array with the index of the characters
		// Also, initialize with -1
		for (int i = 0; i < n; i++)
			visited[i] = -1;
		visited[str.charAt(0)] = 0;
		curLen++;
		for (int i = 1; i < n; i++) {
			prevInd = visited[str.charAt(i)];
			// If the current character is not visited or is visited at index
			// not included in the current substring, then increase the length
			// of
			// current substring
			if (prevInd == -1 || i - curLen > prevInd)
				curLen++;
			else {
				if (curLen > maxLen)
					maxLen = curLen;
				curLen = i - prevInd;
			}

			// Add index of current char to visited array
			visited[str.charAt(i)] = i;
		}
		maxLen = Math.max(maxLen, curLen);
		System.out.println("Max length of non repeating substring : " + maxLen);
	}
}
