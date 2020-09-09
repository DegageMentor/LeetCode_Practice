package leetcode_practice;
import java.util.*;
/*
 * 39. ����ܺ�
����һ�����ظ�Ԫ�ص����� candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�

candidates �е����ֿ����������ظ���ѡȡ��

˵����

�������֣����� target��������������
�⼯���ܰ����ظ�����ϡ� 
ʾ�� 1��

���룺candidates = [2,3,6,7], target = 7,
����⼯Ϊ��
[
  [7],
  [2,2,3]
]
ʾ�� 2��

���룺candidates = [2,3,5], target = 8,
����⼯Ϊ��
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 

��ʾ��

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate �е�ÿ��Ԫ�ض��Ƕ�һ�޶��ġ�
1 <= target <= 500
 */
public class Question39 {
	List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);//���򷽱��֦
        dfs(candidates, 0, 0, target);
        return ans;
    }

    //�ݹ�
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
                dfs(candidates, i, t, target); //�����ظ�ѡȡ����˼����ӵ�ǰλ�õ���
                temp.remove(temp.size() - 1);
            }
            else break;//��Ϊ�������򣬺���Ҳȫ������target
        }
    }
}
