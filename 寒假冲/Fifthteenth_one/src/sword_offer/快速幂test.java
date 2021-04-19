package sword_offer;

/**
 * �������㷨����
 * ������A^B �������λ����ʾ������
 * @author dell
 *
 */
public class ������test {
	
	/**
	 * ����1��(a*b*c)%d=(a%d*b%d*c%d)%d      ��ֹ��������ͳһ�������ʱ���������ֹ�����������ܼ���
	 * @param base   ����
	 * @param power  ָ��
	 * @return
	 */
    public long normalPower(long base,long power) {
    	long result = 1;
    	for(int i=1;i<power;i++) {
            result = result * base;
            result = result % 1000;
    	}
    	return result%1000;
    }
    
    /**
     * ��������	���������ݷ�     ÿ�ν�ż����ƽ��Ϊ������������Ϊԭ������ƽ��
     * @param base
     * @param power
     * @return
     */
    public long normalPower1(long base,long power) {
    	long result = 1;
        while(power > 0) {
        	if(power % 2 == 0) {
        		//���ָ��Ϊż��
        		base = base * base % 1000;
        		power = power / 2;
        	}
        	else {
        		//���ָ��Ϊ����
        		power = power - 1;
        		result = result * base % 1000;
        		base = base * base % 1000;
        		power = power / 2;
        	}
        }
        return result;
    }
    
    /**
     * �������� �ռ������ݷ�     ȥ���������������е��ظ���
     * @param base
     * @param power
     * @return
     */
    public long normalPower2(long base,long power) {
    	long result = 1;
    	while(power > 0) {
    		if(power % 2 == 1)
    			result = result * base % 1000;
    		power = power / 2;
    		base = base * base % 1000;
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	������test t = new ������test();
    	//����һ
		long t1 = System.currentTimeMillis();
		System.out.println(t.normalPower(2, 1000000000));
		long t1_late = System.currentTimeMillis();
		System.out.println(t1_late - t1);
		
		//������
		long t2 = System.currentTimeMillis();
		System.out.println(t.normalPower1(2, 1000000000));
		long t2_late = System.currentTimeMillis();
		System.out.println(t2_late - t2);
		
		//������
		long t3 = System.currentTimeMillis();
		System.out.println(t.normalPower2(2, 1000000000));
		long t3_late = System.currentTimeMillis();
		System.out.println(t3_late - t3);
	}
    
}
