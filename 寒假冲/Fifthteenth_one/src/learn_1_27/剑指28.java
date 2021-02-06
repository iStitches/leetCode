package learn_1_27;

public class 剑指28 {
	/**
	 * 判断一棵二叉树是否是对称的
	 * 递归需要思考三点：
	 *     1.root的左结点和root的右节点是否相等；
	 *     2.递归下一层root的左节点的左节点和root的右节点的右节点是否相等；
	 *     3.递归的出口：有单方面的一方为空、结点值不相等
	 * @param root
	 * @return
	 */
	
    public boolean isSymmetric(TreeNode root) {
         if(root == null) return true;
         return rescu(root.left,root.right); 
    }
    
    public boolean rescu(TreeNode A,TreeNode B) {
    	if(A==null && B==null)return true;
    	if(A==null || B==null || A.val!=B.val) return false;
    	return rescu(A.left,B.right)&&rescu(A.right,B.left);
    }
}
