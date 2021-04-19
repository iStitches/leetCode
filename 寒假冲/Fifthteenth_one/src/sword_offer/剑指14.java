package sword_offer;

/**
 * 动态规划---自底向上解法
 * @author dell
 *
 */
public class 剑指14 {
	public int cuttingRope(int n) {
		if(n==2)
			return 1;
		if(n==3)
			return 2;
		// res 数组代表长度为i 的绳子的最大乘积
		// 注意res[2]此时为2不为1，因为绳子长度此时大于3，那么如果划分到了长度为2的一段就不应该被切割，保持原绳子长度即可
		int []res = new int[n+1];
		res[0]=0;
		res[1]=1;
		res[2]=2;
		res[3]=3;
		for(int i=4;i<=n;i++) {
			int tempMax = 0;
			for(int j=1;j<=i/2;j++) {
				tempMax = Math.max(tempMax,res[j]*res[i-j]);
			}
			res[i] = tempMax;
		}
		return res[n];
	}
	
	public static void main(String[] args) {
		剑指14 t = new 剑指14();
		System.out.println(t.cuttingRope(10));
	}
}
