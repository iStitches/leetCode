package Saturday;

import java.util.Arrays;
import java.util.Comparator;

public class mian_08_13 {
	/**
	 * �����Ž⣬���ҷ�Ϊ�ಽ����ô���Կ��ǲ���dp
	 * ������һ��dp[i] ��ʾ�Ե�i������Ϊ��ʱ�����߶ȣ��ݹ鷽�� dp[i]=max{dp[k]+hi,dp[i]}  k<=i 
	 * �൱�ڼ����ܹ����õ�i�����ӵ����߶�
	 * @param box
	 * @return
	 */
    public int pileBox(int[][] box) {
    	//���ڱ���������������������Ȱ�����������ѭ������
    	for(int i=0;i<box.length;i++) {
    		Arrays.sort(box,new Comparator<int[]>() {   //��ÿһ����ά���鰴�տ����������
    		   @Override
    		    public int compare(int[] o1,int[] o2) {
    			   return o1[0]-o2[0];
    		   }
			});
    	}
    	
    	int max_height=0;
        int dp[]=new int[box.length];
        
        
        for(int i=0;i<box.length;i++) {
        	dp[i]=box[i][2];   //��i������Ϊ�������߶�����Ϊ box[i][2]
        	for(int j=0;j<i;j++) { //�ܷ��ڵ�j�������ϵ�����ֵ�����ֵ
        		if(box[i][0]>box[j][0] && box[i][1]>box[j][1] && box[i][2]>box[j][2]) {
        			dp[i]=Math.max(dp[i],dp[j]+box[i][2]);
        		}
        	}
        	max_height=max_height>dp[i]?max_height:dp[i];
        }
        return max_height;
    }
}
