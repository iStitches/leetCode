package sword_offer;

import java.util.Arrays;

/**
 * 摩尔投票法的应用：
 *   应用场景：选举出一个数组中出现次数超过数组长度一半的数
 *   算法思路：类似于国家混战，人数超过一半的国家一定是最后赢家(一比一比例牺牲)
 *   若记 众数 的票数为 +1 ，非众数 的票数为 -1 ，则一定有所有数字的 票数和 >0 ；
 *   若数组的前 a 个数字的 票数和=0 ，则 数组剩余 (n−a) 个数字的 票数和一定仍 >0 ，即后(n−a) 个数字的 众数仍为 x ；
 * @author dell
 *
 */
public class 剑指39 {
	//方法一：快速排序
    public int majorityElement() {
    	int[] arr = {2,5,7,4,1,2,4};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        return 1;
    }
    public void quickSort(int[] array,int start,int end) {
    	if(start<=end) {
    		int index = getIndex(array,start,end);
    		quickSort(array,start,index-1);
    		quickSort(array,index+1,end);
    	}
    }
    
    public int getIndex(int[] array,int start,int end) {
    	int tmp = array[start];
    	while(start<=end) {
    		while(start<=end && array[end]>=tmp) {
    			end--;
    		}
    		array[start] = array[end];
    		
    		while(start<=end && array[start]<tmp) {
    			start++;
    		}
    		array[end] = array[start];
    	}
    	array[start] = tmp;
    	return start;
    }
    
    
    //方法二：摩尔投票法
    public int majorityElement4(int[] nums) {
    	int x=0,votes=0,count=0;
    	
    	for(int num:nums) {
    		// 如果votes值为0，则选取当前数字为众数
    		if(votes == 0)
    		   x = num;
    		votes += num==x?1:-1;
    	}
    	for(int i=0;i<nums.length;i++)
    		count += nums[i]==x?1:0;
    	return count>nums.length/2?x:0;
    }
    
    public static void main(String[] args) {
    	剑指39 t = new 剑指39();
    	t.majorityElement();
	}
}
