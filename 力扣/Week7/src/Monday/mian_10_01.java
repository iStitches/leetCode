package Monday;

public class mian_10_01 {
	/**
	 * ��ͷ��ʼ����
	 * @param A
	 * @param m
	 * @param B
	 * @param n
	 */
//    public void merge(int[] A, int m, int[] B, int n) {
//        int len=A.length,i=0,j=0,idx=0;
//        while(j<n && i<m){
//            if(A[idx]>B[j]){
//                for(int k=len-1;k>idx;k--)
//                    A[k]=A[k-1];
//                A[idx]=B[j];
//                idx++;
//                j++;
//            }
//            else{
//                i++;
//                idx++;
//            }
//        }
//        if(j<n) {
//        	for(int k=j;k<n;k++) {
//        		A[idx]=B[k];
//        		idx++;
//        	}
//        }
//    }
    /**
     * ������
     * @param args
     */
    public void merge(int[] A,int m,int []B,int n) {
    	//ѡ��ֵ�ϴ�Ĳ����������β
    	while(m>0 && n>0) {
    		A[m+n-1]=A[m-1]>B[n-1]?A[--m]:B[--n];
    	}
    	
    	//����δ�����ʣ������
    	if(n>0) {
            while(n>0) {
            	A[n-1]=B[n-1];
            	n--;
            }
    	}
    }
    
    public static void main(String[] args) {
		int []A= {1,2,3,0,0,0};
		int []B= {2,5,6};
		mian_10_01 t=new mian_10_01();
		t.merge(A, 3, B, 3);
	}
}
