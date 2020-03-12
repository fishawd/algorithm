/**
 * @author jian
 * @date 2020/3/12 22:45
 */
public class UniqueBinaryTree_96 {
    // dp[i]表示以i为节点有多少个二叉搜索树
    // 二叉搜索树特点， 左子树小于父节点，右子树大于父节点
    // dp[1] = 1, dp[2] = 2, dp[3] = 5
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
