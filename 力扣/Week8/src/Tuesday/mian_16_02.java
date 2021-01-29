package Tuesday;

import java.util.HashMap;
import java.util.Map;

public class mian_16_02 {
	
	Map<String,Integer> map=new HashMap();
    public mian_16_02(String[] book) {
         for(String tmp:book){
             if(map.containsKey(tmp))
            	 map.put(tmp, map.get(tmp)+1);
             else {
				map.put(tmp,1);
			}
         }
    }
    
    public int get(String word) {
        return map.get(word);
    }
}
