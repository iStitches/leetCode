package work;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 解法类似于回文，题目的意思就是多一个/少一个/一个不同
 * @author dell
 *
 */
public class mian_01_05 {
    public boolean oneEditAway(String first, String second) {
         int len1=first.length();
         int len2=second.length();
         if(len1<len2) {
            String temp=first;
            first=second;
            second=temp;
         }
         int count=0;
         //特殊情况
         if(Math.abs(len1-len2)>=2)
        	 return false;
    	 List<Character> list=new ArrayList<Character>();
    	 for(char ch:second.toCharArray()) {
    		 list.add(ch);
    	 }
         //1.替换字符
    	 for(int i=0;i<len1;i++)
    		 if(list.get(i)!=first.charAt(i))
    			 count++;
         if(count>=2) 
    		 return false;
         //2.差字符
         for(Character ch:first.toCharArray()) {
        	 if(list.contains(ch)) {
        		 list.remove(ch);
        	 }
        	 else
        		 list.add(ch);
         }
         if(list.size()<=1)
        	 return true;
         return false;
    }
    public static void main(String[] args) {
		mian_01_05 t = new mian_01_05();
		System.out.println(t.oneEditAway("b", ""));
	}

}
