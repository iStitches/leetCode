package Friday;

public class every {
	/**
	 * ����DFS������������ӷ��������
	 * @param grid
	 * @return
	 */
    public int islandPerimeter(int[][] grid) {
    	 int res=0;
         for(int i=0;i<grid.length;i++) {
        	 for(int j=0;j<grid[0].length;j++)
        		 //ע��ֻ�ܴӵ��졪��> ˮ·ʱ���ܼ������
        		 if(grid[i][j]==1)
        			 res+=dfs(grid,i,j);
         }
         return res;
    }
    
    /**
     * �ݹ����ֹ������     ��ʱΪˮ·����ʱ�����곬���˱߽�
     * �ݹ�ʱ�ܳ��ļ��㣺   �ɵ���->ˮ·  (�ܳ�+1)���ɵ���->�߽� (�ܳ�+1)
     * @param grid
     * @param x
     * @param y
     * @return
     */
    public int dfs(int[][] grid,int x,int y) {
    	//���졪��> �߽�
    	if(x<0 || x>=grid.length || y<0 || y>=grid[0].length)
    		return 1;
    	//���졪��> ˮ·
    	if(grid[x][y]==0)
    		return 1;
    	//��ǰ���챻������----ֵΪ2
    	if(grid[x][y]!=1)
    		return 0;
    	grid[x][y]=2;
    	
    	return dfs(grid,x-1,y)+dfs(grid,x+1,y)+dfs(grid,x,y-1)+dfs(grid,x,y+1);
    }
}
