package Thursday;

public class Offer_33 {
	public boolean verifyPostorder(int[] postorder) {
        return judge(postorder, 0, postorder.length-1);
    }
	
	/**
	 * 每次保证左边的子树< 根    &&  右边的子树> 根
	 * @param postorder
	 * @param start
	 * @param end
	 * @return
	 */
	public boolean judge(int []postorder,int start,int end) {
         if(start>=end)
        	 return true;
         
         //找到本次右子树的起点:  rstart+1  终点  end-1
         int rstart=end-1;
         while(rstart>=start && postorder[rstart]>postorder[end])
        	 rstart--;
         
         //找到本次左子树的终点:  rstart  ,起点 start
         int lend=rstart;
         
         //判断左子树是否全部小于当前的根节点
         for(int i=start;i<=lend;i++) {
        	 if(postorder[i]>postorder[end])
        		 return false;
         }
         //存在左子树
         if(lend>=start)
        	 if(!judge(postorder, start, lend))
        		 return false;
         //存在右子树
         if(rstart+1<end)
        	 if(!judge(postorder, rstart+1, end-1))
        		 return false; 
         return true;
	}
	
	public static void main(String[] args) {
		Offer_33 t=new Offer_33();
		int postorder[]= {1,2,5,10,6,9,4,3};
		t.verifyPostorder(postorder);
	}
}
