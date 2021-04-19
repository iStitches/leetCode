package sword_offer;

/**
 * 快速幂算法测试
 * 例如求A^B 的最后三位数表示的整数
 * @author dell
 *
 */
public class 快速幂test {
	
	/**
	 * 方法1：(a*b*c)%d=(a%d*b%d*c%d)%d      防止在最后进行统一求余操作时会由于数字过大溢出而不能计算
	 * @param base   底数
	 * @param power  指数
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
     * 方法二：	初步快速幂法     每次将偶数幂平分为二，而底数变为原底数的平方
     * @param base
     * @param power
     * @return
     */
    public long normalPower1(long base,long power) {
    	long result = 1;
        while(power > 0) {
        	if(power % 2 == 0) {
        		//如果指数为偶数
        		base = base * base % 1000;
        		power = power / 2;
        	}
        	else {
        		//如果指数为奇数
        		power = power - 1;
        		result = result * base % 1000;
        		base = base * base % 1000;
        		power = power / 2;
        	}
        }
        return result;
    }
    
    /**
     * 方法三： 终极快速幂法     去除掉初步快速幂中的重复项
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
    	快速幂test t = new 快速幂test();
    	//方法一
		long t1 = System.currentTimeMillis();
		System.out.println(t.normalPower(2, 1000000000));
		long t1_late = System.currentTimeMillis();
		System.out.println(t1_late - t1);
		
		//方法二
		long t2 = System.currentTimeMillis();
		System.out.println(t.normalPower1(2, 1000000000));
		long t2_late = System.currentTimeMillis();
		System.out.println(t2_late - t2);
		
		//方法三
		long t3 = System.currentTimeMillis();
		System.out.println(t.normalPower2(2, 1000000000));
		long t3_late = System.currentTimeMillis();
		System.out.println(t3_late - t3);
	}
    
}
