package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class offer47 {
	//����һ���󶥶ѣ�Ĭ�ϣ�
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
    //����һ��С����
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
    	@Override
    	public int compare(Integer o1, Integer o2){
    		return o2-o1;
    	}
	});
    int count = 0;
    
    /**
     * ÿ�β���󶥶ѵ���С��������С������
     * ÿ�β���С���ѵ��Ǵ󶥶�����������
     * �������ܹ���֤С�����е���һ�������ڴ󶥶��е�������λ���Ϳ��Դ��������л�ȡ�ˡ�
     * @param num
     */
    public void Insert(Integer num) {
       //���������ż���������뵽�󶥶��У�Ȼ�󽫴󶥶��е����ֵ���뵽С������
       if(count%2 == 0) {
    	   maxHeap.offer(num);
    	   int max = maxHeap.poll();
    	   minHeap.offer(max);
       }
       //��������������������뵽С�����У�Ȼ��С�����е���Сֵ���뵽�󶥶���
       else {
    	   minHeap.offer(num);
    	   int min = minHeap.poll();
    	   maxHeap.offer(min);
       }
       count++;
    }

    public Double GetMedian() {
    	//�ܸ���Ϊż���������ش󶥶Ѻ�С���Ѹ�����һ��
        if(count%2 == 0)
        	return Double.valueOf((minHeap.peek()+maxHeap.peek())*1.0/2);
        //�ܸ���Ϊ��������ֱ�ӷ���С����
        else
        	return Double.valueOf(minHeap.peek());
    }
}
