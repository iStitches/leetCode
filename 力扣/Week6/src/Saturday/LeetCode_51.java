package Saturday;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_51 {
	
	//统计n行n列中放置n个皇后的放置策略
    public List<List<String>> solveNQueens(int n) {
        char chess[][]=new char[n][n];   //n行n列的棋盘初始化为 .
        List<List<String>> list=new ArrayList();
        for(int i=0;i<chess.length;i++) {
        	for(int j=0;j<chess[0].length;j++) {
        		chess[i][j]='.';
        	}
        }
        getPlace(chess,list,0,n);
        return list;
    }
    
    /**
     * 采用回溯法进行遍历获取放置的方案
     * @param list   存储最终方案的集合
     * @param res    存储当前路线的集合
     * @param row    当前到达了第几行----当到达第n行时就可以结束了
     */
    public void getPlace(char[][] chess,List<List<String>> list,int row,int n) {
    	if(row == n) {
    		list.add(getLineString(chess));//注意这里实质上还是每次都new了一个List集合,因为要进行回溯但是全局只有一个List集合
    		return;
    	}
    	
    	for(int col=0;col<n;col++) {
    		if(judgeValid(chess,row,col)) { //如果第row行 i列可以放置那么记录后就进行第row+1 行的遍历
    			chess[row][col]='Q';
    			getPlace(chess,list,row+1,n); //注意这里使用row+1参与递归的巧妙
    			//取消上一次的操作
    			chess[row][col]='.';
    		}
    	}
    }
    
    //记录当前棋盘的位置情况，返回一个字符串集合
    public List<String> getLineString(char chess[][]) {
    	List<String> list=new ArrayList();
    	for(int i=0;i<chess.length;i++) {
    		list.add(new String(chess[i]));
    	}
    	return list;
    }
    
    //判断x,y处能够放置一个皇后
    public boolean judgeValid(char chess[][],int x,int y) {
    	for(int i=0;i<chess.length;i++) {
    		for(int j=0;j<chess[0].length;j++) {
    			/**
    			 * 两种情况：  1.与其它皇后在同一行/列
    			 *        2.与其它皇后在45°或者 135°对角线上
    			 */
    			if(chess[i][j]=='Q' && (j==y||Math.abs(i-x)==Math.abs(j-y)))
    				return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) {
		LeetCode_51 t=new LeetCode_51();
		t.solveNQueens(4);
	}
}
