package leetcode_practice;
import java.util.*;

/*
 * 204. ��������
ͳ������С�ڷǸ����� n ��������������

 

ʾ�� 1��

���룺n = 10
�����4
���ͣ�С�� 10 ������һ���� 4 ��, ������ 2, 3, 5, 7 ��
ʾ�� 2��

���룺n = 0
�����0
ʾ�� 3��

���룺n = 1
�����0
 */
public class Question204 {
    public int countPrimes(int n) {
        int res = 0;
        if(n < 3) return res;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        
        //����ɸ	ʱ�临�Ӷȣ�O(nloglogn)
        for(int i = 2; i < n; i++)
        {
            if(isPrime[i])
            {
                res++;
                if((long)i * i < n)
                {
                    for(int j = i * i; j < n; j += i) isPrime[j] = false;
                }
            }
        }
        return res;
    }
}
