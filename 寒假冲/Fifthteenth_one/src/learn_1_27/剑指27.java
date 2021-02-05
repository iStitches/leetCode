package learn_1_27;

import java.util.ArrayDeque;
import java.util.Deque;

public class ��ָ27 {
	/**
	 * ����һ��  �ݹ鷨��
	 *    1.����ÿһ�����ڵ㣬�������������������ɣ�
	 *    2.�ݹ�ĳ���Ϊ�ø��ڵ�Ϊ��ʱ��
	 *    3.��������ֵΪ������ǰ���ĸ��ڵ�
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
     * �������� ����ջ�ķ�ʽ�����
     *    1.ÿ�δ�ջ�е���һ����㣬�����������ӽڵ�ѹջ��
     *    2.Ȼ�󽻻��ý������ҽ�㣻
     *    3.ѭ��ֱ�����ջΪ��Ϊֹ
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
