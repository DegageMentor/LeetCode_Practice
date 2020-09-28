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
            //��ǰ�ڵ���Ƿֲ��,��ʱ��p �� q �ڵ�ǰ�ڵ�Ĳ�ͬ������
            if(p.val > root.val && q.val < root.val || p.val < root.val && q.val > root.val) return root;
            
            //�����ǰ�ڵ��ֵС�� p �� q ��ֵ��˵�� p �� q Ӧ���ڵ�ǰ�ڵ������������˽���ǰ�ڵ��ƶ����������ӽڵ�
            if(p.val > root.val && q.val > root.val)
            {
                root = root.right;
            }
            else//�����ǰ�ڵ��ֵ���� p �� q ��ֵ��˵�� p �� q Ӧ���ڵ�ǰ�ڵ������������˽���ǰ�ڵ��ƶ����������ӽڵ�
            {
                root = root.left;
            }
        }
        return root;
    }
}
