package offer;

import java.util.ArrayList;

/**
 * ��ӡ������������·��(��Ҷ�ӽڵ�)
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
		   res.add(new ArrayList(list));           // ע��������Ҫʹ��new �������µĶ�����Ϊ֮ǰ���ǶԶ��ж�������ã����еĶ���ֵ���˶�Ӧ������Ҳ�ᷢ���仯
//		   list.remove(list.size()-1);             // �������ʹ�� return; ���أ���ô���뽫����Ķ� root.val��ȥ������ԭ����ǰ��״̬
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
