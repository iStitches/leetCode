package Day5;

import java.util.Arrays;

public class mian_01_09 {
	/**
	 * 我的解法
	 * @param args
	 */
//    public boolean isFlipedString(String s1, String s2) {
//          char[] chars1 = s1.toCharArray();
//          char[] chars2 = s2.toCharArray();
//          Arrays.sort(chars1);
//          Arrays.sort(chars2);
//          String temp1=new String(chars1);
//          String temp2=new String(chars2);
//          return temp1.equals(temp2);
//    }
	
//	/**
//	 * 大佬的解法
//	 * @param args
//	 */
//	public boolean isFlipedString(String s1, String s2) {
//		//
//	}
    public boolean isFlipedString(String s1, String s2) {
        // 长度不相等，肯定不符合要求
        if (s1.length() != s2.length()) {
            return false;
        }

        // 长度相等时，若s2是s1旋转而成的，那么把s2和自身拼接一次，s1就会出现在其中
        // "erbottlewat" + "erbottlewat" = erbottle waterbottle wat
    	// 如果s2不是s1旋转而成的，那么那么把s2和自身拼接一次，s1就肯定不会出现在其中
        return (s2 + s2).indexOf(s1) != -1;
    }
    
    public static void main(String[] args) {
		mian_01_09 t=new mian_01_09();
		System.out.println(t.isFlipedString("waterbottle", "bottleerwat"));
	}
}
