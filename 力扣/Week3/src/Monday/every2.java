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
     * ����һ���������
     */
//    public void bfs(Node root,LinkedList<Node> list) {
//    	while(list.size() > 0) {
//    		int len=list.size();
//    		Node tmp=list.get(0);
//    		//ѭ��������Ľ�㸳��nextֵ
//    		for(int i=1;i<len;i++) {
//    			Node next=list.get(i);
//    			
//    			if(next != null) {
//    				tmp.next=next;
//    				tmp=tmp.next;
//    			}
//    		}
//    		
//    		//������һ��Ľ��
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
     * �������������ǲ�����������ǲ���Ҫ�õ��������洢��������ÿһ�������ָ�봮������
     */
	public Node connect(Node root) {
		if(root == null)
			return root;
		//ѭ������ÿһ��,����ÿһ���ͬʱ��������һ�������
		Node cur=root;
		while(cur != null) {
			//dummy��¼ÿһ���ͷ,���������ǵ�����
			Node dummy=new Node();
			//tail���ڴ�������
			Node tail=dummy;
			
			//������ǰ��
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
			//�滻����һ��
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
