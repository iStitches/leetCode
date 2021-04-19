package others;

public class t_1588 {
	/**
	 * 解法一：前缀和解法
	 * @param arr
	 * @return
	 */
    public int sumOddLengthSubarrays(int[] arr) {
        int []sum = new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            sum[i+1]=sum[i]+arr[i];
        }

        int res = 0;
        for(int i=1;i<=arr.length;i=i+2){
            for(int j=0;j<=arr.length-i;j++){
            	System.out.println(sum[j+i]-sum[j]);
                res+=sum[j+i]-sum[j];
            }
        }
        return res;
    }
    
    /**
     * 解法二：计算每个数字可能出现在多少个数组中
     * 比如对于数组 arr[5]={1,2,3,4,5} 
     *    对于i=3处的4,可以在它的前面再选择0,1,2,3个数字，总共有4种选择 left=i+1;
     *    在它后面可以有n-i个选择 right=n-i;
     * 
     * 如果要组成个数为奇数的数组,那么如果前面选择偶数个,后面也必须选择偶数个,只有这样加上自身总数才为奇数个；
     * 如果前面选择奇数个,后面也必须选择奇数个,只有这样加上自身总数才为奇数个；
     * 
     * 因此如果数字前面总共 left个选择，其中偶数个数字的选择方案有 left_even=(left+1)/2；奇数个数字的选择方案有
     * left_odd=left/2;
     * 同理对于数字后面的选择方式。
     * 
     * 那么对于arr[i] ，它可以位于 left_even*right_even + left_odd*right_odd 个数组中。
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays1(int[] arr) {
    	int res=0;
    	for(int i=0;i<arr.length;i++) {
    	     int left=i+1,right=arr.length-i;
    	     int left_even=(left+1)/2,left_odd=left/2;
    	     int right_even=(right+1)/2,right_odd=right/2;
    	     res+=left_even*right_even+left_odd*right_odd*arr[i];
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		t_1588 t = new t_1588();
		int []arr = {1,4,2,5,3};
		t.sumOddLengthSubarrays(arr);
	}
}
