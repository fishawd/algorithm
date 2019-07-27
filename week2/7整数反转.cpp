/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/7/26
 */
#include <iostream>
#include <climits>

using namespace std;

class Solution {
public:
    int reverse(int x) {
        int revnum = 0;
        while (x!=0){
            int temp = x % 10;
            x = x/ 10;
            //判断是否会溢出
            if (revnum > INT_MAX/10 || (revnum == INT_MAX/10 && temp > 7))
                return 0;
            if (revnum < INT_MIN/10 || (revnum == INT_MAX/10 && temp < -8))
                return 0;
            revnum = 10 * revnum + temp;
        }
    return revnum;
    }
};


int main(){
    Solution solution;
    int s = solution.reverse(123);
    cout << s << endl;
}