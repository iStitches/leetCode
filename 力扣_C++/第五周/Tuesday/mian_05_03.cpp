#include<string>
#include<iostream>
#include<algorithm>
using namespace std;

class mian_05_03{
public:
 //��ĳ�����ֵ�ʮ����ת��Ϊ�����ƣ� ��numȥ��1�������㣬�����num����һλ��Ȼ��ѭ������32��
	/*
	  ����˼·��
	     (1).��̬�滮---����3������pre��cur��max
		    pre������1�ͼ���+1 ������0����0��
			cur������1��cur++������0�͵���pre+1��
			max��ÿ��ȡcur�����ֵ
	 */
	int reverseBits(int num) {
		int pre=0, cur=0, res=0,temp=0;
		//����&���㽫num��ÿһλ��ֵ��ȡ����
		for(int i=0;i<32;i++){
			temp = num & 1;
			num >>= 1;
			if (temp == 1)
			{
				pre++;
				cur++;
			}
			//���Ϊ0����pre��0��curΪ��ǰpre+1
			else{
				cur = pre + 1;
				pre = 0;
			}
			//��ȡ��ʱ���max
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