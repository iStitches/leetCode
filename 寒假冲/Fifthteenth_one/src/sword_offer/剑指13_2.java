package sword_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs解法
 * @author dell
 *
 */
public class 剑指13_2 {
    public int movingCount(int m, int n, int k) {
    	 int res = 0;
    	 boolean flag[][] = new boolean[m][n];
         Queue<int[]> queueList = new LinkedList();
         queueList.add(new int[]{0,0});
         while(!queueList.isEmpty()) {
        	 int[] arr = queueList.poll();
        	 int i = arr[0];
        	 int j = arr[1];
        	 if(i<0 || i>=m || j<0 || j>=n || flag[i][j] || calculate(i)+calculate(j)>k) continue;
        	 res++;
        	 flag[i][j] = true;
        	 queueList.add(new int[] {i-1,j});
        	 queueList.add(new int[] {i,j+1});
        	 queueList.add(new int[] {i+1,j});
        	 queueList.add(new int[] {i,j-1});
         }
         return res;
    }
    
    public int calculate(int num) {
    	int res = 0;
    	while(num!=0) {
    		res += num%10;
    		num = num/10;
    	}
    	return res;
    }
    public static void main(String[] args) {
    	剑指13_2 t = new 剑指13_2();
    	System.out.println(t.movingCount(2, 3, 1));
	}
}
