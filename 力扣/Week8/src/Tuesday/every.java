package Tuesday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(int val){this.val=val;}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
         this.left = left;
         this.right = right;
     }
}


public class every {
    public List<Integer> preorderTraversal(TreeNode root) {
    	  List<Integer> list=new ArrayList();
          LinkedList<TreeNode> stack=new LinkedList();
          TreeNode tmp=root;
          while(tmp!=null || !stack.isEmpty()) {
        	  while(tmp!=null) {
        		  list.add(tmp.val);
        		  stack.push(tmp);
        		  tmp=tmp.left;
        	  }
        	  if(!stack.isEmpty()) {
        		  tmp=stack.pop();
        		  tmp=tmp.right;
        	  }
          }          
          return list;
    }
    
    public static void main(String[] args) {
		TreeNode node1=new TreeNode(2);
		TreeNode node2=new TreeNode(1);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode();
		TreeNode node5=new TreeNode(4);
		node1.left=node2;
		node1.right=node3;
		node2.right=node5;
		every t=new every();
		t.preorderTraversal(node1);
	}
}
