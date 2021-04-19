package sword_offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 剑指45 {
    public String minNumber(int[] nums) {
        quickSort(nums,0,nums.length-1);
        StringBuilder builder = new StringBuilder();
        for(int a:nums){
            builder.append(a);
        }
        return builder.toString();
    }

    //解法一：快排
    public int getIndex(int[] arr,int start,int end){
        int temp = arr[start];
        while(start<end){
            while(start<end && (arr[end]+""+temp).compareTo(temp+""+arr[end])>=0)
                 end--;
            arr[start] = arr[end];
            while(start<end && (temp+""+arr[start]).compareTo(arr[start]+""+temp)>=0)
                 start++;
            arr[end] = arr[start];
        }
        arr[start] = temp;
        return start;
    }

    public void quickSort(int[] arr,int start,int end){
        if(start<end){
            int index = getIndex(arr,start,end);
            quickSort(arr,start,index-1);
            quickSort(arr,index+1,end);
        }
    }
    
    //解法二：归并
    public void merge(int[] arr,int start,int mid,int end) {
    	int[] temp = new int[end-start+1];
    	int i=start,j=mid+1,k=0;
    	while(i<=mid && j<=end) {
    		if((arr[i]+""+arr[j]).compareTo(arr[j]+""+arr[i])>0)
    			temp[k++] = arr[j++];
    		else
    			temp[k++] = arr[i++];
    	}
        if(i<=mid) temp[k++] = arr[i++];
        if(j<=end) temp[k++] = arr[j++];
    	for(i=0;i<temp.length;i++)
    		arr[i+start] = temp[i];
    }
    
    public void mergeSort(int[] arr,int start,int end) {
    	if(start < end) {
    		int mid = (start+end)/2;
    		mergeSort(arr,start,mid-1);
    		mergeSort(arr,mid+1,end);
    		merge(arr,start,mid,end);
    	}
    }
    
    //解法三：小根堆
    PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return (o1+o2).compareTo(o2+o1);
		}
    });
    
    public String heapSort(int[] nums) {
    	for(int num:nums)
    		queue.offer(""+num);
    	StringBuilder res = new StringBuilder();
    	while(!queue.isEmpty())
    		res.append(queue.poll());
    	return res.toString();
    }
}
