package SortSummary;

/**
 * 直接插入排序----设置哨兵，然后和前面的元素比较大小最后进行移动
 * @author dell
 *
 */
public class DirectSort {
	
   public void InsertSort(int arr[]) {
	   int i,j,tmp;
	   for(i=1;i<arr.length;i++) {
		   //用tmp来记载arr[i]处的元素值(哨兵)
		   tmp=arr[i];
		   j=i;
		   
		   //tmp<arr[j-1]:将比tmp值大的往后移动(求出的是正序排序)   |  tmp>arr[j-1]:将比tmp值小的往后移动(求出的是逆序排序)
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
