import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	for(int i=1;i<=6;i++)
    		res.add(i);
    	int[] data = {1,2,3,4,5,6,7};
    	
    	//List<Integer> 转化为 Integer[]
    	Integer[] cc = res.toArray(new Integer[6]);
    	
    	//int[] 转化为 List<Integer>
    	List<Integer> res1 = Arrays.stream(data).boxed().collect(Collectors.toList());
    	//List<Integer> 转化为 int[]
    	int[] res3 = res1.stream().mapToInt(Integer::valueOf).toArray();
    	
    	//int[] 转化为 Integer[]
    	Integer[] res2 = Arrays.stream(data).boxed().toArray(Integer[]::new);
    			
    	//Integer[] 转化为 int[]
    	int[] res4 = Arrays.stream(res2).mapToInt(Integer::valueOf).toArray();
    	
    	//Integer[] 转化为 List<Integer>
        List<Integer> res5 = Arrays.asList(res2);     	
	}
}
