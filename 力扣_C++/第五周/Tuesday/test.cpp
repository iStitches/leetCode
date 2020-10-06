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
		if (target == 0)     	//得到结果退出当次
		{
			res.push_back(tmp);
			return;
		}
		if (target < 0)  		//不满足条件，直接剪枝
			return;

		for (int i = begin; i < candidates.size(); i++)  //每一层的遍历，注意下一层不能使用上一层之前已经用过的点，因此从begin开始
		{
			tmp.push_back(candidates[i]);
			//dfs下一层
			dfs(i, candidates, tmp, target - candidates[i]);
			//回溯，做类型的但是相反的操作
			tmp.pop_back();
		}
	}
};