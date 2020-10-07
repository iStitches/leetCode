#include<iostream>
#include<vector>
#include<bitset>
using namespace std;

/*����bitset��ʵ�ֶ�����λ��0��1��ת��
  �ο���https://www.cnblogs.com/magisk/p/8809922.html
 */
class mian_05_04 {
public:
	vector<int> findClosedNumbers(int num) {
		//����bitset�⺯����numת��Ϊ������
		bitset<32> bigNum(num);
		bitset<32> smallNum(num);
		int small=-1, big=-1;
		//���ٽ������ֵ���ұ���������һ��01��Ϊ10�����ҽ�ʣ���1ȫ�����ƣ������õ��ľ������ֵ
		for (int i =1; i < 32; i++){
			if (bigNum[i] == 0 && bigNum[i - 1] == 1){
				//�ҵ�������flip��������Ӧλȡ��
				bigNum.flip(i);
				bigNum.flip(i - 1);

				//ȡ�����Ҳ�ʣ���1���ƶ�----flip�����ҵ��ԳƵ�1��0�任
				int left = i - 2, right = 0;
				while (left > right){
					while (bigNum[right] == 1)  //���Ҳ࿪ʼ������1��ǰ��������0��ȥ�Ҵ���߿�ʼ�ĵ�һ��1
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

		//���ٽ�����Сֵ���ұ���������һ��10��Ϊ01�����ҽ�ʣ���1ȫ�����ƣ������õ��ľ�����Сֵ
		for (int i = 1; i < 32; i++){
			if (smallNum[i] == 1 && smallNum[i - 1] == 0){
				//�ҵ�������flip��������Ӧλȡ��
				smallNum.flip(i);
				smallNum.flip(i - 1);

				//ȡ�����Ҳ�ʣ���1���ƶ�----flip�����ҵ��ԳƵ�1��0�任
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