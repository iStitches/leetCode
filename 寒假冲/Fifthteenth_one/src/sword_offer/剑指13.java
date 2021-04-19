package sword_offer;

/**
 * dfs解法
 * @author dell
 *
 */

public class 剑指13 {
    int count = 0;
    boolean flag[][] = null;
    public int movingCount(int m, int n, int k) {
        flag = new boolean[m][n];
        return dfs(m,n,0,0,k);
    }

    public int dfs(int m,int n,int i,int j,int k){
        if(i<0 || i>=m || j<0 || j>=n || calculate(i)+calculate(j)>k || flag[i][j])
           return 0;
        flag[i][j] = true;
        return count+1+dfs(m,n,i,j+1,k)+dfs(m,n,i+1,j,k);
    }
    
    public int calculate(int num) {
    	int allNum = 0;
    	int temp = 0;
    	while(num/Math.pow(10,temp)!=0) {
    		temp++;
    	}
    	for(int i=temp-1;i>=0;i--) {
    		allNum+=num/Math.pow(10,i);
    		num= (int) (num % Math.pow(10, i));
    	}
    	return allNum;
    }
    public static void main(String[] args) {
		剑指13 t = new 剑指13();
		System.out.println(t.movingCount(1, 2, 1));
	}
}
