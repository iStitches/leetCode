package Day3;

public class every3 {
    public boolean oneEditAway(String first, String second) {
        int len1=first.length();
        int len2=second.length();
        if(Math.abs(len1-len2)>1) {
        	return false;
        }
        //��֤λ��һ��һ��Ϊ���ȳ���
        if(len1 < len2) {
        	return oneEditAway(second, first);
        }
        
       

        if(len2>0){
            for(int i=0;i<len2;i++) {
                //����������ȵĵ�
            	if(first.charAt(i) != second.charAt(i)) {
            		//������Ⱦʹ���һ���㿪ʼ�Ƚ�
            		return first.substring(i+1).equals(second.substring(i+1).length()==first.substring(i+1).length()?second.substring(i+1):second.substring(i));
            	}
        }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
		every3 t=new every3();
		System.out.println(t.oneEditAway("a",""));
	}
}
