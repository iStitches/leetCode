package Sunday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test1 {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character,Integer> map1=new HashMap();
        Map<Character,Integer> map2=new HashMap();
        
        char[] array=s.toCharArray();
        for(int i=0;i<array.length;i++) {
        	if(map1.get(array[i])==null){
        		map1.put(array[i],i);
        	}
        	else {
        		map2.put(array[i],i);
        	}
        }
        
        int max=0,temp=0;
        for(Character ch:map1.keySet()) {
        	if(map2.get(ch)==null) {
        		temp=-1;
        	}
        	else {
        		temp=map2.get(ch)-map1.get(ch)-1;
        	}
        	max=max>temp?max:temp;
        }
        return max;
    }
    public static void main(String[] args) {
		String str="cabbac";
		test1 t=new test1();
		System.out.println(t.maxLengthBetweenEqualCharacters(str));
	}
}
