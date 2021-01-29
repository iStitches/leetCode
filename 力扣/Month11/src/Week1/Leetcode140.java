package Week1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Leetcode140 {
	List<String> res=new ArrayList();  //�洢�����
	Map<Integer,List<String>> map=new HashMap(); //�洢����������start��ʼ���ܴ��ڵ��ַ���
	
    public List<String> wordBreak(String s, List<String> wordDict) {
         dfs(0,s,new LinkedList(),wordDict);
         return res;
    }
    
    //dfs��ȱ���
    public void dfs(int start,String s,LinkedList<String> stack,List<String> wordDict) {
    	
    	//��������β
    	if(start>=s.length()) {
    		StringBuilder builder=new StringBuilder();
            for(int j=stack.size()-1;j>=0;j--) {
            	builder.append(stack.get(j));
            }
    		String ans=builder.toString().trim();
    		res.add(ans);
    	    
    		return;
    	}
    	
    	//�����start��ʼ������һ������
    	for(int i=start;i<s.length();i++) {
    		if(wordDict.contains(s.substring(start,i+1))) {
    			stack.push(s.substring(start,i+1));
    			//�ݹ���һ��
    			dfs(i+1,s,stack,wordDict);
    			stack.removeFirst();
    		}
    	}
    }
    
    public static void main(String[] args) {
		String s="catsanddog";
		List<String> wordDict=new ArrayList();
		String[] str= {"cat", "cats", "and", "sand", "dog"};
		wordDict.addAll(Arrays.asList(str));
		Leetcode140 t=new Leetcode140();
		t.wordBreak(s, wordDict);
	}
}
