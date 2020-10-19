package WeekGame;

import java.util.Arrays;

public class Term1 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int index=(int) (arr.length*0.05);
        double sum=0;
        for(int i=index;i<=arr.length-index-1;i++) {
        	sum+=arr[i];
        }
        return sum/(arr.length-2*index);
    }
    public static void main(String[] args) {
		int arr[]={1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3};
		Term1 t=new Term1();
		t.trimMean(arr);
	}
}
