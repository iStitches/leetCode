package sword_offer;

import java.util.Arrays;

public class 剑指29 {
	/**
	 * 循环打印，按照顺时针方向，打印可以分为以下重复的几步：从左往右、从上往下、从右往左、从下往上
	 * 每个方向的数字打印完毕后就将当前位置的边界缩短，如果边界不满足要求(下边界>上边界    左边界<右边界)则说明处理完毕。
	 * @param matrix
	 * @return
	 */
	
    public int[] spiralOrder(int[][] matrix) {
         if(matrix.length==0) return new int[0];
         int l,r,t,b,count;  //左右上下四个边界
         l=0;
         count=0;
         b=matrix.length-1;
         t=0;
         r=matrix[0].length-1;
         int []res = new int[(r+1)*(b+1)];
         while(true) {
        	 // 从左往右,当前层遍历完后上边界往下移动一个单位
        	 for(int i=l;i<=r;i++)
        		 res[count++]=matrix[t][i];
        	 if(++t>b) break;
        	 
        	 //从上往下,处理完后右边界往左移动一个单位
        	 for(int i=t;i<=b;i++)
        		 res[count++]=matrix[i][r];
        	 if(--r<l) break;
        	 
        	 //从右往左,处理完后下边界往上移动一个单位
        	 for(int i=r;i>=l;i--)
        		 res[count++]=matrix[b][i];
        	 if(--b<t) break;
        	 
        	 //从下往上,处理完后左边界往右移动一个单位
        	 for(int i=b;i>=t;i--)
        		 res[count++]=matrix[i][l];
        	 if(++l>r) break;
         }
         return res;
    }
    
    public static void main(String[] args) {
		剑指29 t = new 剑指29();
		int [][]matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int []res = t.spiralOrder(matrix);
		System.out.println(Arrays.toString(res));
	}
}
