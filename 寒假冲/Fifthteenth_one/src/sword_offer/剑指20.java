package sword_offer;

public class ��ָ20 {
	/**
	 * �۲���֣�
	 *    +/-:   ֻ�ܳ����ڿ�ͷ���߽�����e�ĺ���
	 *    .  :   ֻ�ܳ���һ��, ������e��ǰ��
	 *    e  :   ֻ�ܳ���һ�Σ�λ�����ֺ���
	 * @param s
	 * @return
	 */
    public boolean isNumber(String s) {
    	boolean numFlag=false;     //�Ƿ��Ѿ�����������
        boolean docFlag=false;     //�Ƿ��Ѿ�������С����.
        boolean eFlag=false;       //�Ƿ��Ѿ�������e
        
        if(s==null || s.length()==0) return false;
        s=s.trim();
        
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)>='0' && s.charAt(i)<='9')  //����
        		numFlag=true;
        	else if(s.charAt(i)=='.' && !docFlag && !eFlag)  //С����
        		docFlag=true;
        	else if((s.charAt(i)=='e'|| s.charAt(i)=='E') && numFlag && !eFlag) {  //e
        		eFlag=true;	
        		numFlag=false;   //���ֹ�e�������false������ 123e���ַ����ֵ����
        	}
        	else if((s.charAt(i)=='+' || s.charAt(i)=='-')&&(i==0 || s.charAt(i-1)=='e' || s.charAt(i-1)=='E')) {
        		
        	}
        	else 
        		return false;
        }
        return numFlag;
    }
}
