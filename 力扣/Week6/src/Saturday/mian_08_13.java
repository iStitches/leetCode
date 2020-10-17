package Saturday;

import java.util.Arrays;
import java.util.Comparator;

public class mian_08_13 {
	/**
	 * 求最优解，而且分为多步，那么可以考虑采用dp
	 * 可以设一个dp[i] 表示以第i号箱子为顶时的最大高度，递归方程 dp[i]=max{dp[k]+hi,dp[i]}  k<=i 
	 * 相当于计算能够放置第i个箱子的最大高度
	 * @param box
	 * @return
	 */
    public int pileBox(int[][] box) {
    	//由于必须满足三个条件，因此先按宽度排序减少循环次数
    	for(int i=0;i<box.length;i++) {
    		Arrays.sort(box,new Comparator<int[]>() {   //对每一个二维数组按照宽度排序，升序
    		   @Override
    		    public int compare(int[] o1,int[] o2) {
    			   return o1[0]-o2[0];
    		   }
			});
    	}
    	
    	int max_height=0;
        int dp[]=new int[box.length];
        
        
        for(int i=0;i<box.length;i++) {
        	dp[i]=box[i][2];   //第i个箱子为顶的最大高度至少为 box[i][2]
        	for(int j=0;j<i;j++) { //能放在第j个箱子上的所有值的最大值
        		if(box[i][0]>box[j][0] && box[i][1]>box[j][1] && box[i][2]>box[j][2]) {
        			dp[i]=Math.max(dp[i],dp[j]+box[i][2]);
        		}
        	}
        	max_height=max_height>dp[i]?max_height:dp[i];
        }
        return max_height;
    }
}
