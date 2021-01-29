package Week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test2 {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())
            return false;
        Map<Character,Integer> map1=new HashMap();
        Map<Character,Integer> map2=new HashMap();
       
        for(char ch1:word1.toCharArray()){
        	if(!map1.containsKey(ch1))
        		map1.put(ch1, 1);
        	else
                map1.put(ch1,map1.get(ch1)+1);
        }
        for(char ch2:word2.toCharArray()){
        	if(!map2.containsKey(ch2))
        		map2.put(ch2, 1);
        	else
                map2.put(ch2,map2.get(ch2)+1);
        }
        
        Integer[] list1= map1.values().toArray(new Integer[0]);
        Integer[] list2= map2.values().toArray(new Integer[0]);
        Arrays.sort(list1);
        Arrays.sort(list2);
        for(int i=0;i<list1.length;i++) {
        	if(list1[i]!=list2[i])
        		return false;
        }
        return true;
   }
    
    public static void main(String[] args) {
		String word1="cabbba";
		String word2="abbccc";
		test2 t=new test2();
		System.out.println(t.closeStrings(word1, word2));
		
	}
}
