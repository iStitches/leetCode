package design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 **  采用 LinkedHashMap来解决
 * @author dell
 *
 */
public class NC93_2 {
    public int[] LRU (int[][] operators, int k) {
        Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for(int[] num:operators) {
        	switch(num[0]) {
        	   case 1:{
        		   if(map.size()<k)
        			   map.put(num[1],num[2]);
        		   else {
        			   Iterator<Integer> it = map.keySet().iterator();
        			   map.remove(it.next());
        			   map.put(num[1],num[2]);
        		   }
        		   break;
        	   }
        	   case 2:{
        		   if(map.containsKey(num[1])) {
        			   int val = map.get(num[1]);
        			   res.add(val);
        			   map.remove(num[1]);
        			   map.put(num[1], val);
        		   }
        		   else
        			   res.add(-1);
        	   }
        	   break;
        	}
        }
        
        int[] ans = res.stream().mapToInt(Integer::valueOf).toArray();
        return ans;
    }
}
