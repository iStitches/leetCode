package sword_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ��ָ34 {
	List<List<Integer>> list=null;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        list = new ArrayList();
        dfs(root,sum,new LinkedList());
        return list;
    }
    
    /**
     * �������----������
     * @param node
     * @param current
     * @param tempList
     */
    public void dfs(TreeNode root,int current,LinkedList<Integer> tempList) {
    	if(root == null)
    		return;
    	tempList.add(root.val);
    	current-=root.val;
    	if(current==0 && root.left==null && root.right==null)
    		list.add(new LinkedList(tempList));
    	dfs(root.left,current,tempList);
    	dfs(root.right,current,tempList);
        tempList.removeLast();
    }
}
