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
        	 * ���ָ���ļ���δ��ֵ���������ӳ�䵽 null ��������ʹ�ø�����ӳ�亯��������ֵ�����������뵽��ӳ���У����� null 
        	 * ͨ�����ڼ�⼯�����Ƿ���ڶ�Ӧ��ֵ
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
