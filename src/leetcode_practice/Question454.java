package leetcode_practice;
import java.util.*;
/*
 * 454. ������� II
�����ĸ����������������б� A , B , C , D ,�����ж��ٸ�Ԫ�� (i, j, k, l) ��ʹ�� A[i] + B[j] + C[k] + D[l] = 0��

Ϊ��ʹ����򵥻������е� A, B, C, D ������ͬ�ĳ��� N���� 0 �� N �� 500 �����������ķ�Χ�� -228 �� 228 - 1 ֮�䣬���ս�����ᳬ�� 231 - 1 ��

����:

����:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

���:
2

����:
����Ԫ������:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */

public class Question454 {
	//�ܽᣬ�������磺A+B....+N=0��ʽ�ӣ�Ҫת��Ϊ(A+...T)=-((T+1)...+N)�ټ��㣬
	//���T�ķָ��һ����һ�룬�����������Ҫ�����жϡ���T�ǽ���Ĺؼ�
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        // ���� + ��ϣ��
        Map<Integer, Integer> ab = new HashMap<>();
        for(int a : A)
        {
            for(int b : B)
            {
                int t = a + b;
                ab.put(t, ab.getOrDefault(t, 0) + 1);
            }
        }

        for(int c : C)
        {
            for(int d : D)
            {
                int t = -c - d;
                res += ab.getOrDefault(t, 0);
            }
        }
        return res;
    }
}
