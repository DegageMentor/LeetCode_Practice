package leetcode_practice;
import java.util.*;


/*
 * 106. 从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 */
public class Question106 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	TreeNode root;
	// 记录中序数组各元素索引
	Map<Integer, Integer> map_in = new HashMap<>();

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length == 0)
			return root;
		for (int i = 0; i < inorder.length; i++) {
			map_in.put(inorder[i], i);
		}

		return helper(inorder, postorder, root, 0, inorder.length - 1, 0, postorder.length - 1);
	}

	// 后序遍历的最后一个元素为root,在中序数组中找到root,拆分两个子树，递归构造
	public TreeNode helper(int[] inorder, int[] postorder, TreeNode root, int in_left, int in_right, int post_left,
			int post_right) {
		if (in_left == in_right) {
			root = new TreeNode(inorder[in_left]);
			return root;
		}
		if (in_left < in_right) {
			root = new TreeNode(postorder[post_right]);
			int in_root = map_in.get(postorder[post_right]);
			root.left = helper(inorder, postorder, root.left, in_left, in_root - 1, post_left,
					post_left + in_root - 1 - in_left);
			root.right = helper(inorder, postorder, root.right, in_root + 1, in_right, post_left + in_root - in_left,
					post_right - 1);
		}

		return root;
	}
	
	// 更好的解法
//	int post_idx;
//    int[] postorder;
//    int[] inorder;
//    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();
//
//    public TreeNode helper(int in_left, int in_right) {
//        // 如果这里没有节点构造二叉树了，就结束
//        if (in_left > in_right) {
//            return null;
//        }
//
//        // 选择 post_idx 位置的元素作为当前子树根节点
//        int root_val = postorder[post_idx];
//        TreeNode root = new TreeNode(root_val);
//
//        // 根据 root 所在位置分成左右两棵子树
//        int index = idx_map.get(root_val);
//
//        // 下标减一
//        post_idx--;
//        // 构造右子树
//        root.right = helper(index + 1, in_right);
//        // 构造左子树
//        root.left = helper(in_left, index - 1);
//        return root;
//    }
//
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        this.postorder = postorder;
//        this.inorder = inorder;
//        // 从后序遍历的最后一个元素开始
//        post_idx = postorder.length - 1;
//
//        // 建立（元素，下标）键值对的哈希表
//        int idx = 0;
//        for (Integer val : inorder) {
//            idx_map.put(val, idx++);
//        }
//        
//        return helper(0, inorder.length - 1);
//    }

}
