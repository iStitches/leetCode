#include<iostream>
#include<vector>
using namespace std;

class mian_08_09{
public:
	vector<string> generateParenthesis(int n) {
		vector<string> res;
		string tmp;
		dfs(res, tmp, n, n);
		return res;
	}

	//深度遍历+回溯法
	/*
	   将括号分为左右来放置，左右的个数相同，从空的根向下衍生出一棵二叉树；
	   生成一棵左子树表示在结果末尾添加一个左括号；
	   生成一棵右子树表示在结果末尾添加一个右括号；
	   但是只有当右括号数大于左括号数时才能进行括号的放置；
	   当左右括号数都为0的时候，放置结束
	 */
	void dfs(vector<string>& res, string& tmp, int left, int right){
		//当左右括号数均变成0  [保存退出]
		if (left == 0 && right == 0)
		{
			res.push_back(tmp);
			return;
		}
		//当左括号数 < 右括号数 [剪枝]
		if (left > right){
			return;
		}

		//左括号还有，先放置左括号
		if (left > 0)  //由于这里传递的是引用，全局而言只有一个tmp变量，因此需要回溯；如果不是引用，那么就需要每次生成一个新的字符串参与递归，那就不需要回溯
		{
			tmp.push_back('(');
			dfs(res, tmp, left - 1, right);
			tmp.pop_back();
		}
		
        //右括号还有，再放置右括号
		if (right > 0)
		{
			tmp.push_back(')');
			dfs(res, tmp, left, right - 1);
			tmp.pop_back();
		}
	}
};