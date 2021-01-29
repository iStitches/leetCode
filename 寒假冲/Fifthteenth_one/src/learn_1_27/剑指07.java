package learn_1_27;

import java.util.HashMap;
import java.util.Map;

public class ½£Ö¸07 {
    Map<Integer,Integer> map = new HashMap();
    int []post = null;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       for(int i=0;i<inorder.length;i++)
           map.put(inorder[i],i);
       post = postorder;
       return getRoot(0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode getRoot(int is,int ie,int ps,int pe){
        if(is>ie || ps>pe)
           return null;
        int index = map.get(post[pe]);
        TreeNode node =new TreeNode(post[pe]);
        node.left = getRoot(is,index-1,ps,ps+index-is-1);
        node.right = getRoot(index+1,ie,ps+index-is,pe-1);
        return node;
    }
	    
	    public static void main(String[] args) {
//	    	½£Ö¸07 t = new ½£Ö¸07();
//	    	t.deepDivide(is, ie, ps, pe)
		}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}