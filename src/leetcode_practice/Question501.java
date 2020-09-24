package leetcode_practice;
import java.util.*;

/*
 * ����һ������ֵͬ�Ķ�����������BST�����ҳ� BST �е���������������Ƶ����ߵ�Ԫ�أ���

�ٶ� BST �����¶��壺

�������������������ֵС�ڵ��ڵ�ǰ����ֵ
�������������������ֵ���ڵ��ڵ�ǰ����ֵ
�����������������Ƕ���������
���磺
���� BST [1,null,2,2],

   1
    \
     2
    /
   2
����[2].

��ʾ�������������1�������迼�����˳��

���ף�����Բ�ʹ�ö���Ŀռ��𣿣������ɵݹ��������ʽ����ջ�Ŀ��������������ڣ�

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Question501 {
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	 }
	 
	 //�ؼ���һ�� BST ���������������һ���ǵݼ����������С�
    int base;
    int count;
    int maxCount;
    List<Integer> ans = new ArrayList<>();
    
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        base = root.val + 1;
        count = 1;
        maxCount = 0;
        dfs(root);
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
        {
            res[i] = ans.get(i);
        }
        return res;
        
    }

    public void dfs(TreeNode root)
    {
        if(root == null) return;

        dfs(root.left);
        if(root.val == base)
        {
            count++;
        }
        else
        {
            base = root.val;
            count = 1;
        }
        
        if(count == maxCount)
        {
            ans.add(root.val);
        }
        else if(count > maxCount)
        {
            ans.clear();
            ans.add(root.val);
            maxCount = count;
        }

        dfs(root.right);
    }
}
