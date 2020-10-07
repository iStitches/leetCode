#include<iostream>
#include<vector>
using namespace std;

class every_75_two{
public:
	/*
	 ����ѭ���������ķ����������������ڿ�������ÿ��ͨ��һ��ѭ��������ֳ��������֣�С��ָ��Ԫ��/����ָ��Ԫ��/����ָ��Ԫ��
	 */
	void sortColors(vector<int>& nums){
		int zero = 0, i = 0, two = nums.size();
        /*[0,zero)�еı�����ֵС��ָ��Ԫ��  (������Ϊ0)
		  [zero,i)�еı�����ֵ����ָ��Ԫ��  (������Ϊ1)
		  [two,len)�еı�����ֵ����ָ��Ԫ��   (������Ϊ2)
		  ��ʼʱzero��i������0��two=lenΪ���鳤�ȣ���ô��i=two��ʱ��ǡ�ø����������������䣬�Ϳ����˳�
		 */
		if (nums.size() < 2)
			return;

		while (i < two){
			//��ǰԪ�ص�ֵΪ0����ônums[i]��nums[zero]��ֵ����Ҫ���н�������0����ǰ��ȥ��zero��i�Ͷ�����ǰ��һ��
			if (nums[i] == 0){
				swap(nums, zero, i);
				zero++;
				i++;
			}
			//��ǰԪ�ص�ֵΪ1��ֻ��i�ܼ���ǰ����zero����λ�ò���
			else if (nums[i] == 1)
				i++;
			//��ǰԪ�ص�ֵΪ2����nums[i]��nums[two]���н�������2��������ȥ��ע��two�ĳ�ʼֵΪlen�������Ҫ�ȼ�1
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