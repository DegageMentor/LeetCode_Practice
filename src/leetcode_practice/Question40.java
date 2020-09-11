package leetcode_practice;
import java.util.*;
/*
 * 40. ����ܺ� II
����һ������ candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�

candidates �е�ÿ��������ÿ�������ֻ��ʹ��һ�Ρ�

˵����

�������֣�����Ŀ������������������
�⼯���ܰ����ظ�����ϡ� 
ʾ�� 1:

����: candidates = [10,1,2,7,6,1,5], target = 8,
����⼯Ϊ:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
ʾ�� 2:

����: candidates = [2,5,2,1,2], target = 5,
����⼯Ϊ:
[
  [1,2,2],
  [5]
]
 */
public class Question40 {
	List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return ans;

    }

    public void dfs(int[] candidates, int target, int index, int sum)
    {
        if(sum == target)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i < candidates.length; i++)
        {
            int t = sum + candidates[i];
            if(t <= target)
            {
                temp.add(candidates[i]);
                dfs(candidates, target, i + 1, t);  //Ԫ�ز����ظ�ѡ��
        temp.remove(temp.size() - 1);
    }
    else break;

    while(i + 1 < candidates.length && candidates[i + 1] == candidates[i]) i++;//ȥ���ظ����
    }
}
}
