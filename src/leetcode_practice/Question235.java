package leetcode_practice;


public class Question235 {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while(root != p && root != q)
        {
            //当前节点就是分岔点,此时，p 和 q 在当前节点的不同的子树
            if(p.val > root.val && q.val < root.val || p.val < root.val && q.val > root.val) return root;
            
            //如果当前节点的值小于 p 和 q 的值，说明 p 和 q 应该在当前节点的右子树，因此将当前节点移动到它的右子节点
            if(p.val > root.val && q.val > root.val)
            {
                root = root.right;
            }
            else//如果当前节点的值大于 p 和 q 的值，说明 p 和 q 应该在当前节点的左子树，因此将当前节点移动到它的左子节点
            {
                root = root.left;
            }
        }
        return root;
    }
}
