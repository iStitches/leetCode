package Thursday;

public class Offer_33 {
	public boolean verifyPostorder(int[] postorder) {
        return judge(postorder, 0, postorder.length-1);
    }
	
	/**
	 * ÿ�α�֤��ߵ�����< ��    &&  �ұߵ�����> ��
	 * @param postorder
	 * @param start
	 * @param end
	 * @return
	 */
	public boolean judge(int []postorder,int start,int end) {
         if(start>=end)
        	 return true;
         
         //�ҵ����������������:  rstart+1  �յ�  end-1
         int rstart=end-1;
         while(rstart>=start && postorder[rstart]>postorder[end])
        	 rstart--;
         
         //�ҵ��������������յ�:  rstart  ,��� start
         int lend=rstart;
         
         //�ж��������Ƿ�ȫ��С�ڵ�ǰ�ĸ��ڵ�
         for(int i=start;i<=lend;i++) {
        	 if(postorder[i]>postorder[end])
        		 return false;
         }
         //����������
         if(lend>=start)
        	 if(!judge(postorder, start, lend))
        		 return false;
         //����������
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
