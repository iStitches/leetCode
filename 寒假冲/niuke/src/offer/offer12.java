package offer;

/**
 * 判断一棵树是否是另一棵树的子树(注意不是子结构)。
 * 区分子树和子结构的概念 ---- 子树是指要完全相同，子结构则是指部分相同
 * 
 * 常规思路(两棵树  A和B)：
 *    1. 先找到A和B相同的节点作为起点；然后遍历A和B的所有节点是否相同；
 *    2. 如果1返回false，从A的左子树和B再次开始执行1；
 *    3. 如果2返回false，从A的右子树和B再次开始执行1；
 * @author dell
 *
 */
public class offer12 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    	if(root1==null || root2==null)
    		return false;
    	boolean result = false;
    	//1. 先判断当前root2 是否为 root1的子树
    	if(root1.val == root2.val) {
    		result = isSubTree(root1,root2);
    	}
    	//2. 如果不是，判断root2 是否是root1左子树的子树
    	if(!result) result=HasSubtree(root1.left,root2);
    	//3. 如果不是，判断root2是否是root1右子树的子树
    	if(!result) result=HasSubtree(root1.right,root2);
    	return result;
    }
    
    /**
     * 判断root2 是否是 root1的子树
     * @param root1
     * @param root2
     * @return
     */
    public boolean isSubTree(TreeNode root1,TreeNode root2) {
    	//如果root2为空，代表已经遍历到了头，返回true
    	if(root2 == null)
    		return true;
    	//如果root2不空，root1空了，肯定不行
    	if(root1 == null)
    		return false;
    	if(root1.val != root2.val) return false;
    	return isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);
    }
}
