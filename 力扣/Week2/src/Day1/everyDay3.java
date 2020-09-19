package Day1;


class TreeNode{
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x){val=x;}
}


public class everyDay3 {
	int res=0;
	
    public int sumOfLeftLeaves(TreeNode root) {
    	traverse(root,false);
    	return res;
    }
    
    public void traverse(TreeNode root,boolean isLeft) {
    	if(root == null)
    		return;
    	if(root.left==null && root.right==null && isLeft) {
    		res+=root.val;
    		return;
    	}
    	
    	//往左就可能有左叶子
    	traverse(root.left,true);
    	//往右一定没有左叶子
    	traverse(root.right,false);
    }
}
