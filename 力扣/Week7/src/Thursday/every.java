package Thursday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class every {
		public List<Integer> partitionLabels(String S) {
            Map<Character,Integer[]> map=new HashMap();
            for(char ch='a';ch<='z';ch++) {
            	Integer tmp[]= {-1,-1};
            	map.put(ch,tmp);
            }
            
            char [] array=S.toCharArray();
            for(int i=0;i<array.length;i++) {
                if(map.get(array[i])[0]==-1)
                	map.get(array[i])[0]=i;
                else
                	map.get(array[i])[1]=i;
            }
		    
            List<Integer> res=new ArrayList();
            int start=0;
            while(start<S.length()) {
            	int left=start;
            	int right=map.get(array[left])[1];
            	if(right==-1)
            	{
            		res.add(1);
            		start++;
            		continue;
            	}
            	
            	for(int j=left+1;j<=right;j++) {
            		int tmp=map.get(array[j])[1];
            		if(tmp>right)
            			right=tmp;
            	}
            	res.add(right-left+1);
            	start=right+1;
            }
            
            return res;
		}
		
		public static void main(String[] args) {
			String S="caedbdedda";
			every t=new every();
			t.partitionLabels(S);
		}
}
