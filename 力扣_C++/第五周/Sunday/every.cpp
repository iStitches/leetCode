#include<iostream>
#include<vector>
using namespace std;

class every {
public:
	/*
	  采用 0 1 背包的思路来解决问题----未优化
	 */
	/*
	bool canPartition(vector<int>& nums) {
		int sum = 0,n=nums.size();
		//1.获取背包容量的一半
		for (int i = 0; i < n; i++)
			sum += nums[i];
		//首先所有元素的和必须是一个偶数
		if (sum % 2 != 0)
			return false;

		sum = sum / 2;
		//2.  0、1背包动态规划----注意因为结果要求的是刚好装满时的状态，因此初始化都为false，只有dp[0][0]初始化为true
		vector<vector<bool>> dp(n, vector<bool>(sum + 1, false));
		for (int i = 0; i < nums.size(); i++)
			dp[i][0] = true;
		for (int i = 1; i < dp.size(); i++){
			for (int j = 1; j <= sum; j++){
                //如果不装，则为原来的值
				dp[i][j] = dp[i - 1][j];
				//如果装，则必须保证能够装下
				if (nums[i] <= j)
					dp[i][j] = dp[i-1][j] || dp[i - 1][j - nums[i]];
			}
		}
		return dp[n-1][sum];
	}*/

	/*
	   01 背包优化，对空间进行优化处理
	 */
	bool canPartition(vector<int>& nums) {
		int sum = 0, n = nums.size();
		for (int i = 0; i < n; i++)
			sum += nums[i];
		if (sum % 2 != 0)
			return false;
		sum = sum / 2;
		vector<int> dp(sum + 1, 0);
		dp[0] = true;    //因为要完全装满，那么就只有dp[0]被初始化为0，其它的都为false，其它状态都只能由dp[0]推导而来

		for (int i = 1; i < n; i++)
			for (int j = sum; j >= 0; j--){
			if (j >= nums[i])
				dp[j] = dp[j - nums[i]] || dp[j];
			}
		return dp[sum];
	}
};

int main(){
	vector<int> nums{ 1,2,3,5};
	every t;
	cout<<t.canPartition(nums);
	int a = 2;
}