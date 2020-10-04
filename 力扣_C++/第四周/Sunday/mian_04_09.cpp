#include<iostream>
#include<vector>
#include<deque>
using namespace std;

struct TreeNode{
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) :val(x), left(NULL), right(NULL){}
};

class mian_04_09{
public:
	vector<vector<int>> res;

	vector<vector<int>>  BSTSequences(TreeNode *root){
		if (root == nullptr)
			return{ {} };

		vector<int> path;    //存储每种答案的数组
		deque<TreeNode*> q;  //双端队列记录本次待选结点
		q.push_back(root);
		selectNode(q, path);
		return res;	
	}

	//选择结点组合
	void selectNode(deque<TreeNode*> &q, vector<int> &v){
		//1.如果本次迭代时队列q空了，那么就证明所有的结点都被选择了，添加到res中
		if (q.empty()){
			res.push_back(v);
			return;
		}

		//2.否则从待选结点数组中选择结点，然后添加新的结点
		int len = q.size();
		for (int i = 0; i < len; i++){
			TreeNode* cur=q.front();
			q.pop_front();
			v.push_back(cur->val);

			if (cur && cur->left)
				q.push_back(cur->left);
			if (cur && cur->right)
				q.push_back(cur->right);
			//进行递归寻找其它结点
			selectNode(q, v);
            
			//回溯要保证状态完全还原，即每次选取结点时都应该保持相同的状况
			if (cur && cur->left)
				q.pop_back();
			if (cur && cur->right)
				q.pop_back();
			//上一次是从头取值，本次回溯就应该添加到尾部
			q.push_back(cur);
			v.pop_back();
		}
	}
};