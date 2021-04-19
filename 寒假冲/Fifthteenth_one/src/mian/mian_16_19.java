package mian;

import java.util.ArrayList;
import java.util.Collections;

public class mian_16_19 {
	
    public int[] pondSizes(int[][] land) {
    	ArrayList<Integer> list = null;
    	int leny = land.length;
    	if(leny == 0) return null;
    	else {
    		list = new ArrayList();
    		for(int i=0;i<land.length;i++) {
    			for(int j=0;j<land[0].length;j++) {
    				list.add(dfs(land,i,j));
    			}
    		}
    	}
    	Collections.sort(list);
    	return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    /**
     * - 从land[i][j] 开始遍历到的池塘大小
     * @param land
     * @param count
     * @param op
     */
    public int dfs(int [][]land,int i,int j) {
    	if(i<0 || i>=land.length || j<0 || j>=land[0].length || land[i][j]!=0)
    		return 0;
    	int count = 1;
    	count += dfs(land,i+1,j);
    	count += dfs(land,i-1,j);
    	count += dfs(land,i,j+1);
    	count += dfs(land,i,j-1);
    	count += dfs(land,i+1,j-1);
    	count += dfs(land,i-1,j+1);
    	count += dfs(land,i+1,j+1);
    	count += dfs(land,i-1,j-1);
    	return count;	
    }
}
