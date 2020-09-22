package Day3;

public class every4 {
	/**
	 * 我的方法
	 * @param args
	 */
//    public String compressString(String S) {
//    	 if(S.length()==0) {
//    		 return S;
//    	 }
//    	 else {
//    		 int i=1,count=1;
//             StringBuffer result=new StringBuffer();
//             
//             
//             for(;i<S.length();i++) {
//            	 if(S.charAt(i-1)==S.charAt(i))
//            		 count++;
//            	 else {
//            		 result.append(String.valueOf(S.charAt(i-1))+String.valueOf(count));
//            		 count=1;
//            	 }
//             }
//             result.append(String.valueOf(S.charAt(S.length()-1))+String.valueOf(count));
//             
//             String cur=result.toString();
//             return cur.length()<S.length()?cur:S; 
//    	 }
//    }
	
	/**
	 * 大佬方法：双指针
	 * @param args
	 */
	public String compressString(String S) {
		int len=S.length();
		int i=0,j=0;
		StringBuffer result=new StringBuffer();
		
		//i与j为两个指针，i定位开始位置，j定位最终位置
		while(j<len) {
			while(j<len && S.charAt(i) == S.charAt(j)) {
				j++;
			}
			//此时 j处值 != i处的值
			result.append(S.charAt(i));
			result.append(j-i);
			i=j;
		}
		
		//比较返回
		String res=result.toString();
		return res.length() < S.length()? res:S;
	}
    
    public static void main(String[] args) {
		every4 t=new every4();
		System.out.println(t.compressString("aabcccccaaa"));
	}
}
