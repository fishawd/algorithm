/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/9/11
 */

#include <iostream>

using namespace std;


struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

/** 方法二：一次遍历 快慢指针法（双指针）
  * 第一个指针先移动n+1，此时第二个指针与第一个指针之间的距离为n，当第一个指针移动到尾部时，第二个指针指向被删除的节点
  */

class Solution {
public:
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        if (!head)
            return head;
        ListNode *fast = new ListNode(0);
        fast->next = head;
        ListNode *slow = fast;
        ListNode *q = fast;//保存头指针

        int i = 0;
        while (fast) {
            i++;
            fast = fast->next;
            if (i >= n + 2) //从n+2开始是为了找出被删除结点的前一个结点
                slow = slow->next;
        }
        if (slow && slow->next)
            slow->next = slow->next->next;
        return q->next;
    }
};

int main() {
    Solution s;
    ListNode *listNode = new ListNode(1);
    ListNode *listNode1 = new ListNode(2);
    ListNode *listNode2 = new ListNode(3);
    ListNode *listNode3 = new ListNode(4);
    ListNode *listNode4 = new ListNode(5);
    listNode->next = listNode1;
    listNode1->next = listNode2;
    listNode2->next = listNode3;
    listNode3->next = listNode4;

    ListNode *head = s.removeNthFromEnd(listNode, 2);
    cout << head->val << endl;
}