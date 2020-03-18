/**
 * @author jian
 * @date 2020/3/18 23:18
 */
public class Rob_213 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return Math.max(rob2(nums, 0, n - 1), rob2(nums, 1, n));
        }

    }

    // 将环形结构分成两种情况，一种是偷第一个不偷最后一个，另一种是不偷第一个偷最后一个
    private int rob2(int[] nums, int start, int end) {
        int n = nums.length;
        int[] dp = new int[n];

        if (start == 0) {
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            dp[n - 1] = 0;
        } else {
            dp[0] = 0;
            dp[1] = nums[1];
        }
        for (int i = 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end - 1];
    }
}
