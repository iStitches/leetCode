package Week1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Leetcode140 {
	List<String> res=new ArrayList();  //存储结果集
	Map<Integer,List<String>> map=new HashMap(); //存储过程量，从start开始可能存在的字符串
	
    public List<String> wordBreak(String s, List<String> wordDict) {
         dfs(0,s,new LinkedList(),wordDict);
         return res;
    }
    
    //dfs深度遍历
    public void dfs(int start,String s,LinkedList<String> stack,List<String> wordDict) {
    	
    	//遍历到结尾
    	if(start>=s.length()) {
    		StringBuilder builder=new StringBuilder();
            for(int j=stack.size()-1;j>=0;j--) {
            	builder.append(stack.get(j));
            }
    		String ans=builder.toString().trim();
    		res.add(ans);
    	    
    		return;
    	}
    	
    	//否则从start开始查找下一个单词
    	for(int i=start;i<s.length();i++) {
    		if(wordDict.contains(s.substring(start,i+1))) {
    			stack.push(s.substring(start,i+1));
    			//递归下一层
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
