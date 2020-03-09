/**
 * @author jian
 * @date 2020/3/9 21:21
 */
public class MinPathSum_64 {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
//        dp[i][j]表示到i,j的路径的最小和
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
//        第一行和第一列是原始值
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (dp[i - 1][j] <= dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
