package leetcode_practice;

/*
 * 684. ��������
�ڱ�������, ��ָ����һ����ͨ���޻�������ͼ��

����һ��ͼ����ͼ��һ������N���ڵ� (�ڵ�ֵ���ظ�1, 2, ..., N) ������һ�����ӵı߹��ɡ����ӵıߵ��������������1��N�м䣬�������ӵı߲����������Ѵ��ڵıߡ�

���ͼ��һ���Ա���ɵĶ�ά���顣ÿһ���ߵ�Ԫ����һ��[u, v] ������ u < v����ʾ���Ӷ���u ��v������ͼ�ıߡ�

����һ������ɾȥ�ıߣ�ʹ�ý��ͼ��һ������N���ڵ����������ж���𰸣��򷵻ض�ά�����������ֵıߡ��𰸱� [u, v] Ӧ������ͬ�ĸ�ʽ u < v��

ʾ�� 1��

����: [[1,2], [1,3], [2,3]]
���: [2,3]
����: ����������ͼΪ:
  1
 / \
2 - 3
ʾ�� 2��

����: [[1,2], [2,3], [3,4], [1,4], [1,5]]
���: [1,4]
����: ����������ͼΪ:
5 - 1 - 2
    |   |
    4 - 3
ע��:

����Ķ�ά�����С�� 3 �� 1000��
��ά�����е�������1��N֮�䣬����N����������Ĵ�С��
 */
public class Question684 {
	
	// ����1
	int[] parent;   // ���鼯
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;   //һ������ N ���ڵ㣬��������� N-1 ����

        parent = new int[n + 1];
        for(int i = 0; i <= n; i++) parent[i] = i;

        for(int i = 0; i < n; i++)
        {
            int p1 = find(edges[i][0]);
            int p2 = find(edges[i][1]);
            if(p1 == p2) return edges[i];   
            else parent[p1] = p2;   //�����������ڲ�ͬ����ͨ�������ϲ�
        }        
        return new int[0];
    }

    public int find(int x)
    {
        if(x == parent[x]) return x;
        return find(parent[x]);
    }
    
    // 2.�ڽӾ���
//    List<List<Integer>> adjacency_matrix = new ArrayList<>();
//    boolean[] visit;
//    List<Integer> hoop = new ArrayList<>();
//
//    public int[] findRedundantConnection(int[][] edges) {
//        int n = edges.length;
//        
//        for(int i = 0; i <= n; i++) adjacency_matrix.add(new ArrayList<Integer>());
//
//        // ����ڽӾ���
//        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
//        for(int i = 0; i < n; i++)
//        {
//            HashMap<Integer, Integer> sub_map = map.getOrDefault(edges[i][0], new HashMap<Integer, Integer>());
//            sub_map.put(edges[i][1], i);
//            map.put(edges[i][0], sub_map);
//            adjacency_matrix.get(edges[i][0]).add(edges[i][1]);
//            adjacency_matrix.get(edges[i][1]).add(edges[i][0]);
//        }
//
//        // Ѱ�һ�
//        visit = new boolean[n + 1];
//        for(int i = 1; i <= n; i++)
//        {
//            hoop.add(i);
//            visit[i] = true;
//            if(dfs(i, -1, i)) break;
//            visit[i] = false;
//            hoop.remove(0);
//        }
//
//        // ���ض�ά�����������ֵı�, ���������ֵ
//        int max = 0;
//        hoop.add(hoop.get(0));
//        for(int i = 0; i < hoop.size() - 1; i++)
//        {
//            int left = Math.min(hoop.get(i), hoop.get(i + 1));
//            int right = Math.max(hoop.get(i), hoop.get(i + 1));
//            max = Math.max(max, map.get(left).get(right));
//        }
//
//        return edges[max];
//    }
//
//    public boolean dfs(int root, int pre, int node)
//    {
//        List<Integer> adjacency_nodes = adjacency_matrix.get(node);
//        for(int i = 0; i < adjacency_nodes.size(); i++)
//        {
//            int next = adjacency_nodes.get(i);
//            if(next == root && next != pre) return true;
//
//            if(!visit[adjacency_nodes.get(i)])
//            {
//                hoop.add(next);
//                visit[next] = true;
//                if(dfs(root, node, next)) return true;
//                hoop.remove(hoop.size() - 1);
//                visit[next] = false;
//            }
//        }
//        return false;
//    }
}
