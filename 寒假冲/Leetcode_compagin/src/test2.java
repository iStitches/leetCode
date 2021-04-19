import java.util.Arrays;

public class test2 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        int i = 0;
        
        for(int[] arr:queries) {
        	for(int[] point:points) {
        		int tmp = (int) (Math.pow(point[0]-arr[0],2) + Math.pow(point[1]-arr[1], 2));
        	    int r = (int)Math.pow(arr[2], 2);
        	    res[i] += tmp<=r?1:0;
        	}
        	i++;
        }
        return res;
    }
    
    public static void main(String[] args) {
		test2  t = new test2();
		int[][] points = {{1,3},{3,3},{5,3},{2,2}};
		int[][] queries = {{2,3,1},{4,3,1},{1,1,2}};
		int[] res = t.countPoints(points, queries);
		System.out.println(Arrays.toString(res));
	}
}
