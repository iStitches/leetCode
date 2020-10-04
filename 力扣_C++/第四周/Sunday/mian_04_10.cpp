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
	//�ж�t2�Ƿ���t1������
	bool checkSubTree(TreeNode* t1, TreeNode* t2) {
		//ֻҪt2���ˣ���һ����t1������
		if (t2 == nullptr)
			return true;
		//t2���գ�t1���ˣ�˵������
		if (t1 == nullptr)
			return false;
		//�����գ���t1�в���t2�ĸ���㣬����Ҫ���߶�������ֻҪ��һ���ҵ������ˣ��û�
		if (t1->val != t2->val){
			return checkSubTree(t1->left, t2) || checkSubTree(t1->right, t2);
		}
		//�ҵ����ڵ���
		else{
			//�����ֱͬ�ӷ���
			return isSameTree(t1, t2);
		}
		//�����ҵ�����㵫�ǲ�ͬ������Ѱ��
		return checkSubTree(t1->left, t2) || checkSubTree(t1->right, t2);
	}


	//�Ա����������Ƿ�ȼ�
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