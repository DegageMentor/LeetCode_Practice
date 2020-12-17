package leetcode_practice;

/*
 * 714. 买卖股票的最佳时机含手续费
给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。

你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

返回获得利润的最大值。

注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

示例 1:

输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
输出: 8
解释: 能够达到的最大利润:  
在此处买入 prices[0] = 1
在此处卖出 prices[3] = 8
在此处买入 prices[4] = 4
在此处卖出 prices[5] = 9
总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
注意:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.
 */
public class Question714 {
    public int maxProfit(int[] prices, int fee) {
        // 动态规划
    	// dp[i][0]表示第 i 天交易完后手里没有股票的最大利润， dp[i][1] 表示第 i天交易完后手里持有一支股票的最大利

    	// int[][] dp = new int[prices.length][4];	

        // dp[0][0] = -prices[0];  // 手里有股票
        // dp[0][1] = 0;           // 手里没股票


        // for(int i = 1; i < prices.length; i++)
        // {
        //     dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
        //     dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
        // }
        // return dp[prices.length - 1][1];

    	
        // 贪心
    	// 当我们卖出一支股票时，我们就立即获得了以相同价格并且免除手续费买入一支股票的权利。
    	// 在遍历完整个数组 prices 之后之后，我们就得到了最大的总收益

        int n = prices.length;
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            }
            else if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }
}
