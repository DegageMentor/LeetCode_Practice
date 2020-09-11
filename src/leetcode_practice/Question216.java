package leetcode_practice;
import java.util.*;
/*
 * 216. 组合总和 III
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Question216 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    //递归
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, k, n);
        return ans;
    }

    public void dfs(int begin, int k, int n)
    {
        if(k == 1 && n < 10)
        {
            int t = temp.size();
            if(t == 0 || temp.get(t-1) < n) 
            {
                temp.add(n);
                ans.add(new ArrayList<Integer>(temp));
                temp.remove(temp.size() - 1);
            }
            return;
        }

        for(int i = begin; i < 10; i++) // 组合中只允许含有1-9的正整数
        {
            temp.add(i);
            dfs(i + 1, k - 1, n - i);   //从i+1开始查找和为n-i的k-1个数的组合
            temp.remove(temp.size() - 1);
        }
    }
}
