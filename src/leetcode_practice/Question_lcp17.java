package leetcode_practice;
/*
 * LCP 19. ��Ҷ�ղؼ�
С�۳�ȥ���Σ�;���ռ���һЩ��Ҷ�ͻ�Ҷ����������ЩҶ�ӳ���������һ����Ҷ�ղؼ� leaves�� �ַ��� leaves ������Сд�ַ� r �� y�� �����ַ� r ��ʾһƬ��Ҷ���ַ� y ��ʾһƬ��Ҷ��
������������Ŀ��ǣ�С����Ҫ���ղؼ�����Ҷ�����е����ɡ��졢�ơ��졹�����֡�ÿ������Ҷ�������Բ���ȣ���������ڵ��� 1��ÿ�ε���������С�ۿ��Խ�һƬ��Ҷ�滻�ɻ�Ҷ���߽�һƬ��Ҷ�滻�ɺ�Ҷ������С��������Ҫ���ٴε����������ܽ���Ҷ�ղؼ�������ϡ�

ʾ�� 1��

���룺leaves = "rrryyyrryyyrr"

�����2

���ͣ��������Σ����м����Ƭ��Ҷ�滻�ɻ�Ҷ���õ� "rrryyyyyyyyrr"

ʾ�� 2��

���룺leaves = "ryr"

�����0

���ͣ��ѷ���Ҫ�󣬲���Ҫ�������

��ʾ��

3 <= leaves.length <= 10^5
leaves ��ֻ�����ַ� 'r' ���ַ� 'y'
 */
public class Question_lcp17 {
	public int minimumOperations(String leaves) {
        int res = 0;
        if(leaves == null || leaves.length() < 3) return res;

        //ÿ��Ҷ��������״̬��dp[i][0]��ʾ��������ߺ�ɫ������Ҫ�����ٵ���������dp[i][1]��ʾ�м��ɫ��dp[i][2]��ʾ�ұߺ�ɫ
        int[][] dp = new int[leaves.length()][3];

        char[] chars = leaves.toCharArray();
        //��ʼ��
        dp[0][0] = chars[0] == 'y' ? 1 : 0;
        dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;

        for(int i = 1; i < chars.length; i++)
        {
            int isYellow = chars[i] == 'y' ? 1 : 0;
            dp[i][0] = dp[i - 1][0] + isYellow;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (1 - isYellow);
            if(i > 1)
            {
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + isYellow;
            }
        }
        return dp[chars.length - 1][2];
    }
}
