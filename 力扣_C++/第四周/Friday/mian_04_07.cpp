#include<iostream>
#include<vector>
#include<stack>
using namespace std;

struct TreeNode{
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x): val(x),left(NULL),right(NULL){}
}; 


class mian_04_08{
	public:
     TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
     	//获取到从根结点到两个节点的路径 
         vector<TreeNode*> pArray;
         vector<TreeNode*> qArray;
		 TreeNode* head=root;
		 getPath(head,p,pArray);
		 getPath(head,q,qArray);
		 
		 
		 while(pArray.size()>0 && qArray.size()>0)
		 {
		 	TreeNode* p1=pArray.back();
			TreeNode* q1=qArray.back();
			if(p1 == q1 && p1!=root)
			    return p1;
			pArray.pop_back();
			qArray.pop_back(); 
		 }
		 return root;

    }
    
     void getPath(TreeNode* root,TreeNode* target,vector<TreeNode*> &v){
     	if(root == NULL || root==target)
     	   return;
     	v.push_back(root);
     	getPath(root->left,target,v);
     	getPath(root->right,target,v);
	 }
};

int main(){
	TreeNode* h1=new TreeNode(3);
	TreeNode* h2=new TreeNode(5);
	TreeNode* h3=new TreeNode(1);
	TreeNode* h4=new TreeNode(6);
	TreeNode* h5=new TreeNode(2);
	TreeNode* h6=new TreeNode(0);
	TreeNode* h7=new TreeNode(8);
	TreeNode* h8=new TreeNode(7);
	TreeNode* h9=new TreeNode(4);
	
	h1->left=h2;
	h1->right=h3;
	h2->left=h4;
	h2->right=h5;
	h3->left=h6;
	h3->right=h7;
	h5->left=h8;
	h5->right=h9;
	
	mian_04_08 t;
	t.lowestCommonAncestor(h1,h2,h9);
}
