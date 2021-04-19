package sword_offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ½£Ö¸41 {
	PriorityQueue<Integer> lowQueue;
	PriorityQueue<Integer> highQueue;
	int count=0;
	
    public ½£Ö¸41() {
         lowQueue = new PriorityQueue<Integer>((o1,o2)->o2-o1);
         highQueue = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
         if(count%2 == 0) {
        	 highQueue.offer(num);
        	 int max = highQueue.poll();
        	 lowQueue.offer(max);
         }
         else {
        	 lowQueue.offer(num);
        	 int min = lowQueue.poll();
        	 highQueue.offer(min);
         }
         count++;
    }
    
    public double findMedian() {
         if(count%2 == 0)
        	 return Double.valueOf((lowQueue.peek()+highQueue.peek())*1.0/2);
         else
        	 return Double.valueOf(lowQueue.peek());
    }
}
