package others;

import java.util.LinkedList;
import java.util.Queue;

public class test3 {
    public int magicTower(int[] nums) {
            Queue<Integer> queue = new LinkedList();
            int len = nums.length;
            
            for(int num:nums)
                queue.offer(num);
            int cur=0,sum=0,count=0,index=0,firstIndex=0;
            boolean flag = false;
            
            while(!queue.isEmpty()){
                if(firstIndex>0)
                    firstIndex--;
                
                if(flag && firstIndex == 0){
                	while(!queue.isEmpty()) {
                        sum+=queue.poll();
                        if(sum<0)
                            return -1;
                	}
                }
                cur = queue.poll();
                if(cur+sum < 0)
                {
                    if(firstIndex==0) {
                    	firstIndex=len-index;
                    	flag = true;
                    }
                        
                    queue.offer(cur);
                    count++;
                }
                else
                	sum+=cur;
                index++;
            }
            return count;
        }
    public static void main(String[] args) {
		test3 t= new test3();
		int res = t.magicTower(new int[] {100,100,100,-250,-60,-140,-50,-50,100,150});
		System.out.println(res);
	}

}
