package dynamicProgramming;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		
		String str = "bananas";
        System.out.println("Length is: " + 
                                 longestPalinSubstr(str));
	}
	
	/**
	 * This method finds the longest palindromic substring from the input string.
	 * Logic:
	 * 		if (str.charAt(i) == str.charAt(j) && boolArr[i+1][j-1] == true)
	 * 				then 
	 * 					{
	 * 					boolArr[i][j] = true;
	 * 					start = i;
	 * 					maxLength = j - i  + 1
	 * Note: All string of length 1 is considered palindrome
	 * 
	 * @param str the string from which to extract the substring
	 * @return
	 * 		the largest palindrome from the string
	 */
	private static String longestPalinSubstr(final String str)
	{
		int n = str.length(), i ;
		int maxStart = 0, maxLength = 1;
		
		// need 
		boolean [][]isPalin = new boolean[n][n];
		
		// all character are considered palindrome
		for(i = 0 ; i < n ; i++)
			isPalin[i][i] = true;
		
		// check palindrome of length 2
		for(i = 0 ; i < n-1 ; i++ )
			if(str.charAt(i) ==  str.charAt(i+1))
				{
				isPalin[i][i+1] = true;
				maxStart = i;
				maxLength = 2;
				}
		
		// check for all size
		for( int k = 3 ; k <= n ; k++)
		{
			// start pointer
			for( i = 0; i < n - k + 1 ; i ++ )
			{
				// end pointer
				int j = i + k -1;
				if( str.charAt(i) ==  str.charAt(j) && isPalin[i+1][j-1])
				{
					isPalin[i][j] = true;
					if(maxLength < k){
						maxStart = i;
						maxLength = k;
					}
				}
			}
		}
		return str.substring(maxStart, maxStart + maxLength);
	}
}
