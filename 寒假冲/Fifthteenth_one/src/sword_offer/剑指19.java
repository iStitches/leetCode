package sword_offer;

/**
 * dp��̬�滮
 * @author dell
 *
 */
public class ��ָ19 {
	/**
	 * 
	 * @param s   ��ƥ�䴮  ÿλ��Ӧi
	 * @param p   ����     ÿλ��Ӧj
	 * @return
	 * dp[i][j] ����s��ǰiλ��p��ǰjλ�ܷ�ƥ��
	 * dp[i][j]��Ӧ���� s[i-1] p[j-1]����λ�õ��ַ�
	 * ���������ÿһλֻ����Ϊ����ֵ�� . �� �ַ���*
	 * ���p[j-1]='*'  dp[i][j]����ֵ���Է�Ϊ���������   
	 *     1. dp[i][j-2]:  ���ַ���� p[j-2]*  ��������0�Σ��ܷ�ƥ�䣻
	 *     2. dp[i][j-1]:  ���ַ���� p[j-2]*  ��������1�Σ��ܷ�ƥ�䣻
	 *     3. dp[i-1][j]:  �����������s[i-1]=p[j-2]���� p[j-2]�����һ�Σ�
	 *     4. dp[i-1][j]:  ������������, p[j-2] = '.'
	 * ���p[j-1]!='*' dp[i][j]��ֵ�ֿ��Ի��֣�
	 *     1. dp[i-1][j-1]:  s[i-1]=p[j-1]
	 *     2. dp[i-1][j-1]:  p[j-1]='.'
	 */
    public boolean isMatch(String s, String p) {
          int len1= s.length(),len2= p.length();
          boolean dp[][]=new boolean[len1+1][len2+1];
          /**
           * ����ֵ  dp[0][0]=true
           * dp[0][j]=dp[0][j-2] �� p[j-1]='*'    p��ż��λΪ*ʱ���ܹ�ƥ��
           */
          dp[0][0]=true;
          for(int j=2;j<=len2;j+=2) {
        	  if(dp[0][j-2] && p.charAt(j-1)=='*')
        		  dp[0][j]=true;
          }
          for(int i=1;i<=len1;i++) {
        	  for(int j=1;j<=len2;j++) {
        		  if(p.charAt(j-1)!='*') {
        			  if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.')
        				  dp[i][j]=dp[i-1][j-1];
        		  }
        		  else {
        			  dp[i][j]=dp[i][j-1]||dp[i][j-2]||dp[i-1][j]&&s.charAt(i-1)==p.charAt(j-2)||dp[i-1][j]&&p.charAt(j-2)=='.';
        		  }
        	  }
          }
          return dp[len1][len2];
    }

    
    public static void main(String[] args) {
		��ָ19 t= new ��ָ19();
		System.out.println(t.isMatch("abb","c*a*b"));
	}
}
