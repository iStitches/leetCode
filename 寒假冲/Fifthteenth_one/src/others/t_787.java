package others;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class t_787 {
	int maxValue = Integer.MAX_VALUE;
	int graph[][];
	int n,res=maxValue;
	boolean visit[];
	
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    	//初始化变量
        this.n = n;
        this.graph = new int[n][n];
        this.visit = new boolean[n];
        for(int[] arr:flights) 
        	graph[arr[0]][arr[1]]=arr[2];
        
        return bfs(src,dst,K);
    }
	/**
	 * 解法一： 深度遍历
	 */
    public void dfs(int src,int dst,int k,int cost) {
    	if(src == dst)
    	{
    		res = Math.min(cost, res);
    		return;
    	}
    	if(k<0)
    		return;
    	//遍历所有可达点
    	for(int i=0;i<n;i++) {
    		if(graph[src][i]!=0 && !visit[i]) {
    			//进行剪枝
    			if(graph[src][i]+cost<res) {
    				visit[i]=true;
    				dfs(i,dst,k-1,cost+graph[src][i]);
    				visit[i]=false;
    			}
    		}
    	}
    }
    
	
	/**
	 * 解法二：层序遍历  基于优先队列实现
	 * 优先队列中存放的都是中转数小于K的，每次从优先队列中取出最优的情况。
	 * 存储格式  {当前费用,到达站,路过的中转站数目}
	 */
    public int bfs(int src,int dst,int k) {    	
    	PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
    	queue.offer(new int[]{0,src,0});
    	while(queue.size()>0) {
    		int[] temp = queue.poll();
    		int fee = temp[0];
    		int cur = temp[1];
    		int stop = temp[2];
    		if(cur == dst) return fee;
    		if(stop<k) {
    			for(int i=0;i<n;i++) {
    				if(graph[cur][i]>0)
    					queue.offer(new int[] {fee+graph[cur][i],i,k+1});
    			}
    		}
    	}
    	return -1;
    }
}
