package Monday;

public class mian_10_03 {
    public int search(int[] arr, int target) {
          int left=0,right=arr.length-1,mid=0;
          while(left<right) {
        	  mid=(left+right)/2;
        	  
        	 //情况1：左侧纯递增
        	  if(arr[left] < arr[mid]) {
        		  if(arr[left]<=target && target<=arr[mid]) {
        			  right=mid;
        		  }
        		  else {
        			  left=mid+1;
        		  }
        	  }
        	  
        	  //情况2：左侧非纯递增
        	  else if(arr[left] > arr[mid]) {
        		  if(arr[left]<=target || target<=arr[mid]) {
        			  right=mid;
        		  }
        		  else {
        			  left=mid+1;
        		  }
        	  }
        	  
        	  //情况3：找到或者重复
        	  else {
        		  if(arr[left] == target)   //找到后就退出循环
        			 right=left;        
        		  else
        			  left++;  //找到重复了的，就去重复继续查找
        	  }
          }
          return arr[left]==target?left:-1;
    }
    public static void main(String[] args) {
		int arr[]= {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		mian_10_03 t=new mian_10_03();
		t.search(arr, 5);
	}
}
