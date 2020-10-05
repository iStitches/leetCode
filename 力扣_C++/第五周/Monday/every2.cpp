#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

/*
  �����а����
 */
class every2{
public:
	vector<vector<int>>  fourSum(vector<int> &nums, int target){
		vector<vector<int>> result;
		int len = nums.size();
		if (len < 4)
			return result;
	    //��3�����Ľⷨ���ƣ�����ĸ����Ļ�ֻ��Ҫ���һ��ѭ������ÿ�ο�ͷ�̶�2������ʣ��2���а�
		    //��������ܼа�
		sort(nums.begin(), nums.end());
		for (int a = 0; a <= len - 4; a++){
			//ÿһ��a�Ƚ����ʾ�Ե�ǰaΪ��ͷ��Ԫ���Ѿ�ȫ���ҵ���ʣ�¾���ȥ��
			if (a>0 && nums[a] == nums[a - 1])
				continue;
			  //3�������
			for (int b = a + 1; b <= len - 3; b++){
				if (b>a+1 && nums[b] == nums[b - 1])
					continue;
				int start = b + 1;
				int end = len - 1;
				//2�����а�
				while (start < end){
					int sum = nums[a] + nums[b] + nums[start] + nums[end];
					//�ҵ�һ�ν��
					if (sum == target){
						result.push_back({ nums[a], nums[b], nums[start], nums[end] });
						//�ҵ�һ�ν����Ϳ��Զ�2�����ļа�����ȥ����
						while (start < end && nums[start] == nums[start + 1])
							start++;
						while (start < end && nums[end] == nums[end - 1])
							end--;
						//ȥ����Ϻ�ǵ����м俿��
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