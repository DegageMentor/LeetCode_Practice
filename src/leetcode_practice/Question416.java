package leetcode_practice;
/*
 * 416. �ָ�Ⱥ��Ӽ�
����һ��ֻ�����������ķǿ����顣�Ƿ���Խ��������ָ�������Ӽ���ʹ�������Ӽ���Ԫ�غ���ȡ�

ע��:

ÿ�������е�Ԫ�ز��ᳬ�� 100
����Ĵ�С���ᳬ�� 200
ʾ�� 1:

����: [1, 5, 11, 5]

���: true

����: ������Էָ�� [1, 5, 5] �� [11].
 

ʾ�� 2:

����: [1, 2, 3, 5]

���: false

����: ���鲻�ָܷ������Ԫ�غ���ȵ��Ӽ�.
 */
public class Question416 {
	public boolean canPartition(int[] nums) {
        if(nums == null || nums.length < 2) return false;

        // ��������Ԫ��֮�Ͳ���¼���ֵ
        int max = 0;
        int sum = 0;
        for(int n : nums)
        {
            sum += n;
            max = n > max? n : max;
        }

        // ����Ϊ������ֱ�ӷ���false
        if(sum % 2 == 1 || max > sum / 2) return false;

        //�������������
        //Arrays.sort(nums);

        //��̬�滮
        int target = sum / 2;
        // dp[i][j]��ʾ������nums�±�0��i���ܷ�ȡ��һ����ʹ�����Ϊj
        boolean[][] dp = new boolean[nums.length][target + 1];

        //��ʼ��
        for(int i = 0; i < nums.length; i++) dp[i][0] = true;
        dp[0][nums[0]] = true;

        for(int i = 1; i < nums.length; i++)
        {
            for(int j = 1; j <= target; j++)
            {
                if(nums[i] > j)
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i]];
                }
                
            }
        }
        return dp[nums.length - 1][target];

        
    }
}
