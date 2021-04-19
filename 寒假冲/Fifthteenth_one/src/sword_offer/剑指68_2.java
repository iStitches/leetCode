package sword_offer;

/**
 * 二叉树的最近公共祖先
 * 解法思路：  两个结点的公共祖先随着结点的位置的分布而不同；
 *      1. 如果两个结点分布在根结点的两边，那么公共祖先一定是root；
 *      2. 如果两个结点都分布在root左子树，那么先遍历到的就是祖先；
 *      3. 如果两个结点都分布在root右子树，那么先遍历到的就是祖先；
 * @author dell
 *
 */
public class 剑指68_2 {
	/**
	 * 这个递归函数就是用来查找p和q 的公共祖先结点的
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	//根节点为空
        if(root == null)
        	return null;
        //在左/右 找到了结点
        if(root==p || root==q)
        	return root;
        
        //先在左子树中查找祖先结点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //然后在右子树中查找祖先结点
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        //如果左右都不空，那么祖先就是root
        if(left!=null && right!=null)
        	return root;
        //如果左边空，说明左边未找到，都在右边
        if(left == null)
        	return right;
        if(right == null)
        	return left;
        //否则左右都未找到
        return null;
    }
}
