package others;

import java.util.Arrays;

public class test1 {
    long count = 0;
//    boolean[] visited;
    
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
//        visited = new boolean[nums.length];
        dfs(nums,target,0,0);
        return (int) count;
    }
    
    public void dfs(int[]nums,int target,int depth,int index){
        if(depth == 2){
            count++;
            return;
        }
        
        for(int i=index;i<nums.length;i++){
//            if(i>0 && nums[i]==nums[i-1] && !visited[i-1])
//                continue;
            if(target-nums[i]<0)
                break;
//            visited[i]=true;
            dfs(nums,target-nums[i],depth+1,i+1);
//            visited[i]=false;
        }
    }
    
    public static void main(String[] args) {
		test1 t = new test1();
		int[] nums= {2,2,1,9};
		int res =t.purchasePlans(nums, 10);
		System.out.println(res);
	}
}
