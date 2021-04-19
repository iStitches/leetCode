package sword_offer;

import java.util.LinkedList;

public class offer59_2 {
    LinkedList<Integer> queue1 = null;
    LinkedList<Integer> queue2 = null;

    public offer59_2() { 
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    
    public int max_value() {
        if(!queue1.isEmpty())
            return queue2.peek();
        return -1;
    }
    
    public void push_back(int value) {
        queue1.offer(value);
        while(!queue2.isEmpty() && queue2.getLast()<value)
            queue2.pollLast();
        queue2.offer(value);
    }
    
    public int pop_front() {
        if(!queue1.isEmpty())
        {
            int tmp = queue1.pollFirst();
            if(!queue2.isEmpty() && queue2.getFirst().equals(tmp))
               queue2.pollFirst();
            return tmp;
        }
        return -1;
    }
    
    public static void main(String[] args) {
		offer59_2 t = new offer59_2();
		System.out.println(t.max_value());
		t.push_back(1);
		t.push_back(2);
		System.out.println(t.max_value());
		System.out.println(t.pop_front());
		System.out.println(t.max_value());
	}
}
