package leetcode_practice;
/*
	 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
	
	单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
	
	 
	
	示例:
	
	board =
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
	
	给定 word = "ABCCED", 返回 true
	给定 word = "SEE", 返回 true
	给定 word = "ABCB", 返回 false
	 
	
	提示：
	
	board 和 word 中只包含大写和小写英文字母。
	1 <= board.length <= 200
	1 <= board[i].length <= 200
	1 <= word.length <= 10^3
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/word-search
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question79 {
	
	//深度优先搜索
	boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if(board ==  null || board.length == 0 || board[0].length == 0) return false;

        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    //判断board的第row行，第col列是否为word的第index个字符
    public boolean dfs(char[][] board, int row, int col, String word, int index)
    {
        if(word.length() == index) return true;
        if(row < 0 || row >= board.length || col < 0 || col >=board[0].length || visited[row][col]) return false;

        if(board[row][col] == word.charAt(index))
        {
            visited[row][col] = true;
            if(dfs(board, row + 1, col, word, index + 1) || dfs(board, row - 1, col, word, index + 1) || dfs(board, row, col - 1, word, index + 1) || dfs(board, row, col + 1, word, index + 1))
            {
                return true;
            }
            visited[row][col] = false;
        }
        return false;
    }
}
