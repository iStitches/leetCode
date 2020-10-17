package Wednesday;

import java.util.ArrayList;
import java.util.List;

public class every {
	/**
	 * 采用hash表的方法方法，建立两个Hash表，每个Hash表统计26个字符出现的在不同单词中出现的次数
	 * @param A
	 * @return
	 */
    public List<String> commonChars(String[] A) {
          int hash1[]=new int[26];    //统计全部字符的出现次数
          int hash2[]=new int[26];    //统计当此单词中字符的出现次数
          //初始时将hash1中所有字符出现次数置为最大(100)
          for(int i=0;i<26;i++)
        	  hash1[i]=100;
          
          for(String str:A) {
        	  //统计当次字符出现次数
        	  for(int i=0;i<str.length();i++) { 
        		   char ch=str.charAt(i);
        		   hash2[ch-'a']++;
        	  }
        	  
        	  //更新全部字符统计
        	  for(int j=0;j<26;j++) { 
        		   hash1[j]=Math.min(hash1[j],hash2[j]);  
        		   hash2[j]=0;
        	  }
          }
          
              //组合结果
          List<String> res=new ArrayList();
          for(int i=0;i<26;i++) {
        	  if(hash1[i]!=0)
        		  while(hash1[i]>0) {
          		    res.add(String.valueOf((char)(i+'a')));
          		    hash1[i]--;
        		  }
          }
          return res;
    }
    
    public static void main(String[] args) {
		String[] A= {"bella","label","roller"};
		every t=new every();
		t.commonChars(A);
	}
}
