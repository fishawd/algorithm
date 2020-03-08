
/**
 * @author jian
 * @date 2020/3/8 20:08
 */
class DiffentPath2_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[rows][cols];
        // 第一行的所有格子只能从右移动走走过去,第一列的只能往下
        dp[0][0] = 1;
        for (int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] == 0)
                dp[i][0] = dp[i - 1][0];
            else
                dp[i][0] = 0;
        }
        for (int i = 1; i < cols; i++) {
            if (obstacleGrid[0][i] == 0)
                dp[0][i] = dp[0][i - 1];
            else
                dp[0][i] = 0;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

                } else {
                    dp[i][j] = 0;

                }
            }
        }
        return dp[rows - 1][cols - 1];

    }
}
