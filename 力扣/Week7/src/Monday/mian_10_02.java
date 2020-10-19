package Monday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class mian_10_02 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap(strs.length);
        
        for(String str:strs) {
        	char[] ch=str.toCharArray();
        	Arrays.sort(ch);
        	String tmp=new String(ch);
        	/**
        	 * map.computeIfAbsent(K key,Function<? super K,? extends V> mappingFunction):
        	 * 如果指定的键尚未与值相关联（或映射到 null ），则尝试使用给定的映射函数计算其值，并将其输入到此映射中，除非 null 
        	 * 通常用于检测集合中是否存在对应的值
        	 */
        	map.computeIfAbsent(tmp, key -> new ArrayList<>()).add(str);
        }
        return new ArrayList(map.values());
    }
    public static void main(String[] args) {
		String[] strs= {"eat", "tea", "tan", "ate", "nat", "bat"};
		mian_10_02 t=new mian_10_02();
		t.groupAnagrams(strs);
	}
}
