#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

class every{

	/*
	特判，对于数组长度 n，如果数组为 null或者数组长度小于 3，返回[]。
	对数组进行排序。
	遍历排序后数组：
	若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
	对于重复元素：跳过，避免出现重复解
	令左指针 L=i+1，右指针 R=n-1，当 L<R 时，执行循环：
	当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将L,R 移到下一位置，寻找新的解
	若和大于 0，说明 nums[R] 太大，R 左移
	若和小于 0，说明 nums[L] 太小，L 右移
	*/
public:
	vector<vector<int>> threeSum(vector<int> &nums){
		vector<vector<int>> result;
		int len = nums.size();
		sort(nums.begin(), nums.end());
		if (len < 3)
			return result;

		else{
			for (int i = 0; i < len; i++){
				//已经由小到大排序了，如果当前大于0就一定大于0
				if (nums[i]>0) break;

				//去重
				if (i > 0 && nums[i] == nums[i - 1])
					continue;
				//前后比较,每次比较时只移动start，end位置始终不变
				int start = i + 1;
				int end = len - 1;

				//从当此的i开始循环寻找
				while (start < end){
					//如果找到了就加入到vector，同时要进行start和end的去重
					int sum = nums[start] + nums[end] + nums[i];
					if (sum == 0){
						int arr[] = { nums[start], nums[end], nums[i] };
						vector<int> cur(arr, arr + sizeof(arr) / sizeof(int));
						result.push_back(cur);
						//当次找到之后就需要进行双边的去重处理
						while (start < end && nums[start] == nums[start + 1])
							start++;
						while (end > start && nums[end] == nums[end - 1])
							end--;
						//去重结束后记得分别向中间靠齐
						start++;
						end--;
					}
					//当此如果没有找到，如果sum<0 那么往后移动start；如果sum>0 那么往前移动end
					else if (sum > 0)
						end--;
					else if (sum < 0)
						start++;
				}
			}
			return result;
		}
	}
};

int main(){
	every t;
	int arr[] = { -1, 0, 1, 2, -1, -4 };
	vector<int> nums(arr,arr+sizeof(arr)/sizeof(int));
	cout << "sdfsdfds";
	t.threeSum(nums);
}