package work;

import org.junit.Test;

public class mian01_01 {
    public boolean isUnique(String astr) {
    	if(astr.length()==0)return true;
    	boolean flag=true;
        for(int i=1;i<astr.length();i++) {
           for(int j=0;j<i;j++) {
        	   if(astr.charAt(i)==astr.charAt(j))
        	   {
        		   flag=false;
        		   break;
        	   }
           }
           if(flag==false)break;
        }
        return flag;
    }
    
    @Test
    public void test() {
    	System.out.println(isUnique("abc"));
    }
}
