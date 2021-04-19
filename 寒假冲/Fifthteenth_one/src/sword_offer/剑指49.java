package sword_offer;

public class 剑指49 {
	
    //找丑数
	/**
	 * * 思路：
	 * *     由于丑数的质因子只能是 2 3 5，也就是说丑数是由任意的这三个数的组合相乘起来的(1除外)，丑数乘以丑数为丑数
	 * *     那么我们需要做的就是每次取3个数各自乘法结果的最小值作为本次的丑数，并且将该数字的下标往后移动。
	 * * 解法：
	 * *     1.定义三个变量 i、j、k作为三个数的位置下标；
	 *       2.每次如果是在当前数字取得的丑数则将该数字下标位置加一(可能这一次三个数字的乘积都等于丑数，那么就都需要往后移一位)；
	 *       
	 * @param n
	 * @return
	 */
    public int nthUglyNumber(int n) {
        if(n == 1)
           return 1;
        int i=0,j=0,k=0,count=1,tmp1,tmp2,tmp3,max;
        int[] arr = new int[n];
        arr[0]=1;
        while(count<n){
            tmp1 = arr[i]*2;
            tmp2 = arr[j]*3;
            tmp3 = arr[k]*5;
            max = Math.min(Math.min(tmp1,tmp2),tmp3);
            arr[count] = max;
            if(max == tmp1)
               i++;
            if(max == tmp2)
               j++;
            if(max == tmp3) 
               k++;
            count++;
        }
        return arr[n-1];
    }
    
    public static void main(String[] args) {
		剑指49 t = new 剑指49();
		int res = t.nthUglyNumber(10);
		System.out.println(res);
	}
}
