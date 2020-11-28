package leetcode_practice;
/*
 * 493. ��ת��
����һ������ nums ����� i < j �� nums[i] > 2*nums[j] ���Ǿͽ� (i, j) ����һ����Ҫ��ת�ԡ�

����Ҫ���ظ��������е���Ҫ��ת�Ե�������

ʾ�� 1:

����: [1,3,2,3,1]
���: 2
ʾ�� 2:

����: [2,4,3,5,1]
���: 3
ע��:

��������ĳ��Ȳ��ᳬ��50000��
���������е��������ֶ���32λ�����ı�ʾ��Χ�ڡ�
 */
public class Question493 {
	public int reversePairs(int[] nums) {
        if(nums.length < 2) return 0;
        return reversePairsRecursive(nums, 0, nums.length - 1);
    }

    // �鲢����
    public int reversePairsRecursive(int[] nums, int left, int right)
    {
        if(left == right)
        {
            return 0;
        }

        int mid = (left + right) / 2;
        int n1 = reversePairsRecursive(nums, left, mid);
        int n2 = reversePairsRecursive(nums, mid + 1, right);

        // ͳ���±������
        int res = n1 + n2;
        int r1 = mid;
        int r2 = right;
        while(r2 > mid)
        {
            long t = nums[r2];
            t = t << 1;
            while(r1 >= left && nums[r1] > t)
            {
                r1--;
            }
            res += mid - r1;
            r2--;
        }

        // �ϲ�������������
        int[] sorted = new int[right - left + 1];
        int p1 = left, p2 = mid + 1, p = 0;
        while(p1 <= mid || p2 <= right)
        {
            if(p1 > mid) sorted[p++] = nums[p2++];
            else if(p2 > right) sorted[p++] = nums[p1++];
            else if(nums[p1] <= nums[p2]) sorted[p++] = nums[p1++];
            else sorted[p++] = nums[p2++];
        }


        for(int k = left; k <= right; k++)
        {
            nums[k] = sorted[k - left];
        }
        return res;
    }
}
