package sword_offer;

public class 剑指47 {
	//解法一：dfs(超时)
//    boolean[][] visited;
//    int maxValue = 0;
//
//    public int maxValue(int[][] grid) {
//        visited = new boolean[grid.length][grid[0].length];
//        dfs(grid,0,0,0);
//        return maxValue;
//    }
//
//    public void dfs(int[][] grid,int x,int y,int value){
//        if(x==grid.length-1 && y==grid[0].length-1){
//        	int tmp = value+grid[x][y];
//            maxValue = maxValue>tmp?maxValue:tmp;
//            return;
//        }
//        if(!visited[x][y]){
//            visited[x][y] = true;
//            value += grid[x][y];
//            if(x < grid.length-1)
//               dfs(grid,x+1,y,value);
//            if(y < grid[0].length-1)
//               dfs(grid,x,y+1,value);
//            value -= grid[x][y];
//            visited[x][y] = false;
//        }
//    }
	
	//解法二：dp
	public int maxValue(int[][] grid) {
		int lenx = grid.length;
		int leny = grid[0].length;
		int dp[][] = new int[lenx+1][leny+1];
	
		for(int i=1;i<=lenx;i++) {
			for(int j=1;j<=leny;j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])+grid[i-1][j-1];
			}
		}
		return dp[lenx][leny];
	}
    
    public static void main(String[] args) {
		剑指47 t = new 剑指47();
		int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(t.maxValue(arr));
	}
}
