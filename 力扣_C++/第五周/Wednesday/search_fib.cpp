#include<iostream>
#include<vector>
using namespace std;
const int max_size = 20;  //斐波拉契数组的长度

class test3{
public:
	//构造斐波拉契数列
	void Fibonacci(int *F){
		F[0] = 1;
		F[1] = 1;
		for (int i = 2; i < max_size; i++)
			F[i] = F[i - 1] + F[i - 2];
	}

	//斐波拉契查找
	int searchFib(vector<int>& v, int target){
		int F[max_size];
		int start = 0, end = v.size() - 1,len=v.size();
		Fibonacci(F);

		//首先确定斐波拉契的k
		int k = 0;
		while (len>F[k] - 1)
			k++;

	}
};