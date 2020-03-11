/**
 * @author jian
 * @date 2020/3/11 23:05
 */
public class DecodeWay_91 {
    //    思路：dp[i]表示到i的最多方法
    //    dp[0] = 1, dp[1] = 2, dp[2] = dp[i-1] + dp[i-2]
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        if (n > 1){
            if (s.charAt(1) == '0'){
                if (s.charAt(0) == '1'|| s.charAt(0) == '2'){
                    dp[1] = 1;
                }else {
                    return 0;
                }
            }else{
                if (s.charAt(0) =='1' || (s.charAt(0) == '2' && s.charAt(1) <= '6')){
                    dp[1] = 2;
                }else {
                    dp[1] = 1;
                }
            }
        }else {
            return 1;
        }

        for (int i = 2; i < n; i++) {
            if (s.charAt(i) == '0'){
                if (s.charAt(i - 1) == '0') {
                    return 0;
                }
                if (s.charAt(i-1) == '1'|| s.charAt(i-1) == '2'){
                    dp[i] = dp[i-2];
                }else {
                    return 0;
                }
            }else {
                if (s.charAt(i-1) == '0'){
                    dp[i] = dp[i-1];
                }else {
                    if (s.charAt(i-1) =='1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')){
                        dp[i] = dp[i-1] + dp[i-2];
                    }else {
                        dp[i] = dp[i-1];
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
