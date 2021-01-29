package week1;

import java.util.Arrays;

public class Monday {
	/**
	 * 动态规划--- O(n^2)
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
	 * 双指针法---更新面积最大值 O(n)
	 * S(i,j)=min(h[i],h[j])*(j-i))
	 * 短板不动，向内移动长板，总的面积一定减小；
	 * 长版不动，向内移动短板，总的面积可能增大。
	 * 因此每次向内移动两个板中的短板并且更新最大面积
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
