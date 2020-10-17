package Thursday;

import java.util.LinkedList;
/**
 * 二叉树的层序遍历
*/
class Node{
	int val;
	Node left;
	Node right;
	Node next;
	Node(){}
    Node(int _val) {
        val = _val;
    }
    Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class every {
//    public Node connect(Node root) {
//       bfs(root,new LinkedList());
//       return root;
//    }
//    
//    public void bfs(Node root,LinkedList<Node> queue) {
//    	if(root!=null)
//    		queue.add(root);
//    	Node pre=root;
//    	
//    	//层序遍历
//    	while(queue.size()>0) {
//    		int len=queue.size();
//    		for(int i=0;i<len;i++) {
//    			pre=queue.get(i);
//    			if(i+1<len)
//    			   pre.next=queue.get(i+1);
//    			pre=pre.next;
//    		}
//            for(int i=0;i<len;i++) {
//            	pre=queue.poll();
//            	if(pre.left!=null)
//            		queue.addLast(pre.left);
//            	if(pre.right!=null)
//            		queue.addLast(pre.right);
//            }
//    	}
//    }
	/**
	 * 方法二：遍历该层时同时设置好下一层的next指针
	 * @param root
	 * @return
	 */
	public Node connect(Node root) {
		Node head=root,tmp=head;

		while(tmp!=null && tmp.left!=null) {
			head=tmp;  //将该层的第一个结点记录下来
			while(tmp!=null) {
			    tmp.left.next=tmp.right;
			    if(tmp.next!=null)
			    	tmp.right.next=tmp.next.left;
			    tmp=tmp.next;
			}
			tmp=head.left;
		}
		return root;
	}
	
    
    public static void main(String[] args) {
		every t=new every();
		Node r1=new Node(1);
		Node r2=new Node(2);
		Node r3=new Node(3);
		Node r4=new Node(4);
		Node r5=new Node(5);
		Node r6=new Node(6);
		Node r7=new Node(7);
		r1.left=r2;
		r1.right=r3;
		r2.left=r4;
		r2.right=r5;
		r3.left=r6;
		r3.right=r7;
		
		t.connect(r1);
	}
}
