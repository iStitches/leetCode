package lanqiaobei;

import java.util.HashSet;

public class t02 {
  public static HashSet set = new HashSet();
  
  
  public static boolean checked(String str) {
	  if(str.length()!=9)
		  return false;
	  set.clear();
	  for(int i=0;i<str.length();i++) {
		  if(str.charAt(i)!='0')
		     set.add(str.charAt(i));
	  }
	  return set.size()==9?true:false;
  }
	
  public static void main(String[] args) {
	  int count = 0;
	  for(int i=123;i<=987;i++) {
		  for(int j=123;j<=987;j++) {
			  int sum = i+j;
			  if(sum>=1000)
				  break;
			  else {
				  if(checked(i+""+j+""+sum))
					  count++;
			  }
		  }
	  }
	  System.out.println(count);
}
//    private static int ans;
//
//    public static void main(String[] args) {
//        String i1 = "";
//        String j1 = "";
//        String k1 = "";
//        int k;
//        for (int i = 100; i < 1000; i++) {
//            for (int j = 100; j < 1000; j++) {
//                k = i + j;
//                if (k > 1000){
//                    break;
//                }
//                i1 = i + "";
//                j1 = j + "";
//                k1 = k + "";
//                if (check(i1 + j1 + k1)){
////                    System.out.println(i + "+" + j + "=" + k);
//                    ans++;
//                }
//            }
//        }
//        System.out.println(ans);
//    }
//
//
//    static HashSet<Character> set = new HashSet<>();
//    private static boolean check(String s) {
//        if (s.length() < 9){
//            return false;
//        }
//        set.clear();
//        for (int i = 0; i < s.length(); i++) {
//            if ((s.charAt(i) != '0')) {
//
//                set.add(s.charAt(i));
//            }
//        }
//        return set.size() == 9;
//    }
}
