package offer;

import java.util.ArrayList;

public class offer13 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList();
        int left=0,right=matrix[0].length-1,up=0,down=matrix.length-1,i;
        while(true){
            i=left;
            while(i<=right) {
            	res.add(matrix[up][i]);
            	i++;
            }
            up++;
            if(up>down) break;
            i=up;
            while(i<=down) {
            	res.add(matrix[i][right]);
            	i++;
            } 
            right--;
            if(right<left) break;
            i=right;
            while(i>=left) {
            	res.add(matrix[down][i]);
            	i--;
            }
            down--;
            if(down<up) break;
            i=down;
            while(i>=up) {
            	res.add(matrix[i][left]);
            	i--;
            }
            left++;
            if(left>right) break;
        }
        return res;
    }
    
    public static void main(String[] args) {
		offer13 t = new offer13();
		int [][]matrix = new int[][] {{1},{2},{3},{4},{5}};
		ArrayList<Integer> res =t.printMatrix(matrix);
		System.out.println(res.toString());
	}
}
