package Day1;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode  47、全排列(回溯+剪枝)
 * @author dell
 *
 */
public class everyDay2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
          Arrays.sort(nums);
          
          List<List<Integer>> result=new ArrayList<List<Integer>>();
          Deque<Integer> queue=new ArrayDeque();
          boolean used[]=new boolean[nums.length]; 
          dfs(nums,0,result,queue,used);
          return result;
    }
    
    /**
     * @param nums     总数组
     * @param depth    当前队列中的元素个数
     * @param result   结果值
     * @param queue    临时队列
     * @param used     记录每一层的循环----通过记录是否被使用过来执行
     * @return
     */
    public void dfs(int []nums,int depth,List<List<Integer>> result,Deque<Integer> queue,boolean []used){
        //如果遍历到了全部则停止
    	if(depth == nums.length) {
    		result.add(new ArrayList(queue));
    	}
    
    	//否则循环当前层
    	for(int i=0;i<nums.length;i++) {
    		if(used[i])
    			continue;
    		
    		//剪枝----前后相等，前一个未被使用过
    		if(i>0 && nums[i] == nums[i-1] && !used[i-1]) {
    			continue;
    		}
    		
    		//否则深度遍历
    		queue.add(nums[i]);
    		used[i]=true;
    		dfs(nums,depth+1,result,queue,used);
    		
    		//回溯修改状态
    		queue.removeLast();
    		used[i]=false;
    	}
    }
}
