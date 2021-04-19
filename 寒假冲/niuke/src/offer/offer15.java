package offer;

import java.util.ArrayList;

public class offer15 {
    ArrayList<ArrayList<Integer>>  list = new ArrayList();
    ArrayList<Integer> temp = new ArrayList();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        dfs(root,target);
        return list;
    }
    
    public void dfs(TreeNode root,int target){
    	temp.add(root.val);
    	if(root.left==null && root.right==null && target==root.val) {
    		list.add(new ArrayList(temp));
    		temp.remove(Integer.valueOf(root.val));
    		return;
    	}
    	if(root.left!=null) dfs(root.left,target-root.val);
    	if(root.right!=null) dfs(root.right,target-root.val);
    	temp.remove(Integer.valueOf(root.val));
    }
    
    public static void main(String[] args) {
		offer15 t= new offer15();
		TreeNode root = new TreeNode(10);
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(12);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(7);
		root.left=node1;root.right=node2;
		node1.left=node3;node1.right=node4;
		
		
		ArrayList<ArrayList<Integer>> res = t.FindPath(root, 22);
		System.out.println(111);
	}
}
