package sword_offer;

import java.util.Arrays;

public class 剑指29_2 {
	int [][] matrix;
	boolean [][] flag;  // 每个位置的boolean 状态标志数组
	int [] res;
	int count;
	int op;   // op代表当前遍历的方向：  1 右   -1 下   2 左  -2 上
	/**
	 * 递归法：  按照指定的顺序去遍历数组，如果遍历完当前方向则转到下一个方向
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
		剑指29_2 t = new 剑指29_2();
		int [][]matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int []res = t.spiralOrder(matrix);
		System.out.println(Arrays.toString(res));
	}
}
