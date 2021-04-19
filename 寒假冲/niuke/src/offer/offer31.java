package offer;

public class offer31 {
    public int NumberOf1Between1AndN_Solution(int n) {
    	int digit=1,high=n/10,low=0,cur=n%10;
    	int count = 0,i=1;
    	while(high!=0 || cur!=0) {
    		switch(cur) {
    		case 0: count+=high*digit;break;
    		case 1: count+=high*digit+low+1;break;
    		default: count+=(high+1)*digit;
    		}
    		digit = (int) Math.pow(10, i);
    		high = n/digit;
    		low = n%digit;
    		cur = n%(10*digit);
    	}
    	return count;
    }
}
