package Day4;

import java.util.ArrayList;
import java.util.List;

/**
 * ����01.08 �����
 * @author dell
 *
 */
public class mian_01_08 {
    List<int []> list=new ArrayList();  //���0
	
    public void setZeroes(int[][] matrix) {
          for(int i=0;i<matrix.length;i++) {
        	  for(int j=0;j<matrix[0].length;j++) {
        		  if(matrix[i][j] == 0) {
        			  list.add(new int[] {i,j});
        		  }
        	  }
          }
          
          for(int k=0;k<list.size();k++) {
        	  change(matrix,list.get(k)[0],list.get(k)[1]);
          }
    }
    
    //�ı�����
    public void change(int[][] array,int i,int j) {
    	int m;
    	//�ı���
    	for(m=0;m<array[0].length;m++) {
    		array[i][m]=0;
    	}
    	//�ı���
    	for(m=0;m<array.length;m++) {
    		array[m][j]=0;
    	}
    }
    
    public static void main(String[] args) {
		int [][]arr= {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        mian_01_08 t=new mian_01_08();
        t.setZeroes(arr);
	}
}
