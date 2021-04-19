package leetcode_DP;

public class dp_5 {
	/**
	 * 1. 动态规划法
	 * * 状态方程： dp[i][j] = S[i]==S[j] && dp[i+1][j-1]
	 * @param s
	 * @return
	 */
    public String longestPalindrome(String s) {
    	 int len = s.length();
    	 String res = "";
         boolean[][] dp = new boolean[len][len];
         
         for(int i=len-1;i>=0;i--) {
        	 for(int j=i;j<len;j++) {
        		 dp[i][j] = s.charAt(i)==s.charAt(j) && (j-i<2 || dp[i+1][j-1]);
        		 if(dp[i][j] && j-i+1>res.length())
        			 res = s.substring(i,j+1);
        	 }
         }
         return res;
    }
    
}
