#include<iostream>
#include<bitset>
using namespace std;

class mian_05_06 {
public:
	int exchangeBits(int num) {
		bitset<32> bitNum(num);
		for (int i = 1; i < 32; i += 2){
			if (bitNum[i] != bitNum[i - 1]){
				int temp = bitNum[i - 1];
				bitNum[i-1] = bitNum[i];
				bitNum[i] = temp;
			}
		}
		return (int)bitNum.to_ulong();
	}
};