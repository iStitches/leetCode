package Day3;

public class every4 {
	/**
	 * �ҵķ���
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
	 * ���з�����˫ָ��
	 * @param args
	 */
	public String compressString(String S) {
		int len=S.length();
		int i=0,j=0;
		StringBuffer result=new StringBuffer();
		
		//i��jΪ����ָ�룬i��λ��ʼλ�ã�j��λ����λ��
		while(j<len) {
			while(j<len && S.charAt(i) == S.charAt(j)) {
				j++;
			}
			//��ʱ j��ֵ != i����ֵ
			result.append(S.charAt(i));
			result.append(j-i);
			i=j;
		}
		
		//�ȽϷ���
		String res=result.toString();
		return res.length() < S.length()? res:S;
	}
    
    public static void main(String[] args) {
		every4 t=new every4();
		System.out.println(t.compressString("aabcccccaaa"));
	}
}
