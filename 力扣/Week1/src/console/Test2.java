package console;

import java.util.Arrays;

import org.junit.Test;

public class Test2 {
    public void headAdjust(int arr[],int start,int end) {
    	int temp=arr[start];
    	int i=start*2+1;
    	while(i<=end) {
    		if(i+1<=end && arr[i]<arr[i+1])
    			i++;
    		if(arr[i]<=temp)
    			break;
    		arr[start]=arr[i];
    		start=i;
    		i=2*start+1;
    	}
    	arr[start]=temp;
    }
    
    public void headSort(int arr[],int len) {
    	int i;
    	//�ȶ��������Ϊ�󶥶�
    	for(i=len/2-1;i>=0;i--)
    		headAdjust(arr, i, len-1);
    	
    	//������
    	for(i=len-1;i>0;i--) {
    		//���Ѷ����ֵ�Ͷ�β��ֵ����
    		int temp=arr[i];
    		arr[i]=arr[0];
    		arr[0]=temp;
    		//���µ�����
    		headAdjust(arr, 0, i-1);
    	}
    }
    
    @Test
    public void test() {
    	int arr[]= {3,7,6,1,2,0,9,4};
    	headSort(arr, arr.length);
    	System.out.println(Arrays.toString(arr));
    }
}
