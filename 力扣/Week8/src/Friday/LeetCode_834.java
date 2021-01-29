package Friday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_834 {
	/**
	 * �������о���֮��
	 * ˼·��  �����㵽ĳ���ڵ�ľ���Ϳ��Կ���������    �ýڵ��������㵽�ý��ľ����+������Ľ�㵽�ý��ľ����
	 * �ýڵ��������㵽�ý��ľ����:   
	 *       �ò��ֵľ�����Կ���root�������ӽ���distSum[child]����nodeNum[child]  (�ӽڵ�ĸ���)
	 *       distSum[root]=sum{ distSum[child]+nodeNum[child] }
	 */
	//ÿ�������ڽӱ�
	List<List<Integer>> graph=new ArrayList();  
	//����������㵽i�ľ����
	int []distSum;  
	//�ӽڵ����
	int []nodeNum;
	
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
    	/**
    	 * distSum[i]: �����㵽i�ľ���ͣ� ������㵽i�ľ����+������ĵ㵽i�ľ����
    	 * nodeNum[i]: ĳ�����������ӽ�����
    	 * List<List<Integer>> graph: ÿ���������ڽ����ڽӱ�
    	 */
    	distSum=new int[N];
    	nodeNum=new int[N];
        Arrays.fill(distSum, 0);
        Arrays.fill(nodeNum, 1);   //ÿ�������ӽڵ��������Ϊ����1
        
        for(int i=0;i<N;i++)
        	graph.add(new ArrayList());
        
        for(int[] line:edges) {   //һ��edge�����߶�Ҫ���м�¼
        	graph.get(line[0]).add(line[1]);
        	graph.get(line[1]).add(line[0]);
        }
        
        postOrder(0,-1);
        firstOrder(0,-1);
        return distSum;
    }
    
    //����ĳ�������������ýڵ�ľ���֮�͡��ýڵ���ӽڵ����----�Ӹ���㿪ʼ
    public void postOrder(int cur,int parent) {
    	//��ȡ�뵱ǰ����صĽ��
    	List<Integer> list=graph.get(cur);
    	for(Integer tmp:list) {   //���������
    		if(tmp==parent)
    			continue;
    		postOrder(tmp,cur);
    		nodeNum[cur]+=nodeNum[tmp];
    		distSum[cur]+=distSum[tmp]+nodeNum[tmp];
    	}
    }
    
    //�������н�㵽�ý��ľ���֮��----��������root��i�Ĺ�ϵ
    public void firstOrder(int cur,int parent) {
    	List<Integer> list=graph.get(cur);
    	for(Integer tmp:list) {	
    		if(tmp==parent)
    			continue;
    		distSum[tmp]=distSum[cur]-nodeNum[tmp]+graph.size()-nodeNum[tmp];
    		firstOrder(tmp,cur);
    	}
    }
}
