
public class test1 {
    public int minOperations(int[] nums) {
        if(nums.length ==1)
             return 0;
        int i=1,res=0;
        while(i<nums.length && nums[i]>nums[i-1]){
            i++;
        }
        for(;i<nums.length;i++){
        	if(nums[i] <= nums[i-1]) {
                res += nums[i-1]+1-nums[i];
                nums[i] = nums[i-1]+1;
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
		test1 t = new test1();
		System.out.println(t.minOperations(new int[] {1,1,1}));
	}
}
