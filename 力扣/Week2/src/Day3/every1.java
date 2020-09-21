package Day3;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public class every1 {
	int result=0;
	
    public TreeNode convertBST(TreeNode root) {
        if(root.right!=null) {
        	convertBST(root.right);
        	root.val+=result;
        	result=root.val;
        	convertBST(root.left);
        }
        return root;
    }
}
