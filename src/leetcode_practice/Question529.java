package leetcode_practice;

class Question529 {
	public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        int rows = board.length;
        int cols = board[0].length;

        // 一个地雷（'M'）被挖出，游戏结束
        if(board[row][col] == 'M')
        {
            board[row][col] = 'X';
            return board;
        }

        if(board[row][col] == 'E')
        {
            // 检查周边一圈是否有地雷
            int mine = 0;
            for(int i = -1; i <= 1; i++)
            {
                for(int j = -1; j <= 1; j++)
                {
                    if(row + i >= 0 && row + i < rows && col + j >= 0 && col + j < cols && board[row + i][col + j] == 'M') mine++;
                }
            }

            //一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字
            if(mine > 0)
            {
                board[row][col] = (char)('0' + mine);
                return board;
            }
            else    //一个没有相邻地雷的空方块（'E'）被挖出，递归揭露其相邻的未挖出方块，8个方向
            {
                board[row][col] = 'B';
                for(int i = -1; i <= 1; i++)
                {
                    for(int j = -1; j <= 1; j++)
                    {
                        if(row + i >= 0 && row + i < rows && col + j >= 0 && col + j < cols && board[row + i][col + j] == 'E')
                        {
                            updateBoard(board, new int[]{row + i, col + j});
                        }
                    }
                }
            }
        }
        return board;
    }
}
