package sword_offer;

public class ��ָ48 {
	/**
	 * 1���ַ�---true
	 * 2���ַ�---�Ƿ����
	 * 3���������ַ�:
	 *      word[i][j]:�����±�i��j���ַ����Ƿ��ǻ���
	 *      word[i][j] = word[i+1][j-1]&&word[i]==word[j]
	 * @param s
	 * @return
	 */
    public int lengthOfLongestSubstring(String s) {
         boolean word[][] = new boolean[s.length()][s.length()];
         String res = null;
         int maxLen = 1;
         //�����ַ�
         for(int i=0;i<s.length();i++) {
        	 word[i][i]=true;
        	 res = s.substring(i,i+1);
         }
         
         //�����ַ�
         for(int i=0;i<s.length()-1;i++) {
        	 if(s.charAt(i) == s.charAt(i+1)) {
        		 word[i][i+1] = true;
        		 res = s.substring(i,i+2);
        		 maxLen = 2;
        	 }
         }
         
         //����������
         for(int i=0;i<s.length()-1;i++) {
        	 for(int j=i+1;j<s.length();j++) {
        		 word[i][j] = word[i+1][j-1] && (s.charAt(i)==s.charAt(j));
        		 if(word[i][j] && j-i+1>maxLen) {
        			 maxLen = j-i+1;
        			 res = s.substring(i,j+1);
        		 }
        	 }
         }
//         System.out.println(res);
         return maxLen;
    }
    
    public static void main(String[] args) {
    	��ָ48 t = new ��ָ48();
    	System.out.println(t.lengthOfLongestSubstring("pwwkew"));
	}
}
