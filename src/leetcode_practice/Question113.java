package leetcode_practice;
import java.util.*;


public class Question113 {
/*
 * 113. 路径总和 II
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	
	List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>(); //dfs用来记录路径
    Map<TreeNode, TreeNode> map = new HashMap<>(); //bfs用来记录各节点父节点

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // 深度优先搜索
        dfs(root, sum, 0);
        return ans;

        // 解法2.广度优先搜索 bfs
        // 
        // if(root == null) return ans;
        // Queue<TreeNode> queueNode = new LinkedList<>();
        // Queue<Integer> queueSum = new LinkedList<>();
        // queueNode.offer(root);
        // queueSum.offer(0);

        // while(!queueNode.isEmpty())
        // {
        //     TreeNode node = queueNode.poll();
        //     int rec = queueSum.poll() + node.val;

        //     if(node.left == null && node.right == null)
        //     {
        //         if(rec == sum) getPath(node);
        //     }
        //     else
        //     {
        //         if(node.left != null)
        //         {
        //             map.put(node.left, node);
        //             queueNode.offer(node.left);
        //             queueSum.offer(rec);
        //         }
        //         if(node.right != null)
        //         {
        //             map.put(node.right, node);
        //             queueNode.offer(node.right);
        //             queueSum.offer(rec);
        //         }
        //     }

        // }
        // return ans;
    }

    public void getPath(TreeNode node)
    {
        List<Integer> temp = new ArrayList<>();
        while(node != null)
        {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ans.add(new ArrayList<>(temp));
    }


    // 解法1.深度优先搜索 dfs
    public void dfs(TreeNode root, int sum, int curSum)
    {
        if(root == null) return ;

        curSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null)
        {
            if(curSum == sum) ans.add(new ArrayList<Integer>(path));
            path.remove(path.size() - 1);
            curSum -= root.val;
            return;
        }
        dfs(root.left, sum, curSum);
        dfs(root.right, sum, curSum);
        path.remove(path.size() - 1);
    }
}
