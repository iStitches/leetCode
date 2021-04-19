package offer;

import java.util.Arrays;

/**
 * 找出数组中的逆序数对
 *  思路：采用归并法解决：
 *    归并法采用的思想是先分后治，在治理的过程中包括两个数组 A和数组B；
 *    在这两个数组中的所有元素都已经有序，那么如果此时 A[i]<B[j]，说明A[i]一定是当前所有剩余元素中的最小的元素；
 *    如果此时 A[i]>B[j]，说明A[i]及其之后的剩余元素的值一定大于此时的 B[j]，这些元素和B[j] 一起构成了逆序数对
 * @author dell
 *
 */
public class offer25 {
	
	int count = 0;
    public int InversePairs(int [] array) {
        mergeSort(array,0,array.length-1);
        return count;
    }
    
    void merge(int []array,int start,int mid,int end) {
    	int []temp = new int[end-start+1];
    	int i=start,j=mid+1,index=0;
    	
    	while(i<=mid && j<=end) {
    		if(array[i]<=array[j])
    			temp[index++] = array[i++];
    		else {
    			count += (mid-i+1);
                count = count%1000000007;
    			temp[index++] = array[j++];
    		}
    	}
    	while(i<=mid) temp[index++] = array[i++];
    	while(j<=end) temp[index++] = array[j++];
        for(index=0;index<temp.length;index++)
        	array[start++] = temp[index];
    }
    
    void mergeSort(int []array,int start,int end) {
    	if(start == end)
    		return;
		int mid = ((end-start)>>1)+start;
	    mergeSort(array,start,mid);
	    mergeSort(array,mid+1,end);
	    merge(array,start,mid,end);
    }
    
    public static void main(String[] args) {
		offer25 t = new offer25();
		int res = t.InversePairs(new int[] {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575});
		System.out.println(res);
	}
}
