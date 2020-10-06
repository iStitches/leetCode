#include<iostream>
#include<vector>
using namespace std;

class mian {
public:
	vector<int> findClosedNumbers(int num) {
		vector<int> front;
		vector<int> end;
		int tmp=0,count=0;
		//找到第一个非0数字，求出此时的front、end
		while (tmp == 0){
			tmp = num & 1;
			count++;
			num >>= 1;
		}
		front[count] = pow(2, count + 1);
		end[count] = pow(2, count - 1);

		//动态规划解决剩下数字
		while (num != 0){
			if ()
		}
	}
};