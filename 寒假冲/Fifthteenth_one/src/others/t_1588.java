package others;

public class t_1588 {
	/**
	 * �ⷨһ��ǰ׺�ͽⷨ
	 * @param arr
	 * @return
	 */
    public int sumOddLengthSubarrays(int[] arr) {
        int []sum = new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            sum[i+1]=sum[i]+arr[i];
        }

        int res = 0;
        for(int i=1;i<=arr.length;i=i+2){
            for(int j=0;j<=arr.length-i;j++){
            	System.out.println(sum[j+i]-sum[j]);
                res+=sum[j+i]-sum[j];
            }
        }
        return res;
    }
    
    /**
     * �ⷨ��������ÿ�����ֿ��ܳ����ڶ��ٸ�������
     * ����������� arr[5]={1,2,3,4,5} 
     *    ����i=3����4,����������ǰ����ѡ��0,1,2,3�����֣��ܹ���4��ѡ�� left=i+1;
     *    �������������n-i��ѡ�� right=n-i;
     * 
     * ���Ҫ��ɸ���Ϊ����������,��ô���ǰ��ѡ��ż����,����Ҳ����ѡ��ż����,ֻ��������������������Ϊ��������
     * ���ǰ��ѡ��������,����Ҳ����ѡ��������,ֻ��������������������Ϊ��������
     * 
     * ����������ǰ���ܹ� left��ѡ������ż�������ֵ�ѡ�񷽰��� left_even=(left+1)/2�����������ֵ�ѡ�񷽰���
     * left_odd=left/2;
     * ͬ��������ֺ����ѡ��ʽ��
     * 
     * ��ô����arr[i] ��������λ�� left_even*right_even + left_odd*right_odd �������С�
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays1(int[] arr) {
    	int res=0;
    	for(int i=0;i<arr.length;i++) {
    	     int left=i+1,right=arr.length-i;
    	     int left_even=(left+1)/2,left_odd=left/2;
    	     int right_even=(right+1)/2,right_odd=right/2;
    	     res+=left_even*right_even+left_odd*right_odd*arr[i];
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		t_1588 t = new t_1588();
		int []arr = {1,4,2,5,3};
		t.sumOddLengthSubarrays(arr);
	}
}
