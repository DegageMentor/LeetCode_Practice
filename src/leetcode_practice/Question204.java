package leetcode_practice;
import java.util.*;

/*
 * 204. 计数质数
统计所有小于非负整数 n 的质数的数量。

 

示例 1：

输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
示例 2：

输入：n = 0
输出：0
示例 3：

输入：n = 1
输出：0
 */
public class Question204 {
    public int countPrimes(int n) {
        int res = 0;
        if(n < 3) return res;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        
        //埃氏筛	时间复杂度：O(nloglogn)
        for(int i = 2; i < n; i++)
        {
            if(isPrime[i])
            {
                res++;
                if((long)i * i < n)
                {
                    for(int j = i * i; j < n; j += i) isPrime[j] = false;
                }
            }
        }
        return res;
    }
}
