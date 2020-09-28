package Monday;

import java.util.LinkedList;

public class every2 {
//    public Node connect(Node root) {
//         LinkedList<Node> list=new LinkedList();
//         list.offer(root);
//         bfs(root,list);
//         return root;
//    }
    
    /**
     * 做法一：层序遍历
     */
//    public void bfs(Node root,LinkedList<Node> list) {
//    	while(list.size() > 0) {
//    		int len=list.size();
//    		Node tmp=list.get(0);
//    		//循环给当层的结点赋予next值
//    		for(int i=1;i<len;i++) {
//    			Node next=list.get(i);
//    			
//    			if(next != null) {
//    				tmp.next=next;
//    				tmp=tmp.next;
//    			}
//    		}
//    		
//    		//加入下一层的结点
//    		for(int i=0;i<len;i++) {
//    			tmp=list.poll();
//    			if(tmp.left != null)
//    				list.offer(tmp.left);
//    			if(tmp.right != null)
//    				list.offer(tmp.right);
//    		}
//    	}
//    }
    
    /**
     * 做法二：依旧是层序遍历，但是不需要用到队列来存储，仅仅将每一个结点用指针串联起来
     */
	public Node connect(Node root) {
		if(root == null)
			return root;
		//循环遍历每一层,遍历每一层的同时串联好下一层的链表
		Node cur=root;
		while(cur != null) {
			//dummy记录每一层的头,它仅仅起标记的作用
			Node dummy=new Node();
			//tail用于串联链表
			Node tail=dummy;
			
			//遍历当前层
			while(cur != null) {
				if(cur.left != null) {
					tail.next=cur.left;
					tail=tail.next;
				}
				if(cur.right != null) {
					tail.next=cur.right;
					tail=tail.next;
				}
				cur=cur.next;
			}
			//替换至下一层
            cur=dummy.next;
		}
		return root;
	}

    public static void main(String[] args) {
        Node h1=new Node(1);
        Node h2=new Node(2);
        Node h3=new Node(3);
        Node h4=new Node(4);
        Node h5=new Node(5);
        Node h6=new Node(7);
        
        h1.left=h2;
        h1.right=h3;
        h2.left=h4;
        h2.right=h5;
        h3.right=h6;

		every2 t=new every2();
		t.connect(h1);
	}
}
