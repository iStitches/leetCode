package work;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class leetcode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists=new ArrayList();
        Deque<Integer> queue=new ArrayDeque();
        dfs(n,1,queue,k,lists);
        return lists;
   }
    
    /**
     * 通过深度遍历以及回溯法的应用
     */
    public void dfs(int n,int begin,Deque<Integer> queue,int k,List<List<Integer>> lists) {
    	if(queue.size()==k) {
    		List path=new ArrayList(queue);
    		lists.add(path);
    		return ;
    	}
    	
    	for(int i=begin;i<=n;i++) {
    		queue.addLast(i);
    		dfs(n,i+1,queue,k,lists);
    		queue.removeLast();
    	}
    }
}
