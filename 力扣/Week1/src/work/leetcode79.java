package work;

import org.junit.Test;

public class leetcode79 {
	//单词
	String word;
	//词语网格
	char[][] board;
	//网格状态
	boolean[][] status;
	//位置调整数组
	int location[][]= {{-1,0},{0,1},{1,0},{0,-1}};
	
	//判断单词是否存在
    public boolean exist(char[][] board, String word) {
    	//初始化全局变量
        this.board=board;
        this.word=word;
        this.status=new boolean[board.length][board[0].length];
        //对从每一个位置开始的单词都进行判断操作
        for(int i=0;i<board.length;i++) {
        	for(int j=0;j<board[0].length;j++) {
        		if(verify(i, j, 0))
        		  return true;
        	}
        }
        return false;
    }
    
    //剪枝
    public boolean inArea(int x,int y) {
    	if(x>=0 && x<board.length && y>=0 && y<board[0].length) {
    		return true;
    	}
    	return false;
    }

    //判断从(i,j)这个点出发能否构成单词
    public boolean verify(int i,int j,int start) {
    	//1.递归的出口条件----(判断到单词的最后一个词语并且该词语能够匹配上)
    	if(start==word.length()-1 && word.charAt(start)==board[i][j]) {
    		return true;
    	}
    	//2.每次遇到一个新的单词先判断能否匹配上，能得话递归继续判断，不能就回溯
    	if(word.charAt(start)==board[i][j]) {
    		//这轮递归中不能再次访问
    		status[i][j]=true;
    		//递归下一次----遍历顺序分为 上、右、下、左
    		for(int k=0;k<4;k++) {
    			int newX=i+location[k][0];
    			int newY=j+location[k][1];
    			//剪枝----超出坐标范围的
                if(inArea(newX,newY) && !status[newX][newY]) {
                	if(verify(newX,newY,start+1)) {
                		return true;
                	}
                }
    		}
    		//回溯
    		status[i][j]=false;
    	}
    	return false;
    }
    public static void main(String[] args) {
    	leetcode79 l=new leetcode79(); 
    	char[][] board =
            {
                    {'A', 'B', 'C', 'E'},
                    {'S', 'F', 'C', 'S'},
                    {'A', 'D', 'E', 'E'}
            };
  	    String word="ABCB";
  	    System.out.println(l.exist(board, word));	
	}
}
