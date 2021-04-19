package sword_offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 剑指32_III {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> nodes = new ArrayList();
//         Deque<TreeNode> array = new ArrayDeque();
//         array.add(root);
//         int level = 0;
//         while(!array.isEmpty()) {
//        	 List<TreeNode> list = new ArrayList();
//        	 List<Integer> numList = new ArrayList();
//        	 while(!array.isEmpty()) {
//    			 TreeNode tmp = array.poll();
//    			 list.add(tmp);
//    			 numList.add(tmp.val);
//    		 }
//        	 //偶数层
//        	 if((level&1)==0) {
//            	 for(int i=list.size()-1;i>=0;i--) {
//           		  TreeNode node = list.get(i);
//           		  if(node.right!=null)
//           			  array.add(node.right);
//           		  if(node.left!=null)
//           			  array.add(node.left);
//	           	 }
//        	 }
//        	 //奇数层
//        	 else {
//            	 for(int i=list.size();i>=0;i--) {
//           		  TreeNode node = list.get(i);
//           		  if(node.left!=null)
//           			  array.add(node.left);
//           		  if(node.right!=null)
//           			  array.add(node.right);
//	           	 }
//        	 }
//        	 nodes.add(numList);
//         }
//         return nodes;
//    }
	
	/**
	 * 方法1： 层序遍历+双端队列   (在添加值val上面做文章)
	 * 思路： 使用双端队列tmp来存储当前层的数值，如果是偶数层则不变顺序正向添加；如果是奇数层则倒序添加。
	 * queue: 存储所有结点
	 * res: 存储结果
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> res = new ArrayList(); 
        if(root!=null) queue.add(root);
        //队列非空
        while(!queue.isEmpty()) {
        	LinkedList<Integer> tmp = new LinkedList();
        	for(int i=queue.size()-1;i>=0;i--) {
        		TreeNode tree = queue.poll();
        		//当前是偶数层，添加到尾部
        		if(res.size()%2==0) {
        			tmp.addLast(tree.val);
        		}
        		else
        			tmp.addFirst(tree.val);
        		//添加下一层的结点
        		if(tree.left!=null)
        			queue.offer(tree.left);
        		if(tree.right!=null)
        			queue.offer(tree.right);
        	}
        	res.add(tmp);
        }
        return res;
    }
	
	/**
	 * 方法2：层序遍历+倒序   (只需要列表一个数据结构，针对当前层数判断是否进行倒序操作)
	 */
	public List<List<Integer>> levelOrder2(TreeNode root){
		Queue<TreeNode> queue =new LinkedList();
		List<List<Integer>> res = new ArrayList();
		if(root != null) queue.add(root);
		//队列非空
		while(!queue.isEmpty()) {
			List<Integer> tmp = new ArrayList();
			for(int i=queue.size()-1;i>=0;i--) {
				TreeNode tree = queue.poll();
				tmp.add(tree.val);
				if(tree.left!=null)
					queue.add(tree.left);
				if(tree.right!=null)
					queue.add(tree.right);
			}
			//偶数层不变，奇数层倒置
			if(res.size()%2==1)
				Collections.reverse(tmp);
			res.add(tmp);
		}
		return res;
	}
}
