package Wednesday;

import java.util.Arrays;

public class mian_10_11 {
          /**
           * 对于一个有序的数组而言，如果将所有的数字按照 谷-峰-谷 来排列，每次遍历到当前位置，即使需要进行交换也只会使得
           * 其左边的值越来越小/越来越大，这正好保证了整体的峰谷排列
           */
		    public void wiggleSort(int[] nums) {
		      Arrays.sort(nums);
		      for(int i=1;i<nums.length;i++)
		      {
		    	  //规定奇数位置为峰、偶数位置为谷
		    	  if(nums[i]<nums[i-1] && i%2!=0)
		    	  {
		    		  int temp=nums[i];
		    		  nums[i]=nums[i-1];
		    		  nums[i-1]=temp;
		    	  }
		    	  else if(nums[i]>nums[i-1] && i%2==0)
		    	  {
		    		  int temp=nums[i];
		    		  nums[i]=nums[i-1];
		    		  nums[i-1]=temp;
		    	  }
		      }
		}
}
