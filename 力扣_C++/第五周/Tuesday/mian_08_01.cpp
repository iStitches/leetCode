#include<iostream>
using namespace std;

class mian_08_01{
public:

	/*
	   �򵥵Ķ�̬�滮���⣬����һ��ֻ����1/2/3������ô��������1����ʣ�µĲ�������֮ǰ�����������е��߷���
	                                              2����3�������Ƶġ�
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