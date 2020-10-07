#include<iostream>
#include<bitset>
using namespace std;

class mian_05_05 {
public:
	int convertInteger(int A, int B) {
		bitset<32> numA(A);
		bitset<32> numB(B);
		int count = 0;
		for (int i = 0; i < 32; i++){
			if (numA[i] != numB[i])
				count++;
		}
		return count;
	}
};