package others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class t_954 {
	/**
	 * ���ڿ����ظ�������ͬ�����������Ҫʹ�� Map ����¼ÿ�����ĳ��ִ�����
	 * Ȼ��ÿ��ȥ��¼��С�����Ƿ��ж�Ӧ�Ķ���ֵ��
	 * �Դ�ѭ����ȥ�����һ���㡣
	 * @param arr
	 * @return
	 */
    public boolean canReorderDoubled(int[] arr) {
	    HashMap<Integer,Integer> map = new HashMap();
	    Integer[] brr = new Integer[arr.length];
	    //ͳ�Ʋ��Ҹ�������
	    for(int i=0;i<arr.length;i++) {
	    	brr[i]=arr[i];
	    	map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
	    }
	    
	    //�Ը��ƺ��������а�����ֵ����
	    Arrays.sort(brr,Comparator.comparingInt(Math::abs));
	    
	    for(int i=0;i<brr.length;i++) {
	    	if(map.get(brr[i]) == 0)continue;
	    	if(map.getOrDefault(brr[i]*2, 0)<=0)return false;
	    	
	    	map.put(brr[i], map.get(brr[i])-1);
	    	map.put(brr[i]*2,map.get(brr[i]*2)-1);
	    }
	    return true;
    }
    
    public static void main(String[] args) {
    	t_954 t= new t_954();
    	System.out.println(t.canReorderDoubled(new int[] {1,2,4,16,8,4}));
	}
}
