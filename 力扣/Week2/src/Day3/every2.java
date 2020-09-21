package Day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class every2 {
	List<int []>list=new ArrayList();   //������Ŀհ׸�
	boolean [][]rows=new boolean[9][9];       //ÿһ����
	boolean [][]columns=new boolean[9][9];    //ÿһ����
	boolean [][][]blocks=new boolean[3][3][9];     //ÿ�������η���----��Ԫ����
	boolean flag=false;
	
	
    public void solveSudoku(char[][] board) {
          //1.����ȫ��������ÿ��ÿ��ÿ�����������ֵĳ������
          for(int i=0;i<board.length;i++) {
        	  for(int j=0;j<board[0].length;j++) {
        		  if(board[i][j]!='.') {
        			  //ע�����鳤��Ϊ9����9������Ϊ���ֲ���
        			  int temp=board[i][j]-'0'-1;
        			  rows[i][temp]=true;
        			  columns[temp][j]=true;
        			  blocks[i/3][j/3][temp]=true;
        		  }
        		  //2.�ѷ����ֵķ��뵽map������
        		  list.add(new int[] {i,j});
        	  }
          }
          fillBoard(board,0);          
          
    }
    
    public void fillBoard(char [][]board,int depth) {
    	if(depth == list.size()) {
    		flag=true;
    		return;
    	}
    	
    		int[] arr=list.get(depth);
    		int x=arr[0],y=arr[1];
    		
            for(int i=0;i<9 && !flag;i++) {
            	//���Է�������
            	if(!rows[x][i] && !columns[i][y] && !blocks[x][y][i]) {
            		board[x][y]=(char) (i-'0'+1);
            		rows[x][i]=columns[i][y]=blocks[x][y][i]=true;
            		//������һ��
            		fillBoard(board, depth+1);
            		//����
            		rows[x][i]=columns[i][y]=blocks[x][y][i]=false;
            	}
            }
    }

}
