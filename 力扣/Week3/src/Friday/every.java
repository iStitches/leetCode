package Friday;

/**
 *   动态规划*day1
 * @author dell
 *
 */
public class every {
    public int minimumOperations(String leaves) {
    	int len=leaves.length();
    	//初始化状态存储数组
    	int [][]status=new int[3][len];
    	
    	/**
    	 * 每一个结点的叶子分为三种情况：
    	 *  1.从头到前一个一直是纯红-----那么只需要+1(当前非红)
    	 *  2.从头到前一个为纯红/前一个已经为黄-----当前红色变为黄色(次数+1)
    	 *  3.从头到前一个经历了从红到黄/从头到前一个经历了从红到黄再到红(前一个已经为红色)
    	 */ 
    	for(int i=0;i<len;i++) {
    		int cur=leaves.charAt(i)=='r'?0:1;
    		
    		//情况1
    		if(i<1) {
    			status[0][i] = cur;
    		} 
    		else {
    			status[0][i] = status[0][i-1]+cur;
    		}
    		
    		//情况2
    		if(i<1) {
    			status[1][i]=status[0][i];
    		}
    		else {
    			status[1][i]=Math.min(status[0][i-1], status[1][i-1])+(cur==0?1:0);
    		}
    		
    		//情况3
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
