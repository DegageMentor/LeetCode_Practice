package leetcode_practice;
/*
 * 44. ͨ���ƥ��
����һ���ַ��� (s) ��һ���ַ�ģʽ (p) ��ʵ��һ��֧�� '?' �� '*' ��ͨ���ƥ�䡣

'?' ����ƥ���κε����ַ���
'*' ����ƥ�������ַ������������ַ�������
�����ַ�����ȫƥ�����ƥ��ɹ���

˵��:

s ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ��
p ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ���Լ��ַ� ? �� *��
ʾ�� 1:

����:
s = "aa"
p = "a"
���: false
����: "a" �޷�ƥ�� "aa" �����ַ�����
ʾ�� 2:

����:
s = "aa"
p = "*"
���: true
����: '*' ����ƥ�������ַ�����
ʾ�� 3:

����:
s = "cb"
p = "?a"
���: false
����: '?' ����ƥ�� 'c', ���ڶ��� 'a' �޷�ƥ�� 'b'��
 */
public class Question44 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        // dp[i][j] ��ʾ�ַ��� s ��ǰ i ���ַ���ģʽ p ��ǰ j ���ַ��Ƿ���ƥ��
        boolean[][] dp = new boolean[m + 1][n + 1]; 

        dp[0][0]  = true;   //�ַ��� s ��ģʽ p ��Ϊ��ʱ��ƥ��ɹ�
        //ģʽ p ��ǰ j ���ַ���Ϊ�Ǻ�ʱ��dp[0][j] Ϊ��
        for(int i = 1; i <= n; i++) if(p.charAt(i - 1) == '*') dp[0][i] = true; else break;
        
        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1))
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(p.charAt(j - 1) == '*')
                {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
                else dp[i][j] = false;
            }
        }
        return dp[m][n];
    }
}
