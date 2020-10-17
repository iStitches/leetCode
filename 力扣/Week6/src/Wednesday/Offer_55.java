package Wednesday;

/**
 * 平衡二叉树求深度
 * @author dell
 *
 */
class TreeNode{
	int val;
	TreeNode right;
	TreeNode left;
	TreeNode(int x){
		this.val=x;
	}
}


public class Offer_55 {
   boolean flag=true;	
	
   public boolean isBalanced(TreeNode root) {
	   if(root==null)
		   return flag;
	   int depth=Math.abs(dfs(root.left)-dfs(root.right));
	   if(depth>1) {
		   flag=false;
		   return false;
	   }
	   if(flag)
		   return isBalanced(root.left)&&isBalanced(root.right);
	   return flag;
   }
   
   //求以该节点为根的树的最大深度
   int dfs(TreeNode root) {
	   if(root==null)
		   return 0;
	   return Math.max(dfs(root.left),dfs(root.right))+1;
   }
}
