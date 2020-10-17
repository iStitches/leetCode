package Thursday;

import java.util.Arrays;

public class mian_08_14 {

	private int[][][] dp;   //记录字符串从i到j使得结果为res的总方案数
	private char[] arr;     //将整个字符串转化为字符数组
	
    public int countEval(String s, int result) {  
    	int len=s.length();
        dp=new int[len][len][2];  //统计累计方案数
        arr=s.toCharArray();
        
        //初始将所有的方案数全部置-1，表示还未计算过
        for(int i=0;i<len;i++) {
        	for(int j=0;j<len;j++)
        		Arrays.fill(dp[i][j],-1);
        }

        return getMenuCount(0, len-1, result);
    }
    
    //计算两个操作数在操作码op下的结果
    int getResult(int val1,int val2,char op) {
    	switch(op) {
    	case '&':return val1&val2;
    	case '|':return val1|val2;
    	case '^':return val1^val2;
    	}
    	return val1&val2;
    }
    
	//字符串s从start到end，使得计算结果为result的总方案数,从start到end（start与end的位置都是两个数字）
    int getMenuCount(int start,int end,int res) {
    	//递归出口---当start==end的时候，返回结果是否等于res
    	if(start==end)
    		return arr[start]-'0'==res?1:0;
    	
    	//返回已经计算过并且存储在数组里的方案数
    	if(dp[start][end][res]!=-1)
    		return dp[start][end][res];
    		
		int count=0;
    	
    	//统计从start到end区间内的方案数
    	for(int i=start;i<end;i+=2) {
    		for(int k=0;k<=1;k++) {
    			for(int m=0;m<=1;m++) {
    				//如果能够匹配的上
    				if(getResult(k, m, arr[i+1])==res) {
    					//统计左右两边的方案数
    					count+=getMenuCount(start, i, k)*getMenuCount(i+2, end, m);
    				}
    			}
    		}
    	}
    	
    	//更新dp数组
    	dp[start][end][res]=count;
    	return count;
    }
}
