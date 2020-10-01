package Wednesday;


class TreeNode{
	int val;
	TreeNode right;
    TreeNode left;
    TreeNode(){}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

public class every {
    public TreeNode insertIntoBST(TreeNode root, int val) {
    	TreeNode head=root;
    	TreeNode pre=null;
        if(root == null)
        	return new TreeNode(val);
        while(root != null) {
        	pre=root;
        	if(root.val < val)
        		root=root.right;
        	else if(root.val > val)
        		root=root.left;	
        }
        if(pre.val < val)
        	pre.right=new TreeNode(val);
        else
        	pre.left=new TreeNode(val);
        
        return head;
    }
}
