package Friday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_834 {
	/**
	 * 计算树中距离之和
	 * 思路：  其余结点到某个节点的距离和可以看成两部分    该节点的子树结点到该结点的距离和+子树外的结点到该结点的距离和
	 * 该节点的子树结点到该结点的距离和:   
	 *       该部分的距离可以看作root的所有子结点的distSum[child]加上nodeNum[child]  (子节点的个数)
	 *       distSum[root]=sum{ distSum[child]+nodeNum[child] }
	 */
	//每个结点的邻接表
	List<List<Integer>> graph=new ArrayList();  
	//所有其它结点到i的距离和
	int []distSum;  
	//子节点个数
	int []nodeNum;
	
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
    	/**
    	 * distSum[i]: 其余结点到i的距离和： 子树结点到i的距离和+子树外的点到i的距离和
    	 * nodeNum[i]: 某个结点的所有子结点个数
    	 * List<List<Integer>> graph: 每个结点的相邻结点的邻接表
    	 */
    	distSum=new int[N];
    	nodeNum=new int[N];
        Arrays.fill(distSum, 0);
        Arrays.fill(nodeNum, 1);   //每个结点的子节点个数最少为本身1
        
        for(int i=0;i<N;i++)
        	graph.add(new ArrayList());
        
        for(int[] line:edges) {   //一条edge的两边都要进行记录
        	graph.get(line[0]).add(line[1]);
        	graph.get(line[1]).add(line[0]);
        }
        
        postOrder(0,-1);
        firstOrder(0,-1);
        return distSum;
    }
    
    //计算某个结点的子树到该节点的距离之和、该节点的子节点个数----从根结点开始
    public void postOrder(int cur,int parent) {
    	//获取与当前点相关的结点
    	List<Integer> list=graph.get(cur);
    	for(Integer tmp:list) {   //跳过父结点
    		if(tmp==parent)
    			continue;
    		postOrder(tmp,cur);
    		nodeNum[cur]+=nodeNum[tmp];
    		distSum[cur]+=distSum[tmp]+nodeNum[tmp];
    	}
    }
    
    //计算所有结点到该结点的距离之和----巧妙运用root与i的关系
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
