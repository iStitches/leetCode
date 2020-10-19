package Monday;

public class mian_10_03 {
    public int search(int[] arr, int target) {
          int left=0,right=arr.length-1,mid=0;
          while(left<right) {
        	  mid=(left+right)/2;
        	  
        	 //���1����ി����
        	  if(arr[left] < arr[mid]) {
        		  if(arr[left]<=target && target<=arr[mid]) {
        			  right=mid;
        		  }
        		  else {
        			  left=mid+1;
        		  }
        	  }
        	  
        	  //���2�����Ǵ�����
        	  else if(arr[left] > arr[mid]) {
        		  if(arr[left]<=target || target<=arr[mid]) {
        			  right=mid;
        		  }
        		  else {
        			  left=mid+1;
        		  }
        	  }
        	  
        	  //���3���ҵ������ظ�
        	  else {
        		  if(arr[left] == target)   //�ҵ�����˳�ѭ��
        			 right=left;        
        		  else
        			  left++;  //�ҵ��ظ��˵ģ���ȥ�ظ���������
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
