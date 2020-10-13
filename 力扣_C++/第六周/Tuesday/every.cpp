#include<iostream>
using namespace std;

struct ListNode{
	int val;
	ListNode* next;
	ListNode(int x) :val(x), next(NULL){}
	ListNode() :val(0), next(NULL){}
};

class every{
public:
	/*  自己的写法
	ListNode* swapPairs(ListNode* head) {
		int count = 0;
		ListNode* h1,*h2,*h3,*h4;

		h1 = NULL;
		h2 = head;
		h3 = head->next;
		h4 = new ListNode();

		if (!h2 || !h3)
			return h2;

		h4->next = h3;
		while (h2 && h3){
			h2->next = h3->next;
			h3->next = h2;
			if (h1){
				h1->next = h3;
			}
			h1 = h2;
			h2 = h2->next;
			if (h2)
				h3 = h2->next;
		}
		return head;
	}
	*/
	/*
	//递归方案：确定递归出口、返回值、递归单元做的工作
	ListNode* swapPairs(ListNode* head) {
		if (head == NULL || head->next == NULL)
			return head;
		//做的工作：交换head与next----生成一个newHead，它的下一个是原先的next，然后对原先的next进一步递归
		ListNode* newHead = head->next;
		ListNode* next = newHead->next;
		newHead->next = head;

		//递归：head的下一步等于递归调用swapPairs得到的链表头
		head->next = swapPairs(next);

		return newHead;
	}*/

	ListNode* swapPairs(ListNode* head){
		ListNode* pre = NULL, *cur = head, *pre = NULL;
		if (!cur)
			return cur;
		pre = cur->next;
		while ()
	}
};

int main(){
	ListNode* h1 = new ListNode(1);
	ListNode* h2 = new ListNode(2);
	ListNode* h3 = new ListNode(3);
	ListNode* h4 = new ListNode(4);
	h1->next = h2;
	h2->next = h3;
	h3->next = h4;

	every t;
	t.swapPairs(h1);
}