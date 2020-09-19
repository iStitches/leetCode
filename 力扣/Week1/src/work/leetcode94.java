package work;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.junit.Test;

public class leetcode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
          List<Integer> list=new ArrayList();
          Deque<TreeNode> stack=new ArrayDeque();
          TreeNode cur=root;
          stack.push(root);
          middleVisit(stack,list,root);
          return list;
    }
    
    public void middleVisit(Deque<TreeNode> stack,List<Integer> list,TreeNode cur) {
         if(stack.size()<=0)
        	 return;
         if(cur.left!=null) {
        	 stack.push(cur);
        	 middleVisit(stack, list, cur.left);
         }
         list.add(cur.val);
         stack.poll();
         if(cur.right!=null) {
        	 stack.push(cur);
        	 middleVisit(stack, list, cur.right);
         }
    }
    @Test
    public void test() {
    	TreeNode root=new TreeNode(1);
    	TreeNode r1=new TreeNode(2);
    	TreeNode l2=new TreeNode(3);
    	root.right=r1;
    	r1.left=l2;
    	
    	List<Integer> list=inorderTraversal(root);
    	System.out.println(list);
    }
}

