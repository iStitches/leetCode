package offer;

/**
 * 旋转数组求最小值----二分法（局部有序）
 * @author dell
 *
 */
public class offer4 {
    public int test(int []array) {
        int left = 0;
        int right = array.length-1;
        int mid = 0;
        while(left<right){
            if(array[left]<array[right])
                return array[left];
            mid = (left+right)/2;
            if(array[mid]<array[right])
                right=mid;
            else if(array[mid]>array[right])
                left=mid+1;
            else 
                left++;
        }
        return array[left];
    }
    
    public static void main(String[] args) {
		offer4 t = new offer4();
		System.out.println(t.test(new int[] {1,2,2,2,2,2}));
	}
}
