package offer;

import java.util.Arrays;

public class offer46 {
	
	/**
	 * 先回顾下堆排序
	 *    1.每次调整start~end 范围内的堆--- HeapAdjustDown
	 *    2.排序从小到大就采用大根堆；从大到小就采用小根堆；
	 *    3.初始构造堆，从最中间的节点(第一个非叶子节点)开始；
	 * @param arr
	 * @param start
	 * @param end
	 */
	void HeapAdjustDown(int []arr,int start,int end) {
		int temp = arr[start];
		int i = start*2+1;
		
		while(i <= end) {
			//获取左右子节点中的较大值
		    if(i+1<=end && arr[i+1]>arr[i])
		    	i++;
		    //判断是否需要调整堆
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
	     * 初始时构建堆
	     * 从 arr.length/2(第一个非叶子节点开始)，因此这之后的都为叶子节点，所以最初构造时只用将arr.length/2 加入就可以了；
	     * 之后每次加入 arr[i-1]就可以了
	     */
		int i;
		for(i=arr.length/2-1;i>=0;i--)
	       	HeapAdjustDown(arr, i, arr.length-1);
		
		//每次交换堆的第一个和最后一个元素，然后重新排序
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
