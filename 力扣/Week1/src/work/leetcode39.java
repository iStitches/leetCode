package work;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class leetcode39 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res=new ArrayList();
		if(candidates.length==0) {
			return res;
		}
		Deque<Integer> queue=new ArrayDeque<Integer>();
        dfs(candidates,target,0,res,queue);
        return res;
    }
	
	public void dfs(int []candidates,int target,int start,List<List<Integer>> res,Deque<Integer> queue) {
		//如果最后的差值为0就退出
		if(target<0) {
			return;
		}
		else if(target==0) {
			List list=new ArrayList(queue);
			res.add(list);
			return;
		}
		
		//反之每次减去未出现的重复字样
		for(int i=start;i<candidates.length;i++) {
			queue.addLast(candidates[i]);
			dfs(candidates,target-candidates[i],i,res,queue);
			//回溯
			queue.removeLast();
		}
	}
}
