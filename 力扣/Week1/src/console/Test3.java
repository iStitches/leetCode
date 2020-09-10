package console;

import java.util.Arrays;

import org.junit.Test;

public class Test3 {
	
	//将排序好的两个数组合并
    public void merge(int arr[],int start,int end,int mid) {
    	int []tmp=new int[arr.length];
    	int i,k,j;
    	i=k=start;
    	j=mid+1;
    	while(i<=mid && j<=end) {
    		if(arr[i]<arr[j]) {
    			tmp[k++]=arr[i++];
    		}
    		else
    			tmp[k++]=arr[j++];
    	}
    	while(i<=mid) {
    		tmp[k++]=arr[i++];
    	}
    	while(j<=end) {
    		tmp[k++]=arr[j++];
    	}
    	for(i=start;i<=end;i++) {
    		arr[i]=tmp[i];
    	}
    }
    
    //归并排序
    public void mergeSort(int arr[],int start,int end) {
    	if(start<end) {
    		int  mid=(start+end)/2;
    		mergeSort(arr,start,mid);
    		mergeSort(arr,mid+1,end);
    		merge(arr,start,end,mid);
    	}
    }
    
    @Test
    public void test() {
    	int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
    	mergeSort(a,0,a.length-1);
    	System.out.println(Arrays.toString(a));
    }
}
