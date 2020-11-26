package leetcode_practice;
import java.util.*;
/*
 * 164. �����
����һ����������飬�ҳ�����������֮������Ԫ��֮�����Ĳ�ֵ��

�������Ԫ�ظ���С�� 2���򷵻� 0��

ʾ�� 1:

����: [3,6,9,1]
���: 3
����: ������������ [1,3,6,9], ��������Ԫ�� (3,6) �� (6,9) ֮�䶼��������ֵ 3��
ʾ�� 2:

����: [10]
���: 0
����: ����Ԫ�ظ���С�� 2����˷��� 0��
˵��:

����Լ�������������Ԫ�ض��ǷǸ�����������ֵ�� 32 λ�з���������Χ�ڡ�
�볢��������ʱ�临�ӶȺͿռ临�Ӷȵ������½�������⡣
 */
public class Question164 {
	public int maximumGap(int[] nums) {
        int len = nums.length;
        if(len < 2) return 0;

        //Ͱ����
        int max_val = nums[0], min_val = nums[0];
        // �ҳ������Сֵ
        for(int n : nums)
        {
            max_val = n > max_val? n : max_val;
            min_val = n < min_val? n : min_val;
        }
        // ȷ��ÿ��Ͱ�������С��Ͱ�ĸ���
        int bucket_size = Math.max(1, (max_val - min_val) / (len - 1));
        int bucket_num = (max_val - min_val) / bucket_size + 1;
        
        int[][] bucket = new int[bucket_num][2];
        for(int i = 0; i < bucket_num; i++) Arrays.fill(bucket[i], -1);
        for(int i = 0; i < len; i++)
        {
            int idx = (nums[i] - min_val) / bucket_size;
            if(bucket[idx][0] == -1)
            {
                bucket[idx][0] = nums[i];
                bucket[idx][1] = nums[i];
            }
            else
            {
                bucket[idx][0] = nums[i] < bucket[idx][0]? nums[i] : bucket[idx][0];
                bucket[idx][1] = nums[i] > bucket[idx][1]? nums[i] : bucket[idx][1];
            }
        }

        int res = 0;
        int pre = -1;
        for(int i = 0; i < bucket_num; i++)
        {
            if(bucket[i][0] == -1) continue;
            if(pre != -1)
            {
                res = Math.max(res, bucket[i][0] - bucket[pre][1]);
            }
            pre = i;
        }
        
        // Arrays.sort(nums);
        // int res = 0;
        // for(int i = 1; i < nums.length; i++)
        // {
        //     int t = nums[i] - nums[i - 1];
        //     if(t > res) res = t;
        // }
        
        return res;
    }
}
