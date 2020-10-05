#include<iostream>
#include<math.h>
#include<string>
using namespace std;

class mian_05_02{
public:
	string printBin(double num) {
		if (num >= 1 || num <= 0)
			return "ERROR";
		string res("0.");
		int count = 30;
		while (count > 0 && num>0){
			num = num * 2;
			if (num >= 1)
			{
				res.append("1");
				num--;
			}
			else
				res.append("0");
			count--;
		}
		return num == 0 ? res : "ERROR";
	}
};

int main(){
	mian_05_02 t;
	t.printBin(0.625);
}