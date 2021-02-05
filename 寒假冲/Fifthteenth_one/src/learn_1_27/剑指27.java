package learn_1_27;

import java.util.ArrayDeque;
import java.util.Deque;

public class 剑指27 {
	/**
	 * 方法一：  递归法：
	 *    1.对于每一个根节点，交换它的左右子树即可；
	 *    2.递归的出口为该根节点为空时；
	 *    3.函数返回值为交换后当前树的根节点
	 * @param root
	 * @return
	 */
    public TreeNode mirrorTree1(TreeNode root) {
        if(root == null) return null;
        TreeNode left = root.left;
        root.left = mirrorTree1(root.right);
        root.right = mirrorTree1(left);
        return root;
    }
    
    /**
     * 方法二： 采用栈的方式解决：
     *    1.每次从栈中弹出一个结点，将它的左右子节点压栈；
     *    2.然后交换该结点的左右结点；
     *    3.循环直到最后栈为空为止
     * @param root
     * @return
     */
    public TreeNode mirrorTree2(TreeNode root) {
        Deque<TreeNode> stack=new ArrayDeque();
        stack.push(root);
        while(!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	if(node.left!=null) stack.push(node.left);
        	if(node.right!=null) stack.push(node.right);
        	TreeNode tmp = node.left;
        	node.left=node.right;
        	node.right=tmp;
        }
        return root;
    }
}
