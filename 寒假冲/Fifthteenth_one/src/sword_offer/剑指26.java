package sword_offer;

/**
 * �����ӽṹ
 * @author dell
 *
 */
public class ��ָ26 {
	
	/**
	 * �����B Ϊ��A���ӽṹ����ô�������������������֮һ��
	 *    1. �Ե�ǰA�ĸ��ڵ�Ϊ����������BΪ��������ͬ��
	 *    2. BΪA����������������
	 *    3. BΪA����������������
	 * @param A
	 * @param B
	 * @return
	 */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
         return (A!=null && B!=null)&&(dfs(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B));
    }
    
    /**
     * �ж�B�Ƿ�����AΪ����������
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
		��ָ26 t =new ��ָ26();
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
