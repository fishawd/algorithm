/**
 * @author jian
 * @date 2020/3/10 22:14
 */
public class ClimbStairs_70 {
    //    动态规划
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    // 实际上是个裴波纳契数列，递归法
    public int climbStairs2(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }
}
