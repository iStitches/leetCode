package sword_offer;

/**
 * �������������������
 * �ⷨ˼·��  �������Ĺ����������Ž���λ�õķֲ�����ͬ��
 *      1. ����������ֲ��ڸ��������ߣ���ô��������һ����root��
 *      2. ���������㶼�ֲ���root����������ô�ȱ������ľ������ȣ�
 *      3. ���������㶼�ֲ���root����������ô�ȱ������ľ������ȣ�
 * @author dell
 *
 */
public class ��ָ68_2 {
	/**
	 * ����ݹ麯��������������p��q �Ĺ������Ƚ���
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	//���ڵ�Ϊ��
        if(root == null)
        	return null;
        //����/�� �ҵ��˽��
        if(root==p || root==q)
        	return root;
        
        //�����������в������Ƚ��
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //Ȼ�����������в������Ƚ��
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        //������Ҷ����գ���ô���Ⱦ���root
        if(left!=null && right!=null)
        	return root;
        //�����߿գ�˵�����δ�ҵ��������ұ�
        if(left == null)
        	return right;
        if(right == null)
        	return left;
        //�������Ҷ�δ�ҵ�
        return null;
    }
}
