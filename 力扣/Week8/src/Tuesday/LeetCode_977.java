package Tuesday;

public class LeetCode_977 {
    public int[] sortedSquares(int[] A) {
        for(int i=0;i<A.length;i++)
        	A[i]=(int) Math.pow(A[i], 2);
        quickSort(A,0,A.length-1);
        return A;
    }
    
    public void quickSort(int[] array,int start,int end) {
    	if(start<end) {
    		int index=getIndex(array, start, end);
    		quickSort(array, start, index-1);
    		quickSort(array, index+1, end);
    	}
    }
    
    
    public int getIndex(int[] array,int start,int end) {
    	int tmp=array[start];
    	while(start<end) {
    		while(array[end]>=tmp) {
    			end--;
    		}
    		array[start]=array[end];
    		while(array[start]<=tmp) {
    			start++;
    		}
    		array[end]=array[start];
    	}
    	array[start]=tmp;
    	return start;
    }
}
