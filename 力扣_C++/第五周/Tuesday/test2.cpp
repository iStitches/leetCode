#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

class test2 {
public:
	vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
		vector<int> path;
		vector<vector<int>> res;
		sort(candidates.begin(), candidates.end());
		dfs(target, candidates, path, res, 0);
		return res;
	}

	void dfs(int target, vector<int> candidates, vector<int>& path,vector<vector<int>>& res, int begin){
		if (target < 0)
			return;
		if (target == 0)
		{
			res.push_back(path);
			return;
		}

		for (int i = begin; i < candidates.size(); i++){
			//对于当前层进行去重
			if (candidates[i] == candidates[i - 1])
				continue;
			
			path.push_back(candidates[i]);
			dfs(target - candidates[i], candidates, path, res, i + 1);   //注意题目中每个元素只允许使用一次，因此为i+1
			//回溯
			path.pop_back();
		}
	}
};