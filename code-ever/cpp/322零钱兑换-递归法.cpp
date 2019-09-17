/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/7/26
 */
#include <iostream>
#include <climits>
#include <vector>
using namespace std;

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        //方法1，递归法
        int res = INT_MAX;
        if(amount == 0)
            return 0;
        for (int i = 0; i < coins.size(); ++i) {
            if (amount >= coins[i]){
                int temp = coinChange(coins, amount-coins[i]);
                if (temp != -1)
                    res = min(temp+1,res);
            }
        }
        return res == INT_MAX ? -1 : res;
    }
};


int main(){
    Solution solution;
    vector<int> vector = {1,2,5};
    int s = solution.coinChange(vector, 21);
    cout << s << endl;
}