package leetcode_practice;
/*
 * 321. 拼接最大数
给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。

求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。

说明: 请尽可能地优化你算法的时间和空间复杂度。

示例 1:

输入:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
输出:
[9, 8, 6, 5, 3]
示例 2:

输入:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
输出:
[6, 7, 6, 0, 4]
示例 3:

输入:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
输出:
[9, 8, 9]
 */
public class Question321 {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		
        // 从nums1中选i个数能组成最大值，从nums2中选K-i个数能组成最大值，
        // 两组数有序合并组成最大值，选择合适的i组成的最大值即为最终结果
		
		int[] res = new int[k];
		for(int i = 0; i < k; i++)
		{
			if(i < nums1.length && k - i < nums2.length)
			{
				int[] t = new int[k];

                int[] a1 = maxSubsequence(nums1, i);
                int[] a2 = maxSubsequence(nums2, k - i);

                // 合并两个数组，组成最大值
                int p = 0, p1 = 0, p2 = 0;
                while(p1 < a1.length || p2 < a2.length)
                {
                    if(p1 >= a1.length) t[p++] = a2[p2++];
                    else if(p2 >= a2.length) t[p++] = a1[p1++];
                    else if(a1[p1] > a2[p2]) t[p++] = a1[p1++];
                    else if(a1[p1] < a2[p2]) t[p++] = a2[p2++];
                    else{// 两数相等，选择后面最先出现更大值的数
                        int pp1 = p1 + 1, pp2 = p2 + 1;
                        while(pp1 < i && pp2 < k - i)
                        {
                            if(a1[pp1] > a2[pp2])
                            {
                                t[p++] = a1[p1++];
                                break;
                            }
                            if(a2[pp2] > a1[pp1])
                            {
                                t[p++] = a2[p2++];
                                break;
                            }
                            pp1++;
                            pp2++;
                        }
                        if(pp1 == i && pp2 == k - i)
                        {
                            while(p1 < i) t[p++] = a1[p1++];
                            while(p2 < k - i) t[p++] = a2[p2++];
                        }
                        else if(pp1 == i) t[p++] = a2[p2++];
                        else if(pp2 == k - i) t[p++] = a1[p1++];
                    }
                }

                //选择更优值
                for(int j = 0; j < k; j++)
                {
                    if(t[j] == res[j]) continue;
                    if(t[j] > res[j]) System.arraycopy(t, 0, res, 0, res.length);
                    break;
                }
            }
        }

        return res;
	}
	
	// 利用单调栈求一个数组中k个数能表示的最大数
	public int[] maxSubsequence(int[] nums, int k)
	{
		int len = nums.length;
		int[] stack = new int[k];
		
		int top = -1;
		int remain = len - k;
		for(int i = 0; i < len; i++)
		{
			while(top >= 0 && nums[i] > stack[top] && remain > 0)
			{
				top--;
				remain--;
			}
			if(top < k - 1)
			{
				stack[++top] = nums[i];
			}
			else
			{
				remain--;
			}
		}
		return stack;
	}
}
