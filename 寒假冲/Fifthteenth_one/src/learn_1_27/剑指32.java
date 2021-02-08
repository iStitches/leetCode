package learn_1_27;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ½£Ö¸32 {
    public int[] levelOrder(TreeNode root) {
        Deque<TreeNode> array = new ArrayDeque<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        array.offer(root);
        while(!array.isEmpty()){
            TreeNode top = array.poll();
            list.add(top.val);
            if(top.left!=null)
               array.offer(top.left);
            if(top.right!=null)
               array.offer(top.right);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
