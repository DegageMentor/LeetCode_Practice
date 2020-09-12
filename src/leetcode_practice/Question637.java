package leetcode_practice;
import java.util.*;

/*
 * 637. �������Ĳ�ƽ��ֵ
����һ���ǿն�����, ����һ����ÿ��ڵ�ƽ��ֵ��ɵ����顣

 

ʾ�� 1��

���룺
    3
   / \
  9  20
    /  \
   15   7
�����[3, 14.5, 11]
���ͣ�
�� 0 ���ƽ��ֵ�� 3 ,  ��1���� 14.5 , ��2���� 11 ����˷��� [3, 14.5, 11] ��
 

��ʾ��

�ڵ�ֵ�ķ�Χ��32λ�з���������Χ�ڡ�

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
    // ����������������Ʋ�α���
    // public List<Double> averageOfLevels(TreeNode root) {
        // List<Double> res = new ArrayList<>();
        // if(root == null) return res;
        // Queue<TreeNode> qu = new LinkedList<>();
        // qu.offer(root); //��root��ӵ����У������ȳ�
        // while(!qu.isEmpty())
        // {
        //     double sum = 0.0;
        //     int num = qu.size();
        //     for(int i = 0; i < num; i++)
        //     {
        //         TreeNode t = qu.poll(); //��ȡ��ǰ������Էǿսڵ�
        //         sum += t.val;
        //         if(t.left != null) qu.offer(t.left);    //����ǰ�ڵ����зǿ��ӽڵ�������
        //         if(t.right != null) qu.offer(t.right);
        //     }
        //     res.add(sum / num);
        // }
        // return res;

    // }

    //������������������м�¼ÿһ��Ľڵ�����ͺ�
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
