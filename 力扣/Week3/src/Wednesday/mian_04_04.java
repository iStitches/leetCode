package Wednesday;

public class mian_04_04 {
	
    public boolean isBalanced(TreeNode root) {
         if(root == null)
        	 return true;
         int left=getDepth(root.left);
         int right=getDepth(root.right);
         if(Math.abs(left-right)>1)
        	 return false;
         return isBalanced(root.left) && isBalanced(root.right);
    }
    
    /**
     * 获取某一个结点的最大深度
     * @param root
     * @return
     */
    public int getDepth(TreeNode root) {
    	if(root == null)
    		return 0;
        int left=getDepth(root.left);
        int right=getDepth(root.right);
        return 1+(left>right?left:right);
    }
    
    public static void main(String[] args) {
		TreeNode r1=new TreeNode(1);
		TreeNode r2=new TreeNode(2);
		TreeNode r3=new TreeNode(3);
		TreeNode r4=new TreeNode(4);
		TreeNode r5=new TreeNode(5);
		TreeNode r6=new TreeNode(6);
		TreeNode r7=new TreeNode(7);
		r1.left=r2;
		r1.right=r3;
		r2.left=r4;
		r2.right=r5;
		r4.left=r6;
		r4.right=r7;
		
		mian_04_04 t=new mian_04_04();
		t.isBalanced(r1);
	}
}
