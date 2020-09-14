package leetcode_practice;
import java.util.*;

/*
 * 给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question94 {

	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; 
		 }
	 }
	 
	//迭代(原理与递归相同，递归的时候隐式地维护了一个栈，而迭代的时候需要显式地将这个栈模拟出来) 
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        Deque<TreeNode> st = new LinkedList<>();
        while(root != null || !st.isEmpty())
        {
            while(root != null)
            {
                st.offerFirst(root);
                root = root.left;
            }
            root = st.pollFirst();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }


    //递归 中序遍历
    // List<Integer> ans = new ArrayList<>();
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     inorder(root);
    //     return ans;
    // }

    // public void inorder(TreeNode root)
    // {
    //     if(root == null) return ;

    //     inorder(root.left);
    //     ans.add(root.val);
    //     inorder(root.right);
    // }
}
