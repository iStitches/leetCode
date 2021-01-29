package week1;

import java.util.Arrays;

public class Monday {
	/**
	 * ��̬�滮--- O(n^2)
	 */
//    public int maxArea(int[] height) {
//         int dp[]=new int[height.length],curheight=0;
//         Arrays.fill(dp, 0);
//         for(int i=1;i<dp.length;i++) {
//    		 dp[i]=dp[i-1];
//        	 for(int j=0;j<i;j++) {
//        		 curheight=height[i]<height[j]?height[i]:height[j];
//        		 if(dp[i]<curheight*(i-j))
//        			 dp[i]=curheight*(i-j);
//        	 }
//         }
//         return dp[height.length-1];
//    }
	
	
	/**
	 * ˫ָ�뷨---����������ֵ O(n)
	 * S(i,j)=min(h[i],h[j])*(j-i))
	 * �̰岻���������ƶ����壬�ܵ����һ����С��
	 * ���治���������ƶ��̰壬�ܵ������������
	 * ���ÿ�������ƶ��������еĶ̰岢�Ҹ���������
	 */	
	public int maxArea(int[] height) {
		int max=0,i=0,j=height.length-1,k=0,cur=0;
		while(i<j) {
			k=height[i]<height[j]?height[i]:height[j];
			cur=k*(j-i);
			max=max<cur?cur:max;
			if(height[i]<height[j])
				i++;
			else
				j--;
		}
		return max;
	}
    
    public static void main(String[] args) {
		Monday m=new Monday();
		int height[]= {1,8,6,2,5,4,8,3,7};
		System.out.println(m.maxArea(height));
	}
}
