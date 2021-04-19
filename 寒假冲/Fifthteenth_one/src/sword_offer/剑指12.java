package sword_offer;

import java.util.List;
/**
 * 动态规划解法
 * @author dell
 *
 */

public class 剑指12 {
    boolean flag[][];
    
    public boolean exist(char [][]board,String word) {
    	flag = new boolean[board.length][board[0].length];
    	boolean ans = false;
    	for(int i=0;i<board.length;i++) {
    		for(int j=0;j<board[0].length;j++) {
    			if(board[i][j] == word.charAt(0))
    				ans = deepSearch(board, i, j, word, 0);
    			    if(ans == true) 
    			      return true;
    		}
    	}
    	return false;
    }
    
    public boolean deepSearch(char [][]board,int x,int y,String word,int len) {
        // 访问该位置并且设置为已经被访问
    	flag[x][y] = true;
    	boolean tempFlag = false;   //标志位
    	
    	//退出条件---能够匹配到字符串的最后一位为止
    	if(word.length()-1<=len)
    		return true;
    	
    	if(x>0 && !flag[x-1][y] && board[x-1][y]==word.charAt(len+1))
    		tempFlag = deepSearch(board,x-1,y,word,len+1);
    	if(!tempFlag && y<board[0].length-1 && !flag[x][y+1] && board[x][y+1]==word.charAt(len+1))
    		tempFlag = deepSearch(board,x,y+1,word,len+1);
    	if(!tempFlag && x<board.length-1 && !flag[x+1][y] && board[x+1][y]==word.charAt(len+1))
    		tempFlag = deepSearch(board,x+1,y,word,len+1);
    	if(!tempFlag && y>0 && !flag[x][y-1] && board[x][y-1]==word.charAt(len+1))
    		tempFlag = deepSearch(board, x, y-1, word, len+1);
    	if(tempFlag == false)
    		flag[x][y] = false;
    	return tempFlag;
    }
    public static void main(String[] args) {
	    char board[][]= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
	    String word = "ABCCED";
	    剑指12 t =new 剑指12();
	    t.exist(board, word);
	}
}
