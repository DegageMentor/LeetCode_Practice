package leetcode_practice;
import java.util.*;

/*
 * 37. 解数独
编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。

给定的数独序列只包含数字 1-9 和字符 '.' 。
你可以假设给定的数独只有唯一解。
给定数独永远是 9x9 形式的。
 */
public class Question37 {
	// 记录数组各行，各列，各个九宫格的数字出现情况
    private boolean[][] Rows = new boolean[9][9];
    private boolean[][] Cols = new boolean[9][9];
    private boolean[][][] Blocks = new boolean[3][3][9];
    private List<int[]> Spaces = new ArrayList<>(); //记录空白位置
    public void solveSudoku(char[][] board) {
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j] == '.')
                {
                    int index[] = new int[2];
                    index[0] = i;
                    index[1] = j;
                    Spaces.add(index);
                }
                else
                {
                    Rows[i][board[i][j] - '1'] = true;
                    Cols[j][board[i][j] - '1'] = true;
                    Blocks[i / 3][j /3][board[i][j] - '1'] = true;
                }
            }
        }

        // 深度优先搜索，解数独
        dfs(board, 0);
    }

    public boolean dfs(char[][] board, int index)
    {
        if(index == Spaces.size()) return true;

        int i = Spaces.get(index)[0];
        int j = Spaces.get(index)[1];

        for(char k = '1'; k <= '9'; k++)
        {
            if(Rows[i][k - '1'] || Cols[j][k - '1'] || Blocks[i / 3][j / 3][k - '1']) continue;
            else
            {
                board[i][j] = k;
                Rows[i][k - '1'] = true;
                Cols[j][k - '1'] = true;
                Blocks[i / 3][j / 3][k - '1'] = true;

                if(dfs(board, index + 1)) return true;

                Rows[i][k - '1'] = false;
                Cols[j][k - '1'] = false;
                Blocks[i / 3][j / 3][k - '1'] = false;                        
            }
        }
        return false;
    }
}
