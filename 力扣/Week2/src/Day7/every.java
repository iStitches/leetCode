package Day7;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public class every {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return initTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    
    public TreeNode initTree(int[] inorder,int[] postorder,int in_start,int in_end,int post_start,int post_end) {
    	//���ǰ�󳬽�
    	if(in_start>in_end || post_start>post_end) {
    		return null;
    	}
    	
    	//1.������������һ������ǵ�ǰ���ĸ����
    	TreeNode root=new TreeNode(postorder[post_end]);
    	//2.���Ҹ��ڵ���ǰ������е�λ��----������������
    	int position=in_start;
    	while(inorder[position] != postorder[post_end]) {
    		position++;
    	}
    	//3.�������쵱ǰ������������������
    	root.left=initTree(inorder, postorder, in_start, position-1,post_start,post_start+position-in_start-1);
    	root.right=initTree(inorder,postorder, position+1,in_end,post_end-(in_end-position-1),post_end-1);
    	
    	return root;
    }
}
