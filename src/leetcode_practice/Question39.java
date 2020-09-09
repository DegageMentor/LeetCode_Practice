package leetcode_practice;
import java.util.*;
/*
 * 39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：

输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 

提示：

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500
 */
public class Question39 {
	List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);//排序方便剪枝
        dfs(candidates, 0, 0, target);
        return ans;
    }

    //递归
    public void dfs(int[] candidates, int cur, int sum, int target)
    {
        if(sum == target)
        {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int i = cur; i < candidates.length; i++)
        {            
            int t = sum + candidates[i];
            if(t <= target) 
            {
                temp.add(candidates[i]);
                dfs(candidates, i, t, target); //可以重复选取，因此继续从当前位置调用
                temp.remove(temp.size() - 1);
            }
            else break;//因为数组升序，后面也全部大于target
        }
    }
}
