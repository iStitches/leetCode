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
	    
	    //�ȽϷ���һ��ʹ�� stream() �����бȽ�
//	    ArrayList<Integer> res = (ArrayList<Integer>)list.stream().sorted(new Comparator<Integer>() {
//	    	@Override
//	    	public int compare(Integer o1, Integer o2) {
//	    		String str1 = o1+""+o2;
//	    		String str2 = o2+""+o1;
//	    		return str1.compareTo(str2);
//	    	}
//	    }).collect(Collectors.toList());
	    
//	    //�ȽϷ�������ʹ�ü��ϵ� sort() �������бȽϣ��ڲ�ʹ�� lambda���ʽ
//	    list.sort((o1,o2)->{
//	    	String str1 = o1+""+o2;
//	    	String str2 = o2+""+o1;
//	    	return str1.compareTo(str2);
//	    });
	    
	    //�ȽϷ�������ʹ��Collections.sort() ������������Ƚϣ�����һ��Comparator����ʽ�ӿڣ����Դ���һ�� lambda���ʽ
//	    Collections.sort(list, new Comparator<Integer>(){
//  
//	    public int compare(Integer str1,Integer str2){
//	      String s1=str1+""+str2;
//	      String s2=str2+""+str1;
//	          return s1.compareTo(s2);
//	      }
//	    });
	    
	    //�ȽϷ����ģ�ʹ��Collections.sort() ������������Ƚϣ��ڲ�ʹ�� Comparator.comparing()�������бȽϣ����һ�������ڱȽ϶����ĳЩ����ʱ
	    for(int j:list){
	      s+=j;
	    }
        return s;
    }
}
