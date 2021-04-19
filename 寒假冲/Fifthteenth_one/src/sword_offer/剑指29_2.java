package sword_offer;

import java.util.Arrays;

public class ��ָ29_2 {
	int [][] matrix;
	boolean [][] flag;  // ÿ��λ�õ�boolean ״̬��־����
	int [] res;
	int count;
	int op;   // op����ǰ�����ķ���  1 ��   -1 ��   2 ��  -2 ��
	/**
	 * �ݹ鷨��  ����ָ����˳��ȥ�������飬��������굱ǰ������ת����һ������
	 * @param matrix
	 * @return
	 */
    public int[] spiralOrder(int[][] matrix) {
         count=0;
         this.matrix=matrix;
         op=0;
         res=new int[(matrix.length)*(matrix[0].length)];
         flag=new boolean[matrix.length][matrix[0].length];
         dfs(matrix,matrix.length-1,matrix[0].length-1,res,0,0,0,1);
         return res;
    }
    
    public void dfs(int[][] matrix,int lenx,int leny,int[] res,int count,int x,int y,int op) {
    	if(count==(lenx)*(leny))
    		return;
    	if(x>=0 && x<=matrix[0].length-1 && y>=0 && y<=matrix.length-1 && !flag[x][y])
    	{
    	    flag[x][y]=true;
    	    res[count]=matrix[x][y];
    	    if(op == 1) {
    	    	dfs(matrix,lenx,leny,res,count+1,x,y+1,1);
    	    	dfs(matrix,lenx,leny,res,count+1,x+1,y,0);
    	    }
    	    if(op == -1) {
    	    	dfs(matrix,lenx,leny,res,count+1,x+1,y,-1);
    	    	dfs(matrix,lenx,leny,res,count+1,x,y-1,2);
    	    }
    	    if(op == 2) {
    	    	dfs(matrix,lenx,leny,res,count+1,x,y-1,2);
    	    	dfs(matrix,lenx,leny,res,count+1,x-1,y,-2);
    	    }
    	    if(op == -2) {
    	    	dfs(matrix,lenx,leny,res,count+1,x-1,y,-2);
    	    	dfs(matrix,lenx,leny,res,count+1,x,y+1,1);
    	    }
    	}
    }
    public static void main(String[] args) {
		��ָ29_2 t = new ��ָ29_2();
		int [][]matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int []res = t.spiralOrder(matrix);
		System.out.println(Arrays.toString(res));
	}
}
