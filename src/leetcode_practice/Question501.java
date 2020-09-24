package leetcode_practice;
import java.util.*;

/*
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树
例如：
给定 BST [1,null,2,2],

   1
    \
     2
    /
   2
返回[2].

提示：如果众数超过1个，不需考虑输出顺序

进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question501 {
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	 }
	 
	 //关键：一棵 BST 的中序遍历序列是一个非递减的有序序列。
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
