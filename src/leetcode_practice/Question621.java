package leetcode_practice;
/*
 * 621. ���������
����һ�����ַ����� tasks ��ʾ�� CPU ��Ҫִ�е������б�����ÿ����ĸ��ʾһ�ֲ�ͬ����������������������˳��ִ�У�����ÿ�����񶼿����� 1 ����λʱ����ִ���ꡣ���κ�һ����λʱ�䣬CPU �������һ�����񣬻��ߴ��ڴ���״̬��

Ȼ�������� ��ͬ���� ������֮������г���Ϊ���� n ����ȴʱ�䣬������������� n ����λʱ���� CPU ��ִ�в�ͬ�����񣬻����ڴ���״̬��

����Ҫ�������������������Ҫ�� ���ʱ�� ��

 

ʾ�� 1��

���룺tasks = ["A","A","A","B","B","B"], n = 2
�����8
���ͣ�A -> B -> (����) -> A -> B -> (����) -> A -> B
     �ڱ�ʾ���У�������ͬ��������֮�����������Ϊ n = 2 ����ȴʱ�䣬��ִ��һ������ֻ��Ҫһ����λʱ�䣬�����м�����ˣ�������״̬�� 
ʾ�� 2��

���룺tasks = ["A","A","A","B","B","B"], n = 0
�����6
���ͣ�����������£��κδ�СΪ 6 �����ж���������Ҫ����Ϊ n = 0
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
�������
ʾ�� 3��

���룺tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
�����16
���ͣ�һ�ֿ��ܵĽ�������ǣ�
     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (����) -> (����) -> A -> (����) -> (����) -> A
 

��ʾ��

1 <= task.length <= 104
tasks[i] �Ǵ�дӢ����ĸ
n ��ȡֵ��ΧΪ [0, 100]
 */
public class Question621 {
	public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;

        int[] counts = new int[26];
        for(char t : tasks) counts[t - 'A']++;
        
        //̰�� + �Խת��
        int maxExec = 0;
        for(int c : counts) maxExec = Math.max(maxExec, c);

        int maxCount = 0;
        for(int c : counts) if(c == maxExec) maxCount++;

        return Math.max((n + 1) * (maxExec - 1) + maxCount, tasks.length);


        // //ģ��ִ�У������������Ӵ�С���У�̰��ѡ��
        // PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>()
        // {
        //     @Override
        //     public int compare(Character c1, Character c2)
        //     {
        //         return counts[c2 - 'A'] - counts[c1 - 'A'];
        //     }
        // });

        // for(int i = 0; i < 26; i++) if(counts[i] > 0) queue.offer((char)('A' + i));

        // int res = 0;
        // while(!queue.isEmpty())
        // {
        //     char[] cur = new char[n + 1];
        //     int t = 0;
        //     while(!queue.isEmpty() && t <= n)
        //     {
        //         cur[t] = queue.poll();
        //         counts[cur[t] - 'A']--;
        //         t++;
        //     }
        //     res += t;

        //     for(int i = 0; i < t; i++)
        //     {
        //         if(counts[cur[i] - 'A'] > 0) queue.offer(cur[i]);
        //     }

        //     if(!queue.isEmpty() && t <= n) res += n + 1 - t;
        // }
        // return res;
    }
}
