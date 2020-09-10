package console;
import java.util.Arrays;

import org.junit.Test;

public class Test1{
    public int getIndex(int arr[],int start,int end) {
    	int temp =arr[start];
    	while(start<end) {
    		while(start<end && arr[end]>=temp) {
    			end--;
    		}
    		arr[start]=arr[end];
    		while(start<end && arr[start]<=temp) {
    			start++;
    		}
    		arr[end]=arr[start];
    	}
    	arr[start]=temp;
    	return start;
    }
    
    public void quickSort(int arr[],int start,int end) {
    	if(start<end) {
    		int index=getIndex(arr, start, end);
    		quickSort(arr, start, index-1);
    		quickSort(arr, index+1,end);
    	}
    }
    
    @Test
    public void test() {
    	int arr[]= {2,5,3,1,15,12,42,98,79};
    	quickSort(arr, 0, arr.length-1);
    	System.out.println(Arrays.toString(arr));
    }
	
}