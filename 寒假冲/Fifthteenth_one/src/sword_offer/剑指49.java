package sword_offer;

public class ��ָ49 {
	
    //�ҳ���
	/**
	 * * ˼·��
	 * *     ���ڳ�����������ֻ���� 2 3 5��Ҳ����˵�����������������������������������(1����)���������Գ���Ϊ����
	 * *     ��ô������Ҫ���ľ���ÿ��ȡ3�������Գ˷��������Сֵ��Ϊ���εĳ��������ҽ������ֵ��±������ƶ���
	 * * �ⷨ��
	 * *     1.������������ i��j��k��Ϊ��������λ���±ꣻ
	 *       2.ÿ��������ڵ�ǰ����ȡ�õĳ����򽫸������±�λ�ü�һ(������һ���������ֵĳ˻������ڳ�������ô�Ͷ���Ҫ������һλ)��
	 *       
	 * @param n
	 * @return
	 */
    public int nthUglyNumber(int n) {
        if(n == 1)
           return 1;
        int i=0,j=0,k=0,count=1,tmp1,tmp2,tmp3,max;
        int[] arr = new int[n];
        arr[0]=1;
        while(count<n){
            tmp1 = arr[i]*2;
            tmp2 = arr[j]*3;
            tmp3 = arr[k]*5;
            max = Math.min(Math.min(tmp1,tmp2),tmp3);
            arr[count] = max;
            if(max == tmp1)
               i++;
            if(max == tmp2)
               j++;
            if(max == tmp3) 
               k++;
            count++;
        }
        return arr[n-1];
    }
    
    public static void main(String[] args) {
		��ָ49 t = new ��ָ49();
		int res = t.nthUglyNumber(10);
		System.out.println(res);
	}
}
