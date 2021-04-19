package sword_offer;

import java.util.HashMap;

public class 剑指48_2 {
	//方法一、时间复杂度O(n^2)      空间复杂度O(n)
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
           return 0;
        int[] dp = new int[s.length()+1];
        int max = 1;
        dp[0] = 0;dp[1] = 1;
        for(int i=2;i<=s.length();i++){
            int len = dp[i-1];
            int index = i-1;
            while(index>=i-len && s.charAt(index-1) != s.charAt(i-1))
                 index--;
            dp[i] = i-index;
            max = max>dp[i]?max:dp[i];
        }
        return max;
    }
    
    //方法二： dp+哈希表
    /**
     *    dp方程：
     * *      此时已知dp[i-1],需要求出dp[i]的值，假设 s[i]=s[j]
     *             1.  dp[i] = dp[i-1]+1     i-j>dp[i-1]
     *             2.  dp[i] = i-j           i-j>=dp[i-1]    
     * *  通过对每种字符最后出现的位置进行统计来方便求出 j 的值 
     * @param args
     */
    public int lengthOfLongestSubstring2(String s) {
    	int[] dp = new int[s.length()];
    	int res=0,i=0,j,tmp;
    	HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    	char[] array = s.toCharArray();
    	
    	for(;i<s.length();i++) {
    		j = map.getOrDefault(s.charAt(i), -1);
    		map.put(s.charAt(i),i);
            tmp = i-j>dp[i-1]?dp[i-1]+1:i-j;
            res = res>tmp?res:tmp;
    	}
    	return res;
    }
    
    
    
    public static void main(String[] args) {
		剑指48_2 t = new 剑指48_2();
		String str = "pwwkew";
		int res = t.lengthOfLongestSubstring(str);
		System.out.println(res);
	}
}
