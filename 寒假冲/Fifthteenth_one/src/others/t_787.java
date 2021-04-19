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
    	//��ʼ������
        this.n = n;
        this.graph = new int[n][n];
        this.visit = new boolean[n];
        for(int[] arr:flights) 
        	graph[arr[0]][arr[1]]=arr[2];
        
        return bfs(src,dst,K);
    }
	/**
	 * �ⷨһ�� ��ȱ���
	 */
    public void dfs(int src,int dst,int k,int cost) {
    	if(src == dst)
    	{
    		res = Math.min(cost, res);
    		return;
    	}
    	if(k<0)
    		return;
    	//�������пɴ��
    	for(int i=0;i<n;i++) {
    		if(graph[src][i]!=0 && !visit[i]) {
    			//���м�֦
    			if(graph[src][i]+cost<res) {
    				visit[i]=true;
    				dfs(i,dst,k-1,cost+graph[src][i]);
    				visit[i]=false;
    			}
    		}
    	}
    }
    
	
	/**
	 * �ⷨ�����������  �������ȶ���ʵ��
	 * ���ȶ����д�ŵĶ�����ת��С��K�ģ�ÿ�δ����ȶ�����ȡ�����ŵ������
	 * �洢��ʽ  {��ǰ����,����վ,·������תվ��Ŀ}
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
