package leetcode_practice;

/*
 * 97. 交错字符串
	给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
	
	示例 1:
	
	输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
	输出: true
	示例 2:
	
	输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
	输出: false
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
        visited = new boolean[c1.length + 1][c2.length + 1]; //多加一个避免越界
        if(c3.length != c1.length + c2.length)
        {
            return false;
        }
        dfs(0, 0, 0);
        return this.res;
    }

    // dfs 加记忆化优化
    public void dfs(int i, int j, int k)    // visited数组初始化为false，所以dfs不定义返回值
    {
        if(k == c3.length) res = true;
        if(res || visited[i][j]) return;
        if(i < c1.length && c3[k] == c1[i]) dfs(i + 1, j, k + 1); //i没有越界，且s1[i]和s3[k]相同
        if(j < c2.length && c3[k] == c2[j]) dfs(i, j + 1, k + 1); //j没有越界，且s2[i]和s3[k]相同
        visited[i][j] = true;
    }

//    //解法2 动态规划
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if(s1.length() + s2.length() != s3.length()) return false; // 如果s1,s2和s3字符串数目不等，一定不可能交错组成
//
//        //定义dp数组，dp[i][j]表示s1前i个字母和s2前j个字母可以交错组成s3前i+j个字母序列
//        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
//        // 数组初始化
//        dp[0][0] = true;
//        for(int i = 1; i <= s1.length(); i++) dp[i][0] = dp[i - 1][0] && s1.charAt(i-1) == s3.charAt(i-1);
//        for(int i = 1; i <= s2.length(); i++) dp[0][i] = dp[0][i - 1] && s2.charAt(i-1) == s3.charAt(i-1);
//        
//        // 状态转移公式为：dp[i][j] = s1[i] = s3[i+j] & dp[i-1][j] || s2[j] = s3[i+j] & dp[i][j-1]
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
