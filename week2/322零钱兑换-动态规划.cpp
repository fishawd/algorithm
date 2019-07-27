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
        //方法2,动态规划
        vector<int> dp(amount + 1,INT_MAX);//vector[x]表示凑成x需要多少硬币,INT_MAX表示凑不出
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            //对每个i试验所有硬币
            for (int coin : coins) {
                //i-coin可能小于0，因此需要作出判断
                //另外因为dp[i-coin]在dp[i]前边，所以若dp[i-coin]==INT_MAX，则一定拼不出，如果不加判断可能会溢出
                if (i >= coin && dp[i - coin] != INT_MAX)
                    dp[i] = min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] == INT_MAX ? -1: dp[amount];
    }
};