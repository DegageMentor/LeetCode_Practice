package leetcode_practice;
import java.util.*;

/*
 * 637. 二叉树的层平均值
给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。

 

示例 1：

输入：
    3
   / \
  9  20
    /  \
   15   7
输出：[3, 14.5, 11]
解释：
第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 

提示：

节点值的范围在32位有符号整数范围内。

 */

public class Question637 {
	public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;

		TreeNode(int x) {
			val = x;
		}
}
    // 广度优先搜索，类似层次遍历
    // public List<Double> averageOfLevels(TreeNode root) {
        // List<Double> res = new ArrayList<>();
        // if(root == null) return res;
        // Queue<TreeNode> qu = new LinkedList<>();
        // qu.offer(root); //将root添加到队列，先入先出
        // while(!qu.isEmpty())
        // {
        //     double sum = 0.0;
        //     int num = qu.size();
        //     for(int i = 0; i < num; i++)
        //     {
        //         TreeNode t = qu.poll(); //获取当前层的所以非空节点
        //         sum += t.val;
        //         if(t.left != null) qu.offer(t.left);    //将当前节点所有非空子节点加入队列
        //         if(t.right != null) qu.offer(t.right);
        //     }
        //     res.add(sum / num);
        // }
        // return res;

    // }

    //深度优先搜索，过程中记录每一层的节点个数和和
    List<Double> res = new ArrayList<>();
    List<Double> sum = new ArrayList<>();
    List<Integer> count = new ArrayList();
    public List<Double> averageOfLevels(TreeNode root)
    {
        dfs(root, 0);
        for(int i = 0; i < sum.size(); i++) res.add(sum.get(i) / count.get(i));
        return res;
    }

    public void dfs(TreeNode root, int level)
    {
        if(root == null) return;

        if(level < sum.size())
        {
            sum.set(level, sum.get(level) + root.val);
            count.set(level, count.get(level) + 1);
        }
        else
        {
            sum.add((double)root.val);
            count.add(1);
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
