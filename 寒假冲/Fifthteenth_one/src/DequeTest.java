import java.util.LinkedList;
import java.util.Stack;

public class DequeTest {
    public static void main(String[] args) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		
		//����
		/**
		 * ע��˫�˶��в��� push��ͷ�巨��������Stackʹ�õ���β�巨
		 */
		for(int i=1;i<=4;i++)
			queue.offer(i);
		while(!queue.isEmpty())
			System.out.println(queue.poll());
		
		//ջ
		for(int i=1;i<=4;i++) {
			queue.push(i);
			stack.push(i);
		}
			
		while(!queue.isEmpty())
			System.out.println(queue.pop());
	}
}
