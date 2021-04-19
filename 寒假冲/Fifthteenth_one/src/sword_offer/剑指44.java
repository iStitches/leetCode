package sword_offer;

public class ½£Ö¸44 {
    public int findNthDigit(int n) {
        if(n<10)
            return n;
        int i=1,sum=1,cur=n,start=0;
        while(cur > sum){
            sum += (Math.pow(10,i)-Math.pow(10,i-1))*i;
            start = (int) Math.pow(10,i-1);
            i++;
        }
        i--;
        start = (int)Math.pow(10, i-1);
        sum -= (Math.pow(10,i)-Math.pow(10,i-1))*i;
        n = n-sum;
        int p = n/i+1;
        start += p;
        int left = n-p*i;
        if(left == 0)
           return start/10;
        else{
            left = i-left+1;
            int res = 0;
            for(int k=1;k<=left;k++){
                res = start%10;
                start = start/10;
            }
            return res;
        }
    }
    
    public static void main(String[] args) {
		½£Ö¸44 t = new ½£Ö¸44();
		int res  = t.findNthDigit(19);
		System.out.println(res);
	}
}
