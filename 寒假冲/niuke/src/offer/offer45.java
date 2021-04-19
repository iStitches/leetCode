package offer;

import java.util.ArrayList;
import java.util.Stack;

public class offer45 {
	//中序遍历非递归
	public void Inorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(!stack.isEmpty() || root!=null) {
			//深度左遍历
			if(root!=null && root.left!=null) {
				stack.push(root);
				root = root.left;
				continue;
			}
			//到达左叶子或者遍历完成
			if(root == null) {
				if(!stack.isEmpty()) {
					root = stack.pop();
				}
				else
					break;
			}
			//访问节点、访问右子树
			System.out.println(root.val);
			root = root.right;
		}
	}
	
	//先序遍历非递归
	public void preOrder(TreeNode root) {
	   Stack<TreeNode> stack = new Stack<TreeNode>();
	   while(!stack.isEmpty() || root!=null) {
		   if(root!=null) {
			   System.out.println(root.val);
			   stack.push(root);
			   root = root.left;
			   continue;
		   }
		   if(root==null) {
			   if(!stack.isEmpty()) {
				   root = stack.pop();
			   }
			   else 
				   break;
		   }
		   root = root.right;
	   }
	}
	
	//后序遍历非递归----左右根----> 根右左----->根左右
	public void afterOrder(TreeNode root) {
	   	ArrayList<Integer> list = new ArrayList<Integer>();
	   	Stack<TreeNode> stack = new Stack<TreeNode>();
	   	while(!stack.isEmpty() || root!=null) {
	   		if(root!=null) {
	   			stack.push(root);
	   			list.add(root.val);
	   			root = root.right;
	   			continue;
	   		}
	   		if(root==null) {
	   			if(!stack.isEmpty()) {
	   				root = stack.pop();
	   			}
	   			else
	   				break;
	   		}
	   		root = root.left;
	   	}
	   	for(int i=list.size()-1;i>=0;i--) {
	   		System.out.println(list.get(i));
	   	}
	}
	
	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(5);
		TreeNode r6 = new TreeNode(6);
		TreeNode r7 = new TreeNode(7);
		r1.left=r2;r1.right=r3;
		r2.left=r4;r2.right=r5;	
		r3.left=r6;r3.right=r7;
		
		offer45 t = new offer45();
		t.afterOrder(r1);
	}
}
