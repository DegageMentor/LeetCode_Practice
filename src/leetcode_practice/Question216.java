package leetcode_practice;
import java.util.*;
/*
 * 216. ����ܺ� III
�ҳ��������֮��Ϊ n �� k ��������ϡ������ֻ������ 1 - 9 ��������������ÿ������в������ظ������֡�

˵����

�������ֶ�����������
�⼯���ܰ����ظ�����ϡ� 
ʾ�� 1:

����: k = 3, n = 7
���: [[1,2,4]]
ʾ�� 2:

����: k = 3, n = 9
���: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Question216 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    //�ݹ�
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

        for(int i = begin; i < 10; i++) // �����ֻ������1-9��������
        {
            temp.add(i);
            dfs(i + 1, k - 1, n - i);   //��i+1��ʼ���Һ�Ϊn-i��k-1���������
            temp.remove(temp.size() - 1);
        }
    }
}
