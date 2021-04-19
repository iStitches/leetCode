package sword_offer;

import java.util.HashMap;

public class ��ָ48_2 {
	//����һ��ʱ�临�Ӷ�O(n^2)      �ռ临�Ӷ�O(n)
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
    
    //�������� dp+��ϣ��
    /**
     *    dp���̣�
     * *      ��ʱ��֪dp[i-1],��Ҫ���dp[i]��ֵ������ s[i]=s[j]
     *             1.  dp[i] = dp[i-1]+1     i-j>dp[i-1]
     *             2.  dp[i] = i-j           i-j>=dp[i-1]    
     * *  ͨ����ÿ���ַ������ֵ�λ�ý���ͳ����������� j ��ֵ 
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
		��ָ48_2 t = new ��ָ48_2();
		String str = "pwwkew";
		int res = t.lengthOfLongestSubstring(str);
		System.out.println(res);
	}
}
