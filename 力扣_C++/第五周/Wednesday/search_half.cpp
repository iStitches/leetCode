#include<iostream>
#include<vector>
using namespace std;

class test{
public:
	//二分查找递归版本
/*	int BinarySearch(vector<int>& nums, int start, int end,int value){
		int mid = (start + end) / 2;     //首先比较mid处的值
		if (nums[mid] == value) 
			return mid;
		if (nums[mid] > value)           //大了就移动right
			return BinarySearch(nums, start, mid - 1, value);
		else                             //小了就移动left
			return BinarySearch(nums, mid + 1, end, value);
	}*/

	//非递归
	int BinarySearch(vector<int>& nums, int target){
		int start = 0, end = nums.size()-1,mid;
		while (start <= end){
			mid = (start + end) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}
};


/*int main(){
	vector<int> v{ 1, 2, 3, 4, 5, 5, 6, 6, 7 };
	test t;
	cout<<t.BinarySearch(v, 0, v.size() - 1, 4);
}*/