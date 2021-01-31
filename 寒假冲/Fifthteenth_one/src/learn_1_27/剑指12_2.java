package learn_1_27;

public class 剑指12_2 {
    public boolean exist(char[][] board, String word) {
    	boolean res = false;
        for(int i=0;i<board.length;i++) {
        	for(int j=0;j<board[0].length;j++) {
        		if(board[i][j] == word.charAt(0))
        			res = dfs(board,word,i,j,0);
        		    if(res) return true;
        	}
        }
        return false;
    }
    
    boolean dfs(char[][] board,String word,int i,int j,int k) {
    	//当前如果越界、当前字符与word字符串中该位置的字符不等 时退出
    	if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(k))
    		return false;
    	//如果遍历完word字符的所有长度，直接退出
    	if(k == word.length()-1) return true;
    	
    	board[i][j] = '\0';
    	boolean flag = dfs(board,word,i-1,j,k+1) || dfs(board,word,i,j+1,k+1) || dfs(board,word,i+1,j,k+1) || dfs(board,word,i,j-1,k+1);
    	board[i][j] = word.charAt(k);
    	return flag;
    }
    
    public static void main(String[] args) {
    	char board[][]= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
	    String word = "ABCCED";
	    剑指12_2 t =new 剑指12_2();
	    System.out.println(t.exist(board, word));
	}
}
