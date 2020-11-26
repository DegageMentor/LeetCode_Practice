package leetcode_practice;
import java.util.*;
/*
 * 164. 最大间距
给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。

如果数组元素个数小于 2，则返回 0。

示例 1:

输入: [3,6,9,1]
输出: 3
解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
示例 2:

输入: [10]
输出: 0
解释: 数组元素个数小于 2，因此返回 0。
说明:

你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 */
public class Question164 {
	public int maximumGap(int[] nums) {
        int len = nums.length;
        if(len < 2) return 0;

        //桶排序
        int max_val = nums[0], min_val = nums[0];
        // 找出最大最小值
        for(int n : nums)
        {
            max_val = n > max_val? n : max_val;
            min_val = n < min_val? n : min_val;
        }
        // 确定每个桶的区间大小，桶的个数
        int bucket_size = Math.max(1, (max_val - min_val) / (len - 1));
        int bucket_num = (max_val - min_val) / bucket_size + 1;
        
        int[][] bucket = new int[bucket_num][2];
        for(int i = 0; i < bucket_num; i++) Arrays.fill(bucket[i], -1);
        for(int i = 0; i < len; i++)
        {
            int idx = (nums[i] - min_val) / bucket_size;
            if(bucket[idx][0] == -1)
            {
                bucket[idx][0] = nums[i];
                bucket[idx][1] = nums[i];
            }
            else
            {
                bucket[idx][0] = nums[i] < bucket[idx][0]? nums[i] : bucket[idx][0];
                bucket[idx][1] = nums[i] > bucket[idx][1]? nums[i] : bucket[idx][1];
            }
        }

        int res = 0;
        int pre = -1;
        for(int i = 0; i < bucket_num; i++)
        {
            if(bucket[i][0] == -1) continue;
            if(pre != -1)
            {
                res = Math.max(res, bucket[i][0] - bucket[pre][1]);
            }
            pre = i;
        }
        
        // Arrays.sort(nums);
        // int res = 0;
        // for(int i = 1; i < nums.length; i++)
        // {
        //     int t = nums[i] - nums[i - 1];
        //     if(t > res) res = t;
        // }
        
        return res;
    }
}
