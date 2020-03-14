/**
 * @author jian
 * @date 2020/3/14 22:53
 */
public class BestTime_121 {
    // 思路：用一个变量存储最低价格，一个存储在当前位置卖出的价格
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int min_price = prices[0];
        int sail_max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min_price) {
                sail_max = Math.max(prices[i] - min_price, sail_max);
            }else {
                min_price = prices[i];
            }
        }
        return sail_max;
    }
}
