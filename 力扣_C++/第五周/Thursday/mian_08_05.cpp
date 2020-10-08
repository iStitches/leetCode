#include<iostream>
#include<vector>

using namespace std;

class mian_08_05 {
public:
	/*
	 首先要将所有的A借助B移动到C；不妨想象如果A只有1个，那么直接移动到C；如果A有n个，那么就需要先将n-1个移动到B，然后将最后一个移动到C
	 最后再将n-1个借助A移动到C。
	 */
	void hanota(vector<int>& A, vector<int>& B, vector<int>& C) {
		int n = A.size();
		move(n, A, B, C);
	}

	/*
	注意必须通过设置n来记录当前层A上的盘子数，因为在递归的状态下A中的盘子数有可能不变，那么就会导致错误
	 */
	void move(int n, vector<int>& A, vector<int>& B, vector<int>& C){    
		//递归的出口就是A的盘子数为1，其它情况下需要不断递归移动A
		if (n == 1)
		{
			cout << "A此时的大小："<<A.size();
			C.push_back(A.back());
			A.pop_back();
			return;
		}

		//将A中n-1个借助C移动到B
		move(n-1,A, C, B);;
		//将A最后一个移动到C
		C.push_back(A.back());
		A.pop_back();
		//将B中的n-1个通过A移动到C
		move(n - 1, B, A, C);
	}
};

int main(){
	vector<int> A{ 2, 1, 0 };
	vector<int> B, C;
	mian_08_05 t;
	t.hanota(A, B, C);
	int a = 0;
}