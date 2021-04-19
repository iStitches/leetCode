package sword_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
 *  序列化：层序遍历
 *  反序列化：由层序遍历反向还原二叉树
 * @author dell
 *
 */
public class 剑指37 {
	
   //序列化
   public String serialize(TreeNode root) {
       if(root == null)
          return "[]";
       StringBuilder builder = new StringBuilder();
       builder.append("[");
       LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
       
       
       boolean flag = true;
       queue.offer(root);
       while(!queue.isEmpty()){
           TreeNode node = queue.poll();
           if(node != null)
           {
        	   builder.append(node.val).append(",");
        	   queue.offer(node.left);
        	   queue.offer(node.right);
           }
           else
        	   builder.append("null").append(",");
       }
       builder = builder.deleteCharAt(builder.length()-1);
       builder.append("]");
       return builder.toString();
   }
   
   //反序列化----由层序遍历数组还原二叉树
   /**
    * 想象成3个节点，start下标为数组中对应的左节点；
    * 然后判断 
    * @param data
    * @return
    */
   public TreeNode deserialize(String data) {
	   if(data.equals("[]"))
		   return null;
	   String []array = data.substring(1,data.length()-1).split(",");
	   TreeNode root = new TreeNode(Integer.parseInt(array[0]));
	   Queue<TreeNode> queue = new LinkedList<TreeNode>();
	   queue.offer(root);
	   int start = 1;
	   
	   while(!queue.isEmpty()) {
		   TreeNode node = queue.poll();
		   if(!array[start].equals("null")) {
			   node.left = new TreeNode(Integer.parseInt(array[start]));
			   queue.add(node.left);
		   }
		   start++;
		   
		   if(!array[start].equals("null")) {
			   node.right = new TreeNode(Integer.parseInt(array[start]));
			   queue.add(node.right);
		   }
		   start++;
	   }
	   return root;
   }
   
   public static void main(String[] args) {
	剑指37 t = new 剑指37();
	TreeNode n1 = new TreeNode(1);
	TreeNode n2 = new TreeNode(2);
	TreeNode n3 = new TreeNode(3);
	TreeNode n4 = new TreeNode(4);
	TreeNode n5 = new TreeNode(5);
	n1.left = n2;
	n1.right = n3;
	n3.left = n4;
	n3.right = n5;
	System.out.println(t.serialize(n1));
}
}
