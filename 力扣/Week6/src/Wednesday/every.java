package Wednesday;

import java.util.ArrayList;
import java.util.List;

public class every {
	/**
	 * ����hash��ķ�����������������Hash��ÿ��Hash��ͳ��26���ַ����ֵ��ڲ�ͬ�����г��ֵĴ���
	 * @param A
	 * @return
	 */
    public List<String> commonChars(String[] A) {
          int hash1[]=new int[26];    //ͳ��ȫ���ַ��ĳ��ִ���
          int hash2[]=new int[26];    //ͳ�Ƶ��˵������ַ��ĳ��ִ���
          //��ʼʱ��hash1�������ַ����ִ�����Ϊ���(100)
          for(int i=0;i<26;i++)
        	  hash1[i]=100;
          
          for(String str:A) {
        	  //ͳ�Ƶ����ַ����ִ���
        	  for(int i=0;i<str.length();i++) { 
        		   char ch=str.charAt(i);
        		   hash2[ch-'a']++;
        	  }
        	  
        	  //����ȫ���ַ�ͳ��
        	  for(int j=0;j<26;j++) { 
        		   hash1[j]=Math.min(hash1[j],hash2[j]);  
        		   hash2[j]=0;
        	  }
          }
          
              //��Ͻ��
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
