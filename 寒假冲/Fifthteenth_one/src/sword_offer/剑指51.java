package sword_offer;

import java.util.Arrays;

public class ½£Ö¸51 {
    int count = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return count;
    }

    public void mergeSort(int[] arr,int start,int end){
        if(start<end){
            int mid = start+((end-start)>>1);
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }

    public void merge(int[] arr,int start,int mid,int end){
        int[] tmp = new int[end-start+1];
        int i=start,j=mid+1,k=0;
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j])
                tmp[k++] = arr[i++];
            else{
                count += (mid-i+1);
                tmp[k++] = arr[j++];
            }
        }
        while(i<=mid) tmp[k++]=arr[i++];
        while(j<=end) tmp[k++]=arr[j++];
        for(i=0;i<tmp.length;i++)
            arr[i+start] = tmp[i];
    }

    public static void main(String[] args) {
		½£Ö¸51 t = new ½£Ö¸51();
		int[] arr = {1,3,2,3,1};
		int res = t.reversePairs(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(res);
	}
}
