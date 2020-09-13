package work;

import org.junit.Test;

public class mian_01_03 {
    public String replaceSpaces(String S, int length) {
         String s1=S.substring(0,length);
         String s2=s1.replaceAll(" ","%20");
         return s2;
    }
    
    @Test
    public void test() {
    	System.out.println(replaceSpaces("               ",5));
    }
}
