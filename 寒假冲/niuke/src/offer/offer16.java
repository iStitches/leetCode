package offer;

import java.util.ArrayList;

/**
 * 打印二叉树的所有路径(到叶子节点)
 * @author dell
 *
 */
public class offer16 {
	
   ArrayList<ArrayList<Integer>> res = new ArrayList();
   ArrayList<Integer> list = new ArrayList();
   public ArrayList<ArrayList<Integer>> getPath(TreeNode root){
	   dfs(root);
	   return res;
   }
   
   public void dfs(TreeNode root) {
	   list.add(root.val);
	   if(root.left==null && root.right==null) {
		   res.add(new ArrayList(list));           // 注意这里需要使用new 来生成新的对象，因为之前都是对堆中对象的引用，堆中的对象值变了对应的引用也会发生变化
//		   list.remove(list.size()-1);             // 如果这里使用 return; 返回，那么必须将插入的额 root.val给去掉，还原插入前的状态
//		   return;
	   }
	   if(root.left!=null) dfs(root.left);
	   if(root.right!=null) dfs(root.right);
	   list.remove(list.size()-1);
   }
   
   public static void main(String[] args) {
		offer16 t= new offer16();
		TreeNode root = new TreeNode(10);
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(12);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(7);
		root.left=node1;root.right=node2;
		node1.left=node3;node1.right=node4;
		ArrayList<ArrayList<Integer>> result = t.getPath(root);
		System.out.println(111);
}
}
