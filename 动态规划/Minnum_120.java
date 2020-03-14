import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jian
 * @date 2020/3/13 23:21
 */
public class Minnum_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return Collections.min(triangle.get(0));
        }
        int rows = triangle.size();
        int cols = triangle.get(rows - 1).size();
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < triangle.get(0).size(); i++) {
            dp[0][i] = triangle.get(0).get(i);
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        return Arrays.stream(dp[rows - 1]).min().getAsInt();
    }

    // 自顶向下，o(n)复杂度
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp存储第i行的各个元素的最短路径
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        // pre1存储dp[i-1][j-1],pre2存储dp[i-1][j]
        int pre1 = dp[0];
        int pre2;
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                pre2 = dp[j];
                if (j == 0) {
                    dp[j] = pre2 + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[j] = pre1 + triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(pre1, pre2) + triangle.get(i).get(j);
                }
                pre1 = pre2;
            }

        }
        return Arrays.stream(dp).min().getAsInt();
    }

    // 自下而上，不用判断边界
}
