package offer;

public class offer9 {
    public int jumpFloorII(int target) {
        if(target<=2)
        	return target;
        int arr[]= new int[target+1];
        arr[1]=1;
        arr[2]=2;
        int sum = arr[1]+arr[2];
        for(int i=3;i<=target;i++){
            arr[i]=sum+1;
            sum=sum+arr[i];
        }
        return arr[target];
    }
    public static void main(String[] args) {
		offer9 t = new offer9();
		System.out.println(t.jumpFloorII(1));
	}
}
