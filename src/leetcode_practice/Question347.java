package leetcode_practice;
import java.util.*;
/*
 * 347. 前 K 个高频元素
	给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
	
	 
	
	示例 1:
	
	输入: nums = [1,1,1,2,2,3], k = 2
	输出: [1,2]
	示例 2:
	
	输入: nums = [1], k = 1
	输出: [1]
	 
	
	提示：
	
	你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
	你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
	题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
	你可以按任意顺序返回答案。
 */
public class Question347 {
	
//	Map<Integer, Integer> map = new HashMap<>();
//    for (int num : nums) {
//        map.compute(num, (key, v) -> v = v == null ? 1 : v + 1);
//    }
//    PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return map.get(o1) - map.get(o2);
//        }
//    });
//    for (Integer key : map.keySet()) {
//        if (heap.size() < k) heap.add(key);
//        else if (map.get(key) > map.get(heap.peek())) {
//            heap.poll();
//            heap.add(key);
//        }
//    }
//    int[] ans = new int[k];
//    for (int i = 0; i < k; i++) {
//        ans[i] = heap.poll();
//    }
//    return ans;
    

	//HashMap + 堆排序
	Map<Integer, Integer> mymap = new HashMap<>();
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        for(int i : nums)
        {
            mymap.put(i, mymap.getOrDefault(i, 0) + 1);
        }

        Iterator it = mymap.keySet().iterator();
        int i = 0;
        while(it.hasNext())
        {
            if(i < k)
            {
                res[i] = (Integer)it.next();
                i++;
                if(i == k)
                {
                    for(int j = k / 2 - 1; j >=0; j--)
                    {
                        heapSort(res, j);
                    }
                }
            }
            else
            {
                int t = (Integer)it.next();
                if(mymap.get(t) > mymap.get(res[0]))
                {
                    res[0] = t;
                    heapSort(res, 0);
                }
            }            
        }

        return res;
    }
    public void heapSort(int[] nums, int i)
    {
        int temp = nums[i];
        for(int j = i * 2 + 1; j < nums.length; j = j * 2 + 1)
        {
            if(j + 1 < nums.length && mymap.get(nums[j + 1]) < mymap.get(nums[j])) j++;
            if(mymap.get(nums[j]) < mymap.get(temp))
            {
                nums[i] = nums[j];
                i = j;
            }
            else break;
        }
        nums[i] = temp;
    }
}
