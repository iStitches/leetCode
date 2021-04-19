package sword_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �����������л��뷴���л�
 *  ���л����������
 *  �����л����ɲ����������ԭ������
 * @author dell
 *
 */
public class ��ָ37 {
	
   //���л�
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
   
   //�����л�----�ɲ���������黹ԭ������
   /**
    * �����3���ڵ㣬start�±�Ϊ�����ж�Ӧ����ڵ㣻
    * Ȼ���ж� 
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
	��ָ37 t = new ��ָ37();
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
