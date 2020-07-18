package leetcode_practice;

/*
 * 97. �����ַ���
	���������ַ��� s1, s2, s3, ��֤ s3 �Ƿ����� s1 �� s2 ������ɵġ�
	
	ʾ�� 1:
	
	����: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
	���: true
	ʾ�� 2:
	
	����: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
	���: false
 */
class Question97 {
    private char[] c1;
    private char[] c2;
    private char[] c3;
    private boolean res;
    private boolean[][] visited;
    public boolean isInterleave(String s1, String s2, String s3) {
        this.c1 = s1.toCharArray();
        this.c2 = s2.toCharArray();
        this.c3 = s3.toCharArray();
        visited = new boolean[c1.length + 1][c2.length + 1]; //���һ������Խ��
        if(c3.length != c1.length + c2.length)
        {
            return false;
        }
        dfs(0, 0, 0);
        return this.res;
    }

    // dfs �Ӽ��仯�Ż�
    public void dfs(int i, int j, int k)    // visited�����ʼ��Ϊfalse������dfs�����巵��ֵ
    {
        if(k == c3.length) res = true;
        if(res || visited[i][j]) return;
        if(i < c1.length && c3[k] == c1[i]) dfs(i + 1, j, k + 1); //iû��Խ�磬��s1[i]��s3[k]��ͬ
        if(j < c2.length && c3[k] == c2[j]) dfs(i, j + 1, k + 1); //jû��Խ�磬��s2[i]��s3[k]��ͬ
        visited[i][j] = true;
    }

//    //�ⷨ2 ��̬�滮
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if(s1.length() + s2.length() != s3.length()) return false; // ���s1,s2��s3�ַ�����Ŀ���ȣ�һ�������ܽ������
//
//        //����dp���飬dp[i][j]��ʾs1ǰi����ĸ��s2ǰj����ĸ���Խ������s3ǰi+j����ĸ����
//        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
//        // �����ʼ��
//        dp[0][0] = true;
//        for(int i = 1; i <= s1.length(); i++) dp[i][0] = dp[i - 1][0] && s1.charAt(i-1) == s3.charAt(i-1);
//        for(int i = 1; i <= s2.length(); i++) dp[0][i] = dp[0][i - 1] && s2.charAt(i-1) == s3.charAt(i-1);
//        
//        // ״̬ת�ƹ�ʽΪ��dp[i][j] = s1[i] = s3[i+j] & dp[i-1][j] || s2[j] = s3[i+j] & dp[i][j-1]
//        for(int i = 1; i <= s1.length(); i++)
//        {
//            for(int j = 1; j <= s2.length(); j++)
//            {
//                dp[i][j] = s1.charAt(i-1) == s3.charAt(i+j-1) & dp[i-1][j] | s2.charAt(j-1) == s3.charAt(i+j-1) & dp[i][j-1];
//            }
//        }
//        return dp[s1.length()][s2.length()];
//    }
}
