/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/7/30
 */
#include <iostream>
#include <vector>
using namespace std;

/**
 * 算法思想:
 *      这个官方给的算法的核心思路和我想的暴力法的核心思路一样，只是实现的就很优雅了。。。
 *      1.创建几个一维数组存放每行的字符
 *      2.当row = 0 时候向下, row = numRows -1 时候向上
 *      3.判断当前是向下走还是向上走来确定row的增减
 */
class Solution {
public:
    string convert(string s, int numRows) {
        string rstr;
        int row = 0;
        bool down = false; // 当前是否向下走
        if (numRows == 1)
            return s;
        //存放每行的字符
        vector<string> A(min(numRows, int(s.size())));
        for(char c : s){
            A[row] += c;
            if (row == 0 || row == numRows -1) // 关键判断，当row=0说明是第一行，往下走，当 row=numRows-1，往上走
                down = !down;
            row += down ? 1 : -1;
        }

        for(string string1 : A){
            rstr += string1;
        }
        return rstr;
    }
};