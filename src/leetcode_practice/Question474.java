package leetcode_practice;
/*
 * 474. 一和零
在计算机界中，我们总是追求用有限的资源获取最大的收益。

现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。

你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。

 

示例 1:

输入: strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
输出: 4
解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
示例 2:

输入: strs = ["10", "0", "1"], m = 1, n = 1
输出: 2
解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
 

提示：

1 <= strs.length <= 600
1 <= strs[i].length <= 100
strs[i] 仅由 '0' 和 '1' 组成
1 <= m, n <= 100
 */

public class Question474 {
    public int findMaxForm(String[] strs, int m, int n) {
    	//nums数组记录strs中各个字符串0，1的个数及str长度
        int[][] nums = new int[strs.length][2];
        for(int i = 0; i < strs.length; i++)
        {
            for(char c : strs[i].toCharArray())
            {
                nums[i][c-'0']++;
            }
        }
        
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        // dp[k][i][j] 表示遍历到第k-1k−1个字符的时候，使用ii个0，jj个1的时候，能够拼出的字符串的最大数量
        for(int k = 1; k <= strs.length; k++)
        {
            for(int i = 0; i <= m; i++)
            {
                for(int j = 0; j <= n; j++)
                {
                    if(i >= nums[k-1][0] && j >= nums[k-1][1])
                    {
                        dp[k][i][j] = Math.max(dp[k-1][i][j], dp[k-1][i-nums[k-1][0]][j-nums[k-1][1]] + 1);
                    }
                    else
                    {
                        dp[k][i][j] = dp[k-1][i][j];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
}
