package leetcode_practice;
import java.util.*;

/*
 * 767. 重构字符串
给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。

若可行，输出任意可行的结果。若不可行，返回空字符串。

示例 1:

输入: S = "aab"
输出: "aba"
示例 2:

输入: S = "aaab"
输出: ""
注意:

S 只包含小写字母并且长度在[1, 500]区间内。
 */
public class Question767 {
    public String reorganizeString(String S) {
        if(S.length() < 2) return S;

        String res = "";

        int[] counts = new int[26];
        for(char c : S.toCharArray()) counts[c - 'a']++;
        int maxCount = counts[0];
        for(int c : counts) maxCount = Math.max(c, maxCount);

        // 出现频率最高的元素占总数一半以上，不可行
        if(maxCount > (S.length() + 1) / 2) return res;

        // 基于堆排序的贪心算法
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
