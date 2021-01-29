package Friday;

public class LeetCode_941 {
	//双指针头尾查找然后比较最终位置
	 public boolean validMountainArray(int[] A) {
	        int len=A.length;
	        if(len<3)
	          return false;
	        int start=0,end=len-1;
	        //双指针注意left对多只能到倒数第二个位置
	        while(start<len-2 && A[start]<A[start+1])
	          start++;
	        //注意right最多只能到开头第2个位置
	        while(end>1 && A[end]<A[end-1])
	          end--;
	        return start==end?true:false;
	     }
	 
	 public static void main(String[] args) {
		LeetCode_941 t=new LeetCode_941();
		int A[]= {0,1,2,3,4,5,6,7,8,9};
		t.validMountainArray(A);
		int b=0;
	}
}
