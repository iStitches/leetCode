#include<iostream>
#include<vector>
using namespace std;

class every {
public:
	/*
	  ���� 0 1 ������˼·���������----δ�Ż�
	 */
	/*
	bool canPartition(vector<int>& nums) {
		int sum = 0,n=nums.size();
		//1.��ȡ����������һ��
		for (int i = 0; i < n; i++)
			sum += nums[i];
		//��������Ԫ�صĺͱ�����һ��ż��
		if (sum % 2 != 0)
			return false;

		sum = sum / 2;
		//2.  0��1������̬�滮----ע����Ϊ���Ҫ����Ǹպ�װ��ʱ��״̬����˳�ʼ����Ϊfalse��ֻ��dp[0][0]��ʼ��Ϊtrue
		vector<vector<bool>> dp(n, vector<bool>(sum + 1, false));
		for (int i = 0; i < nums.size(); i++)
			dp[i][0] = true;
		for (int i = 1; i < dp.size(); i++){
			for (int j = 1; j <= sum; j++){
                //�����װ����Ϊԭ����ֵ
				dp[i][j] = dp[i - 1][j];
				//���װ������뱣֤�ܹ�װ��
				if (nums[i] <= j)
					dp[i][j] = dp[i-1][j] || dp[i - 1][j - nums[i]];
			}
		}
		return dp[n-1][sum];
	}*/

	/*
	   01 �����Ż����Կռ�����Ż�����
	 */
	bool canPartition(vector<int>& nums) {
		int sum = 0, n = nums.size();
		for (int i = 0; i < n; i++)
			sum += nums[i];
		if (sum % 2 != 0)
			return false;
		sum = sum / 2;
		vector<int> dp(sum + 1, 0);
		dp[0] = true;    //��ΪҪ��ȫװ������ô��ֻ��dp[0]����ʼ��Ϊ0�������Ķ�Ϊfalse������״̬��ֻ����dp[0]�Ƶ�����

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