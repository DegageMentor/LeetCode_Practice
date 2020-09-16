package leetcode_practice;
import java.util.*;

/*
 * 37. ������
��дһ������ͨ�������Ŀո�������������⡣

һ�������Ľⷨ����ѭ���¹���

���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�
�հ׸��� '.' ��ʾ��

��������������ֻ�������� 1-9 ���ַ� '.' ��
����Լ������������ֻ��Ψһ�⡣
����������Զ�� 9x9 ��ʽ�ġ�
 */
public class Question37 {
	// ��¼������У����У������Ź�������ֳ������
    private boolean[][] Rows = new boolean[9][9];
    private boolean[][] Cols = new boolean[9][9];
    private boolean[][][] Blocks = new boolean[3][3][9];
    private List<int[]> Spaces = new ArrayList<>(); //��¼�հ�λ��
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

        // �������������������
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
