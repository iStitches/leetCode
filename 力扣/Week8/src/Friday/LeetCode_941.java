package Friday;

public class LeetCode_941 {
	//˫ָ��ͷβ����Ȼ��Ƚ�����λ��
	 public boolean validMountainArray(int[] A) {
	        int len=A.length;
	        if(len<3)
	          return false;
	        int start=0,end=len-1;
	        //˫ָ��ע��left�Զ�ֻ�ܵ������ڶ���λ��
	        while(start<len-2 && A[start]<A[start+1])
	          start++;
	        //ע��right���ֻ�ܵ���ͷ��2��λ��
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
