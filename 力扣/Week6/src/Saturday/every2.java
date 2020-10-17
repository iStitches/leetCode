package Saturday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class every2 {
	int count=0;
	
	//计算总的方法数
    public int totalNQueens(int n) {
        char[][] chess=new char[n][n];
        for(int i=0;i<chess.length;i++) {
           Arrays.fill(chess[i],'.');
        }
        dfs(0,chess,n);
        return count;
    }
    
    //dfs深度遍历
    public void dfs(int row,char[][] chess,int n) {
    	if(row==n) {
    		count++;
    	}
    	
    	for(int i=0;i<chess.length;i++) {
    		if(isValid(chess, row, i)) {
    			chess[row][i]='Q';
    			dfs(row+1,chess,n);
    			chess[row][i]='.';
    		}
    	}
    }
    
    //检查当前是否可以放置
    public boolean isValid(char[][] chess,int x,int y) {
    	for(int i=0;i<chess.length;i++) {
    		for(int j=0;j<chess[0].length;j++) {
    			if(chess[i][j]=='Q' && (j==y||Math.abs(j-y)==Math.abs(i-x))) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) {
	    every2 t=new every2();
	    t.totalNQueens(4);
	}
}
