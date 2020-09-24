package leetcode_practice;
import java.util.*;

import leetcode_practice.Question617.TreeNode;
/*
 * 538. �Ѷ���������ת��Ϊ�ۼ���
	����һ��������������Binary Search Tree��������ת����Ϊ�ۼ�����Greater Tree)��ʹ��ÿ���ڵ��ֵ��ԭ���Ľڵ�ֵ�������д������Ľڵ�ֵ֮�͡�
	
	 
	
	���磺
	
	����: ԭʼ����������:
	              5
	            /   \
	           2     13
	
	���: ת��Ϊ�ۼ���:
	             18
	            /   \
	          20     13
 */
public class Question538 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	// �����������
	List<Integer> nums = new ArrayList<>();
    int n = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;
        // ������¼
        postTravel(root, 0);
        nums.add(0);
        for(int i : nums)
            System.out.println(i);
        //
        postTravel(root, 1);

        return root;
    }

    public void postTravel(TreeNode root, int set)
    {
        if(root == null) return;
        postTravel(root.right, set);
        if(set == 0)
        {
            nums.add(root.val);
            n++;
        }
        else
        {
            n--;
            nums.set(n, nums.get(n) + nums.get(n+1));
            root.val = nums.get(n);
        }
        postTravel(root.left, set);
    }
}
