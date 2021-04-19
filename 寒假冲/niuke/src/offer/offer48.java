package offer;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class offer48 {
	/**
	 * 优先队列解法
	 */
	PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1,Integer o2) {
			return o2-o1;
		}
	});
	
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if(size > num.length)
        	return null;
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        int i = 0;
        for(i=0;i<size;i++)
        	queue.offer(num[i]);
        res.add(queue.peek());
        
        for(i=size;i<num.length;i++) {
        	queue.remove(num[i-size]);
        	queue.add(num[i]);
        	res.add(queue.peek());
        }
        return res;
    }
    
    public static void main(String[] args) {
		offer48 t = new offer48();
		ArrayList<Integer> res = t.maxInWindows(new int[] {2,3,4,2,6,2,5,1}, 3);
		System.out.println(res.toString());
	}
}
