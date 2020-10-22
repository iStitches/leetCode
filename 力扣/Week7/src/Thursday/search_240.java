package Thursday;

public class search_240 {
    public boolean searchMatrix(int [][] matrix,int target) {
    	/**
    	 * 已知每行每列都是递增的，那么不妨  以行为递增标准，以列为递减标准。
    	 * 初始的位置从最后一行的第一个元素开始，这保证了比当前位置大的元素只能在该行右边。
    	 * 比当前位置小的元素一定在该行上边。
    	 * 那么可以形成一种方法，只要比当前位置小就往右移动增大，比当前位置大的就往上移动减小。
    	 */
    	if(matrix.length==0 || matrix[0].length==0)
    		return false;
    	int column=matrix.length,line=matrix[0].length;
    	int i=column-1,j=0;
    	while(0<=i && i<column && 0<=j && j<line) {
    		if(matrix[i][j]<target)
    			j++;
    		else if(matrix[i][j]>target)
    			i--;
    		else
    			return true;
    	}
    	return false;
    }
}
