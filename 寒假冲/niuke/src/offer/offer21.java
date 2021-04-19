package offer;

public class offer21 {
	 TreeNode preNode = null,root = null;
	    
	    public TreeNode Convert(TreeNode pRootOfTree) {
	        if(pRootOfTree == null)
	            return null;
	        Convert(pRootOfTree.left);
	        if(root == null)
	            root = pRootOfTree;
	        
	        if(pRootOfTree!=null && pRootOfTree.left == null)
	            pRootOfTree.left = preNode;
	        if(preNode!=null && preNode.right == null)
	            preNode.right = pRootOfTree;
	        preNode = pRootOfTree;
	        Convert(pRootOfTree.right);
	        return root;
	    }
	    
	    TreeNode initTree(int[] array,int index) {
	    	TreeNode node = null;
	    	if(index<array.length) {
	    		node = new TreeNode(array[index]);
	    		node.left = initTree(array,index*2+1);
	    		node.right = initTree(array,index*2+2);
	    	}
	    	return node;
	    }
	    
	    public static void main(String[] args) {
	    	offer21 t = new offer21();
			int []arr = {10,6,14,4,8,12,16};
			TreeNode temp = t.initTree(arr,0);
			TreeNode root = t.Convert(temp);
		}
}
