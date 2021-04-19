package sword_offer;

public class Test127_1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lenx = matrix.length;
        int leny = matrix[0].length;
        int x=lenx-1,y=0;
        while(x>=0 && y>=0 && y<leny){
            if(matrix[x][y] == target)
                return true;
            else if(matrix[x][y] < target)
            	y++;
            else if(matrix[x][y] > target)
            	x--;
        }
        return false;
    }
    public static void main(String[] args) {
		Test127_1 t = new Test127_1();
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		System.out.println(t.searchMatrix(matrix, 12));
	}
}
