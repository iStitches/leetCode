package Wednesday;

import java.util.Arrays;
import Wednesday.every;

public class mian_04_02 {
	/**
	 * 构成一棵高度最小的二叉排序树的关键在于左右子树的结点个数一致
	 * 那么就可以先将数组排序，然后运用分治法递归地去划分构建
	 * @param nums
	 * @return
	 */
    public TreeNode sortedArrayToBST(int[] nums) {
        Arrays.sort(nums); 
        return createTree(nums, 0, nums.length-1);
    }
    
    public TreeNode createTree(int []nums,int start,int end) {
    	if(start > end && start>=0 && end<=nums.length-1)
    		return null;
    	int mid=(start+end)/2;
    	TreeNode root=new TreeNode(nums[mid]);
    	root.left=createTree(nums, start, mid-1);
    	root.right=createTree(nums,mid+1,end);
    	return root;
    }
    public static void main(String[] args) {
		int []nums= {-10,-3,0,5,9};
		mian_04_02 t=new mian_04_02();
		t.sortedArrayToBST(nums);
	}
}
