#include<iostream>
#include<vector>
using namespace std;
const int max_size = 20;  //쳲���������ĳ���

class test3{
public:
	//����쳲���������
	void Fibonacci(int *F){
		F[0] = 1;
		F[1] = 1;
		for (int i = 2; i < max_size; i++)
			F[i] = F[i - 1] + F[i - 2];
	}

	//쳲���������
	int searchFib(vector<int>& v, int target){
		int F[max_size];
		int start = 0, end = v.size() - 1,len=v.size();
		Fibonacci(F);

		//����ȷ��쳲�������k
		int k = 0;
		while (len>F[k] - 1)
			k++;

	}
};