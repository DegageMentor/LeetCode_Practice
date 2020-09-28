package leetcode_practice;
import java.util.*;

/*
 * 117. ���ÿ���ڵ����һ���Ҳ�ڵ�ָ�� II
����һ��������

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
�������ÿ�� next ָ�룬�����ָ��ָ������һ���Ҳ�ڵ㡣����Ҳ�����һ���Ҳ�ڵ㣬�� next ָ������Ϊ NULL��

��ʼ״̬�£����� next ָ�붼������Ϊ NULL��

 

���ף�

��ֻ��ʹ�ó���������ռ䡣
ʹ�õݹ����Ҳ����Ҫ�󣬱����еݹ����ռ�õ�ջ�ռ䲻��������Ŀռ临�Ӷȡ�
 

ʾ����



���룺root = [1,2,3,4,5,null,7]
�����[1,#,2,3,#,4,5,7,#]
���ͣ�������������ͼ A ��ʾ����ĺ���Ӧ���������ÿ�� next ָ�룬��ָ������һ���Ҳ�ڵ㣬��ͼ B ��ʾ��
 */
public class Question117 {
	// Definition for a Node.
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};
	
	
    public Node connect(Node root) {        
        if(root == null) return root;

        // ��α����������������
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            int num = queue.size();
            while(num > 0)
            {
                Node cur = queue.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                if(num > 1) cur.next = queue.peek();
                num--;
            }
        }
        return root;
    }
}
