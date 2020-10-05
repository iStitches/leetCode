#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

/*
  四数夹包求解
 */
class every2{
public:
	vector<vector<int>>  fourSum(vector<int> &nums, int target){
		vector<vector<int>> result;
		int len = nums.size();
		if (len < 4)
			return result;
	    //与3个数的解法类似，变成四个数的话只需要多加一层循环，即每次开头固定2个数，剩下2个夹包
		    //先排序才能夹包
		sort(nums.begin(), nums.end());
		for (int a = 0; a <= len - 4; a++){
			//每一次a比较完表示以当前a为开头的元素已经全部找到，剩下就是去重
			if (a>0 && nums[a] == nums[a - 1])
				continue;
			  //3个数求和
			for (int b = a + 1; b <= len - 3; b++){
				if (b>a+1 && nums[b] == nums[b - 1])
					continue;
				int start = b + 1;
				int end = len - 1;
				//2个数夹包
				while (start < end){
					int sum = nums[a] + nums[b] + nums[start] + nums[end];
					//找到一次结果
					if (sum == target){
						result.push_back({ nums[a], nums[b], nums[start], nums[end] });
						//找到一次结果后就可以对2个数的夹包进行去重了
						while (start < end && nums[start] == nums[start + 1])
							start++;
						while (start < end && nums[end] == nums[end - 1])
							end--;
						//去重完毕后记得向中间靠齐
						start++;
						end--;
					}
					else if (sum < target){
						start++;
					}
					else if (sum > target){
						end--;
					}
				}
			}
		}
		return result;
	}
};

int main(){
	every2 t;
	vector<int> v({ -2,-1,-1,1,1,2,2});
	vector<vector<int>> m=t.fourSum(v, 0);
	int a = 9;
}