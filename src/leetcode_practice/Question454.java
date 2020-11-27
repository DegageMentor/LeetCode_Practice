package leetcode_practice;
import java.util.*;
/*
 * 454. 四数相加 II
给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

例如:

输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

输出:
2

解释:
两个元组如下:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */

public class Question454 {
	//总结，看到形如：A+B....+N=0的式子，要转换为(A+...T)=-((T+1)...+N)再计算，
	//这个T的分割点一般是一半，特殊情况下需要自行判断。定T是解题的关键
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        // 分组 + 哈希表
        Map<Integer, Integer> ab = new HashMap<>();
        for(int a : A)
        {
            for(int b : B)
            {
                int t = a + b;
                ab.put(t, ab.getOrDefault(t, 0) + 1);
            }
        }

        for(int c : C)
        {
            for(int d : D)
            {
                int t = -c - d;
                res += ab.getOrDefault(t, 0);
            }
        }
        return res;
    }
}
