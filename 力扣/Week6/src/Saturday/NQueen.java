package Saturday;

import java.util.ArrayList;
import java.util.List;

/**
 * N�ʺ�������⣺
 * @author dell
 *
 */
public class NQueen {
	 public List<List<String>> solveNQueens(int n) {
	        char[][] chs=new char[n][n];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<n;j++){
	                chs[i][j]='.';
	            }
	        }
	        List<List<String>> res=new ArrayList<>();
	        backTracing(chs,0,n,res);
	        return res;
	    }
	 
	    public void backTracing(char[][] chs,int row,int n,List<List<String>> res){
	    	//ÿ�ж������ʺ�ʱ���������һ�ֽⷨ
	        if(row==n){
	            res.add(chsToList(chs));
	            return;
	        }
	        //һ��һ�еذڷţ���ȷ��һ���е��Ǹ��ʺ�Ӧ�ð�����һ��ʱ����Ҫ��ǰ���Ƿ�Ϸ���
	        //����Ϸ����򽫻ʺ�����ڵ�ǰλ�ã������еݹ飬���ݡ�
	        for(int col=0;col<chs[0].length;col++){
	            if(isValid(chs,row,col)){
	                chs[row][col]='Q';
	                //�ݹ�
	                backTracing(chs,row+1,n,res);
	                //����
	                chs[row][col]='.';
	            }
	        }
	    }
	    
	    public List<String> chsToList(char[][] chs){
	        List<String> list=new ArrayList<>();
	        for(int i=0;i<chs.length;i++){
	            list.add(new String(chs[i]));
	        }
	        return list;
	    }
	    
	    //�жϺϷ�����ǰ��Ҫ�ڷ�'Q'��λ�ú������Ѱڷš�Q����λ�ò�����ͬһ�У��Ҳ�����ͬһ��45��б�߻�135��б���ϡ�
	    //�����ж��Ƿ���ͬһ��б���Ͽ�ͨ����ǰ��Ҫ�ڷ�'Q'��λ�ú������Ѱڷš�Q����λ�ú�����֮���������֮��ľ���ֵ�Ƿ�������жϡ�
	    public boolean isValid(char[][] chs,int x,int y){
	        for(int i=0;i<=x;i++){
	            for(int j=0;j<chs[0].length;j++){
	                if(chs[i][j]=='Q'&&(j==y||Math.abs(x-i)==Math.abs(y-j))){
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
}
