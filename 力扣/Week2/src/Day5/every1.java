package Day5;


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public class every1 {

	/**
	 * 我的写法
	 * @param args
	 */
//    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//    	 if(t1==null || t2==null) {
//    		 return t1==null?t2:t1;
//    	 }
//         merge(t1,t2);
//         return t1;
//    }
//    
//    public void merge(TreeNode t1,TreeNode t2) {
//    	if(t1!=null && t2!=null) {
//    		t1.val+=t2.val;
//    		merge(t1.left,t2.left);
//    		if(t1.left==null && t2.left!=null) {
//    			t1.left=t2.left;
//    		}
//    		merge(t1.right,t2.right);
//    		if(t1.right==null && t2.right!=null) {
//    			t1.right=t2.right;
//    		}
//    	}
//    }
	
	/**
	 * 大佬的写法
	 * @param args
	 */
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1==null || t2==null) {
			return t1==null?t2:t1;
		}
		return dfs(t1,t2);
	}
	public TreeNode dfs(TreeNode t1,TreeNode t2) {
		//递归出口----t1为空/t2为空
		if(t1==null || t2==null) {
			return t1==null?t2:t1;
		}
		//递归函数内----val相加，然后先序遍历
		t1.val+=t2.val;
		t1.left=dfs(t1.left,t2.left);
		t1.right=dfs(t1.right,t2.right);
		return t1;
	}
	
    
    public static void main(String[] args) {
//		TreeNode root1=new TreeNode(1);
//		TreeNode l1=new TreeNode(3);
//		TreeNode l2=new TreeNode(2);
//		TreeNode l3=new TreeNode(5);
//		root1.left=l1;
//		root1.right=l2;
//		l1.left=l3;
//		
//		TreeNode root2=new TreeNode(2);
//		TreeNode r1=new TreeNode(1);
//		TreeNode r2=new TreeNode(3);
//		TreeNode r3=new TreeNode(4);
//		TreeNode r4=new TreeNode(7);
//		root2.left=r1;
//		root2.right=r2;
//	    r1.right=r3;
//	    r2.right=r4;
    	TreeNode root1=null;
    	TreeNode root2=new TreeNode(1);
	    
	    
	    every1 t=new every1();
	    t.mergeTrees(root1, root2);
	}
}
