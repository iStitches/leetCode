package work;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class leetcode216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList();
        Deque<Integer> queue=new ArrayDeque();
        if(n>9 && k==1) {
        	return res;
        }
        int arr[]= {1,2,3,4,5,6,7,8,9};
        dfs(arr,n,0,k,res,queue);
        return res;
   }
    
    public void dfs(int arr[],int target,int start,int k,List<List<Integer>> res,Deque<Integer> queue) {
    	if(target==0 && k==0) {
    		List list=new ArrayList(queue);
    		res.add(list);
    		return;
    	}
    	if(target-arr[start]<0 || k<0)
    		return;
    	for(int i=start;i<arr.length;i++) {
    		queue.addLast(arr[i]);
    		k--;
    		dfs(arr,target-arr[i],i+1,k,res,queue);
    		queue.removeLast();
    		k++;
    	}
    }
}
