package leetcode_practice;
/*
 * 300. �����������
����һ��������������飬�ҵ���������������еĳ��ȡ�

ʾ��:

����: [10,9,2,5,3,7,101,18]
���: 4 
����: ��������������� [2,3,7,101]�����ĳ����� 4��
˵��:

���ܻ��ж�������������е���ϣ���ֻ��Ҫ�����Ӧ�ĳ��ȼ��ɡ�
���㷨��ʱ�临�Ӷ�Ӧ��Ϊ O(n2) ��
����: ���ܽ��㷨��ʱ�临�ӶȽ��͵� O(n log n) ��?
 */
public class Question300 {
	public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int res = 0;
        int len = nums.length;
        int[] dp = new int[len];
        
        // dp[i]��ʾǰi��Ԫ�أ����Ե�i��Ԫ�ؽ�β������������г���, ��dp[i] = max(dp[j]) + 1 �� j<i��nums[i] > nums[j]������dp[i] = 1
        // ��ʼ��Ϊ1

        for(int i = 0; i < len; i++) dp[i] = 1;

        for(int i = 1; i < len; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        // ��dp������ѡ�������ķ��أ���һ����dp[len-1]
        for(int i = 0; i < len; i++) res = dp[i] > res ? dp[i] : res;
        return res;
    }
}
