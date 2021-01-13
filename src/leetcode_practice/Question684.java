package leetcode_practice;

/*
 * 684. 冗余连接
在本问题中, 树指的是一个连通且无环的无向图。

输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。

结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。

返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。

示例 1：

输入: [[1,2], [1,3], [2,3]]
输出: [2,3]
解释: 给定的无向图为:
  1
 / \
2 - 3
示例 2：

输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
输出: [1,4]
解释: 给定的无向图为:
5 - 1 - 2
    |   |
    4 - 3
注意:

输入的二维数组大小在 3 到 1000。
二维数组中的整数在1到N之间，其中N是输入数组的大小。
 */
public class Question684 {
	
	// 方法1
	int[] parent;   // 并查集
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;   //一棵树有 N 个节点，则这棵树有 N-1 条边

        parent = new int[n + 1];
        for(int i = 0; i <= n; i++) parent[i] = i;

        for(int i = 0; i < n; i++)
        {
            int p1 = find(edges[i][0]);
            int p2 = find(edges[i][1]);
            if(p1 == p2) return edges[i];   
            else parent[p1] = p2;   //两个顶点属于不同的连通分量，合并
        }        
        return new int[0];
    }

    public int find(int x)
    {
        if(x == parent[x]) return x;
        return find(parent[x]);
    }
    
    // 2.邻接矩阵
//    List<List<Integer>> adjacency_matrix = new ArrayList<>();
//    boolean[] visit;
//    List<Integer> hoop = new ArrayList<>();
//
//    public int[] findRedundantConnection(int[][] edges) {
//        int n = edges.length;
//        
//        for(int i = 0; i <= n; i++) adjacency_matrix.add(new ArrayList<Integer>());
//
//        // 填充邻接矩阵
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
//        // 寻找环
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
//        // 返回二维数组中最后出现的边, 即索引最大值
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
