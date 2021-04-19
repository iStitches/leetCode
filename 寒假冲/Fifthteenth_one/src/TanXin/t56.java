package TanXin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class t56 {
    public int[][] merge(int[][] intervals) {
         if(intervals.length == 0)
        	 return new int[0][2];
         List<int[]> res = new ArrayList<int[]>();
         
         //ÅÅĞò
         Arrays.sort(intervals,new Comparator<int[]>() {
         	@Override
         	public int compare(int[] o1,int[] o2) {
         		return o1[0]-o2[0];
         	}
         });
         
         for(int i=0;i<intervals.length;i++) {
        	 int L = intervals[i][0],R=intervals[i][1];
        	 if(res.size()==0 || res.get(res.size()-1)[1]<L) {
        		 res.add(new int[] {intervals[i][0],intervals[i][1]});
        	 }
        	 else {
        		 res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], R);
        	 }
         }
         return res.toArray(new int[res.size()][]);
    }
}
