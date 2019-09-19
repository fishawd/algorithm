
/**
 * @author jian
 * @date 2019/9/17 22:23
 */


/**
 * 动态规划
 * 1. dp[i]表示从0-i的有效长度
 * 2. 所有的'('都是0
 * 3. 如果s[i] == ')' 并且s[i-1] == '('，那么dp[i] = dp[i-2]+2
 * 4. 如果s[i] == ')' 并且s[i-1] == ')', 如果 dp[i-dp[i-1]-1] == '(', 那么dp[i] = dp[i-1] + dp[i-dp[i-1]-2]+2
 *
 *
 *
 * 例如 “)()())”，初始条件，dp={0,0,0,0,0,0}
 *
 *
 */
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int max = 0;
        int[] dp = new int[n];
        if (n <= 1)
            return max;
        for (int i = 1; i < n; i++) {

            if (s.charAt(i) == ')') {

                if (s.charAt(i - 1) == '(') {
                    if (i >= 2) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else if (s.charAt(i - 1) == ')' && i >= dp[i - 1] + 1 && s.charAt(i - dp[i - 1] - 1) == '(') {

                    if (i >= dp[i - 1] + 2) {
                        dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}

