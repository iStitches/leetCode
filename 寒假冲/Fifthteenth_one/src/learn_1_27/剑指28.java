package learn_1_27;

public class ��ָ28 {
	/**
	 * �ж�һ�ö������Ƿ��ǶԳƵ�
	 * �ݹ���Ҫ˼�����㣺
	 *     1.root�������root���ҽڵ��Ƿ���ȣ�
	 *     2.�ݹ���һ��root����ڵ����ڵ��root���ҽڵ���ҽڵ��Ƿ���ȣ�
	 *     3.�ݹ�ĳ��ڣ��е������һ��Ϊ�ա����ֵ�����
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
