package Day1;
import Day1.*;

public class everyDay3 {
	int res=0;
	
    public int sumOfLeftLeaves(TreeNode root) {
    	traverse(root,false);
    	return res;
    }
    
    public void traverse(TreeNode root,boolean isLeft) {
    	if(root == null)
    		return;
    	if(root.left==null && root.right==null && isLeft) {
    		res+=root.val;
    		return;
    	}
    	
    	//����Ϳ�������Ҷ��
    	traverse(root.left,true);
    	//����һ��û����Ҷ��
    	traverse(root.right,false);
    }
}
