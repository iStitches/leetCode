#include<iostream>
#include<vector>
#include<bitset>
using namespace std;

/*巧用bitset来实现二进制位上0和1的转化
  参考：https://www.cnblogs.com/magisk/p/8809922.html
 */
class mian_05_04 {
public:
	vector<int> findClosedNumbers(int num) {
		//调用bitset库函数将num转换为二进制
		bitset<32> bigNum(num);
		bitset<32> smallNum(num);
		int small=-1, big=-1;
		//找临近的最大值：右边往左数第一个01变为10，并且将剩余的1全部右移，这样得到的就是最大值
		for (int i =1; i < 32; i++){
			if (bigNum[i] == 0 && bigNum[i - 1] == 1){
				//找到后运用flip函数将对应位取反
				bigNum.flip(i);
				bigNum.flip(i - 1);

				//取反后将右侧剩余的1右移动----flip函数找到对称的1和0变换
				int left = i - 2, right = 0;
				while (left > right){
					while (bigNum[right] == 1)  //从右侧开始，遇到1就前进，遇到0就去找从左边开始的第一个1
						right++;
					while (bigNum[left] == 0)
						left--;
					if (left > right){
						bigNum.flip(right);
						bigNum.flip(left);
					}
				}
				big=(int)bigNum.to_ulong();
				break;
			}
		}

		//找临近的最小值：右边往左数第一个10变为01，并且将剩余的1全部左移，这样得到的就是最小值
		for (int i = 1; i < 32; i++){
			if (smallNum[i] == 1 && smallNum[i - 1] == 0){
				//找到后运用flip函数将对应位取反
				smallNum.flip(i);
				smallNum.flip(i - 1);

				//取反后将右侧剩余的1左移动----flip函数找到对称的1和0变换
				int left = i - 2, right = 0;
				while (left > right){
					while (smallNum[left] == 1)
						left--;
					while (smallNum[right] == 0)
						right++;
					if (left > right){
						smallNum.flip(right);
						smallNum.flip(left);
					}
				}
				small = (int)smallNum.to_ulong();
				break;
			}
		}
		return vector < int > {big, small};
	}
};