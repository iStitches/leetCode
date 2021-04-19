package sword_offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ��ָ32_III {
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
//        	 //ż����
//        	 if((level&1)==0) {
//            	 for(int i=list.size()-1;i>=0;i--) {
//           		  TreeNode node = list.get(i);
//           		  if(node.right!=null)
//           			  array.add(node.right);
//           		  if(node.left!=null)
//           			  array.add(node.left);
//	           	 }
//        	 }
//        	 //������
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
	 * ����1�� �������+˫�˶���   (�����ֵval����������)
	 * ˼·�� ʹ��˫�˶���tmp���洢��ǰ�����ֵ�������ż�����򲻱�˳��������ӣ������������������ӡ�
	 * queue: �洢���н��
	 * res: �洢���
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> res = new ArrayList(); 
        if(root!=null) queue.add(root);
        //���зǿ�
        while(!queue.isEmpty()) {
        	LinkedList<Integer> tmp = new LinkedList();
        	for(int i=queue.size()-1;i>=0;i--) {
        		TreeNode tree = queue.poll();
        		//��ǰ��ż���㣬��ӵ�β��
        		if(res.size()%2==0) {
        			tmp.addLast(tree.val);
        		}
        		else
        			tmp.addFirst(tree.val);
        		//�����һ��Ľ��
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
	 * ����2���������+����   (ֻ��Ҫ�б�һ�����ݽṹ����Ե�ǰ�����ж��Ƿ���е������)
	 */
	public List<List<Integer>> levelOrder2(TreeNode root){
		Queue<TreeNode> queue =new LinkedList();
		List<List<Integer>> res = new ArrayList();
		if(root != null) queue.add(root);
		//���зǿ�
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
			//ż���㲻�䣬�����㵹��
			if(res.size()%2==1)
				Collections.reverse(tmp);
			res.add(tmp);
		}
		return res;
	}
}
