package Sunday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game2 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
    	 List<Boolean> list=new ArrayList();
         for(int i=0;i<l.length;i++) {
        	 list.add(isSubArray(nums, l[i], r[i]));
         }
         return list;
    }
    
    
    
    public Boolean isSubArray(int []nums,int start,int end) {
    	if(end-start>=2) {
        	int []temp=Arrays.copyOfRange(nums, start, end+1);
        	Arrays.sort(temp);
        	int c=temp[1]-temp[0];
        	for(int i=2;i<temp.length;i++) {
        		if(temp[i]-temp[i-1]!=c)
        			return false;
        	}
    	}
    	return true;
    }
    public static void main(String[] args) {
		int array[]= {4,6,5,9,3,7};
		int l[]= {0,0,2};
		int r[]= {2,3,5};
		Game2 t=new Game2();
		t.checkArithmeticSubarrays(array, l, r);
	}
}
