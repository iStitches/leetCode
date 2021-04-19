package sword_offer;

/**
 * dp动态规划
 * @author dell
 *
 */
public class 剑指19 {
	/**
	 * 
	 * @param s   待匹配串  每位对应i
	 * @param p   正则串     每位对应j
	 * @return
	 * dp[i][j] 代表s的前i位和p的前j位能否匹配
	 * dp[i][j]对应的是 s[i-1] p[j-1]两个位置的字符
	 * 由于正则的每一位只可能为三种值： . 、 字符、*
	 * 如果p[j-1]='*'  dp[i][j]的求值可以分为三种情况：   
	 *     1. dp[i][j-2]:  将字符组合 p[j-2]*  看作出现0次，能否匹配；
	 *     2. dp[i][j-1]:  将字符组合 p[j-2]*  看作出现1次，能否匹配；
	 *     3. dp[i-1][j]:  不忽略这两项，s[i-1]=p[j-2]，让 p[j-2]多出现一次；
	 *     4. dp[i-1][j]:  不忽略这两项, p[j-2] = '.'
	 * 如果p[j-1]!='*' dp[i][j]的值又可以划分：
	 *     1. dp[i-1][j-1]:  s[i-1]=p[j-1]
	 *     2. dp[i-1][j-1]:  p[j-1]='.'
	 */
    public boolean isMatch(String s, String p) {
          int len1= s.length(),len2= p.length();
          boolean dp[][]=new boolean[len1+1][len2+1];
          /**
           * 特殊值  dp[0][0]=true
           * dp[0][j]=dp[0][j-2] 且 p[j-1]='*'    p的偶数位为*时才能够匹配
           */
          dp[0][0]=true;
          for(int j=2;j<=len2;j+=2) {
        	  if(dp[0][j-2] && p.charAt(j-1)=='*')
        		  dp[0][j]=true;
          }
          for(int i=1;i<=len1;i++) {
        	  for(int j=1;j<=len2;j++) {
        		  if(p.charAt(j-1)!='*') {
        			  if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.')
        				  dp[i][j]=dp[i-1][j-1];
        		  }
        		  else {
        			  dp[i][j]=dp[i][j-1]||dp[i][j-2]||dp[i-1][j]&&s.charAt(i-1)==p.charAt(j-2)||dp[i-1][j]&&p.charAt(j-2)=='.';
        		  }
        	  }
          }
          return dp[len1][len2];
    }

    
    public static void main(String[] args) {
		剑指19 t= new 剑指19();
		System.out.println(t.isMatch("abb","c*a*b"));
	}
}
