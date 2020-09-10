package work;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import org.junit.Test;

public class leetcode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> res=new ArrayList();
         Deque<Integer> queue=new ArrayDeque();
         if(candidates.length==0)
        	 return res;
         //排序保证相同的元素处在一起
         Arrays.sort(candidates);
         dfs(candidates,target,0,queue,res);
         return res;
    }
    
    public void dfs(int []candidates,int target,int start,Deque<Integer> queue,List<List<Integer>> res) {
    	if(target==0) {
    		List list=new ArrayList(queue);
    		res.add(list);
    		return ;
    	}
    	else if(target<0) {
    		return ;
    	}
    	for(int i=start;i<candidates.length;i++) {
    		if(i>start) {
    			if(candidates[i]==candidates[i-1])
    				continue;
    		}
        		queue.addLast(candidates[i]);
        		dfs(candidates,target-candidates[i],i+1,queue,res);
        		queue.removeLast();
    	}
    }

    @Test
    public void test() {
    	int candidates[]= {2,5,2,1,2};
    	List<List<Integer>> list=combinationSum2(candidates, 5);
    	list.forEach(x->{
            System.out.println(x);
    	});
    }
}
