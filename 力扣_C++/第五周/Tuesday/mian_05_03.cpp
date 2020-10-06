#include<string>
#include<iostream>
#include<algorithm>
using namespace std;

class mian_05_03{
public:
 //将某个数字的十进制转化为二进制： 用num去和1做与运算，做完后将num右移一位，然后循环操作32次
	/*
	  解题思路：
	     (1).动态规划---采用3个变量pre、cur、max
		    pre：遇到1就继续+1 ；遇到0就置0；
			cur：遇到1就cur++；遇到0就等于pre+1；
			max：每次取cur的最大值
	 */
	int reverseBits(int num) {
		int pre=0, cur=0, res=0,temp=0;
		//采用&运算将num的每一位的值获取出来
		for(int i=0;i<32;i++){
			temp = num & 1;
			num >>= 1;
			if (temp == 1)
			{
				pre++;
				cur++;
			}
			//如果为0，则pre置0，cur为当前pre+1
			else{
				cur = pre + 1;
				pre = 0;
			}
			//获取此时最大max
			res = max(max(pre, cur), res);
		}
		return res;
	}
};

int main(){
	mian_05_03 t;
	cout<<t.reverseBits(8);
	int a = 0;
}