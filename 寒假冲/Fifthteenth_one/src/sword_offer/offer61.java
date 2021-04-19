package sword_offer;

import java.util.HashSet;

public class offer61 {
    public boolean isStraight(int[] nums) {
        quickSort(nums,0,4);
        int start = 0;
        while(start<=4 && nums[start]==0)
            start++;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=start;i<5;i++){
            if(!set.add(nums[i]))
               return false;
        }
        if(nums[4]-nums[start]>4)
            return false;
        return true;
    }

    public int getIndex(int[] nums,int start,int end){
        int temp = nums[start];
        while(start<end){
            while(start<end && nums[end]>=temp)
                 end--;
            nums[start] = nums[end];
            while(start<end && nums[start]<temp)
                 start++;
            nums[end] = nums[start];
        }
        nums[start] = temp;
        return start;
    }

    public void quickSort(int[] nums,int start,int end){
        if(start<end){
            int index = getIndex(nums,start,end);
            quickSort(nums,start,index-1);
            quickSort(nums,index+1,end);
        }
    }
    
    public static void main(String[] args) {
		offer61 t = new offer61();
		System.out.println(t.isStraight(new int[] {0,0,2,2,5}));
	}
}
