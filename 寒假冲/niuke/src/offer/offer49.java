package offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 滑动窗口，求解多个窗口中的最大值的集合
 * 思路：
 *   1. 线性时间复杂度：每次在滑动窗口时对当前窗口的最大值进行一个动态的更新
 *   2. 那么需要维护一个单调队列：在队尾添加元素，在队首删除元素，时刻维护队列中的最大值(最大值维护在队首)，保持队列单调使其查询时间为 O(1)
 *   3. 双端队列：
 *        在队首删除元素：因为长度超过了，必须删除队首的元素；
 *        在队尾删除元素：因为当前元素值num[i] 比队尾的元素值 nums[mq.getLast()]大，那么之前的所有值对于后续窗口都是无效值，需要删除更新；
 * @author dell
 *
 */
public class offer49 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(size==0 || size>num.length)
        	return res;
   
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        for(int i=0;i<num.length;i++) {
        	//当长度超过时删除队首元素(存储的是下标)
        	if(!queue.isEmpty() && queue.getFirst()==i-size)
        		queue.removeFirst();
        	//当前元素大于队尾元素值
        	while(!queue.isEmpty() && num[i]>num[queue.getLast()])
        		queue.removeLast();
        	queue.addLast(i);
        	if(i>=size-1)
        		res.add(num[queue.getFirst()]);
        }
        return res;
    }
    
    public static void main(String[] args) {
		
	}
}
