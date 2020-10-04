#include<iostream>
using namespace std;

struct TreeNode{
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) :val(x), left(nullptr), right(nullptr){}
};

class mian_04_10 {
public:
	//判断t2是否是t1的子树
	bool checkSubTree(TreeNode* t1, TreeNode* t2) {
		//只要t2空了，就一定是t1的子树
		if (t2 == nullptr)
			return true;
		//t2不空，t1空了，说明不是
		if (t1 == nullptr)
			return false;
		//都不空，在t1中查找t2的根结点，不需要两边都遍历，只要在一边找到就行了，用或
		if (t1->val != t2->val){
			return checkSubTree(t1->left, t2) || checkSubTree(t1->right, t2);
		}
		//找到根节点了
		else{
			//如果相同直接返回
			return isSameTree(t1, t2);
		}
		//否则找到根结点但是不同，继续寻找
		return checkSubTree(t1->left, t2) || checkSubTree(t1->right, t2);
	}


	//对比两棵子树是否等价
	bool isSameTree(TreeNode* p, TreeNode* q) {
		if (p == nullptr && q == nullptr)
			return true;
		if (p == nullptr || q == nullptr)
			return false;
		if (p->val == q->val){
			return isSameTree(p->left, q->left)&&isSameTree(p->right,q->right);
		}
		return false;
	}
};