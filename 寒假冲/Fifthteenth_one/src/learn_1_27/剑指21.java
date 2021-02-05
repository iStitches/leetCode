package learn_1_27;

/**
 * ��βָ�������ָ�������
 * @author dell
 *
 */
public class ��ָ21 {
	/**
	 * ��βָ�룬firstλ�ڿ�ͷ��lastλ�ڽ�β
	 * fisrtֱ������ż����ͣ�¡�lastֱ������������ͣ�£�Ȼ�󽻻�first��last
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
     * ����ָ�룬fastÿ�ζ���ǰ��һλ��
     * fast���������ͺ�low���н���Ȼ��fast��low����ǰ��һλ��
     * fast����ż���Ͷ�����ǰ��һλ��low����
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