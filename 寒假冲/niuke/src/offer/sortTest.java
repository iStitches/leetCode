package offer;

import java.util.Arrays;

public class sortTest {
	/**
	 * 直接插入排序
	 * @param arr
	 */
   public void directSort(int  []arr) {
	   int temp;
	   for(int i=1;i<arr.length;i++) {
		   if(arr[i]<arr[i-1]) {
			   temp = arr[i];
			   for(int j=i;j>=0;j--) {
				   if(j>0 && arr[j-1]>temp)
					   arr[j]=arr[j-1];
				   else {
					   arr[j]=temp;
					   break;
				   }
			   }
		   }
	   }
   }
   
   /**
    * 快速排序
    * @param args
    */
   
   public void quickSort(int arr[],int start,int end) {
	   if(start<end) {
		   int index = getIndex(arr,start,end);
		   quickSort(arr,start,index-1);
		   quickSort(arr,index+1,end);
	   }
   }
   public int getIndex(int arr[],int start,int end) {
	   int temp = arr[start];
	   while(start<end) {
		   while(start<end && arr[end]>=temp)
			   end--;
		   arr[start]=arr[end];
		   while(start<end && arr[start]<temp)
			   start++;
		   arr[end]=arr[start];
	   }
	   arr[start] = temp;
	   return start;
   }
   
   /**
    * 归并排序
    * @param args
    */
   public void merge(int arr[],int left,int mid,int right) {
	   int []temp = new int[arr.length];
	   int i=left,j=mid+1,k=left;
	   while(i<=mid && j<=right) {
		   if(arr[i]<=arr[j])
			   temp[k++]=arr[i++];
		   else
			   temp[k++]=arr[j++];
	   }
	   while(i<=mid) temp[k++]=arr[i++];
	   while(j<=right) temp[k++]=arr[j++];
	   
	   for(int l=left;l<=right;l++)
		   arr[l]=temp[l];
   }
   public void mergeSort(int []arr,int start,int end) {
	   if(start<end)
	   {
		   int mid = (start+end)/2;
		   mergeSort(arr,start,mid);
		   mergeSort(arr,mid+1,end);
		   merge(arr,start,mid,end);
	   }
   }
   
   
   public static void main(String[] args) {
	sortTest t = new sortTest();
	int []arr = {5,2,7,1,6,9,3};
//	t.directSort(arr);
//	t.quickSort(arr,0,arr.length-1);
	t.mergeSort(arr, 0, arr.length-1);
	System.out.println(Arrays.toString(arr));
	
}
}
