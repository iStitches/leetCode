package Sunday;

import java.util.Arrays;

/**
 *  力扣 845 数组中的最长山脉
 * @author dell
 *
 */
public class every {
	/**
	 * 考虑到需要求出每一个位置元素的左侧递减序列、右侧递增序列，只要求出了序列后就能够用right[i]-left[i]+1来得出该点的最长
	 * 山脉长度。求left和right的过程可以利用动态规划求解。
	 * @param A
	 * @return
	 */
    public int longestMountain(int[] A) {
        int len=A.length;
        if(len<=2)
        	return 0; 
        int left[]=new int[len];
        int right[]=new int[len];
        
        //求出left[]
        left[0]=0;
        for(int i=1;i<len;i++) {
        	left[i]=A[i]>A[i-1]?left[i-1]+1:0;
        }
        //求出right[]
        right[len-1]=0;
        for(int i=len-2;i>0;i--) {
        	right[i]=A[i]>A[i+1]?right[i+1]+1:0;
        }
        
        //求出最长山脉长度
        int ans=0;
        for(int i=1;i<len-1;i++) {
            if(left[i]>0 && right[i]>0 && right[i]+left[i]>=2) {
            	ans=Math.max(ans,right[i]+left[i]+1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
		every t=new every();
		int []A= {2,1,4,7,3,2,5};
		t.longestMountain(A);
	}
}

