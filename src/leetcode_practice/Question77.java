package leetcode_practice;
import java.util.*;
/*
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question77 {
	
	//dfs方法2
	List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k)
    {
        
        if(temp.size() == k)
        {
            ans.add(new ArrayList(temp));
            return;
        }
        //如果剩余元素全选仍然不够k个，剪枝返回
        if(cur > n || n - cur < k - temp.size() - 1) return;

        //选择当前元素
        temp.add(cur);
        dfs(cur + 1, n, k);
        //不选当前元素
        temp.remove(temp.size()-1);
        dfs(cur + 1, n, k);
    }
	// dfs方法1
//    public List<List<Integer>> combine(int n, int k) {
//        return dfs(1, n, k);
//    }
//    public List<List<Integer>> dfs(int l, int r, int k) {
//        List<List<Integer>> res = new ArrayList<>();
//
//        //如果k = 1,返回范围内所以可取的数
//        if(k == 1)
//        {
//            while(l <= r)
//            {
//                List<Integer> li = new ArrayList<>();
//                li.add(l);
//                res.add(li);
//                l++;
//            }
//            return res;
//        }
//
//        //如果k > 1，选定第一个数，再后面的数中选择k-1个数的组合进行合并
//        for(int i = l; i + k - 1 <= r; i++)
//        {
//            for(List<Integer> li : dfs(i+1, r, k-1))
//            {
//                li.add(0, i);
//                res.add(li);
//            }
//        }
//        return res;
//    }
//        List<List<Integer>> res = new ArrayList<>();
//
//        if(k == 1)
//        {
//            while(l <= r)
//            {
//                List<Integer> li = new ArrayList<>();
//                li.add(l);
//                res.add(li);
//                l++;
//            }
//            return res;
//        }
//
//        for(int i = l; i + k - 1 <= r; i++)
//        {
//            for(List<Integer> li : dfs(i+1, r, k-1))
//            {
//                li.add(0, i);
//                res.add(li);
//            }
//        }
//        return res;
//    }
}
