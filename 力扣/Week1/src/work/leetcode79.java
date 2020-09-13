package work;

import org.junit.Test;

public class leetcode79 {
	//����
	String word;
	//��������
	char[][] board;
	//����״̬
	boolean[][] status;
	//λ�õ�������
	int location[][]= {{-1,0},{0,1},{1,0},{0,-1}};
	
	//�жϵ����Ƿ����
    public boolean exist(char[][] board, String word) {
    	//��ʼ��ȫ�ֱ���
        this.board=board;
        this.word=word;
        this.status=new boolean[board.length][board[0].length];
        //�Դ�ÿһ��λ�ÿ�ʼ�ĵ��ʶ������жϲ���
        for(int i=0;i<board.length;i++) {
        	for(int j=0;j<board[0].length;j++) {
        		if(verify(i, j, 0))
        		  return true;
        	}
        }
        return false;
    }
    
    //��֦
    public boolean inArea(int x,int y) {
    	if(x>=0 && x<board.length && y>=0 && y<board[0].length) {
    		return true;
    	}
    	return false;
    }

    //�жϴ�(i,j)���������ܷ񹹳ɵ���
    public boolean verify(int i,int j,int start) {
    	//1.�ݹ�ĳ�������----(�жϵ����ʵ����һ�����ﲢ�Ҹô����ܹ�ƥ����)
    	if(start==word.length()-1 && word.charAt(start)==board[i][j]) {
    		return true;
    	}
    	//2.ÿ������һ���µĵ������ж��ܷ�ƥ���ϣ��ܵû��ݹ�����жϣ����ܾͻ���
    	if(word.charAt(start)==board[i][j]) {
    		//���ֵݹ��в����ٴη���
    		status[i][j]=true;
    		//�ݹ���һ��----����˳���Ϊ �ϡ��ҡ��¡���
    		for(int k=0;k<4;k++) {
    			int newX=i+location[k][0];
    			int newY=j+location[k][1];
    			//��֦----�������귶Χ��
                if(inArea(newX,newY) && !status[newX][newY]) {
                	if(verify(newX,newY,start+1)) {
                		return true;
                	}
                }
    		}
    		//����
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
