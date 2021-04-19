package mianshi;

import java.util.Scanner;

public class Main {
	int res = 0;
	
    public static void main(String[] args) {
    	Main t = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++)
        	arr[i] = i;
        int l,r;
        while(k>0) {
        	l = sc.nextInt();
        	r= sc.nextInt();
        	t.reverse(arr,l,r);
        	k--;
        }
        t.MergeSort(arr, 1, arr.length-1);
        System.out.println(t.res);
    }
    
    public void reverse(int[] arr,int i,int j) {
    	while(i<j) {
    		int temp = arr[i];
    		arr[i] = arr[j];
    		arr[j] = temp;
    	    i++;
    	    j--;
    	}
    }
    
    public void merge(int[] arr,int start,int mid,int end) {
    	int[] tmp = new int[end-start+1];
    	int i=start,j=mid+1,k=0;
    	while(i<=mid && j<=end) {
    		if(arr[i] < arr[j])
    			tmp[k++] = arr[i++];
    		else {
    			res += mid-i+1;
    			tmp[k++] = arr[j++];
    		}
    	}
    	while(i<=mid) tmp[k++] = arr[i++];
    	while(j<=end) tmp[k++] = arr[j++];
    	
    	for(i=0;i<tmp.length;i++) {
    		arr[i+start] = tmp[i];
    	}
    }
    
    public void MergeSort(int[] arr,int start,int end) {
    	if(start<end) {
    		int mid = (start+end)/2;
    		MergeSort(arr, start, mid);
    		MergeSort(arr, mid+1, end);
    		merge(arr,start,mid,end);
    	}
    }
}
