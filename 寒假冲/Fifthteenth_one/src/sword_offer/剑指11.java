package sword_offer;

public class ½£Ö¸11 {
    public int minArray(int[] numbers) {
        int i=0,j=numbers.length-1,m;
        while(i<j){
        	m=(i+j)/2;
            if(numbers[m] < numbers[j])
               j=m;
            else if(numbers[m] > numbers[j])
               i=m+1;
            else
               j=j-1;
        }
        return numbers[i];
    }
    public static void main(String[] args) {
		½£Ö¸11 t =new ½£Ö¸11();
		int []arr = new int[]{3,1,3};
		System.out.println(t.minArray(arr));
	}
}
