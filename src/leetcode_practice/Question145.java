package leetcode_practice;
import java.util.*;

/*
 * 给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Question145 {
	
	 // Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	 
	List<Integer> ans = new ArrayList<>();
	
    public List<Integer> postorderTraversal(TreeNode root) {
        // post_order(root);
    	
    	//解法2.迭代
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode cur = root;
    	TreeNode last = null;
    	while(cur != null || !stack.isEmpty())
    	{
    		while(cur != null)
    		{
    			stack.push(cur);
    			cur = cur.left;
    		}
    		cur = stack.peek();
    		if(cur.right == null || cur.right == last)
    		{
    			cur = stack.pop();
    			ans.add(cur.val);
    			last = cur;
    			cur = null;
    		}
    		else
    		{
    			cur = cur.right;
    		}
    	}
    	
        return ans;
    }
    
    // 解法1.递归
    public void post_order(TreeNode root)
    {
        if(root == null) return;

        post_order(root.left);
        post_order(root.right);
        ans.add(root.val);
    }
	
}
