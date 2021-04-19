package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class offer23 {
	/**
	 * 方法一：全排列法
	 */
//	Long min = Long.MAX_VALUE;
//	String res = null;
//	StringBuilder builder = new StringBuilder();
//	boolean visited[] = null;
//	
//    public String PrintMinNumber(int [] numbers) {
//    	visited = new boolean[numbers.length];
//    	dfs(0,numbers);
//    	return res;
//    }
//    
//    public void dfs(int len,int []numbers) {
//    	if(len == numbers.length) {
//    		Long temp = Long.valueOf(builder.toString());
//    		if(min > temp) {
//    			min = temp;
//    			res = builder.toString();
//    		}
//    		return;
//    	}
//    	for(int i=0;i<numbers.length;i++) {
//    		if(visited[i])
//    			continue;
//    		visited[i] = true;
//    		builder.append(numbers[i]);
//    		dfs(len+1,numbers);
//    		visited[i] = false;
//    		builder.delete(builder.length()-String.valueOf(numbers[i]).length(), builder.length());
//    	}
//    }
//    
//    public static void main(String[] args) {
//		offer23 t = new offer23();
//		String res = t.PrintMinNumber(new int[] {});
//		System.out.println(res);
//	}
	
	/**
	 * 方法二：贪心法
	 * @param numbers
	 * @return
	 */
    public String PrintMinNumber(int [] numbers) {
      int n;
	  String s="";
	  ArrayList<Integer> list= new ArrayList<Integer>();
	  n=numbers.length;
	  for(int i=0;i<n;i++){
	   list.add(numbers[i]);
	   
	  }
	  Collections.sort(list, new Comparator<Integer>() {
		 public int compare(Integer r1,Integer r2) {
			 String temp1 = r1+""+r2;
			 String temp2 = r2+""+r1;
			 return temp1.compareTo(temp2);
		 }
	});
	  
	  for(int j:list){
	   s+=j;
	  }
        return s;
	
	}
}
