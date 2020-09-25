package leetcode_practice;
import java.util.*;


/*
 * 106. �����������������й��������
����һ��������������������������������

ע��:
����Լ�������û���ظ���Ԫ�ء�

���磬����

������� inorder = [9,3,15,20,7]
������� postorder = [9,15,7,20,3]
�������µĶ�������

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
	// ��¼���������Ԫ������
	Map<Integer, Integer> map_in = new HashMap<>();

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length == 0)
			return root;
		for (int i = 0; i < inorder.length; i++) {
			map_in.put(inorder[i], i);
		}

		return helper(inorder, postorder, root, 0, inorder.length - 1, 0, postorder.length - 1);
	}

	// ������������һ��Ԫ��Ϊroot,�������������ҵ�root,��������������ݹ鹹��
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
	
	// ���õĽⷨ
//	int post_idx;
//    int[] postorder;
//    int[] inorder;
//    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();
//
//    public TreeNode helper(int in_left, int in_right) {
//        // �������û�нڵ㹹��������ˣ��ͽ���
//        if (in_left > in_right) {
//            return null;
//        }
//
//        // ѡ�� post_idx λ�õ�Ԫ����Ϊ��ǰ�������ڵ�
//        int root_val = postorder[post_idx];
//        TreeNode root = new TreeNode(root_val);
//
//        // ���� root ����λ�÷ֳ�������������
//        int index = idx_map.get(root_val);
//
//        // �±��һ
//        post_idx--;
//        // ����������
//        root.right = helper(index + 1, in_right);
//        // ����������
//        root.left = helper(in_left, index - 1);
//        return root;
//    }
//
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        this.postorder = postorder;
//        this.inorder = inorder;
//        // �Ӻ�����������һ��Ԫ�ؿ�ʼ
//        post_idx = postorder.length - 1;
//
//        // ������Ԫ�أ��±꣩��ֵ�ԵĹ�ϣ��
//        int idx = 0;
//        for (Integer val : inorder) {
//            idx_map.put(val, idx++);
//        }
//        
//        return helper(0, inorder.length - 1);
//    }

}
