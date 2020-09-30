package leetcode_practice;
/*
 * 701. �����������еĲ������
����������������BST���ĸ��ڵ��Ҫ�������е�ֵ����ֵ��������������� ���ز��������������ĸ��ڵ㡣 �������ݱ�֤����ֵ��ԭʼ�����������е�����ڵ�ֵ����ͬ��

ע�⣬���ܴ��ڶ�����Ч�Ĳ��뷽ʽ��ֻҪ���ڲ�����Ա���Ϊ�������������ɡ� ����Է���������Ч�Ľ����

 

����, 

��������������:

        4
       / \
      2   7
     / \
    1   3

�� �����ֵ: 5
����Է����������������:

         4
       /   \
      2     7
     / \   /
    1   3 5
���������Ҳ����Ч��:

         5
       /   \
      2     7
     / \   
    1   3
         \
          4
 

��ʾ��

���������ϵĽڵ������� 0 �� 10^4 ֮��
ÿ���ڵ㶼��һ��Ψһ����ֵ��ȡֵ��Χ�� 0 �� 10^8
-10^8 <= val <= 10^8
��ֵ��ԭʼ�����������е�����ڵ�ֵ����ͬ
 */
public class Question701 {
	
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode cur = root;
        
        // ����BST�����ԣ��������ң�С�����󣬱�������λ��
        while(cur != null)
        {
            if(val > cur.val)
            {
                if(cur.right == null)
                {
                    cur.right = new TreeNode(val);
                    break;
                }
                cur = cur.right;
            }
            else
            {
                if(cur.left == null)
                {
                    cur.left = new TreeNode(val);
                    break;
                }
                cur = cur.left;
            }
        }
        return root;
    }
}
