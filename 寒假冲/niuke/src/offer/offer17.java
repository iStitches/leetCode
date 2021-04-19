package offer;

public class offer17 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode root = pRootOfTree;
        while(pRootOfTree.left != null)
            pRootOfTree = pRootOfTree.left;
        connect(root);
        return pRootOfTree;
    }
    
    public void connect(TreeNode pRootOfTree){
        if(pRootOfTree == null)
           return;
        if(pRootOfTree.left==null && pRootOfTree.right==null)
        	return;
        connect(pRootOfTree.left);
        TreeNode leftNode=pRootOfTree.left,rightNode=pRootOfTree.right;
        while(leftNode!=null && leftNode.right!=null)
            leftNode=leftNode.right;
        while(rightNode!=null && rightNode.left!=null)
            rightNode = rightNode.left;
        leftNode.right = pRootOfTree;
        pRootOfTree.left = leftNode;
        pRootOfTree.right = rightNode;
        rightNode.left = pRootOfTree;
        connect(pRootOfTree.right);
    }
    
    public static void main(String[] args) {
		TreeNode t1 = new TreeNode(8);
		TreeNode t2 = new TreeNode(6);
		TreeNode t3 = new TreeNode(10);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(7);
		TreeNode t6 = new TreeNode(9);
		TreeNode t7 = new TreeNode(12);
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t3.left=t6;
		t3.right=t7;
		offer17 t = new offer17();
		t.Convert(t1);
	}
}
