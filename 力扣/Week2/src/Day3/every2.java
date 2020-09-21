package Day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class every2 {
	List<int []>list=new ArrayList();   //待解决的空白格
	boolean [][]rows=new boolean[9][9];       //每一横行
	boolean [][]columns=new boolean[9][9];    //每一纵行
	boolean [][][]blocks=new boolean[3][3][9];     //每个正方形方格----三元数组
	boolean flag=false;
	
	
    public void solveSudoku(char[][] board) {
          //1.遍历全部数组标记每行每列每个方格中数字的出现情况
          for(int i=0;i<board.length;i++) {
        	  for(int j=0;j<board[0].length;j++) {
        		  if(board[i][j]!='.') {
        			  //注意数组长度为9但是9可以作为数字插入
        			  int temp=board[i][j]-'0'-1;
        			  rows[i][temp]=true;
        			  columns[temp][j]=true;
        			  blocks[i/3][j/3][temp]=true;
        		  }
        		  //2.把非数字的放入到map集合中
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
            	//可以放置数字
            	if(!rows[x][i] && !columns[i][y] && !blocks[x][y][i]) {
            		board[x][y]=(char) (i-'0'+1);
            		rows[x][i]=columns[i][y]=blocks[x][y][i]=true;
            		//继续下一个
            		fillBoard(board, depth+1);
            		//回溯
            		rows[x][i]=columns[i][y]=blocks[x][y][i]=false;
            	}
            }
    }

}
