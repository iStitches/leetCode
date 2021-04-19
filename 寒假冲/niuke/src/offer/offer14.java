package offer;

import java.util.Stack;

public class offer14 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack stack = new Stack<Integer>();
        int i=0,j=0;
        while(j<popA.length) {
            if(!stack.empty() && stack.peek().equals(popA[j])){
                stack.pop();
                j++;
            }
            else if(i<pushA.length)
                 stack.push(pushA[i++]);
            else
                 return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
		int pushA[] = {1,2,3,4,5};
		int popA[] = {4,5,3,1,2};
		offer14 t = new offer14();
		System.out.println(t.IsPopOrder(pushA, popA));
	}
}
