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
    	
    	//List<Integer> ת��Ϊ Integer[]
    	Integer[] cc = res.toArray(new Integer[6]);
    	
    	//int[] ת��Ϊ List<Integer>
    	List<Integer> res1 = Arrays.stream(data).boxed().collect(Collectors.toList());
    	//List<Integer> ת��Ϊ int[]
    	int[] res3 = res1.stream().mapToInt(Integer::valueOf).toArray();
    	
    	//int[] ת��Ϊ Integer[]
    	Integer[] res2 = Arrays.stream(data).boxed().toArray(Integer[]::new);
    			
    	//Integer[] ת��Ϊ int[]
    	int[] res4 = Arrays.stream(res2).mapToInt(Integer::valueOf).toArray();
    	
    	//Integer[] ת��Ϊ List<Integer>
        List<Integer> res5 = Arrays.asList(res2);     	
	}
}
