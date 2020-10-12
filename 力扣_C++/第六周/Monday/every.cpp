#include<iostream>
#include<math.h>
using namespace std;

struct TreeNode{
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) :val(x), left(NULL), right(NULL){}
};

class every{
public:
	int min = 10000;
	TreeNode *prev = NULL;
	int getMinimumDifference(TreeNode* root) {
		TreeNode* prev = NULL;
		dfs(root);
		return min;
	}

	void dfs(TreeNode* cur){
		if (cur == NULL)
			return;
		dfs(cur->left);
		if (prev){
			int tmp =abs(cur->val - prev->val);
			min = min > tmp ? tmp : min;
		}
		prev = cur;
		dfs(cur->right);
	}
};

int main(){
	TreeNode *h1 = new TreeNode(1);
	TreeNode *h2 = new TreeNode(3);
	TreeNode *h3 = new TreeNode(2);
	h1->right = h2;
	h2->left = h3;
	every t;
	t.getMinimumDifference(h1);
}