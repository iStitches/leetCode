package Thursday;

import java.util.Arrays;

public class mian_08_14 {

	private int[][][] dp;   //��¼�ַ�����i��jʹ�ý��Ϊres���ܷ�����
	private char[] arr;     //�������ַ���ת��Ϊ�ַ�����
	
    public int countEval(String s, int result) {  
    	int len=s.length();
        dp=new int[len][len][2];  //ͳ���ۼƷ�����
        arr=s.toCharArray();
        
        //��ʼ�����еķ�����ȫ����-1����ʾ��δ�����
        for(int i=0;i<len;i++) {
        	for(int j=0;j<len;j++)
        		Arrays.fill(dp[i][j],-1);
        }

        return getMenuCount(0, len-1, result);
    }
    
    //���������������ڲ�����op�µĽ��
    int getResult(int val1,int val2,char op) {
    	switch(op) {
    	case '&':return val1&val2;
    	case '|':return val1|val2;
    	case '^':return val1^val2;
    	}
    	return val1&val2;
    }
    
	//�ַ���s��start��end��ʹ�ü�����Ϊresult���ܷ�����,��start��end��start��end��λ�ö����������֣�
    int getMenuCount(int start,int end,int res) {
    	//�ݹ����---��start==end��ʱ�򣬷��ؽ���Ƿ����res
    	if(start==end)
    		return arr[start]-'0'==res?1:0;
    	
    	//�����Ѿ���������Ҵ洢��������ķ�����
    	if(dp[start][end][res]!=-1)
    		return dp[start][end][res];
    		
		int count=0;
    	
    	//ͳ�ƴ�start��end�����ڵķ�����
    	for(int i=start;i<end;i+=2) {
    		for(int k=0;k<=1;k++) {
    			for(int m=0;m<=1;m++) {
    				//����ܹ�ƥ�����
    				if(getResult(k, m, arr[i+1])==res) {
    					//ͳ���������ߵķ�����
    					count+=getMenuCount(start, i, k)*getMenuCount(i+2, end, m);
    				}
    			}
    		}
    	}
    	
    	//����dp����
    	dp[start][end][res]=count;
    	return count;
    }
}
