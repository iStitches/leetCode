package sword_offer;

public class ��ָ53 {
    public int search(int[] nums, int target) {
        int start = getIndex(nums,0,nums.length-1,target-0.5);
        int end = getIndex(nums,0,nums.length-1,target+0.5);
        return end-start;
    }

    /**
     *  ����ҵ��˶�Ӧ��num���򷵻أ�
     *  ����Ҳ�����Ӧ��num���򷵻ر�num�Դ��ֵ��λ��
     * @param nums
     * @param start
     * @param end
     * @param num
     * @return
     */
    public int getIndex(int[] nums,int start,int end,double num){
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid] > num)
                end = mid-1;
            else if(nums[mid] < num)
                start = mid+1;
            else
                return mid;
            }
        return start;
    }
    
//	public int search(int[] nums,int target) {
//		return helper(nums,target)-helper(nums,target-1);
//	}
//	
//	//���� tar���ұ߽�
//	public int helper(int[] nums,int tar) {
//		int i=0,j=nums.length-1;
//		while(i <= j) {
//			int m = (i+j)/2;
//			if(nums[m] <= tar)
//				i=m+1;
//			else
//				j=m-1;
//		}
//		return i;
//	}
	
    public static void main(String[] args) {
		��ָ53 t = new ��ָ53();
		t.search(new int[] {5,6,7,7,8,8,10}, 7);
	}
}
