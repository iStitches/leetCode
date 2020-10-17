package Saturday;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_51 {
	
	//ͳ��n��n���з���n���ʺ�ķ��ò���
    public List<List<String>> solveNQueens(int n) {
        char chess[][]=new char[n][n];   //n��n�е����̳�ʼ��Ϊ .
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
     * ���û��ݷ����б�����ȡ���õķ���
     * @param list   �洢���շ����ļ���
     * @param res    �洢��ǰ·�ߵļ���
     * @param row    ��ǰ�����˵ڼ���----�������n��ʱ�Ϳ��Խ�����
     */
    public void getPlace(char[][] chess,List<List<String>> list,int row,int n) {
    	if(row == n) {
    		list.add(getLineString(chess));//ע������ʵ���ϻ���ÿ�ζ�new��һ��List����,��ΪҪ���л��ݵ���ȫ��ֻ��һ��List����
    		return;
    	}
    	
    	for(int col=0;col<n;col++) {
    		if(judgeValid(chess,row,col)) { //�����row�� i�п��Է�����ô��¼��ͽ��е�row+1 �еı���
    			chess[row][col]='Q';
    			getPlace(chess,list,row+1,n); //ע������ʹ��row+1����ݹ������
    			//ȡ����һ�εĲ���
    			chess[row][col]='.';
    		}
    	}
    }
    
    //��¼��ǰ���̵�λ�����������һ���ַ�������
    public List<String> getLineString(char chess[][]) {
    	List<String> list=new ArrayList();
    	for(int i=0;i<chess.length;i++) {
    		list.add(new String(chess[i]));
    	}
    	return list;
    }
    
    //�ж�x,y���ܹ�����һ���ʺ�
    public boolean judgeValid(char chess[][],int x,int y) {
    	for(int i=0;i<chess.length;i++) {
    		for(int j=0;j<chess[0].length;j++) {
    			/**
    			 * ���������  1.�������ʺ���ͬһ��/��
    			 *        2.�������ʺ���45����� 135��Խ�����
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
