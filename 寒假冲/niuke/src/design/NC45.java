package design;

import java.util.ArrayList;

public class NC45 {
	ArrayList<Integer> preList = new ArrayList<Integer>();
	ArrayList<Integer> midList = new ArrayList<Integer>();
	ArrayList<Integer> afterList = new ArrayList<Integer>();
	
    public int[][] threeOrders (TreeNode root) {
        preView(root);
        midView(root);
        afterView(root);
        int[][] ans = new int[3][preList.size()];
        ans[0] = preList.stream().mapToInt(Integer::valueOf).toArray();
        ans[1] = midList.stream().mapToInt(Integer::valueOf).toArray();
        ans[2] = afterList.stream().mapToInt(Integer::valueOf).toArray();
        return ans;
    }
    
    public void preView(TreeNode root){
        if(root == null)
            return;
        preList.add(root.val);
        preView(root.left);
        preView(root.right);
    }
    
    public void midView(TreeNode root){
        if(root == null)
            return;
        preView(root.left);
        midList.add(root.val);
        preView(root.right);
    }
    
    public void afterView(TreeNode root){
        if(root == null)
            return;
        preView(root.left);
        preView(root.right);
        afterList.add(root.val);
    }
    
    static class TreeNode{
    	int val=0;
    	TreeNode left=null,right=null;
    	TreeNode(int val){
    		this.val = val;
    	}
    }
    
    public static void main(String[] args) {
		NC45 t = new NC45();
		TreeNode root = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		root.left=root2;
		root.right=root3;
		
		int[][] res = t.threeOrders(root);
	}
}
