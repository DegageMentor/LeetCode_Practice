package leetcode_practice;
import java.util.*;

/*
 * 78. 子集
	给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
	
	说明：解集不能包含重复的子集。
	
	示例:
	
	输入: nums = [1,2,3]
	输出:
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
 */
public class Question78 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    public void dfs(int[]nums, int index)
    {
        if(index == nums.length)
        {
            ans.add(new ArrayList<>(temp));
            return ;
        }
        
        temp.add(nums[index]);
        dfs(nums, index + 1);
        temp.remove(temp.size() - 1);
        dfs(nums, index + 1);
    }
}
