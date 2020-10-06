#include<iostream>
using namespace std;

class mian_08_01{
public:

	/*
	   简单的动态规划问题，由于一次只能走1/2/3步，那么可以先走1步，剩下的步数就是之前保存在数组中的走法；
	                                              2步、3步是类似的。
	 */
	int waysToStep(int n){
		long a = 1, b = 2, c = 4,temp;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (n == 3)
			return 4;
		for (int i = 4; i <= n; i++)
		{
			temp = (a + b + c) % 1000000007;
			a = b;
			b = c;
			c = temp;
		}
		return temp;
	}
};