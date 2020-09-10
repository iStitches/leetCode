package work;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

import org.junit.Test;

public class mian_01_02 {
	    public boolean CheckPermutation(String s1, String s2) {
	       char[] charArray1 = s1.toCharArray();
	       Arrays.sort(charArray1);
	       char[] charArray2 = s2.toCharArray();
	       Arrays.sort(charArray2);
	       return new String(charArray1).equals(new String(charArray2));
	    }
    
    @Test
    public void test() {
    	String s1="abc";
    	String s2="bca";
    	System.out.println(CheckPermutation(s1, s2));
    }
}
