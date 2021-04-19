package offer;

public class offer10 {
    public int NumberOf1(int n) {
//    	if(n==-2147483648) return 1;
//        long temp = Math.abs(n),res = 0;
//        StringBuilder builder = new StringBuilder();
//        while(temp!=0){
//            long cur = temp%2;
//            if(cur == 1)
//                res++;
//            builder.insert(0,cur);
//            temp = temp/2;
//        }
//        if(n>=0) return Long.valueOf(res).intValue();
//         
//        String str = builder.toString();
//        res = 32-res;
//        int index=str.length()-1;
//        while(str.charAt(index)=='0') {
//        	res--;
//        	index--;
//        }
//        return Long.valueOf(res).intValue()+1;
        int count=0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
     }
    public static void main(String[] args) {
		offer10 t = new offer10();
		System.out.println(t.NumberOf1(-8));
	}
}
