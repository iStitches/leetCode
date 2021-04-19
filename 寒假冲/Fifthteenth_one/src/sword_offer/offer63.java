package sword_offer;

public class offer63 {
    public int maxProfit(int[] prices) {
        int len = prices.length,min = 0,max=0;
        if(len == 0)
            return 0;
        min = prices[0];
        int[] dp = new int[len+1];

        for(int i=2;i<=len;i++){
            int tmp = prices[i-1]-min;
            dp[i] = tmp>dp[i-1]?tmp:dp[i-1];
            min = min>prices[i-1]?prices[i-1]:min;
            max = max>dp[i]?max:dp[i];
        }
        return max;
    }
    
    public static void main(String[] args) {
		offer63 t = new offer63();
		System.out.println(t.maxProfit(new int[] {7,1,5,3,6,4}));
	}
}
