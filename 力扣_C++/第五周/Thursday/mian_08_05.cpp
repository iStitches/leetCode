#include<iostream>
#include<vector>

using namespace std;

class mian_08_05 {
public:
	/*
	 ����Ҫ�����е�A����B�ƶ���C�������������Aֻ��1������ôֱ���ƶ���C�����A��n������ô����Ҫ�Ƚ�n-1���ƶ���B��Ȼ�����һ���ƶ���C
	 ����ٽ�n-1������A�ƶ���C��
	 */
	void hanota(vector<int>& A, vector<int>& B, vector<int>& C) {
		int n = A.size();
		move(n, A, B, C);
	}

	/*
	ע�����ͨ������n����¼��ǰ��A�ϵ�����������Ϊ�ڵݹ��״̬��A�е��������п��ܲ��䣬��ô�ͻᵼ�´���
	 */
	void move(int n, vector<int>& A, vector<int>& B, vector<int>& C){    
		//�ݹ�ĳ��ھ���A��������Ϊ1�������������Ҫ���ϵݹ��ƶ�A
		if (n == 1)
		{
			cout << "A��ʱ�Ĵ�С��"<<A.size();
			C.push_back(A.back());
			A.pop_back();
			return;
		}

		//��A��n-1������C�ƶ���B
		move(n-1,A, C, B);;
		//��A���һ���ƶ���C
		C.push_back(A.back());
		A.pop_back();
		//��B�е�n-1��ͨ��A�ƶ���C
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