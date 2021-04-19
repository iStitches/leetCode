package others;

public class t_529 {
	char[][] board;
	int[] click;
	boolean[][] flag;
	int[][] nums;
	
    public char[][] updateBoard(char[][] board, int[] click) {
         this.board=board;
         this.flag=new boolean[board.length][board[0].length];
         this.click=click;
         this.nums=new int[board.length][board[0].length];
         calculate();
         if(board[click[0]][click[1]] == 'M')
        	 board[click[0]][click[1]] = 'X';
         else
        	 dfs(click[0],click[1]);
         return board;
    }
    
    public void dfs(int i, int j) {
    	if(i<0 || i>=board.length || j<0 || j>=board[0].length || flag[i][j])
    		return;
    	flag[i][j] = true;
    	if(board[i][j] == 'E') {
    		if(nums[i][j] == 0) {
   			    board[i][j] = 'B';
    	    	dfs(i-1,j);
    	    	dfs(i+1,j);
    	    	dfs(i,j-1);
    	    	dfs(i,j+1);
    	    	dfs(i-1,j+1);
    	    	dfs(i+1,j+1);
    	    	dfs(i+1,j-1);
    	    	dfs(i-1,j-1);
    		}
    		else {
    			board[i][j] = (char)(nums[i][j]+'0');
    		}

    	}

    }
    
    public void calculate() {
        for(int i=0;i<board.length;i++) {
        	for(int j=0;j<board[0].length;j++) {
        		if(board[i][j] == 'M') {
        			if(i-1>=0) {
        				nums[i-1][j]++;
        				if(j-1>=0)
        					nums[i-1][j-1]++;
        				if(j+1<board[0].length)
        					nums[i-1][j+1]++;
        			}
        			if(j-1>=0)
        				nums[i][j-1]++;
        			if(j+1<board[0].length)
        				nums[i][j+1]++;
        			if(i+1<board.length) {
        				nums[i+1][j]++;
        				if(j-1>=0)
        					nums[i+1][j-1]++;
        				if(j+1<board[0].length)
        					nums[i+1][j+1]++;
        			}
        		}
        	}
        }
    }
    
    public static void main(String[] args) {
		char[][] array={
				{'M','M','M','M','M','M'},
				{'M','M','M','E','M','M'},
				{'M','M','M','M','M','M'}};
		int[] click={1,3};
		t_529 t = new t_529();
		char[][] res=t.updateBoard(array, click);
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res.length;j++)
				System.out.println(res[i][j]);
		}
	}
}
