package Monday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class mian_04_01 {
	boolean visited[];
	List<Integer> []adj;
	
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
          //1.�����ڽӱ�---List����
    	  adj=new ArrayList[n];
    	  for(int[] edge:graph) {
    		  if(adj[edge[0]] == null) {
    			  adj[edge[0]]=new ArrayList();
    		  }
    		  adj[edge[0]].add(edge[1]);
    	  }
    	  //��־����
    	  visited=new boolean[n];
    	  
    	  //2.������ȱ�������
    	  return bfs(start,target);
    }
    
    /**
     * ������ȱ���
     */
//    public boolean dfs(int start,int end) {
//         //���start == end���ҵ�������·��
//    	if(start == end){
//    		return true;
//    	}
//    	
//    	 //�����start��ʼ������ȱ���
//    	visited[start]=true;
//    	    //1.��ȡ��start��ʼ���ڽӱ�
//    	List<Integer> path=adj[start];
//    	  
//    	if(path == null)  //�����ǰ��㲻�����ڽӱ��ֱ���˳�
//    		return false;
//    	    //2.���ڽӱ��е�ÿ�������·���ж�
//    	for(Integer node:path) {
//    		if(!visited[node]) {
//    			
//    			//!!!ע���������visitedΪȫ�ֱ�������ôÿһ����ȱ��������ʱҪ��visited��Ϊfalse���������������true��Ҳ�ͱ�ʾ���ҵ��ˣ�ֱ��return �˳�
//    			boolean result=dfs(node,end);
//    			visited[node]=false;
//                if(result == true)
//                  return true;
//    		}
//    	}
//    	return false;
//    }
    
    /**
     * ������ȱ���----����ÿһ����ڽӱ����Ƿ����target
     */
    public boolean bfs(int start,int end) {
          LinkedList queue=new LinkedList<Integer>();
          visited[start]=true;
          queue.offer(start);
          
          //��ȱ�������
          while(!queue.isEmpty()) {
        	  Integer node=(Integer) queue.poll();
        	  
        	  //�жϸ�node���ڽӱ����Ƿ����target
        	  List<Integer> path=adj[node];
        	  if(path == null)
        		  continue;
        	  
        	  for(Integer value:path) {
        		  if(visited[value])
        			  continue;
        		  if(value == end)
        			  return true;
        		  //����δ���ʵı��Ϊ���ʹ�Ȼ��������
        		  visited[value]=true;
        		  queue.offer(value);
        	  }
          }
          return false;
    }
}
