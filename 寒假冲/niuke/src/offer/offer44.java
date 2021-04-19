package offer;

import java.util.Stack;

public class offer44 {
	/**
	 * 方法一： 先将整个句子进行翻转，然后针对句子中的每个单词再分别翻转
	 * @param str
	 * @return
	 */
	public String ReverseSentence(String str) {
		if(str==null || str.length()==0)
			return str;
		char[] array = str.toCharArray();
		//1. 对整个句子进行翻转
		reverse(array,0,array.length-1);
		
		//2. 对里面的每个单词进行翻转
		int start=0,end=0;
		while(start < array.length) {
			
			 //如果 start位置对应的是空格,不需要进行翻转,找到下一个非空格的字符
		     if(array[start] == ' ') {
		    	 start++;
		    	 end++;
		     } 
		     //如果end对应的位置是空格(说明已经找到了一个单词,进行翻转)   或者已经结束了查找,进行最后一个单词的翻转
		     else if(end>=array.length || array[end] == ' '){
		    	 reverse(array,start,end-1);
		    	 end++;
		    	 start = end;
		     }
		     //否则说明还未找到一个单词,继续查找
		     else {
		    	 end++;
		     }
		}
		return new String(array);
	}
	
	public void reverse(char[] array,int begin,int end) {
		while(begin < end) {
			char temp = array[begin];
			array[begin] = array[end];
			array[end] = temp;
			begin++;
			end--;
		}
	}
	
	/**
	 * 方法二：采用栈来解决倒序问题
	 * @param str
	 * @return
	 */
	public String ReverseSentence2(String str) {
		if(str==null || str.length()==0)
			return str;
		//按空格分割字符串准备入栈
		String[] array = str.split(" ");
		if(array.length == 0)
			return str;
		Stack<String> stack = new Stack<String>();
		
		//入栈操作,除开最后一个单词每个单词后面需要同时压入一个空格; 
		for(int i=0;i<array.length-1;i++) {
			stack.push(array[i]);
			stack.push(" ");
		}
		stack.push(array[array.length-1]);
		
		//出栈操作
		StringBuilder builder = new StringBuilder();
		while(!stack.isEmpty()) {
			builder.append(stack.pop());
		}
		return builder.toString();
	}
	
	public static void main(String[] args) {
		offer44 t = new offer44();
//		System.out.println(t.ReverseSentence("nowcoder. a am I"));
		System.out.println(t.ReverseSentence2("   "));
	}
}
