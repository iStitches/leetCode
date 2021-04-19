package offer;

import java.util.ArrayList;
import java.util.Arrays;

public class offer29 {
    ArrayList<Integer> res = new ArrayList<Integer>();
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k > input.length)
             return res;
        HeapSort(input,k);
        System.out.println(Arrays.toString(input));
        return res;
    }
    
    public void HeapAdjust(int[] arr,int start,int end){
        int tmp = arr[start];
        int i = start*2+1;
        while(i <= end){
            if(i+1<=end && arr[i+1]<arr[i])
                i++;
            if(arr[i]>=tmp)
                break;
            arr[start] = arr[i];
            start = i;
            i = i*2+1;
        }
        arr[start] = tmp;
    }
    
    public void HeapSort(int[] arr,int k){
        int len = arr.length;
        for(int i=len/2-1;i>=0;i--)
            HeapAdjust(arr,i,len-1);
        
        for(int i=len-1;i>=0 && k>0;i--){
            res.add(arr[0]);
            k--;
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            HeapAdjust(arr,0,i-1);
        }
    }
    
    public static void main(String[] args) {
		offer29 t = new offer29();
		ArrayList<Integer> res = t.GetLeastNumbers_Solution(new int[] {4,5,1,6,2,7,3,8}, 4);
		System.out.println(res);
	}
}
