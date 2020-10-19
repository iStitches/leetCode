package Monday;

import java.util.ArrayDeque;

public class every {
    public boolean backspaceCompare(String S, String T) {
        ArrayDeque<Character> stack1=new ArrayDeque();
        ArrayDeque<Character> stack2=new ArrayDeque();
        char[] array1=S.toCharArray();
        char[] array2=T.toCharArray();
        
        for(int i=0;i<array1.length;i++) {
        	if(array1[i]=='#') {
        		if(!stack1.isEmpty())
        		   stack1.pop();
        	}
        	else {
        		stack1.push(array1[i]);
        	}
        }
        for(int i=0;i<array2.length;i++) {
        	if(array2[i]=='#') {
        		if(!stack2.isEmpty()) {
        			stack2.pop();
        		}
        	}
        	else{
        		stack2.push(array2[i]);
        	}
        }
        while(!stack1.isEmpty() && !stack2.isEmpty()) {
        	char ch1=stack1.pop();
        	char ch2=stack2.pop();
        	if(ch1!=ch2)
        		return false;
        }
        if(stack1.isEmpty() && stack2.isEmpty())
        	return true;
        return false;
    }
    public static void main(String[] args) {
		String S="a##c";
		String T="#a#c";
		every t=new every();
		t.backspaceCompare(S, T);
	}
}
