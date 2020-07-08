package leetcode_practice;
/*
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
	机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
	
	现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
	网格中的障碍物和空位置分别用 1 和 0 来表示。
	
	说明：m 和 n 的值均不超过 100。
	
	示例 1:
	
	输入:
	[
	  [0,0,0],
	  [0,1,0],
	  [0,0,0]
	]
	输出: 2
	解释:
	3x3 网格的正中间有一个障碍物。
	从左上角到右下角一共有 2 条不同的路径：
	1. 向右 -> 向右 -> 向下 -> 向下
	2. 向下 -> 向下 -> 向右 -> 向右
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/unique-paths-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        //初始化第一行，第一列
        dp[0][0] = obstacleGrid[0][0] == 1? 0 : 1;
        for(int i = 1; i < obstacleGrid.length; i++)
        {
            dp[i][0] = obstacleGrid[i][0] == 1? 0 : dp[i-1][0];
        }
        for(int j = 1; j < obstacleGrid[0].length; j++)
        {
            dp[0][j] = obstacleGrid[0][j] == 1? 0 : dp[0][j-1];
        }
        
        //更新dp数组，如果当前位置有障碍物，dp[i][j] = 0; 否则dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for(int i = 1 ; i < obstacleGrid.length; i++)
        {
            for(int j = 1; j < obstacleGrid[0].length; j++)
            {
                dp[i][j] = obstacleGrid[i][j] == 1? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
