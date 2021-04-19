package sword_offer;

/**
 * 树的子结构
 * @author dell
 *
 */
public class 剑指26 {
	
	/**
	 * 如果树B 为树A的子结构：那么必须满足如下三种情况之一：
	 *    1. 以当前A的根节点为结点的树与以B为结点的树相同；
	 *    2. B为A的左子树的子树；
	 *    3. B为A的右子树的子树；
	 * @param A
	 * @param B
	 * @return
	 */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
         return (A!=null && B!=null)&&(dfs(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B));
    }
    
    /**
     * 判断B是否是以A为根结点的子树
     * @param A
     * @param B
     * @return
     */
    public boolean dfs(TreeNode A,TreeNode B) {
    	if(B==null) return true;
    	if(A==null || A.val!=B.val) return false;
    	return dfs(A.left,B.left)&&dfs(A.right,B.right);
    }
    
    public static void main(String[] args) {
		剑指26 t =new 剑指26();
		TreeNode l1=new TreeNode(1);
		TreeNode l2=new TreeNode(2);
		TreeNode l3=new TreeNode(3);
		TreeNode l4=new TreeNode(4);
		l1.left=l2;l1.right=l3;
		l2.left=l4;
		
		TreeNode r1=new TreeNode(3);
		t.isSubStructure(l1, r1);
	}
}
