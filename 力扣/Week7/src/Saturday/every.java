package Saturday;

import java.util.Arrays;
import java.util.Comparator;

public class every {
	/**
	 * 力扣 1024、  视频拼接
	 * 解法一：  采用动态规划算法
	 *   假设dp[i]为时刻i之前能够剪辑成功所需的最小的片段数。那么对于每一个区间，有以下状态转移方程：
	 *   dp[i]=min{dp[clip[0]]+1,dp[i]}  clip[0]<i<=clip[1]
	 *   只要时刻i处在 clip[0]与clip[1]之间，说明当前段能够通过clip[0]之前的方案+1 来拼凑
	 *   
	 * 解法二：贪心法
	 *   贪心就让每次划分的区间的长度最大即可，选择开始时间为0，每次找到结束时间最长的区间，并记录结束时间t；
	 *   下一次再找开始时间不大于t但是结束时间最长的区间并更新t为此时的结束时间。循环直到t>规定的时间
	 * @param clips
	 * @param T
	 * @return
	 */
	public int videoStitching(int[][] clips, int T) {
//         int dp[]=new int[T+1];
//         Arrays.fill(dp,Integer.MAX_VALUE-1);    //注意这里要防止数字溢出，溢出后就成负数了
//         dp[0]=0;
//         dps(clips,dp);
//         return dp[T]==Integer.MAX_VALUE-1?-1:dp[T];
		
		Arrays.sort(clips, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]!=o2[0])
					return o1[0]-o2[0];
				else {
					return o1[1]-o2[1];
				}
			}
		});
		
		return hungry(clips, T);
		
    }
	
	//动态规划
	public void dps(int [][]clips,int dp[]) {
		for(int i=1;i<dp.length;i++) {
			for(int[] tmp:clips) {
				if(tmp[0]<i && i<=tmp[1])
				dp[i]=Math.min(dp[i],dp[tmp[0]]+1);
			}
		}
	}
	
	//贪心法
	public int hungry(int [][]clips,int T) {
        int start=0,t_last=0,i=0,ans=0;
        
        while(i<clips.length && start<T) {
        	if(clips[i][0]<=start) {
               	t_last=start;
            	while(i<clips.length && t_last>=clips[i][0]) {  //每次寻找当前start的最末尾结束符
            		start=Math.max(start, clips[i][1]);
            		i++;
            	}
            	ans++;
        	}
            
        	else {
        		break;
        	}        	
        }
        return start>=T?ans:-1;
	}
	
    public static void main(String[] args) {
		every t=new every();
		int clips[][]= {{0,2},{4,8}};
		t.videoStitching(clips, 5);
	}
}
