package Day9;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public class every {
    boolean flag=false;
	/**
	 * 方法一：构造集合存放路径，分别访问p和q,最后找公共的最后一个点
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        Deque<TreeNode> path1=new ArrayDeque();
//        Deque<TreeNode> path2=new ArrayDeque();
//        getPath(root, p, path1);
//        flag=false;
//        getPath(root,q,path2);
//        TreeNode result=null,n1=null,n2=null;
//        while(path1.size()>0 || path2.size()>0) {
//           if(path1.size()>0)
//        	   n1=path1.removeFirst();
//           if(path2.size()>0)
//        	   n2=path2.removeFirst();
//           result=n1==n2?n1:result;
//        }
//        return result;
//    }
//    /**
//     * 递归回溯获取从根结点到指定结点的路径
//     * @param root
//     * @param temp
//     * @param path
//     */
//    public void getPath(TreeNode root,TreeNode temp,Deque<TreeNode> path){
//    	if(root==null || flag) {
//    		return;
//    	}
//       	    path.addLast(root);
//       	    if(root == temp) {
//       	    	flag=true;
//       	    	return;
//       	    }
//            getPath(root.left,temp,path);
//            getPath(root.right,temp,path);
//            if(!flag)
//            path.removeLast();
//    }
    
    /**
     * 方法二：运用二叉搜索树的性质，根据p和q的大小与当前的root大小比较确定下一步root往哪边移动
     * @param args
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
        	return null;
        else if(root.val>p.val && root.val>q.val)
        	return lowestCommonAncestor(root.left, p, q);
        else if(root.val<p.val && root.val<q.val)
        	return lowestCommonAncestor(root.right, p, q);
        else 
        	return root;
    }
    
    public static void main(String[] args) {
		TreeNode h1=new TreeNode(6);
		TreeNode h2=new TreeNode(2);
		TreeNode h3=new TreeNode(8);
		TreeNode h4=new TreeNode(0);
		TreeNode h5=new TreeNode(4);
		TreeNode h6=new TreeNode(7);
		TreeNode h7=new TreeNode(9);
		TreeNode h8=new TreeNode(3);
		TreeNode h9=new TreeNode(5);
		
		h1.left=h2;
		h1.right=h3;
		h2.left=h4;
		h2.right=h5;
		h5.left=h8;
		h5.right=h9;
		h3.left=h6;
		h3.right=h7;
		
		every t=new every();
		t.lowestCommonAncestor(h1, h2, h5);
	}
}
