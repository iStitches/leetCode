package Day4;

public class mian_01_07 {
	/**
	 * �Լ��ķ���������һ���������ҹ���
	 * ʱ�临�Ӷ�=�ռ临�Ӷ�=O(N)
	 * @param matrix
	 */
//    public void rotate(int[][] matrix) {
//        int len=matrix.length;
//        int [][]temp=new int[len][len];
//
//        
//        //����
//        for(int i=0;i<temp.length;i++) {
//       	 for(int j=0;j<len;j++) {
//       		 //λ��(i,j) ---> λ��(j,������i��)
//       		 temp[j][len-1-i]=matrix[i][j];
//       	 }
//        }
//        //����
//        for(int i=0;i<temp.length;i++) {
//       	 for(int j=0;j<len;j++) {
//       		 matrix[i][j]=temp[i][j];
//       	 }
//        }
//   }
    
    /**
     * ���з���-----ԭ����ת(�����¶Գƽ������ٶԽ��߽���)
     */
    public void rotate(int[][] matrix) {
    	 int temp,i,j;
    	 int len=matrix.length;
    	 
    	 //���¶Գƽ���
    	 for(i=0;i<len/2;i++) {
    		 for(j=0;j<len;j++) {
    			 temp=matrix[i][j];
    			 matrix[i][j]=matrix[len-1-i][j];
    			 matrix[len-1-i][j]=temp;
    		 }
    	 }
    	 
    	 //�Խ��߽���
    	 for(i=0;i<len;i++) {
    		 for(j=i;j<len;j++) {
    			 temp=matrix[i][j];
    			 matrix[i][j]=matrix[j][i];
    			 matrix[j][i]=temp;
    		 }
    	 }
    }
}
