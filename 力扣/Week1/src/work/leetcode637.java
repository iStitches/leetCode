package work;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class leetcode637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list=new ArrayList();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
        	double sum=0;
        	//1.每次遍历当前队列中的所有结点(位于同一层)
        	int length=queue.size();
        	for(int i=1;i<=length;i++) {
        		TreeNode temp=queue.poll();
        		sum+=temp.val;
        		//2.添加下一层的结点
        		if(temp.left!=null) {
        			queue.offer(temp.left);
        		}
        		if(temp.right!=null) {
        		    queue.offer(temp.right);
        		}
        	}
        	//3.计算当前层的平均值
        	list.add(sum/length);
        }
        return list;
   }
    @Test
    public void test() {
    	TreeNode tree=new TreeNode(3);
        TreeNode l1=new TreeNode(9);
        TreeNode r1=new TreeNode(20);
        TreeNode l2=new TreeNode(15);
        TreeNode r2=new TreeNode(7);
        r1.left=l2;
        r1.right=r2;
        tree.left=l1;
        tree.right=r1;
        averageOfLevels(tree);
    }
}
