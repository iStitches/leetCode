#include<iostream>
#include<string>
using namespace std;

 
class every {
public:
    int numJewelsInStones(string J, string S) {
        int count=0;
        for(int i=0;i<S.length();i++){
            if(J.find(S[i]) != -1)
               count++;
        }
        return count;
    }
};

int main(){
	every s;
	cout<<s.numJewelsInStones("aA","aAAbbbb");
}
