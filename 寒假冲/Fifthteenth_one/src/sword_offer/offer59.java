package sword_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class offer59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(!queue.isEmpty() && queue.getFirst()==i-k)
               queue.removeFirst();
            while(!queue.isEmpty() && nums[i]>nums[queue.getLast()]){
                queue.removeLast();
            }
            queue.offer(i);
            if(i>=k-1)
               res.add(nums[queue.getFirst()]);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    public static void main(String[] args) {
		offer59 t = new offer59();
		int[] res = t.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
		System.out.println(Arrays.toString(res));
	}
}
