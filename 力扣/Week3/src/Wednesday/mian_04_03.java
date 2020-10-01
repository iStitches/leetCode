package Wednesday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Wednesday.every;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class mian_04_03 {
    public ListNode[] listOfDepth(TreeNode tree) {
    	LinkedList<TreeNode> list=new LinkedList();
    	ListNode []array=null;
    	list.add(tree);
    	int length=bfs(tree,list,array);
    	array=new ListNode[length];
    	list.add(tree);
    	bfs(tree,list,array);
    	return array;
    }
    
    public int bfs(TreeNode tree,LinkedList<TreeNode> list,ListNode[] array) {
    	int level=0;
    	while(list.size() > 0) {
            int size=list.size();
            ListNode head=null,cur=null;
            for(int i=0;i<size;i++) {
            	//每次先弹出一个结点
            	TreeNode tmp= list.poll();
            	//连接起当层结点
            	if(i == 0){
            		head=new ListNode(tmp.val);
            		cur=head;
            	}
            	else {
            		ListNode t=new ListNode(tmp.val);
            		cur.next=t;
            		cur=t;
            	}
            	//存储下一层结点
            	if(tmp.left != null)
            		list.offer(tmp.left);
            	if(tmp.right != null)
            		list.offer(tmp.right);
            }
            if(array != null)
            	array[level]=head;
            level++;
    	}
    	return level;
    }
    
    public static void main(String[] args) {
		TreeNode r1=new TreeNode(1);
		TreeNode r2=new TreeNode(2);
		TreeNode r3=new TreeNode(3);
		TreeNode r4=new TreeNode(4);
		TreeNode r5=new TreeNode(5);
		TreeNode r6=new TreeNode(7);
		TreeNode r7=new TreeNode(8);
		r1.left=r2;
		r1.right=r3;
		r2.left=r4;
		r2.right=r5;
		r3.right=r6;
		r4.left=r7;
	    
		mian_04_03 t=new mian_04_03();
		t.listOfDepth(r1);
	}
}
