package Day2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class every1 {
    public List<List<Integer>> subsets(int[] nums) {
          List<List<Integer>>  result=new ArrayList<List<Integer>>();
          Deque<Integer> queue=new ArrayDeque();
          dfs(nums,result,queue,0);
          return result;
    } 
    
    public void dfs(int nums[],List<List<Integer>> result,Deque<Integer> queue,int start) {
    	 result.add(new ArrayList(queue)); 
    	 
    	 for(int i=start;i<nums.length;i++) {
    		 queue.add(nums[i]);
    		 dfs(nums,result,queue,i+1);
    		 queue.removeLast();
    	 }
    }
}
