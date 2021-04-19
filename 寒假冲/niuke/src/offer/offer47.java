package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class offer47 {
	//声明一个大顶堆（默认）
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
    //声明一个小顶堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
    	@Override
    	public int compare(Integer o1, Integer o2){
    		return o2-o1;
    	}
	});
    int count = 0;
    
    /**
     * 每次插入大顶堆的是小顶堆中最小的数；
     * 每次插入小顶堆的是大顶堆中最大的数；
     * 这样就能够保证小顶堆中的数一定都大于大顶堆中的数；中位数就可以从两个堆中获取了。
     * @param num
     */
    public void Insert(Integer num) {
       //如果现在有偶数个，插入到大顶堆中，然后将大顶堆中的最大值插入到小顶堆中
       if(count%2 == 0) {
    	   maxHeap.offer(num);
    	   int max = maxHeap.poll();
    	   minHeap.offer(max);
       }
       //如果现在有奇数个，插入到小顶堆中，然后将小顶堆中的最小值插入到大顶堆中
       else {
    	   minHeap.offer(num);
    	   int min = minHeap.poll();
    	   maxHeap.offer(min);
       }
       count++;
    }

    public Double GetMedian() {
    	//总个数为偶数个，返回大顶堆和小顶堆个数的一半
        if(count%2 == 0)
        	return Double.valueOf((minHeap.peek()+maxHeap.peek())*1.0/2);
        //总个数为奇数个，直接返回小顶堆
        else
        	return Double.valueOf(minHeap.peek());
    }
}
