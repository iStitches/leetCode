#include<iostream>
#include<vector>
using namespace std;

struct TreeNode{
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) :val(x), left(nullptr), right(nullptr){}
};

class mian_04_12{
public:
	int counter = 0;
	int pathSum(TreeNode* root, int sum){
		if (root == nullptr)
			return 0;
		dfs(root, sum);
		pathSum(root->left, sum);
		pathSum(root->right, sum);
		return counter;
	}

	//��ȱ������root��ĳһ����Ϊtarget��·������
	void dfs(TreeNode* root, int target){
		//rootΪ��Ϊ�ݹ����
		if (root == nullptr)
			return;
		//��Ϊ����֤�����Լ���
		target -= root->val;
		//�������жϴ�ʱ�Ƿ����
		if (target == 0)
			counter++;
		//�����Ͼͼ������ұ���
		dfs(root->left, target);
		dfs(root->right, target);
	}
};


int main(){
/*	TreeNode* r = new TreeNode(5);
	TreeNode* r1 = new TreeNode(4);
	TreeNode* r2 = new TreeNode(8);
	TreeNode* r3 = new TreeNode(11);
	TreeNode* r4 = new TreeNode(13);
	TreeNode* r5 = new TreeNode(4);
	TreeNode* r6 = new TreeNode(7);
	TreeNode* r7 = new TreeNode(2);
	TreeNode* r8 = new TreeNode(5);
	TreeNode* r9 = new TreeNode(1);

	r->left = r1;
	r->right = r2;
	r1->left = r3;
	r2->left = r4;
	r2->right = r5;
	r3->left = r6;
	r3->right = r7;
	r5->left = r8;
	r5->right = r9;*/
	TreeNode* r = new TreeNode(1);
	TreeNode* r1 = new TreeNode(-2);
	TreeNode* r2 = new TreeNode(-3);
	TreeNode* r3 = new TreeNode(1);
	TreeNode* r4 = new TreeNode(3);
	TreeNode* r5 = new TreeNode(-2);
	TreeNode* r6 = new TreeNode(-1);
	r->left = r1;
	r->right = r2;
	r1->left = r3;
	r1->right = r4;
	r3->left = r6;
	r2->left = r5;


	mian_04_12 t;
	vector<int> path;
	vector<vector<int>> res;
	int count=t.pathSum(r, -1);
	cout << count;
}