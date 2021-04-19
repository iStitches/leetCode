package design;

import java.util.ArrayList;
import java.util.Arrays;

public class NC119 {
    int count = 0,k=0;
    ArrayList<Integer> res = new ArrayList<Integer>();
    
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        this.k = k;
        HeapSort(input,input.length);
        System.out.println(Arrays.toString(input));
        return res;
     }
    
    public void HeapAdjust(int[] arr,int start,int end){
        int tmp = arr[start];
        int i = 2*start+1;
        while(i<=end){
            if(i+1<=end && arr[i]>arr[i+1])
                i++;
            if(arr[i]>=tmp)
                break;
            arr[start] = arr[i];
            start = i;
            i = 2*i+1;
        }
        arr[start] = tmp;
    }
    
    public void HeapSort(int[] arr,int len){
        for(int i=len/2-1;i>=0;i--)
            HeapAdjust(arr,i,len-1);
        
        for(int i=len-1;i>=0;i--){
//            if(count>=k)
//                break;
//            res.add(arr[0]);
            int tmp = arr[0];
            arr[0] = arr[i];
            count++;
            arr[i] = tmp;
            HeapAdjust(arr,0,i-1);
        }
    }
    
    public static void main(String[] args) {
		NC119 t = new NC119();
		t.GetLeastNumbers_Solution(new int[] {4,5,1,6,2,7,3,8}, 4);
	}
}
