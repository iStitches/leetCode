package Day4;

public class mian_01_07 {
	/**
	 * 自己的方案，开辟一个新数组找规律
	 * 时间复杂度=空间复杂度=O(N)
	 * @param matrix
	 */
//    public void rotate(int[][] matrix) {
//        int len=matrix.length;
//        int [][]temp=new int[len][len];
//
//        
//        //交换
//        for(int i=0;i<temp.length;i++) {
//       	 for(int j=0;j<len;j++) {
//       		 //位置(i,j) ---> 位置(j,倒数第i列)
//       		 temp[j][len-1-i]=matrix[i][j];
//       	 }
//        }
//        //复制
//        for(int i=0;i<temp.length;i++) {
//       	 for(int j=0;j<len;j++) {
//       		 matrix[i][j]=temp[i][j];
//       	 }
//        }
//   }
    
    /**
     * 大佬方法-----原地旋转(先上下对称交换，再对角线交换)
     */
    public void rotate(int[][] matrix) {
    	 int temp,i,j;
    	 int len=matrix.length;
    	 
    	 //上下对称交换
    	 for(i=0;i<len/2;i++) {
    		 for(j=0;j<len;j++) {
    			 temp=matrix[i][j];
    			 matrix[i][j]=matrix[len-1-i][j];
    			 matrix[len-1-i][j]=temp;
    		 }
    	 }
    	 
    	 //对角线交换
    	 for(i=0;i<len;i++) {
    		 for(j=i;j<len;j++) {
    			 temp=matrix[i][j];
    			 matrix[i][j]=matrix[j][i];
    			 matrix[j][i]=temp;
    		 }
    	 }
    }
}
