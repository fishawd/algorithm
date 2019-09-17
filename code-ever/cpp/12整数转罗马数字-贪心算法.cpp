/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/8/13
 */

#include <iostream>

using namespace std;
/**
 * 解法1：贪心算法
 */
class Solution {
public:
    string intToRoman(int num) {
        string roman[13] = {
                "M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"
        };
        int nums[13] = {
                1000,900,500,400,100,90,50,40,10,9,5,4,1
        };
        string res;
        int i =0;
        while (i < 13){
            while (num >= nums[i]){
                num -= nums[i];
                res += roman[i];
            }
            i++;
        }
        return res;

    }
};