import java.util.Arrays;

public class test3 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
    	int len = nums.length;
        int[] res = new int[len];
        int sum = 0;
        int[] km = new int[maximumBit];
        
        for(int i=0;i<len;i++) {
        	sum = sum^nums[i];
        	int cur = sum;
        	for(int j=0;j<maximumBit;j++) {
        		if(cur != 0) {
        			int ni = cur&1;
        			km[j] = ni==0?1:0;
        			cur >>= 1;
        		}
        		else
        			km[j] = 1;
        }
            int ret = 0;
            for(int m=km.length-1;m>=0;m--) {
            	ret += km[m];
            	if(m != 0)
            		ret <<= 1;
            }
            res[len-i-1] = ret; 
        }
        return res;
    }
    
    public static void main(String[] args) {
		test3 t = new test3();
		int[] res = t.getMaximumXor(new int[] {0,1,2,2,5,7}, 3);
		System.out.println(Arrays.toString(res));
	}
}
