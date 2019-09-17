/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/8/1
 */
#include <iostream>
#include <climits>
using namespace std;

/**
 * 算法思想:
 *  1.遍历，判断第一个非空字符是 + - or num
 *  2.+ - num的情况  ans = 10*ans + i;
 */
class Solution {
public:
    int myAtoi(string str) {
        int ans = 0;
        bool neg = false; //负数标志，如果是负数，用-1乘

        int i = 0;
        int n = str.size();
        //先找到第一个非空字符
        while(i < n){
            if(str[i] != ' ')
                break;
            i++;
        }
        //若全是空或者第一个非空字符是字母

        if ( i == n || (str[i] >= 'a' && str[i] <= 'z') || (str[i] >= 'A' && str[i] <= 'Z'))
            return 0;
        else if(str[i] == '+' || str[i] == '-'){
            if (str[i] == '-')
                neg = true;
            i++;
        }

        while(str[i] >= '0' && str[i] <= '9' && i < n){
            //判断溢出
            if(ans > INT_MAX/10 || (ans == INT_MAX/10 && int(str[i] - '0') > 7))
                return INT_MAX;
                //-2147483648
            else if(ans < INT_MIN/10 || ( ans == INT_MIN/10 && -1*int(str[i]-'0') < -8))
                return INT_MIN;
            else{
                if(neg){
                    ans = 10 * ans + -1*int(str[i]-'0');
                } else{
                    ans = 10 * ans + int(str[i]-'0');
                }
                i++;
            }
        }
        return ans;

    }
};