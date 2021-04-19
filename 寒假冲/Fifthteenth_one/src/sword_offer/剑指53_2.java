package sword_offer;

/**
 * 排序数组的搜索问题，首先想到的是二分法
 * @author dell
 * 解法：如果当前元素 nums[i] != i，那么说明找到了结果；
 *      否则采用二分法快速前进
 *
 */
public class 剑指53_2 {
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
    	剑指53_2 t = new 剑指53_2();
    	int res = t.missingNumber(new int[] {0,1,2,3,4,5,6,7,9});
    	System.out.println(res);
	}
}
