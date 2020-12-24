package leetcode_practice;
/*
 * 135. �ַ��ǹ�
��ʦ��������Ƿַ��ǹ����� N ������վ����һ��ֱ�ߣ���ʦ�����ÿ�����ӵı��֣�Ԥ�ȸ��������֡�

����Ҫ��������Ҫ�󣬰�����ʦ����Щ���ӷַ��ǹ���

ÿ���������ٷ��䵽 1 ���ǹ���
���ڵĺ����У����ָߵĺ��ӱ����ø�����ǹ���
��ô������������ʦ������Ҫ׼�����ٿ��ǹ��أ�

ʾ�� 1:

����: [1,0,2]
���: 5
����: ����Էֱ�����������ӷַ� 2��1��2 ���ǹ���
ʾ�� 2:

����: [1,2,2]
���: 4
����: ����Էֱ�����������ӷַ� 1��2��1 ���ǹ���
     ����������ֻ�õ� 1 ���ǹ�������������������������
 */
public class Question135 {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int res = n;
        int candys[] = new int[n];
        //Arrays.fill(candys, 1);

        //�������α���
        for(int i = 0; i < n - 1; i++)
        {
            if(ratings[i] < ratings[i + 1] && candys[i] >= candys[i + 1])
            {
                res += candys[i] + 1 - candys[i + 1];
                candys[i + 1] = candys[i] + 1;                    
            }
        }

        for(int i = n - 1; i >  0; i--)
        {
            if(ratings[i] < ratings[i - 1] && candys[i] >= candys[i - 1])
            {
                res += candys[i] + 1 -candys[i - 1];
                candys[i - 1] = candys[i] + 1;
            }
        }
        return res;
    }
}
