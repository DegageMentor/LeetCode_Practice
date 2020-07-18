package leetcode_practice;
/*
 * 309. 最佳买卖股票时机含冷冻期
	给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
	
	设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
	
	你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
	卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
	示例:
	
	输入: [1,2,3,0,2]
	输出: 3 
	解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
class Question309 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
        {
            return 0;
        }
        // 动态规划
        // 定义dp数组，dp[i]表示前i(即i+1)天能获得的最大利润
        // dp[i][0]表示第i天持有股票时获得的最大利润，dp[i][1]表示第i天未持有股票但处于冷冻期，dp[i][2]表示第i天未持有股票且不处于冷冻期
        // int n = prices.length;
        // int[][] dp = new int[n][3];
        // dp[0][0] = -prices[0];

        // for(int i = 1; i < n; i++)
        // {
        //     dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
        //     dp[i][1] = dp[i - 1][0] + prices[i];
        //     dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        // }

        // // 只需返回dp[n-1][1]和dp[n-1][2]中的较大值即可
        // return Math.max(dp[n - 1][1], dp[n - 1][2]);
        
        // 解法2
        // dp[i][]只取决于dp[i-1]的值，空间上可以优化
        int[] dp = new int[3];
        dp[0] = -prices[0];
        for(int i = 1; i < prices.length; i++)
        {
            int t0 = dp[0];
            int t1 = dp[1];
            dp[0] = Math.max(dp[0], dp[2] - prices[i]);
            dp[1] = t0 + prices[i];
            dp[2] = Math.max(t1, dp[2]);
        }
        return Math.max(dp[1], dp[2]);
    }
}
