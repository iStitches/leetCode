package offer;

public class offer26 {
	/**
	 * ���η�----��ȹ鲢����
	 * @param args
	 */
//	   int count = 0;
//	    public int GetNumberOfK(int [] array , int k) {
//	        getAns(array,0,array.length-1,k);
//	        return count;
//	    }
//	    public void getAns(int[] array,int start,int end,int target){
//	        if(start>end)
//	            return;
//	        int index = getNumber(array,start,end,target);
//	        if(index != -1)
//	        {
//		        getAns(array,start,index-1,target);
//		        getAns(array,index+1,end,target);	
//	        }
//	    }
//	    
//	    public int getNumber(int []array,int start,int end,int target){
//	        while(start<=end && array[end]>=target){
//	            int mid = ((end-start)>>1)+start;
//	            if(array[mid]>target)
//	                end = mid-1;
//	            else if(array[mid]<target)
//	                start = mid+1;
//	            else 
//	            {
//	                count++;
//	                return mid;
//	            }
//	        }
//	        return -1;
//	    }
	    
	/**
	 * ���ڶ�����������ô��ֱ�Ӳ��� num-0.5  �� num+0.5 ��λ������Ϳ�����
	 * ע�� >> �� + �����ȼ���+ ���ȼ�����
	 * @param args
	 */
	public int GetNumberOfK(int []array,int k) {
		return getIndex(array,k+0.5)-getIndex(array,k-0.5);
	}
	
	public int getIndex(int []array,double num) {
		int s = 0,e = array.length-1,mid;
		while(s <= e) {
			System.out.println(((e-s)>>1)+s);
			mid = ((e-s)>>1+s);
			if(array[mid] > num)
				e = mid-1;
			else if(array[mid] < num)
				s = mid+1;
			else
				return mid;
		}
		return s;
	}
	
	    public static void main(String[] args) {
			offer26 t = new offer26();
			int []arr= new int[] {1,2,3,3,3,3,4,5};
			System.out.println(t.GetNumberOfK(arr, 3));
		}
}
