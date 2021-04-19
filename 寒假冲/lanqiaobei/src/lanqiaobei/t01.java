package lanqiaobei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class t01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        Character res = null;
        int count=0;
        HashMap<Character,Integer> map = new HashMap();

        char[] array = str.toCharArray();
        for(char ch:array){
          if(!map.containsKey(ch))
              map.put(ch,1);
          else
              map.put(ch,map.get(ch)+1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
          if(count<entry.getValue()){
            count = entry.getValue();
            res = entry.getKey();
          }
        }
        System.out.println(res);
        System.out.println(count);
        scan.close();
    }
}
