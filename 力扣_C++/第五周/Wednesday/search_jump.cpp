#include<vector>
#include<iostream>
using namespace std;

class test2{
public:
	//��ֵ����----�ݹ��
	int InsertSearch(vector<int>& nums, int target,int start,int end){

		//�����Ǽ����е�ֵ�����Ǹ��ݽ����ռ�ı���������
		int mid = start + (target - nums[start]) / (nums[end] - nums[start])*(end-start);   
		if (nums[mid] == target)
			return mid;
		else if (nums[mid] > target)
			return InsertSearch(nums, target, start, mid - 1);
		else
			return InsertSearch(nums, target, mid + 1, end);
	}
};


int main(){
	vector<int> v{ 1, 2, 3, 4, 5, 5, 6, 6, 7 };
	test2 t;
	cout << t.InsertSearch(v, 4,0, v.size() - 1);
}