package sword_offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ��ָ32 {
//  public List<List<Integer>> levelOrder(TreeNode root) {
//  Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
//  queue.offer(root);
//  List<List<Integer>> res = new ArrayList<List<Integer>>();
//  while(!queue.isEmpty()){
//      List<TreeNode> list = new ArrayList<TreeNode>();
//      while(!queue.isEmpty()){
//          TreeNode temp =queue.poll();
//          list.add(temp);
//      }
//      List<Integer> intList = new ArrayList<Integer>();
//      for(int i=0;i<list.size();i++){
//          intList.add(list.get(i).val);
//          if(list.get(i).left!=null) queue.add(list.get(i).left);
//          if(list.get(i).right!=null) queue.add(list.get(i).right);
//      }
//      res.add(intList);
//  }
//  return res;
//}

//public List<List<Integer>> levelOrder(TreeNode root) {
//    Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
//    List<List<Integer>> res = new ArrayList<List<Integer>>();
//    if(root != null) queue.add(root);
//    while(!queue.isEmpty()) {
//  	  List<Integer> temp = new ArrayList();
//  	  for(int i=queue.size();i>0;i--) {
//  		  TreeNode node = queue.poll();
//  		  temp.add(node.val);
//  		  if(node.left != null) queue.add(node.left);
//  		  if(node.right != null) queue.add(node.right);
//  	  }
//  	  res.add(temp);
//    }
//    return res;
//}

List<List<Integer>> node=new ArrayList();
public List<List<Integer>> levelOrder(TreeNode root) {
  lei(root,0);
  return node;
}
/**
* �ݹ��Ĳ�α���
* @param root  ��ǰ�Ľ��
* @param k     �ڼ���
*/
public void lei(TreeNode root,int k){
  if(root != null) {
  	/**
  	 * ��node�����е� list����С��kʱ������
  	 * 1. �жϵ�k���Ƿ��ж�Ӧ��list����;
  	 * 2. ����ǰ�ǿյ�root ��ֵ��ӽ���node��Ӧ��K��list������;
  	 */
  	if(node.size()<=k) node.add(new ArrayList());
  	node.get(k).add(root.val);
  	lei(root.left,k+1);
  	lei(root.right,k+1);
  }
}
}
