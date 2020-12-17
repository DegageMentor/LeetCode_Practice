package leetcode_practice;

/*
 * 714. ������Ʊ�����ʱ����������
����һ���������� prices�����е� i ��Ԫ�ش����˵� i ��Ĺ�Ʊ�۸� ���Ǹ����� fee �����˽��׹�Ʊ���������á�

��������޴ε���ɽ��ף�������ÿ�ʽ��׶���Ҫ�������ѡ�������Ѿ�������һ����Ʊ����������֮ǰ��Ͳ����ټ��������Ʊ�ˡ�

���ػ����������ֵ��

ע�⣺�����һ�ʽ���ָ������в�������Ʊ���������̣�ÿ�ʽ�����ֻ��ҪΪ֧��һ�������ѡ�

ʾ�� 1:

����: prices = [1, 3, 2, 8, 4, 9], fee = 2
���: 8
����: �ܹ��ﵽ���������:  
�ڴ˴����� prices[0] = 1
�ڴ˴����� prices[3] = 8
�ڴ˴����� prices[4] = 4
�ڴ˴����� prices[5] = 9
������: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
ע��:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.
 */
public class Question714 {
    public int maxProfit(int[] prices, int fee) {
        // ��̬�滮
    	// dp[i][0]��ʾ�� i �콻���������û�й�Ʊ��������� dp[i][1] ��ʾ�� i�콻������������һ֧��Ʊ�������

    	// int[][] dp = new int[prices.length][4];	

        // dp[0][0] = -prices[0];  // �����й�Ʊ
        // dp[0][1] = 0;           // ����û��Ʊ


        // for(int i = 1; i < prices.length; i++)
        // {
        //     dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
        //     dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
        // }
        // return dp[prices.length - 1][1];

    	
        // ̰��
    	// ����������һ֧��Ʊʱ�����Ǿ��������������ͬ�۸����������������һ֧��Ʊ��Ȩ����
    	// �ڱ������������� prices ֮��֮�����Ǿ͵õ�������������

        int n = prices.length;
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            }
            else if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }
}
