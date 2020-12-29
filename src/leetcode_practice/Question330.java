package leetcode_practice;
/*
 * 330. ��Ҫ��������
����һ������������������� nums����һ�������� n ���� [1, n] ������ѡȡ��������ֲ��䵽 nums �У�ʹ�� [1, n] �����ڵ��κ����ֶ������� nums ��ĳ�������ֵĺ�����ʾ���������������Ҫ���������Ҫ��������ָ�����

ʾ�� 1:

����: nums = [1,3], n = 6
���: 1 
����:
���� nums �����е���� [1], [3], [1,3]�����Եó� 1, 3, 4��
����������ǽ� 2 ��ӵ� nums �У� ��ϱ�Ϊ: [1], [2], [3], [1,3], [2,3], [1,2,3]��
��Ϳ��Ա�ʾ���� 1, 2, 3, 4, 5, 6���ܹ����� [1, 6] ���������е�����
��������������Ҫ���һ�����֡�
ʾ�� 2:

����: nums = [1,5,10], n = 20
���: 2
����: ������Ҫ��� [2, 4]��
ʾ�� 3:

����: nums = [1,2,2], n = 5
���: 0
 */
public class Question330 {
    public int minPatches(int[] nums, int n) {
        int res = 0;

        long maxLen = 0; // ����ܱ�ʾ����
        int index = 0;
        while(maxLen < n)
        {
           while(index < nums.length && nums[index] <= maxLen + 1) maxLen += nums[index++];
           if(maxLen >= n) break;
           maxLen += maxLen + 1;
           res++;
        }
        return res;
    }
}
