package SortSummary;

/**
 * ֱ�Ӳ�������----�����ڱ���Ȼ���ǰ���Ԫ�رȽϴ�С�������ƶ�
 * @author dell
 *
 */
public class DirectSort {
	
   public void InsertSort(int arr[]) {
	   int i,j,tmp;
	   for(i=1;i<arr.length;i++) {
		   //��tmp������arr[i]����Ԫ��ֵ(�ڱ�)
		   tmp=arr[i];
		   j=i;
		   
		   //tmp<arr[j-1]:����tmpֵ��������ƶ�(���������������)   |  tmp>arr[j-1]:����tmpֵС�������ƶ�(���������������)
		   while(j>0 && tmp<arr[j-1]) {
			   arr[j]=arr[j-1];
			   j--;
		   }
		   arr[j]=tmp;
	   }
   }
	
   public static void main(String[] args) {
	int arr[]= {2,1,5,7,2,3,-1};
	DirectSort t=new DirectSort();
	t.InsertSort(arr);
}
}
