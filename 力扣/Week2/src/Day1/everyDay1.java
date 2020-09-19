package Day1;


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public class everyDay1 {
    public TreeNode invertTree(TreeNode root) {
         tranverse(root);
         return root;
    }
    
    public void tranverse(TreeNode root) {
        if(root==null)
          	 return;
   	   	 TreeNode temp=root.left;
   	   	 root.left=root.right;
   	   	 root.right=temp;
           invertTree(root.left);
           invertTree(root.right);   
    }
    
}


