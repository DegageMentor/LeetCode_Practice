package leetcode_practice;
/*
 * 75. ��ɫ����
����һ��������ɫ����ɫ����ɫ��һ�� n ��Ԫ�ص����飬ԭ�ض����ǽ�������ʹ����ͬ��ɫ��Ԫ�����ڣ������պ�ɫ����ɫ����ɫ˳�����С�

�����У�����ʹ������ 0�� 1 �� 2 �ֱ��ʾ��ɫ����ɫ����ɫ��

ע��:
����ʹ�ô�����е����������������⡣

ʾ��:

����: [2,0,2,1,1,0]
���: [0,0,1,1,2,2]
���ף�

һ��ֱ�۵Ľ��������ʹ�ü������������ɨ���㷨��
���ȣ����������0��1 �� 2 Ԫ�صĸ�����Ȼ����0��1��2��������д��ǰ���顣
�������һ����ʹ�ó����ռ��һ��ɨ���㷨��
 */
public class Question75 {
	public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) return;

        int left = 0;
        int right = nums.length - 1;
        
        int i = 0;
        // ˫ָ�룬0�ƶ���ߣ�2�Ƶ��ұ�
        while(i <= right)
        {   
            if(nums[i] == 0 && i != left)
            {
                int t = nums[i];
                nums[i] = nums[left];
                nums[left] = t;

                left++;
                continue;
            }

            if(nums[i] == 2 && i != right)
            {
                int t = nums[i];
                nums[i] = nums[right];
                nums[right] = t;

                right--;
                continue;
            }
            i++;
        }
        return;
    }
}
