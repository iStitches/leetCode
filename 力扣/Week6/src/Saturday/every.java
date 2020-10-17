package Saturday;

public class every {
    public int[] sortedSquares(int[] A) {
    	for(int i=0;i<A.length;i++) {
    		A[i]=(int)Math.pow(A[i], 2);
    	}
    	quickSort(A,0,A.length-1);
    	return A;
    }
    
    public void quickSort(int []arr,int start,int end) {
    	if(start<end) {
    		int index=getIndex(arr, start, end);
    		quickSort(arr,start,index-1);
    		quickSort(arr,index+1,end);
    	}
    }
    
    //快速排序查找指定元素的存放位置
    public int getIndex(int []arr,int start,int end) {
    	int tmp=arr[start];
    	while(start < end) {
    		while(start < end && arr[end]>=tmp) {
    			end--;
    		}
    		arr[start]=arr[end];
    		while(start < end && arr[start]<=tmp) {
    			start++;
    		}
    		arr[end]=arr[start];
    	}
    	arr[start]=tmp;
    	return start;
    }
    public static void main(String[] args) {
		int arr[]= {-4,-1,0,3,10};
		every t=new every();
		t.sortedSquares(arr);
	}
}
