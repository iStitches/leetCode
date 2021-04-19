package others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class t_954 {
	/**
	 * 由于可能重复出现相同的数，因此需要使用 Map 来记录每个数的出现次数；
	 * 然后每次去记录最小的数是否有对应的二倍值；
	 * 以此循环下去到最后一个点。
	 * @param arr
	 * @return
	 */
    public boolean canReorderDoubled(int[] arr) {
	    HashMap<Integer,Integer> map = new HashMap();
	    Integer[] brr = new Integer[arr.length];
	    //统计并且复制数组
	    for(int i=0;i<arr.length;i++) {
	    	brr[i]=arr[i];
	    	map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
	    }
	    
	    //对复制后的数组进行按绝对值排序
	    Arrays.sort(brr,Comparator.comparingInt(Math::abs));
	    
	    for(int i=0;i<brr.length;i++) {
	    	if(map.get(brr[i]) == 0)continue;
	    	if(map.getOrDefault(brr[i]*2, 0)<=0)return false;
	    	
	    	map.put(brr[i], map.get(brr[i])-1);
	    	map.put(brr[i]*2,map.get(brr[i]*2)-1);
	    }
	    return true;
    }
    
    public static void main(String[] args) {
    	t_954 t= new t_954();
    	System.out.println(t.canReorderDoubled(new int[] {1,2,4,16,8,4}));
	}
}
