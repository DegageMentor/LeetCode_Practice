package leetcode_practice;

class Question529 {
	public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        int rows = board.length;
        int cols = board[0].length;

        // һ�����ף�'M'�����ڳ�����Ϸ����
        if(board[row][col] == 'M')
        {
            board[row][col] = 'X';
            return board;
        }

        if(board[row][col] == 'E')
        {
            // ����ܱ�һȦ�Ƿ��е���
            int mine = 0;
            for(int i = -1; i <= 1; i++)
            {
                for(int j = -1; j <= 1; j++)
                {
                    if(row + i >= 0 && row + i < rows && col + j >= 0 && col + j < cols && board[row + i][col + j] == 'M') mine++;
                }
            }

            //һ��������һ���������ڵĿշ��飨'E'�����ڳ����޸���Ϊ����
            if(mine > 0)
            {
                board[row][col] = (char)('0' + mine);
                return board;
            }
            else    //һ��û�����ڵ��׵Ŀշ��飨'E'�����ڳ����ݹ��¶�����ڵ�δ�ڳ����飬8������
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
