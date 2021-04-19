import java.util.LinkedList;
import java.util.Stack;

public class DequeTest {
    public static void main(String[] args) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		
		//队列
		/**
		 * 注意双端队列采用 push是头插法；而采用Stack使用的是尾插法
		 */
		for(int i=1;i<=4;i++)
			queue.offer(i);
		while(!queue.isEmpty())
			System.out.println(queue.poll());
		
		//栈
		for(int i=1;i<=4;i++) {
			queue.push(i);
			stack.push(i);
		}
			
		while(!queue.isEmpty())
			System.out.println(queue.pop());
	}
}
