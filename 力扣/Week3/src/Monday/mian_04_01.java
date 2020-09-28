package Monday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class mian_04_01 {
	boolean visited[];
	List<Integer> []adj;
	
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
          //1.构造邻接表---List数组
    	  adj=new ArrayList[n];
    	  for(int[] edge:graph) {
    		  if(adj[edge[0]] == null) {
    			  adj[edge[0]]=new ArrayList();
    		  }
    		  adj[edge[0]].add(edge[1]);
    	  }
    	  //标志数据
    	  visited=new boolean[n];
    	  
    	  //2.深度优先遍历搜索
    	  return bfs(start,target);
    }
    
    /**
     * 深度优先遍历
     */
//    public boolean dfs(int start,int end) {
//         //如果start == end则找到了这条路径
//    	if(start == end){
//    		return true;
//    	}
//    	
//    	 //否则从start开始进行深度遍历
//    	visited[start]=true;
//    	    //1.获取到start开始的邻接表
//    	List<Integer> path=adj[start];
//    	  
//    	if(path == null)  //如果当前结点不存在邻接表就直接退出
//    		return false;
//    	    //2.对邻接表中的每个点进行路径判断
//    	for(Integer node:path) {
//    		if(!visited[node]) {
//    			
//    			//!!!注意这里，由于visited为全局变量，那么每一次深度遍历完回溯时要将visited置为false，但是如果返回了true，也就表示着找到了，直接return 退出
//    			boolean result=dfs(node,end);
//    			visited[node]=false;
//                if(result == true)
//                  return true;
//    		}
//    	}
//    	return false;
//    }
    
    /**
     * 广度优先遍历----遍历每一层的邻接表中是否包含target
     */
    public boolean bfs(int start,int end) {
          LinkedList queue=new LinkedList<Integer>();
          visited[start]=true;
          queue.offer(start);
          
          //广度遍历搜索
          while(!queue.isEmpty()) {
        	  Integer node=(Integer) queue.poll();
        	  
        	  //判断该node的邻接表中是否包含target
        	  List<Integer> path=adj[node];
        	  if(path == null)
        		  continue;
        	  
        	  for(Integer value:path) {
        		  if(visited[value])
        			  continue;
        		  if(value == end)
        			  return true;
        		  //否则将未访问的标记为访问过然后放入队列
        		  visited[value]=true;
        		  queue.offer(value);
        	  }
          }
          return false;
    }
}
