/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/8/1
 */
#include <iostream>

/**
 *  将数字转换成字符串来判断，时间复杂度o(n),空间复杂度o(n)
 */
class Solution {
public:
    bool isPalindrome(int x) {
        string rstr;
        if (x < 0)
            return false;
        while (x != 0) {
            rstr += x % 10;
            x = x / 10;
        }
        int i = 0, j = rstr.size() - 1;
        while (i < j) {
            if (rstr[i] != rstr[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
};