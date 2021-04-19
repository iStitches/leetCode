package offer;

import java.util.Stack;

public class offer44 {
	/**
	 * ����һ�� �Ƚ��������ӽ��з�ת��Ȼ����Ծ����е�ÿ�������ٷֱ�ת
	 * @param str
	 * @return
	 */
	public String ReverseSentence(String str) {
		if(str==null || str.length()==0)
			return str;
		char[] array = str.toCharArray();
		//1. ���������ӽ��з�ת
		reverse(array,0,array.length-1);
		
		//2. �������ÿ�����ʽ��з�ת
		int start=0,end=0;
		while(start < array.length) {
			
			 //��� startλ�ö�Ӧ���ǿո�,����Ҫ���з�ת,�ҵ���һ���ǿո���ַ�
		     if(array[start] == ' ') {
		    	 start++;
		    	 end++;
		     } 
		     //���end��Ӧ��λ���ǿո�(˵���Ѿ��ҵ���һ������,���з�ת)   �����Ѿ������˲���,�������һ�����ʵķ�ת
		     else if(end>=array.length || array[end] == ' '){
		    	 reverse(array,start,end-1);
		    	 end++;
		    	 start = end;
		     }
		     //����˵����δ�ҵ�һ������,��������
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
	 * ������������ջ�������������
	 * @param str
	 * @return
	 */
	public String ReverseSentence2(String str) {
		if(str==null || str.length()==0)
			return str;
		//���ո�ָ��ַ���׼����ջ
		String[] array = str.split(" ");
		if(array.length == 0)
			return str;
		Stack<String> stack = new Stack<String>();
		
		//��ջ����,�������һ������ÿ�����ʺ�����Ҫͬʱѹ��һ���ո�; 
		for(int i=0;i<array.length-1;i++) {
			stack.push(array[i]);
			stack.push(" ");
		}
		stack.push(array[array.length-1]);
		
		//��ջ����
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
