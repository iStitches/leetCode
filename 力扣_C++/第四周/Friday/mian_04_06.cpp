#include<iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class mian_04_06{
public:
    TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p) {
        TreeNode* pre=nullptr,*res=nullptr;
        inorderTranverse(root,p,pre,res);
        return res;
    }
    //注意在这里要用指针的引用来传递数值，因为需要不断递归调用，每次传入的参数的值必须更新，而指针作为特殊的存在，必须加上& 才能修改 
    void inorderTranverse(TreeNode* root,TreeNode* p,TreeNode*& pre,TreeNode*& res){
    	if(root==nullptr || res!=nullptr)
    	    return;
        inorderTranverse(root->left,p,pre,res);
        if(pre==p)
          res=root;
        pre=root;
        inorderTranverse(root->right,p,pre,res);
	}
};

int main(){
	TreeNode* t1=new TreeNode(1);
	TreeNode* t2=new TreeNode(2);
	TreeNode* t3=new TreeNode(3);
	t2->left=t1;
	t2->right=t3;
	mian_04_06 t;
	t.inorderSuccessor(t2,t1);
	delete t1;
	delete t2;
	delete t3;
}
