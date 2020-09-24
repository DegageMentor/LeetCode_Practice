package leetcode_practice;
import java.util.*;

import leetcode_practice.Question617.TreeNode;
/*
 * 538. 把二叉搜索树转换为累加树
	给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
	
	 
	
	例如：
	
	输入: 原始二叉搜索树:
	              5
	            /   \
	           2     13
	
	输出: 转换为累加树:
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
	
	// 反序中序遍历
	List<Integer> nums = new ArrayList<>();
    int n = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;
        // 遍历记录
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
