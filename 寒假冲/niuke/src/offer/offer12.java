package offer;

/**
 * �ж�һ�����Ƿ�����һ����������(ע�ⲻ���ӽṹ)��
 * �����������ӽṹ�ĸ��� ---- ������ָҪ��ȫ��ͬ���ӽṹ����ָ������ͬ
 * 
 * ����˼·(������  A��B)��
 *    1. ���ҵ�A��B��ͬ�Ľڵ���Ϊ��㣻Ȼ�����A��B�����нڵ��Ƿ���ͬ��
 *    2. ���1����false����A����������B�ٴο�ʼִ��1��
 *    3. ���2����false����A����������B�ٴο�ʼִ��1��
 * @author dell
 *
 */
public class offer12 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    	if(root1==null || root2==null)
    		return false;
    	boolean result = false;
    	//1. ���жϵ�ǰroot2 �Ƿ�Ϊ root1������
    	if(root1.val == root2.val) {
    		result = isSubTree(root1,root2);
    	}
    	//2. ������ǣ��ж�root2 �Ƿ���root1������������
    	if(!result) result=HasSubtree(root1.left,root2);
    	//3. ������ǣ��ж�root2�Ƿ���root1������������
    	if(!result) result=HasSubtree(root1.right,root2);
    	return result;
    }
    
    /**
     * �ж�root2 �Ƿ��� root1������
     * @param root1
     * @param root2
     * @return
     */
    public boolean isSubTree(TreeNode root1,TreeNode root2) {
    	//���root2Ϊ�գ������Ѿ���������ͷ������true
    	if(root2 == null)
    		return true;
    	//���root2���գ�root1���ˣ��϶�����
    	if(root1 == null)
    		return false;
    	if(root1.val != root2.val) return false;
    	return isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);
    }
}
