#include<iostream>
#include<vector>
using namespace std;

class every_75_two{
public:
	/*
	 采用循环不变量的方法来操作，类似于快速排序，每次通过一次循环将数组分成三个部分，小于指定元素/等于指定元素/大于指定元素
	 */
	void sortColors(vector<int>& nums){
		int zero = 0, i = 0, two = nums.size();
        /*[0,zero)中的变量的值小于指定元素  (本题中为0)
		  [zero,i)中的变量的值等于指定元素  (本题中为1)
		  [two,len)中的变量的值大于指定元素   (本题中为2)
		  初始时zero和i都等于0，two=len为数组长度，那么当i=two的时候恰好覆盖了整个数组区间，就可以退出
		 */
		if (nums.size() < 2)
			return;

		while (i < two){
			//当前元素的值为0，那么nums[i]和nums[zero]的值就需要进行交换，把0换到前面去，zero和i就都可以前进一步
			if (nums[i] == 0){
				swap(nums, zero, i);
				zero++;
				i++;
			}
			//当前元素的值为1，只有i能继续前进，zero保持位置不变
			else if (nums[i] == 1)
				i++;
			//当前元素的值为2，则将nums[i]与nums[two]进行交换，将2换到后面去，注意two的初始值为len，因此需要先减1
			else {
				two--;
				swap(nums, i, two);
			}
		}
	}

	void swap(vector<int>& nums, int zero, int i){
		int temp = nums[zero];
		nums[zero] = nums[i];
		nums[i] = temp;
	}
};