package leetcode_practice;

import leetcode_practice.Question501.TreeNode;

/*
 * 617. �ϲ�������
���������������������㽫�����е�һ�����ǵ���һ����ʱ��������������һЩ�ڵ����ص���

����Ҫ�����Ǻϲ�Ϊһ���µĶ��������ϲ��Ĺ�������������ڵ��ص�����ô�����ǵ�ֵ�����Ϊ�ڵ�ϲ������ֵ������Ϊ NULL �Ľڵ㽫ֱ����Ϊ�¶������Ľڵ㡣

ʾ�� 1:

����: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
���: 
�ϲ������:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
ע��: �ϲ�������������ĸ��ڵ㿪ʼ��
 */
public class Question617 {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	 
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null) return t2;
		if(t2 == null) return t1;
		
		t1.val = t1.val + t2.val;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
	}
}
