package learn_1_27;

import java.util.Arrays;

public class 剑指29 {
    int []res= null;
    int [][] matrix=null;
    boolean [][]flag = null;
    int count = 0,lenx,leny,tag=1;
    public int[] spiralOrder(int[][] matrix) {
        lenx = matrix.length;
        if(lenx==0)
           return new int[0];
        leny = matrix[0].length;
        res = new int[lenx*leny];
        flag = new boolean[lenx][leny];
        this.matrix=matrix;
        reset(0,0);
        return res;
    }

    /**
     * 递归遍历二维数组
     * @param x  数组横
     * @param y  数组纵
     * @param tag 该往哪个方向移动  1:右边  -1:左边   2:下边  -2:上边
     */
    public void reset(int x,int y){
        if(x>=lenx || x<0 || y<0 || y>=leny || flag[x][y]) {
        	if(tag == 1)
        		tag = 2;
        	else if(tag == 2)
        		tag = -1;
        	else if(tag == -1)
        		tag = -2;
        	else
        		tag = 1;
            return;	
        }
        res[count++]=matrix[x][y];
        flag[x][y]=true;
        if(tag == 1)
          reset(x,y+1);
        if(tag == 2)
          reset(x+1,y);
        if(tag == -1)
          reset(x,y-1);
        if(tag == -2)
          reset(x-1,y);
    }
    
    public static void main(String[] args) {
		剑指29 t = new 剑指29();
		int [][]matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int []res = t.spiralOrder(matrix);
		System.out.println(Arrays.toString(res));
	}
}
