package sword_offer;

/**
 * @author dell
 *
 */
public class 剑指56_2 {
    public int singleNumber(int[] nums) {
         //1. 统计 nums[i] 的数字的二进制位各位的出现次数
    	int[] arr= new int[32];
    	for(int i=0;i<nums.length;i++) {
    		for(int j=0;j<32;j++)
    			arr[j] += (nums[i]>>j & 1)==1?1:0;
    	}
    	
    	int res = 0;
    	 //2. 某位如果%3==0，则说明只出现一次的数字的该位为0；反之为1
    	for(int i=31;i>=0;i--) {
    		res = res>>1;
    		res = (res|1);
    	}
    	return res;
    }
}
