package leetcode_practice;
/*
 * 416. 分割等和子集
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].
 

示例 2:

输入: [1, 2, 3, 5]

输出: false

解释: 数组不能分割成两个元素和相等的子集.
 */
public class Question416 {
	public boolean canPartition(int[] nums) {
        if(nums == null || nums.length < 2) return false;

        // 计算所有元素之和并记录最大值
        int max = 0;
        int sum = 0;
        for(int n : nums)
        {
            sum += n;
            max = n > max? n : max;
        }

        // 若和为奇数，直接返回false
        if(sum % 2 == 1 || max > sum / 2) return false;

        //对数组进行排序
        //Arrays.sort(nums);

        //动态规划
        int target = sum / 2;
        // dp[i][j]表示从数组nums下标0到i中能否取出一组数使得其和为j
        boolean[][] dp = new boolean[nums.length][target + 1];

        //初始化
        for(int i = 0; i < nums.length; i++) dp[i][0] = true;
        dp[0][nums[0]] = true;

        for(int i = 1; i < nums.length; i++)
        {
            for(int j = 1; j <= target; j++)
            {
                if(nums[i] > j)
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i]];
                }
                
            }
        }
        return dp[nums.length - 1][target];

        
    }
}
