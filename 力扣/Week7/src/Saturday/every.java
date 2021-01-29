package Saturday;

import java.util.Arrays;
import java.util.Comparator;

public class every {
	/**
	 * ���� 1024��  ��Ƶƴ��
	 * �ⷨһ��  ���ö�̬�滮�㷨
	 *   ����dp[i]Ϊʱ��i֮ǰ�ܹ������ɹ��������С��Ƭ��������ô����ÿһ�����䣬������״̬ת�Ʒ��̣�
	 *   dp[i]=min{dp[clip[0]]+1,dp[i]}  clip[0]<i<=clip[1]
	 *   ֻҪʱ��i���� clip[0]��clip[1]֮�䣬˵����ǰ���ܹ�ͨ��clip[0]֮ǰ�ķ���+1 ��ƴ��
	 *   
	 * �ⷨ����̰�ķ�
	 *   ̰�ľ���ÿ�λ��ֵ�����ĳ�����󼴿ɣ�ѡ��ʼʱ��Ϊ0��ÿ���ҵ�����ʱ��������䣬����¼����ʱ��t��
	 *   ��һ�����ҿ�ʼʱ�䲻����t���ǽ���ʱ��������䲢����tΪ��ʱ�Ľ���ʱ�䡣ѭ��ֱ��t>�涨��ʱ��
	 * @param clips
	 * @param T
	 * @return
	 */
	public int videoStitching(int[][] clips, int T) {
//         int dp[]=new int[T+1];
//         Arrays.fill(dp,Integer.MAX_VALUE-1);    //ע������Ҫ��ֹ��������������ͳɸ�����
//         dp[0]=0;
//         dps(clips,dp);
//         return dp[T]==Integer.MAX_VALUE-1?-1:dp[T];
		
		Arrays.sort(clips, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]!=o2[0])
					return o1[0]-o2[0];
				else {
					return o1[1]-o2[1];
				}
			}
		});
		
		return hungry(clips, T);
		
    }
	
	//��̬�滮
	public void dps(int [][]clips,int dp[]) {
		for(int i=1;i<dp.length;i++) {
			for(int[] tmp:clips) {
				if(tmp[0]<i && i<=tmp[1])
				dp[i]=Math.min(dp[i],dp[tmp[0]]+1);
			}
		}
	}
	
	//̰�ķ�
	public int hungry(int [][]clips,int T) {
        int start=0,t_last=0,i=0,ans=0;
        
        while(i<clips.length && start<T) {
        	if(clips[i][0]<=start) {
               	t_last=start;
            	while(i<clips.length && t_last>=clips[i][0]) {  //ÿ��Ѱ�ҵ�ǰstart����ĩβ������
            		start=Math.max(start, clips[i][1]);
            		i++;
            	}
            	ans++;
        	}
            
        	else {
        		break;
        	}        	
        }
        return start>=T?ans:-1;
	}
	
    public static void main(String[] args) {
		every t=new every();
		int clips[][]= {{0,2},{4,8}};
		t.videoStitching(clips, 5);
	}
}
