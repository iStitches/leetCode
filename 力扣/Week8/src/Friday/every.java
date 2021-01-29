package Friday;

public class every {
	/**
	 * 采用DFS方法来解决连接方格的问题
	 * @param grid
	 * @return
	 */
    public int islandPerimeter(int[][] grid) {
    	 int res=0;
         for(int i=0;i<grid.length;i++) {
        	 for(int j=0;j<grid[0].length;j++)
        		 //注意只能从岛屿——> 水路时才能计算相加
        		 if(grid[i][j]==1)
        			 res+=dfs(grid,i,j);
         }
         return res;
    }
    
    /**
     * 递归的终止条件：     此时为水路、此时的坐标超出了边界
     * 递归时周长的计算：   由岛屿->水路  (周长+1)、由岛屿->边界 (周长+1)
     * @param grid
     * @param x
     * @param y
     * @return
     */
    public int dfs(int[][] grid,int x,int y) {
    	//岛屿——> 边界
    	if(x<0 || x>=grid.length || y<0 || y>=grid[0].length)
    		return 1;
    	//岛屿——> 水路
    	if(grid[x][y]==0)
    		return 1;
    	//当前岛屿被遍历过----值为2
    	if(grid[x][y]!=1)
    		return 0;
    	grid[x][y]=2;
    	
    	return dfs(grid,x-1,y)+dfs(grid,x+1,y)+dfs(grid,x,y-1)+dfs(grid,x,y+1);
    }
}
