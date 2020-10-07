#include<iostream>
#include<vector>
using namespace std;

class every_75{
public:
	void sortColors(vector<int>& nums) {
		quickSort(nums, 0, nums.size() - 1);
	}
	//¿ìËÙÅÅĞò	
	void quickSort(vector<int>& nums, int low, int high){
		if (low < high){
			int index = getIndex(nums, low, high);
			quickSort(nums, low, index - 1);
			quickSort(nums, index + 1, high);
		}
	}

	int getIndex(vector<int>& nums, int start, int end){
			int temp = nums[start];
			while (start < end){
				while (end>start && nums[end] >= temp)
					end--;
				nums[start] = nums[end];
				while (start<end && nums[start] <= temp)
					start++;
				nums[end] = nums[start];
			}
			nums[start] = temp;
			return start;
		}
};

int main(){
	vector<int> v = {0};
	every_75 t;
	t.sortColors(v);
	int a = 2;
}