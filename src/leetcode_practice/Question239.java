package leetcode_practice;
import java.util.*;
/*
 * 239. �����������ֵ
����һ���������� nums����һ����СΪ k �Ļ������ڴ������������ƶ�����������Ҳࡣ��ֻ���Կ����ڻ��������ڵ� k �����֡���������ÿ��ֻ�����ƶ�һλ��

���ػ��������е����ֵ��

 

ʾ�� 1��

���룺nums = [1,3,-1,-3,5,3,6,7], k = 3
�����[3,3,5,5,6,7]
���ͣ�
�������ڵ�λ��                ���ֵ
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
ʾ�� 2��

���룺nums = [1], k = 1
�����[1]
ʾ�� 3��

���룺nums = [1,-1], k = 1
�����[1,-1]
 */
public class Question239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
        // ��������
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;


        // ���ȶ���
        // int n = nums.length;
        // PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
        //     public int compare(int[] pair1, int[] pair2) {
        //         return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
        //     }
        // });
        // for (int i = 0; i < k; ++i) {
        //     pq.offer(new int[]{nums[i], i});
        // }
        // int[] ans = new int[n - k + 1];
        // ans[0] = pq.peek()[0];
        // for (int i = k; i < n; ++i) {
        //     pq.offer(new int[]{nums[i], i});
        //     while (pq.peek()[1] <= i - k) {
        //         pq.poll();
        //     }
        //     ans[i - k + 1] = pq.peek()[0];
        // }
        // return ans;
    }

}
