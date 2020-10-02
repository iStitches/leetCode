#include<iostream>
#include<vector>
using namespace std;

struct TreeNode{
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL){}
};


class mian_04_08{
public:

	TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
		//��ȡ���Ӹ���㵽�����ڵ��·�� 
		vector<TreeNode*> pArray, pPath, qArray, qPath;
		TreeNode* head = root,*result=nullptr;
		getPath(head, p, pArray,pPath);
		getPath(head, q, qArray,qPath);
        

		int len = pPath.size() < qPath.size() ? pPath.size() : qPath.size();
		for (int i = 0; i < len; i++){
			if (pPath[i] == qPath[i])
				result = pPath[i];
		}
		return result;
	}

	void getPath(TreeNode* root, TreeNode* target, vector<TreeNode*> &v, vector<TreeNode*> &Path){
		if (root == NULL)
			return;
		v.push_back(root);
		if (root == target){
			Path = v;
			return;
		}
		if (root->left != NULL)
			getPath(root->left, target, v,Path);
		if (root->right != NULL)
			getPath(root->right, target, v, Path);
		v.pop_back();
	}
};

int main(){
	TreeNode* h1 = new TreeNode(3);
	TreeNode* h2 = new TreeNode(5);
	TreeNode* h3 = new TreeNode(1);
	TreeNode* h4 = new TreeNode(6);
	TreeNode* h5 = new TreeNode(2);
	TreeNode* h6 = new TreeNode(0);
	TreeNode* h7 = new TreeNode(8);
	TreeNode* h8 = new TreeNode(7);
	TreeNode* h9 = new TreeNode(4);

	h1->left = h2;
	h1->right = h3;
	h2->left = h4;
	h2->right = h5;
	h3->left = h6;
	h3->right = h7;
	h5->left = h8;
	h5->right = h9;

	mian_04_08 t;
	t.lowestCommonAncestor(h1, h2, h9);
}
