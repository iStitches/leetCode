package offer;

import java.util.Arrays;

public class offer46 {
	
	/**
	 * �Ȼع��¶�����
	 *    1.ÿ�ε���start~end ��Χ�ڵĶ�--- HeapAdjustDown
	 *    2.�����С����Ͳ��ô���ѣ��Ӵ�С�Ͳ���С���ѣ�
	 *    3.��ʼ����ѣ������м�Ľڵ�(��һ����Ҷ�ӽڵ�)��ʼ��
	 * @param arr
	 * @param start
	 * @param end
	 */
	void HeapAdjustDown(int []arr,int start,int end) {
		int temp = arr[start];
		int i = start*2+1;
		
		while(i <= end) {
			//��ȡ�����ӽڵ��еĽϴ�ֵ
		    if(i+1<=end && arr[i+1]>arr[i])
		    	i++;
		    //�ж��Ƿ���Ҫ������
		    if(temp >= arr[i])
		    	break;
		    arr[start] = arr[i];
		    start = i;
		    i = 2*i+1;
		}
		arr[start] = temp;
	}
	
	void HeapSort(int []arr) {
	    /**
	     * ��ʼʱ������
	     * �� arr.length/2(��һ����Ҷ�ӽڵ㿪ʼ)�������֮��Ķ�ΪҶ�ӽڵ㣬�����������ʱֻ�ý�arr.length/2 ����Ϳ����ˣ�
	     * ֮��ÿ�μ��� arr[i-1]�Ϳ�����
	     */
		int i;
		for(i=arr.length/2-1;i>=0;i--)
	       	HeapAdjustDown(arr, i, arr.length-1);
		
		//ÿ�ν����ѵĵ�һ�������һ��Ԫ�أ�Ȼ����������
		for(i=arr.length-1;i>=0;i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			HeapAdjustDown(arr, 0, i-1);
		}
	}
	
	public static void main(String[] args) {
		int []arr = {6,1,3,9,5,4,2,7};
		offer46 t = new offer46();
		t.HeapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
