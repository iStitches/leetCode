package Monday;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class every {
	/**
	 * 我的解法
	 * @param args
	 */
//    public Node connect(Node root) {
//    	if(root == null)
//    		return root;
//    	ArrayDeque queue=new ArrayDeque<Node>();
//    	queue.add(root);
//         bfs(root,queue);
//         return root;
//    }
//    
//    public void bfs(Node root,ArrayDeque<Node> queue) {
//		ArrayList<Node> list=new ArrayList();
//    	while(queue.size()>0) {
//    		list.clear();
//    		Node pre=null,next=null;
//    		//遍历当前层的所有结点
//    		while(queue.size()>0 || pre!=null) {
//    			if(pre == null)
//    				pre=queue.removeFirst();
//    			if(queue.size() > 0)
//        		    next=queue.removeFirst();
//    			else 
//    				next=null;
//        		pre.next=next;
//        		if(pre.left !=null) {
//        			list.add(pre.left);
//        		}
//        		if(pre.right !=null) {
//        			list.add(pre.right);
//        		}
//        		pre=next;
//    		}
//    		//添加结点进队列
//    		for(int i=0;i<list.size();i++) {
//    			queue.add(list.get(i));
//    		}
//    	}
//    }
	
	/**
	 * 大佬的解法 一
	 * 采用队列来存储临时结点
	 * @param args
	 */
//	public Node connect(Node root) {
//		if(root == null)
//			return root;
//		LinkedList<Node> queue=new LinkedList<Node>();
//		queue.add(root);
//		
//		//层序遍历
//		while(queue.size() > 0) {
//			//对当前队列中的所有结点进行next赋值操作
//			int len=queue.size();
//            Node temp=queue.get(0);
//            for(int i=1;i<len;i++) {
//            	temp.next=queue.get(i);
//            	temp=queue.get(i);
//            }
//            //加入子结点到queue中
//            for(int i=0;i<len;i++) {
//            	Node tmp=queue.removeFirst();
//            	if(tmp.left != null)
//            		queue.addLast(tmp.left);
//            	if(tmp.right != null)
//            		queue.addLast(tmp.right);
//            }
//		}
//		return root;
//	}
	/**
	 * 大佬解法二 -----迭代+递归
	 * 每一节点的左子树的next 等于 其右子树； 每一个节点的右子树的next等于其父节点的next的左子树--仍然是基于层序遍历
	 * @param args
	 */
//	public Node connect(Node root) {
//		if(root == null)
//		   return root;
//		Node pre=root;
//		//为每一个结点的左右子节点的next设置值
//		while(pre.left != null) {
//			
//			//遍历该层的所有pre结点，赋值
//			while(pre != null) {
//				pre.left.next=pre.right;
//				if(pre.next != null)
//				{
//					pre.right.next=pre.next.left;
//				}
//				pre=pre.next;
//			}
//
//		}
//		return root;
//	}
	/**
	 * 迭代解法----每次判断该列从头直到尾部的操作结果
	 * @param root
	 * @return
	 */
	public Node connect(Node root) {
		if(root == null)
			return root;
		Node left=root.left;
		Node right=root.right;
		//整个纵条竖切下来，指明每个点的next
		while(left != null) {
			left.next=right;
			left=left.right;
			right=right.left;
		}
		//递归调用左子树
		connect(root.left);
		//递归调用右子树
		connect(root.right);
		return root;
	}
    
    public static void main(String[] args) {
		Node root=new Node(1);
		Node root2=new Node(2);
		Node root3=new Node(3);
		Node root4=new Node(4);
		Node root5=new Node(5);
		Node root6=new Node(6);
		Node root7=new Node(7);
		
		root.left=root2;
		root.right=root3;
		root2.left=root4;
		root2.right=root5;
		root3.left=root6;
		root3.right=root7;
		every t=new every();
		t.connect(root);
	}
}
