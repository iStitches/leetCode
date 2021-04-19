package offer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;


public class offer32 {

      public String PrintMinNumber(int [] numbers) {
        int n;
	    String s="";
	    ArrayList<Integer> list= new ArrayList<Integer>();
	    n=numbers.length;
	    for(int i=0;i<n;i++){
	      list.add(numbers[i]);
	    }	    
	    
	    //比较方法一：使用 stream() 流进行比较
//	    ArrayList<Integer> res = (ArrayList<Integer>)list.stream().sorted(new Comparator<Integer>() {
//	    	@Override
//	    	public int compare(Integer o1, Integer o2) {
//	    		String str1 = o1+""+o2;
//	    		String str2 = o2+""+o1;
//	    		return str1.compareTo(str2);
//	    	}
//	    }).collect(Collectors.toList());
	    
//	    //比较方法二：使用集合的 sort() 方法进行比较，内部使用 lambda表达式
//	    list.sort((o1,o2)->{
//	    	String str1 = o1+""+o2;
//	    	String str2 = o2+""+o1;
//	    	return str1.compareTo(str2);
//	    });
	    
	    //比较方法三：使用Collections.sort() 方法进行排序比较，接收一个Comparator函数式接口，可以传入一个 lambda表达式
//	    Collections.sort(list, new Comparator<Integer>(){
//  
//	    public int compare(Integer str1,Integer str2){
//	      String s1=str1+""+str2;
//	      String s2=str2+""+str1;
//	          return s1.compareTo(s2);
//	      }
//	    });
	    
	    //比较方法四：使用Collections.sort() 方法进行排序比较，内部使用 Comparator.comparing()方法进行比较，这个一般适用于比较对象的某些属性时
	    for(int j:list){
	      s+=j;
	    }
        return s;
    }
}
