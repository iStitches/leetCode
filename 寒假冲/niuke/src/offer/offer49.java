package offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * �������ڣ�����������е����ֵ�ļ���
 * ˼·��
 *   1. ����ʱ�临�Ӷȣ�ÿ���ڻ�������ʱ�Ե�ǰ���ڵ����ֵ����һ����̬�ĸ���
 *   2. ��ô��Ҫά��һ���������У��ڶ�β���Ԫ�أ��ڶ���ɾ��Ԫ�أ�ʱ��ά�������е����ֵ(���ֵά���ڶ���)�����ֶ��е���ʹ���ѯʱ��Ϊ O(1)
 *   3. ˫�˶��У�
 *        �ڶ���ɾ��Ԫ�أ���Ϊ���ȳ����ˣ�����ɾ�����׵�Ԫ�أ�
 *        �ڶ�βɾ��Ԫ�أ���Ϊ��ǰԪ��ֵnum[i] �ȶ�β��Ԫ��ֵ nums[mq.getLast()]����ô֮ǰ������ֵ���ں������ڶ�����Чֵ����Ҫɾ�����£�
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
        	//�����ȳ���ʱɾ������Ԫ��(�洢�����±�)
        	if(!queue.isEmpty() && queue.getFirst()==i-size)
        		queue.removeFirst();
        	//��ǰԪ�ش��ڶ�βԪ��ֵ
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
