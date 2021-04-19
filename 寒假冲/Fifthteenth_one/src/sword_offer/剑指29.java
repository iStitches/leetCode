package sword_offer;

import java.util.Arrays;

public class ��ָ29 {
	/**
	 * ѭ����ӡ������˳ʱ�뷽�򣬴�ӡ���Է�Ϊ�����ظ��ļ������������ҡ��������¡��������󡢴�������
	 * ÿ����������ִ�ӡ��Ϻ�ͽ���ǰλ�õı߽����̣�����߽粻����Ҫ��(�±߽�>�ϱ߽�    ��߽�<�ұ߽�)��˵��������ϡ�
	 * @param matrix
	 * @return
	 */
	
    public int[] spiralOrder(int[][] matrix) {
         if(matrix.length==0) return new int[0];
         int l,r,t,b,count;  //���������ĸ��߽�
         l=0;
         count=0;
         b=matrix.length-1;
         t=0;
         r=matrix[0].length-1;
         int []res = new int[(r+1)*(b+1)];
         while(true) {
        	 // ��������,��ǰ���������ϱ߽������ƶ�һ����λ
        	 for(int i=l;i<=r;i++)
        		 res[count++]=matrix[t][i];
        	 if(++t>b) break;
        	 
        	 //��������,��������ұ߽������ƶ�һ����λ
        	 for(int i=t;i<=b;i++)
        		 res[count++]=matrix[i][r];
        	 if(--r<l) break;
        	 
        	 //��������,��������±߽������ƶ�һ����λ
        	 for(int i=r;i>=l;i--)
        		 res[count++]=matrix[b][i];
        	 if(--b<t) break;
        	 
        	 //��������,���������߽������ƶ�һ����λ
        	 for(int i=b;i>=t;i--)
        		 res[count++]=matrix[i][l];
        	 if(++l>r) break;
         }
         return res;
    }
    
    public static void main(String[] args) {
		��ָ29 t = new ��ָ29();
		int [][]matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int []res = t.spiralOrder(matrix);
		System.out.println(Arrays.toString(res));
	}
}
