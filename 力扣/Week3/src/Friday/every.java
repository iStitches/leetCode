package Friday;

/**
 *   ��̬�滮*day1
 * @author dell
 *
 */
public class every {
    public int minimumOperations(String leaves) {
    	int len=leaves.length();
    	//��ʼ��״̬�洢����
    	int [][]status=new int[3][len];
    	
    	/**
    	 * ÿһ������Ҷ�ӷ�Ϊ���������
    	 *  1.��ͷ��ǰһ��һֱ�Ǵ���-----��ôֻ��Ҫ+1(��ǰ�Ǻ�)
    	 *  2.��ͷ��ǰһ��Ϊ����/ǰһ���Ѿ�Ϊ��-----��ǰ��ɫ��Ϊ��ɫ(����+1)
    	 *  3.��ͷ��ǰһ�������˴Ӻ쵽��/��ͷ��ǰһ�������˴Ӻ쵽���ٵ���(ǰһ���Ѿ�Ϊ��ɫ)
    	 */ 
    	for(int i=0;i<len;i++) {
    		int cur=leaves.charAt(i)=='r'?0:1;
    		
    		//���1
    		if(i<1) {
    			status[0][i] = cur;
    		} 
    		else {
    			status[0][i] = status[0][i-1]+cur;
    		}
    		
    		//���2
    		if(i<1) {
    			status[1][i]=status[0][i];
    		}
    		else {
    			status[1][i]=Math.min(status[0][i-1], status[1][i-1])+(cur==0?1:0);
    		}
    		
    		//���3
    		if(i<2) {
    			status[2][i]=status[1][i];
    		}
    		else {
    			status[2][i]=Math.min(status[2][i-1],status[1][i-1])+cur;
    		}
    	}
    	return status[2][len-1];
    }
}
