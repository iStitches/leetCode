#include<iostream>
using namespace std;

struct ListNode{
	int val;
	ListNode * next;
	ListNode() : val(0), next(nullptr) {}
	ListNode(int x) : val(x), next(nullptr) {}
	ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class every {
public:
	ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
		ListNode * l3 = new ListNode(0);
		ListNode * m = l3;
		int cur = 0, next = 0,num1=0,num2=0;
		while (l1 != NULL || l2 != NULL || next != 0){
			num1 = l1 == NULL ? 0 : l1->val;
			num2 = l2 == NULL ? 0 : l2->val;
			cur = (num1 + num2 + next) % 10;
			next = (num1 + num2 + next) / 10;
			ListNode *t = new ListNode(cur);
			m->next = t;
			m = t;
			if (l1) l1 = l1->next;
			if (l2)l2 = l2->next;
		}
		return l3->next;
	}
};

int main(){
	ListNode *h1 = new ListNode(9);
	ListNode *h2 = new ListNode(9);
	ListNode *h3 = new ListNode(9);
	ListNode *h4 = new ListNode(9);
	ListNode *h5 = new ListNode(9);
	ListNode *h6 = new ListNode(9);
	ListNode *h7 = new ListNode(9);
	h1->next = h2;
	h2->next = h3;
	h3->next = h4;
	h4->next = h5;
	h5->next = h6;
	h6->next = h7;

	ListNode *r1 = new ListNode(9);
	ListNode *r2 = new ListNode(9);
	ListNode *r3 = new ListNode(9);
	ListNode *r4 = new ListNode(9);
	r1->next = r2;
	r2->next = r3;
	r3->next = r4;
	every t;
	t.addTwoNumbers(h1, r1);
}