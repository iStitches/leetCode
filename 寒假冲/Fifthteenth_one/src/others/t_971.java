package others;

import java.util.ArrayList;
import java.util.List;

public class t_971 {
	   List<Integer> list = new ArrayList();
	   int index = 0;
		
	   public List<Integer> flipMatchVoyage(TreeNode root,int[] voyage){
		   dfs(root,voyage);
		   if(list.contains(-1)) {
			   list.clear();
			   list.add(-1);
		   }
		   return list;
	   }
	   
	   public void dfs(TreeNode node,int[] voyage) {
		   if(node != null) {
			   if(node.val != voyage[index++]) {
				   list.clear();
				   list.add(-1);
				   return;
			   }
			   if(index<voyage.length && node.left!=null && node.left.val!=voyage[index]) {
				   list.add(node.val);
				   dfs(node.right,voyage);
				   dfs(node.left,voyage);
	            }else{
	                dfs(node.left,voyage);
	                dfs(node.right,voyage);
	           }
		   }
	   }
} 


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(int val){this.val=val;}
	TreeNode(int val,TreeNode left,TreeNode right){
		this.val=val;
		this.left=left;
		this.right=right;
	}
}
