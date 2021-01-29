package Week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class OrderedStream {
    private int ptr;
    private HashMap<Integer,String> map=null;
    
    public OrderedStream(int n) {
        map=new HashMap(n);
        ptr=1;
    }
    
    public List<String> insert(int id, String value) {
        map.put(id,value);
        List<String> list=new ArrayList();
        if(ptr==id){
            while(map.containsKey(ptr)){
                list.add(map.get(ptr));
                ptr++;
            }
        }
        return list;
    }
}
