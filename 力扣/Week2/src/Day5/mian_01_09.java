package Day5;

import java.util.Arrays;

public class mian_01_09 {
	/**
	 * �ҵĽⷨ
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
//	 * ���еĽⷨ
//	 * @param args
//	 */
//	public boolean isFlipedString(String s1, String s2) {
//		//
//	}
    public boolean isFlipedString(String s1, String s2) {
        // ���Ȳ���ȣ��϶�������Ҫ��
        if (s1.length() != s2.length()) {
            return false;
        }

        // �������ʱ����s2��s1��ת���ɵģ���ô��s2������ƴ��һ�Σ�s1�ͻ����������
        // "erbottlewat" + "erbottlewat" = erbottle waterbottle wat
    	// ���s2����s1��ת���ɵģ���ô��ô��s2������ƴ��һ�Σ�s1�Ϳ϶��������������
        return (s2 + s2).indexOf(s1) != -1;
    }
    
    public static void main(String[] args) {
		mian_01_09 t=new mian_01_09();
		System.out.println(t.isFlipedString("waterbottle", "bottleerwat"));
	}
}
