package work;

import java.util.HashSet;
import java.util.Set;

public class mian_01_04 {
    public boolean canPermutePalindrome(String s) {
         //1.���Ϊ���ģ���ô��һ�������(�ȼ���set����)
    	 Set set=new HashSet();
    	 char[] charArray = s.toCharArray();
    	 for(char ch:charArray) {
    		 //2.����Ѿ����ڣ��ٴ�������ɾ��
    		 if(set.contains(ch)) {
    			 set.remove(ch);
    		 }
    		 else
    		     set.add(ch);
    	 }
    	 if(set.size()<=1)
    		 return true;
    	 return false;
    }
    public static void main(String[] args) {
		mian_01_04 t = new mian_01_04();
		t.canPermutePalindrome("aab");
	}
}
