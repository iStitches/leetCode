package Thursday;

public class search_240 {
    public boolean searchMatrix(int [][] matrix,int target) {
    	/**
    	 * ��֪ÿ��ÿ�ж��ǵ����ģ���ô����  ����Ϊ������׼������Ϊ�ݼ���׼��
    	 * ��ʼ��λ�ô����һ�еĵ�һ��Ԫ�ؿ�ʼ���Ᵽ֤�˱ȵ�ǰλ�ô��Ԫ��ֻ���ڸ����ұߡ�
    	 * �ȵ�ǰλ��С��Ԫ��һ���ڸ����ϱߡ�
    	 * ��ô�����γ�һ�ַ�����ֻҪ�ȵ�ǰλ��С�������ƶ����󣬱ȵ�ǰλ�ô�ľ������ƶ���С��
    	 */
    	if(matrix.length==0 || matrix[0].length==0)
    		return false;
    	int column=matrix.length,line=matrix[0].length;
    	int i=column-1,j=0;
    	while(0<=i && i<column && 0<=j && j<line) {
    		if(matrix[i][j]<target)
    			j++;
    		else if(matrix[i][j]>target)
    			i--;
    		else
    			return true;
    	}
    	return false;
    }
}
