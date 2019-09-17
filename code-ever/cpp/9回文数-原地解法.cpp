/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/8/2
 */

#include <iostream>

using namespace std;

/**
 * 算法思想:
 *  1.如果是负数肯定不是回文数
 *  2.如果末位是0，首位也得是0，只有0符合
 *  3.从后向前翻转数字，翻转到一半，如果两者相等，则是回文，否则不是
 */
class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int ans = 0;
        //若x比ans小，说明已经到一半了
        while (x > ans) {
            ans = 10 * ans + x % 10;
            x = x / 10;
        }

        /**
         *  1.如果是偶数位数,ans和x位数相等的时候，x和ans的关系，可能相等，可能小于，可能大于
         *   若 x == ans，循环终止，若x < ans，循环也终止，若x > ans，则循环继续，那么x和ans再也不能不可能相等了
         *  2.奇数位数，则当循环终止的时候, ans比x多一位，所以需要用 x 和 ans/10比较
         */
        return x == ans || x == ans / 10;

    }
};
