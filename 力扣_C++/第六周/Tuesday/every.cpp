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
	/*  �Լ���д��
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
	//�ݹ鷽����ȷ���ݹ���ڡ�����ֵ���ݹ鵥Ԫ���Ĺ���
	ListNode* swapPairs(ListNode* head) {
		if (head == NULL || head->next == NULL)
			return head;
		//���Ĺ���������head��next----����һ��newHead��������һ����ԭ�ȵ�next��Ȼ���ԭ�ȵ�next��һ���ݹ�
		ListNode* newHead = head->next;
		ListNode* next = newHead->next;
		newHead->next = head;

		//�ݹ飺head����һ�����ڵݹ����swapPairs�õ�������ͷ
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