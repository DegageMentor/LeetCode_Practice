package leetcode_practice;
/*
 * 321. ƴ�������
�������ȷֱ�Ϊ m �� n ���������飬��Ԫ���� 0-9 ���ɣ���ʾ������Ȼ����λ�ϵ����֡����ڴ�������������ѡ�� k (k <= m + n) ������ƴ�ӳ�һ���µ�����Ҫ���ͬһ��������ȡ�������ֱ�������ԭ�����е����˳��

���������������������������һ����ʾ��������ĳ���Ϊ k �����顣

˵��: �뾡���ܵ��Ż����㷨��ʱ��Ϳռ临�Ӷȡ�

ʾ�� 1:

����:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
���:
[9, 8, 6, 5, 3]
ʾ�� 2:

����:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
���:
[6, 7, 6, 0, 4]
ʾ�� 3:

����:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
���:
[9, 8, 9]
 */
public class Question321 {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		
        // ��nums1��ѡi������������ֵ����nums2��ѡK-i������������ֵ��
        // ����������ϲ�������ֵ��ѡ����ʵ�i��ɵ����ֵ��Ϊ���ս��
		
		int[] res = new int[k];
		for(int i = 0; i < k; i++)
		{
			if(i < nums1.length && k - i < nums2.length)
			{
				int[] t = new int[k];

                int[] a1 = maxSubsequence(nums1, i);
                int[] a2 = maxSubsequence(nums2, k - i);

                // �ϲ��������飬������ֵ
                int p = 0, p1 = 0, p2 = 0;
                while(p1 < a1.length || p2 < a2.length)
                {
                    if(p1 >= a1.length) t[p++] = a2[p2++];
                    else if(p2 >= a2.length) t[p++] = a1[p1++];
                    else if(a1[p1] > a2[p2]) t[p++] = a1[p1++];
                    else if(a1[p1] < a2[p2]) t[p++] = a2[p2++];
                    else{// ������ȣ�ѡ��������ȳ��ָ���ֵ����
                        int pp1 = p1 + 1, pp2 = p2 + 1;
                        while(pp1 < i && pp2 < k - i)
                        {
                            if(a1[pp1] > a2[pp2])
                            {
                                t[p++] = a1[p1++];
                                break;
                            }
                            if(a2[pp2] > a1[pp1])
                            {
                                t[p++] = a2[p2++];
                                break;
                            }
                            pp1++;
                            pp2++;
                        }
                        if(pp1 == i && pp2 == k - i)
                        {
                            while(p1 < i) t[p++] = a1[p1++];
                            while(p2 < k - i) t[p++] = a2[p2++];
                        }
                        else if(pp1 == i) t[p++] = a2[p2++];
                        else if(pp2 == k - i) t[p++] = a1[p1++];
                    }
                }

                //ѡ�����ֵ
                for(int j = 0; j < k; j++)
                {
                    if(t[j] == res[j]) continue;
                    if(t[j] > res[j]) System.arraycopy(t, 0, res, 0, res.length);
                    break;
                }
            }
        }

        return res;
	}
	
	// ���õ���ջ��һ��������k�����ܱ�ʾ�������
	public int[] maxSubsequence(int[] nums, int k)
	{
		int len = nums.length;
		int[] stack = new int[k];
		
		int top = -1;
		int remain = len - k;
		for(int i = 0; i < len; i++)
		{
			while(top >= 0 && nums[i] > stack[top] && remain > 0)
			{
				top--;
				remain--;
			}
			if(top < k - 1)
			{
				stack[++top] = nums[i];
			}
			else
			{
				remain--;
			}
		}
		return stack;
	}
}
