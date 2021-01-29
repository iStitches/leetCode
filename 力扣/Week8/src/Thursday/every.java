package Thursday;

import java.util.ArrayDeque;
import java.util.ArrayList;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 };
 
public class every {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    
    public int dfs(TreeNode cur,int res) {
        if(cur==null)
        	return 0;
        res=res*10+cur.val;
        if(cur.left==null && cur.right==null)
        	return res;
        
        return dfs(cur.left,res)+dfs(cur.right,res);
    }
    
    public static void main(String[] args) {
		every t=new every();
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
	    t1.left=t2;
	    t1.right=t3;
	    t.sumNumbers(t1);
	}
    
}
