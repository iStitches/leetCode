package Monday;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class every {
	 public int[] smallerNumbersThanCurrent(int[] nums) {
	        ArrayList list=new ArrayList<Integer>();
	        int[] res=new int[nums.length];
	        for(int i=0;i<nums.length;i++)
	           list.add(nums[i]);
	        list.sort(new Comparator<Integer>() {
	        	@Override
	        	public int compare(Integer o1, Integer o2) {
	        		// TODO Auto-generated method stub
	        		return o1-o2;
	        	}
			});
	        for(int i=0;i<res.length;i++){
	            res[i]=list.indexOf(nums[i]);
	        }
	        return res;
	    }
}
