package sword_offer;

public class ½£Ö¸42 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE,sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum<0)
               sum=0;
            sum+=nums[i];
            res = res>sum?res:sum;
        }
        return sum;
  }
    public static void main(String[] args) {
		½£Ö¸42 t = new ½£Ö¸42();
		int res = t.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
		System.out.println(res);
	}
}
