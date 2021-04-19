package sword_offer;

/**
 * ����������������⣬�����뵽���Ƕ��ַ�
 * @author dell
 * �ⷨ�������ǰԪ�� nums[i] != i����ô˵���ҵ��˽����
 *      ������ö��ַ�����ǰ��
 *
 */
public class ��ָ53_2 {
    public int missingNumber(int[] nums) {
         int i=0,j=nums.length-1;
         while(i <= j) {
        	 int mid = (i+j)/2;
        	 if(nums[mid] == mid)
        		 i = mid+1;
        	 else
        		 return mid;
         }
         return i;
    }
    
    public static void main(String[] args) {
    	��ָ53_2 t = new ��ָ53_2();
    	int res = t.missingNumber(new int[] {0,1,2,3,4,5,6,7,9});
    	System.out.println(res);
	}
}
