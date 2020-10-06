#include<iostream>
#include<vector>
using namespace std;

class test{

public:
	vector<vector<int>> res;

	vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
		vector<int> tmp;
		dfs(0, candidates, tmp, target);
		return res;
	}

	void dfs(int begin, vector<int> candidates,vector<int>& tmp,int target){
		if (target == 0)     	//�õ�����˳�����
		{
			res.push_back(tmp);
			return;
		}
		if (target < 0)  		//������������ֱ�Ӽ�֦
			return;

		for (int i = begin; i < candidates.size(); i++)  //ÿһ��ı�����ע����һ�㲻��ʹ����һ��֮ǰ�Ѿ��ù��ĵ㣬��˴�begin��ʼ
		{
			tmp.push_back(candidates[i]);
			//dfs��һ��
			dfs(i, candidates, tmp, target - candidates[i]);
			//���ݣ������͵ĵ����෴�Ĳ���
			tmp.pop_back();
		}
	}
};