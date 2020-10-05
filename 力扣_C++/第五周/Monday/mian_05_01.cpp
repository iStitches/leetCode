#include<iostream>
using namespace std;

class mian_05_01{
public:
	int insertBits(int N, int M, int i, int j){
		//1.将N的第i到j位置为0
		/*
		   方法：采用与(&)运算，先将对应位全部置为0然后&，结果就一定为0；
		   类似的可以推理先将对应位全部置1，然后| 运算，结果就一定为1；
		         那么就需要构造i~j位为0的数，采用 t|1<<x (初始t为0，每次x+1，这样得到的结果就是连续的1)，然后取反就成0了
		 */
		int t = 0;
		//构造对应位为1的数
		for (int x = i; x <= j; x++){
			t = t | 1 << x;
		}
		//取反变为0
		t = ~t;
		//与N&，将对应位置0，其它位不变
		N = N&t;
		//最后将M左移i位，采用|来覆盖
		M = M << i;
		return N | M;
	}
};