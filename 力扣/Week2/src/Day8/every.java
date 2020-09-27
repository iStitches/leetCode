package Day8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public class every {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        ArrayDeque stack=new ArrayDeque();
        preorder(root,list,stack,sum);
        return list;
     }
    
    public void preorder(TreeNode root,List<List<Integer>> result,ArrayDeque<Integer> queue,int sum) {
        //如果结点为空，直接退出本次遍历
    	if(root == null) {
        	return;
        }
    	//如果为叶子结点并且值满足题意，则添加到result----此时还未添加进来
        if(root.left==null && root.right==null && sum==root.val)
        {
        	queue.addLast(root.val);
        	result.add(new ArrayList(queue));
        	//退出当次遍历前需要退栈保持原样---回溯
        	queue.removeLast();
        	return;
        }
        
        queue.addLast(root.val);
        preorder(root.left,result,queue,sum-root.val);
        //这里不用写 queue.pop(),因为既然能够遍历当前的右子树说明左子树的所有子树一定经过了下面的queue.pop()
        preorder(root.right,result,queue,sum-root.val);
        queue.removeLast();
    }
    
    public static void main(String[] args) {
		TreeNode n1=new TreeNode(5);
		TreeNode n2=new TreeNode(4);
		TreeNode n3=new TreeNode(8);
		TreeNode n4=new TreeNode(11);
		TreeNode n5=new TreeNode(13);
		TreeNode n6=new TreeNode(4);
		TreeNode n7=new TreeNode(7);
		TreeNode n8=new TreeNode(2);
		TreeNode n9=new TreeNode(5);
		TreeNode n10=new TreeNode(1);
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n3.left=n5;
		n3.right=n6;
		n4.left=n7;
		n4.right=n8;
		n6.left=n9;
		n6.right=n10;
		
		every t=new every();
		t.pathSum(n1, 22);
	}
}
