package leetcode_practice;
import java.util.*;

/*
 * 78. �Ӽ�
	����һ�鲻���ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����
	
	˵�����⼯���ܰ����ظ����Ӽ���
	
	ʾ��:
	
	����: nums = [1,2,3]
	���:
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
