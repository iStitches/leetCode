package learn_1_27;

/**
 * 首尾指针与快慢指针的运用
 * @author dell
 *
 */
public class 剑指21 {
	/**
	 * 首尾指针，first位于开头、last位于结尾
	 * fisrt直到遇到偶数才停下、last直到遇到奇数才停下；然后交换first和last
	 * @param nums
	 * @return
	 */
    public int[] exchange(int[] nums) {
         int first=0,last=nums.length-1;
         while(first<last) {
        	if((first&1)!=0) {
        		first++;
        		continue;
        	}
        	if((last&1)==0) {
        		last--;
        		continue;
        	}
        	int temp = nums[first];
        	nums[first] = nums[last];
        	nums[last] = temp;
         }
         return nums;
   }
    
    /**
     * 快慢指针，fast每次都往前进一位；
     * fast遇到奇数就和low进行交换然后fast和low都往前进一位；
     * fast遇到偶数就独自往前进一位，low不变
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
    	int fast=0,low=0;
    	while(fast<nums.length) {
    		if((nums[fast]&1)!=0) {
    			int temp = nums[fast];
    			nums[fast] = nums[low];
    			nums[low] = temp;
    			low++;
    		}
    		fast++;
    	}
    	return nums;
    }
}