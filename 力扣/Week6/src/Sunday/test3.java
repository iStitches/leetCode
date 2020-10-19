package Sunday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class test3 {
    public int bestTeamScore(int[] scores, int[] ages) {
    	 int len=scores.length;
         int dp[]=new int[len];
         /**
          * �������ʹ��һ�ָ���ķ���������һά�������洢�±�ֵ���ı��ֻ���±������Ԫ��
          */
//         //��������ӽ�List��
//         List<List<Integer>> list=new ArrayList();
//         for(int i=0;i<len;i++) {
//        	 ArrayList tmp=new ArrayList();
//        	 tmp.add(ages[i]);
//        	 tmp.add(scores[i]);
//        	 list.add(tmp);
//         }    
//         //�Ȱ�ages����Ȼ���ٰ�scores����
//         Collections.sort(list, new Comparator<List<Integer>>() {
//        	 @Override
//        	public int compare(List<Integer> o1, List<Integer> o2) {
//        		int res=o1.get(0)-o2.get(0);
//        		if(res==0) {
//        			return o1.get(1)-o2.get(1);
//        		}
//        		return res;
//        	}
//		});
         Integer order[]=new Integer[len];
         for(int i=0;i<len;i++) {
        	 order[i]=i;
         }
         Arrays.sort(order, new Comparator<Integer>() {
        	 @Override
        	public int compare(Integer o1, Integer o2) {
        		int res=ages[o1]-ages[o2];
        		if(res==0)
        			return scores[o1]-scores[o2];
        		return res;
        	}
		});
         
         //����dp:   dp[i]����ʾ�Ե�i����Ա��βʱ��������
         int best=0;
         for(int i=0;i<len;i++) {
        	 int idx=order[i];
        	 dp[i]=scores[idx];
        	 for(int j=0;j<i;j++) {
        		 int last=order[j];
        		 if(scores[idx]>=scores[last]) {
        			 dp[i]=Math.max(dp[i],dp[j]+scores[idx]);
        		 }
        	 }
        	 best=Math.max(best,dp[i]);
         }

         return best;
    }
    public static void main(String[] args) {
		int scores[]= {1,2,3,5};
		int ages[]= {8,9,10,1};
		test3 t=new test3();
		System.out.println(t.bestTeamScore(scores, ages));
	}
}
