#include<iostream>
#include<vector>
using namespace std;

class mian_08_04 {
public:
	vector<vector<int>> subsets(vector<int>& nums) {
		vector<int> path;
		vector<vector<int>> res;
		res.push_back(path);
		dfs(nums, res, path,0);
		return res;
	}

	void dfs(vector<int>& nums, vector<vector<int>>& res, vector<int>& path,int begin){
		if (begin >= nums.size())
			return;
		for (int i = begin; i < nums.size(); i++){
			path.push_back(nums[i]);
			res.push_back(path);
			dfs(nums, res, path, i + 1);
			path.pop_back();
		}
	}
};

int main(){
	vector<int> v{1,2,3};
	mian_08_04 t;
	t.subsets(v);
}