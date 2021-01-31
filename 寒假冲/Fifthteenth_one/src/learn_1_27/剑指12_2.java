package learn_1_27;

public class ��ָ12_2 {
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
    	//��ǰ���Խ�硢��ǰ�ַ���word�ַ����и�λ�õ��ַ����� ʱ�˳�
    	if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(k))
    		return false;
    	//���������word�ַ������г��ȣ�ֱ���˳�
    	if(k == word.length()-1) return true;
    	
    	board[i][j] = '\0';
    	boolean flag = dfs(board,word,i-1,j,k+1) || dfs(board,word,i,j+1,k+1) || dfs(board,word,i+1,j,k+1) || dfs(board,word,i,j-1,k+1);
    	board[i][j] = word.charAt(k);
    	return flag;
    }
    
    public static void main(String[] args) {
    	char board[][]= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
	    String word = "ABCCED";
	    ��ָ12_2 t =new ��ָ12_2();
	    System.out.println(t.exist(board, word));
	}
}
