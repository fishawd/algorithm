/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/9/13
 */
#include <iostream>

using namespace std;


struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        //头结点
        ListNode *p = new ListNode(0);
        ListNode *res = p;
        while (l1 && l2) {
            if (l1->val < l2->val) {
                p->next = l1;
                l1 = l1->next;
                p = p->next;
            } else if (l1->val > l2->val) {
                p->next = l2;
                l2 = l2->next;
                p = p->next;
            } else {
                p->next = l1;
                l1 = l1->next;
                p = p->next;
                p->next = l2;
                l2 = l2->next;
                p = p->next;
            }
        }
        while (l1) {
            p->next = l1;
            l1 = l1->next;
            p = p->next;
        }
        while (l2) {
            p->next = l2;
            l2 = l2->next;
            p = p->next;
        }
        return res->next;
    }
};