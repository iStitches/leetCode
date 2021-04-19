package sword_offer;

public class 剑指20 {
	/**
	 * 观察后发现：
	 *    +/-:   只能出现在开头或者紧跟在e的后面
	 *    .  :   只能出现一次, 出现在e的前面
	 *    e  :   只能出现一次，位于数字后面
	 * @param s
	 * @return
	 */
    public boolean isNumber(String s) {
    	boolean numFlag=false;     //是否已经出现了数字
        boolean docFlag=false;     //是否已经出现了小数点.
        boolean eFlag=false;       //是否已经出现了e
        
        if(s==null || s.length()==0) return false;
        s=s.trim();
        
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)>='0' && s.charAt(i)<='9')  //数字
        		numFlag=true;
        	else if(s.charAt(i)=='.' && !docFlag && !eFlag)  //小数点
        		docFlag=true;
        	else if((s.charAt(i)=='e'|| s.charAt(i)=='E') && numFlag && !eFlag) {  //e
        		eFlag=true;	
        		numFlag=false;   //出现过e后必须置false，放置 123e这种非数字的情况
        	}
        	else if((s.charAt(i)=='+' || s.charAt(i)=='-')&&(i==0 || s.charAt(i-1)=='e' || s.charAt(i-1)=='E')) {
        		
        	}
        	else 
        		return false;
        }
        return numFlag;
    }
}
