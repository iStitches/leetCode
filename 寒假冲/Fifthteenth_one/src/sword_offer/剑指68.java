package sword_offer;

import java.util.ArrayList;

public class 剑指68 {
	/**
	 * 获取p和q的公共父结点
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> list2 = new ArrayList<TreeNode>();
        getPath(root,p,list1);
        getPath(root,q,list2);
        int i = 0;
        while(i<list1.size() && i<list2.size()){
            if(list1.get(i) == list2.get(i))
                i++;
            else
                break;
        }
        return list1.get(i-1);
    }

	/**
	 * 记录从根节点到指定节点的路径
	 * @param root
	 * @param target
	 * @param list
	 * @return
	 */
    public boolean getPath(TreeNode root,TreeNode target,ArrayList<TreeNode> list){
        if(root == null)
           return false;
        list.add(root);
        if(root == target)
           return true;
        if(getPath(root.left,target,list) || getPath(root.right,target,list))
        	return true;
        list.remove(list.size()-1);
        return false;
    } 
    
    /**
     * 非递归解法，由于是二叉搜索树，比较特殊的做法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode getParent(TreeNode root,TreeNode p,TreeNode q) {
    	while(root != null) {
    		if(root.val<p.val && root.val<q.val) {
    			root = root.right;
    		}
    		else if(root.val>p.val && root.val>q.val)
    			root = root.left;
    		else
    			return root;
    	}
    	return null;
    }
    
    /**
     * 递归解法，二叉搜索树比较特殊解法
     * @param args
     */
    public TreeNode getParent1(TreeNode root,TreeNode p,TreeNode q) {
    	if(root.val<p.val && root.val<q.val)
    		return getParent1(root.right,p,q);
    	if(root.val>p.val && root.val>q.val)
    		return getParent1(root.left,p,q);
    	return root;
    }
    
    public static void main(String[] args) {
		TreeNode r1= new TreeNode(6);
		TreeNode r2= new TreeNode(2);
		TreeNode r3= new TreeNode(8);
		TreeNode r4= new TreeNode(0);
		TreeNode r5= new TreeNode(4);
		TreeNode r6= new TreeNode(7);
		TreeNode r7= new TreeNode(9);
		TreeNode r8= new TreeNode(3);
		TreeNode r9= new TreeNode(5);
		
		r1.left=r2; r1.right=r3;
		r2.left=r4; r2.right=r5;
		r3.left=r6; r3.right=r7;
		r5.left=r8; r5.right=r9;
		
		剑指68 t= new 剑指68();
		TreeNode node = t.lowestCommonAncestor(r1, r5, r6);
		System.out.println(node.val);
	}
}
