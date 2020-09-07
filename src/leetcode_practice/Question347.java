package leetcode_practice;
import java.util.*;
/*
 * 347. ǰ K ����ƵԪ��
	����һ���ǿյ��������飬�������г���Ƶ��ǰ k �ߵ�Ԫ�ء�
	
	 
	
	ʾ�� 1:
	
	����: nums = [1,1,1,2,2,3], k = 2
	���: [1,2]
	ʾ�� 2:
	
	����: nums = [1], k = 1
	���: [1]
	 
	
	��ʾ��
	
	����Լ�������� k ���Ǻ���ģ��� 1 �� k �� �����в���ͬ��Ԫ�صĸ�����
	����㷨��ʱ�临�Ӷȱ������� O(n log n) , n ������Ĵ�С��
	��Ŀ���ݱ�֤��Ψһ�����仰˵��������ǰ k ����ƵԪ�صļ�����Ψһ�ġ�
	����԰�����˳�򷵻ش𰸡�
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
    

	//HashMap + ������
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
