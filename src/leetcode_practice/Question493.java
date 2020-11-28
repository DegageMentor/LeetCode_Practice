package leetcode_practice;
/*
 * 493. 翻转对
给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。

你需要返回给定数组中的重要翻转对的数量。

示例 1:

输入: [1,3,2,3,1]
输出: 2
示例 2:

输入: [2,4,3,5,1]
输出: 3
注意:

给定数组的长度不会超过50000。
输入数组中的所有数字都在32位整数的表示范围内。
 */
public class Question493 {
	public int reversePairs(int[] nums) {
        if(nums.length < 2) return 0;
        return reversePairsRecursive(nums, 0, nums.length - 1);
    }

    // 归并排序
    public int reversePairsRecursive(int[] nums, int left, int right)
    {
        if(left == right)
        {
            return 0;
        }

        int mid = (left + right) / 2;
        int n1 = reversePairsRecursive(nums, left, mid);
        int n2 = reversePairsRecursive(nums, mid + 1, right);

        // 统计下标对数量
        int res = n1 + n2;
        int r1 = mid;
        int r2 = right;
        while(r2 > mid)
        {
            long t = nums[r2];
            t = t << 1;
            while(r1 >= left && nums[r1] > t)
            {
                r1--;
            }
            res += mid - r1;
            r2--;
        }

        // 合并两个有序数组
        int[] sorted = new int[right - left + 1];
        int p1 = left, p2 = mid + 1, p = 0;
        while(p1 <= mid || p2 <= right)
        {
            if(p1 > mid) sorted[p++] = nums[p2++];
            else if(p2 > right) sorted[p++] = nums[p1++];
            else if(nums[p1] <= nums[p2]) sorted[p++] = nums[p1++];
            else sorted[p++] = nums[p2++];
        }


        for(int k = left; k <= right; k++)
        {
            nums[k] = sorted[k - left];
        }
        return res;
    }
}
