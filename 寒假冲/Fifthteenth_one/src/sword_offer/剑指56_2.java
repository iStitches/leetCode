package sword_offer;

/**
 * @author dell
 *
 */
public class ��ָ56_2 {
    public int singleNumber(int[] nums) {
         //1. ͳ�� nums[i] �����ֵĶ�����λ��λ�ĳ��ִ���
    	int[] arr= new int[32];
    	for(int i=0;i<nums.length;i++) {
    		for(int j=0;j<32;j++)
    			arr[j] += (nums[i]>>j & 1)==1?1:0;
    	}
    	
    	int res = 0;
    	 //2. ĳλ���%3==0����˵��ֻ����һ�ε����ֵĸ�λΪ0����֮Ϊ1
    	for(int i=31;i>=0;i--) {
    		res = res>>1;
    		res = (res|1);
    	}
    	return res;
    }
}
