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
	 * �ҵĽⷨ
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
//    		//������ǰ������н��
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
//    		//��ӽ�������
//    		for(int i=0;i<list.size();i++) {
//    			queue.add(list.get(i));
//    		}
//    	}
//    }
	
	/**
	 * ���еĽⷨ һ
	 * ���ö������洢��ʱ���
	 * @param args
	 */
//	public Node connect(Node root) {
//		if(root == null)
//			return root;
//		LinkedList<Node> queue=new LinkedList<Node>();
//		queue.add(root);
//		
//		//�������
//		while(queue.size() > 0) {
//			//�Ե�ǰ�����е����н�����next��ֵ����
//			int len=queue.size();
//            Node temp=queue.get(0);
//            for(int i=1;i<len;i++) {
//            	temp.next=queue.get(i);
//            	temp=queue.get(i);
//            }
//            //�����ӽ�㵽queue��
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
	 * ���нⷨ�� -----����+�ݹ�
	 * ÿһ�ڵ����������next ���� ���������� ÿһ���ڵ����������next�����丸�ڵ��next��������--��Ȼ�ǻ��ڲ������
	 * @param args
	 */
//	public Node connect(Node root) {
//		if(root == null)
//		   return root;
//		Node pre=root;
//		//Ϊÿһ�����������ӽڵ��next����ֵ
//		while(pre.left != null) {
//			
//			//�����ò������pre��㣬��ֵ
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
	 * �����ⷨ----ÿ���жϸ��д�ͷֱ��β���Ĳ������
	 * @param root
	 * @return
	 */
	public Node connect(Node root) {
		if(root == null)
			return root;
		Node left=root.left;
		Node right=root.right;
		//������������������ָ��ÿ�����next
		while(left != null) {
			left.next=right;
			left=left.right;
			right=right.left;
		}
		//�ݹ����������
		connect(root.left);
		//�ݹ����������
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
