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

		vector<int> path;    //�洢ÿ�ִ𰸵�����
		deque<TreeNode*> q;  //˫�˶��м�¼���δ�ѡ���
		q.push_back(root);
		selectNode(q, path);
		return res;	
	}

	//ѡ�������
	void selectNode(deque<TreeNode*> &q, vector<int> &v){
		//1.������ε���ʱ����q���ˣ���ô��֤�����еĽ�㶼��ѡ���ˣ���ӵ�res��
		if (q.empty()){
			res.push_back(v);
			return;
		}

		//2.����Ӵ�ѡ���������ѡ���㣬Ȼ������µĽ��
		int len = q.size();
		for (int i = 0; i < len; i++){
			TreeNode* cur=q.front();
			q.pop_front();
			v.push_back(cur->val);

			if (cur && cur->left)
				q.push_back(cur->left);
			if (cur && cur->right)
				q.push_back(cur->right);
			//���еݹ�Ѱ���������
			selectNode(q, v);
            
			//����Ҫ��֤״̬��ȫ��ԭ����ÿ��ѡȡ���ʱ��Ӧ�ñ�����ͬ��״��
			if (cur && cur->left)
				q.pop_back();
			if (cur && cur->right)
				q.pop_back();
			//��һ���Ǵ�ͷȡֵ�����λ��ݾ�Ӧ����ӵ�β��
			q.push_back(cur);
			v.pop_back();
		}
	}
};