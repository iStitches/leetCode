package Wednesday;

public class mian_10_09 {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int leny=matrix.length;     //行数
    	int lenx=matrix[0].length;  //列数
    	boolean flag=false;
        
    	for(int i=0;i<leny;i++) {
    		if(matrix[i][0]>target || matrix[i][lenx-1]<target)
    			continue;
    		if(binarySearch(matrix, 0, lenx-1, target, i))
    			return true;
    	}
    	return false;
    }
    
    public boolean binarySearch(int[][] matrix,int start,int end,int target,int row) {
    	while(start<end) {
    		int mid=(start+end)/2;
    		if(matrix[row][mid]<target)
    			start=mid+1;
    		else if(matrix[row][mid]>target)
    			end=mid-1;
    		else
    			start=end=mid;
    	}
    	return matrix[row][start]==target;
    }
    
    public static void main(String[] args) {
		mian_10_09 t=new mian_10_09();
		int[][] matrix= {
				{1,   4,  7, 11, 15},
				{2,   5,  8, 12, 19},
				{3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
		};
		t.searchMatrix(matrix, 5);
	}
}
