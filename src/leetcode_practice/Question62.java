package leetcode_practice;
/*
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？

示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28
 

提示：

1 <= m, n <= 100
题目数据保证答案小于等于 2 * 10 ^ 9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question62 {
	public int uniquePaths(int m, int n) {
        // //排列组合 c(m + n - 2, m - 1)
        // long t1 = 1;	//避免计算越界
        // long t2 = 1;
        // int min = Math.min(m - 1, n - 1);
        // if(min == 0)
        // {
        //     return 1;
        // }
        // int steps = m + n - 2;
        // for(int i = 1; i <= min; i++)
        // {
        //     t1 = t1 * steps--;
        //     t2 = t2 * i;
        // }
        // return (int)(t1 / t2);

        //动态规划
        int[][] dp = new int[m][n]; //dp[i][j]表示到达i行j列所需的步数，dp[i][j] = dp[i-1][j] + dp[i][j-1]
        // 初始化第1行，第1列为1
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
	}

}
