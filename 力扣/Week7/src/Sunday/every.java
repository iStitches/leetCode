package Sunday;

import java.util.Arrays;

/**
 *  ���� 845 �����е��ɽ��
 * @author dell
 *
 */
public class every {
	/**
	 * ���ǵ���Ҫ���ÿһ��λ��Ԫ�ص����ݼ����С��Ҳ�������У�ֻҪ��������к���ܹ���right[i]-left[i]+1���ó��õ���
	 * ɽ�����ȡ���left��right�Ĺ��̿������ö�̬�滮��⡣
	 * @param A
	 * @return
	 */
    public int longestMountain(int[] A) {
        int len=A.length;
        if(len<=2)
        	return 0; 
        int left[]=new int[len];
        int right[]=new int[len];
        
        //���left[]
        left[0]=0;
        for(int i=1;i<len;i++) {
        	left[i]=A[i]>A[i-1]?left[i-1]+1:0;
        }
        //���right[]
        right[len-1]=0;
        for(int i=len-2;i>0;i--) {
        	right[i]=A[i]>A[i+1]?right[i+1]+1:0;
        }
        
        //����ɽ������
        int ans=0;
        for(int i=1;i<len-1;i++) {
            if(left[i]>0 && right[i]>0 && right[i]+left[i]>=2) {
            	ans=Math.max(ans,right[i]+left[i]+1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
		every t=new every();
		int []A= {2,1,4,7,3,2,5};
		t.longestMountain(A);
	}
}

