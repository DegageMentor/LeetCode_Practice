package leetcode_practice;
import java.util.*;

/*
 * 767. �ع��ַ���
����һ���ַ���S������Ƿ��������Ų����е���ĸ��ʹ�������ڵ��ַ���ͬ��

�����У����������еĽ�����������У����ؿ��ַ�����

ʾ�� 1:

����: S = "aab"
���: "aba"
ʾ�� 2:

����: S = "aaab"
���: ""
ע��:

S ֻ����Сд��ĸ���ҳ�����[1, 500]�����ڡ�
 */
public class Question767 {
    public String reorganizeString(String S) {
        if(S.length() < 2) return S;

        String res = "";

        int[] counts = new int[26];
        for(char c : S.toCharArray()) counts[c - 'a']++;
        int maxCount = counts[0];
        for(int c : counts) maxCount = Math.max(c, maxCount);

        // ����Ƶ����ߵ�Ԫ��ռ����һ�����ϣ�������
        if(maxCount > (S.length() + 1) / 2) return res;

        // ���ڶ������̰���㷨
        PriorityQueue<Character> maxheap = new PriorityQueue<>(new Comparator<Character>(){
            public int compare(Character c1, Character c2)
            {
                return counts[c2 - 'a'] - counts[c1 - 'a'];
            }
        });

        for(int i = 0; i < counts.length; i++)
        {
            if(counts[i] > 0) maxheap.offer((char)('a' + i));
        }

        StringBuffer sb = new StringBuffer();
        while(maxheap.size() > 1)
        {
            char c1 = maxheap.poll();
            char c2 = maxheap.poll();
            counts[c1 - 'a']--;
            counts[c2 - 'a']--;
            sb.append(c1);
            sb.append(c2);
            if(counts[c1 - 'a'] > 0) maxheap.offer(c1);
            if(counts[c2 - 'a'] > 0) maxheap.offer(c2);
        }
        if(maxheap.size() > 0) sb.append(maxheap.peek());
        
        return sb.toString();
    }
}
