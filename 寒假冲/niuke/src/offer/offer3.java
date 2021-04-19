package offer;

/**
 * 已知  二叉树 中序、前序 来构建二叉树
 * 扩展： 已知二叉树 中序、后序来构建二叉树
 * 注意： 已知二叉树 前序、后序不可以唯一确定一棵二叉树
 * @author dell
 *
 */
public class offer3 {
	 int[] pre;
	 int[] in;
	    
	    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
	        this.pre=pre;
	        this.in=in;
	        return dfs(0,pre.length-1,0,in.length-1);
	    }
	    
	    public TreeNode dfs(int pstart,int pend,int mstart,int mend){
	        if(pstart>pend || mstart>mend)
	            return null;
	        TreeNode root = new TreeNode(pre[pstart]);
	        for(int i=mstart;i<=mend;i++)
	            if(pre[pstart+1] == in[i]){
	                 root.left = dfs(pstart+1,pstart+i-mstart+1, mstart,i-1);
	                 root.right = dfs(pstart+i-mstart+2,pend,i+1,mend-1);
	                 break;
	            }
	        return root;
	    }
	    
	    public static void main(String[] args) {
	    	offer3 t = new offer3();
	    	TreeNode res =t.reConstructBinaryTree(new int[] {1,2,3,4,5,6,7},new int[] {3,4,2,6,7,5,1});
	    	System.out.println(res);
		}
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
