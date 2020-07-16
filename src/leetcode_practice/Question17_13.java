package leetcode_practice;

/*
 * ������ 17.13. �ָ��ո�
Ŷ�������㲻С�İ�һ����ƪ�����еĿո񡢱�㶼ɾ���ˣ����Ҵ�дҲŪ����Сд�������"I reset the computer. It still didn��t boot!"�Ѿ������"iresetthecomputeritstilldidntboot"���ڴ�������źʹ�Сд֮ǰ������Ȱ����ϳɴ����Ȼ�ˣ�����һ�����Ĵʵ�dictionary����������Щ��û�ڴʵ������������sentence��ʾ�����һ���㷨�������¶Ͽ���Ҫ��δʶ����ַ����٣�����δʶ����ַ�����

ע�⣺�������ԭ�������Ķ���ֻ�践��δʶ����ַ���

 

ʾ����

���룺
dictionary = ["looked","just","like","her","brother"]
sentence = "jesslookedjustliketimherbrother"
����� 7
���ͣ� �Ͼ��Ϊ"jess looked just like tim her brother"����7��δʶ���ַ���
��ʾ��

0 <= len(sentence) <= 1000
dictionary�����ַ��������� 150000��
�������Ϊdictionary��sentence��ֻ����Сд��ĸ��
 */
class Question17_13 {
	public int respace(String[] dictionary, String sentence) {
		if (dictionary == null || dictionary.length == 0) {
			return sentence.length();
		}
		// �ֵ��� + ��̬�滮
		// �ֵ�����ʼ��
		Trie root = new Trie();
		for (int i = 0; i < dictionary.length; i++) {
			root.insert(dictionary[i]);
		}

		// dp[i] ��ʾsentenceǰi���ַ����ٵ�δʶ���ַ���
		int dp[] = new int[sentence.length() + 1];
		for (int i = 1; i < dp.length; i++) {
			// ��ʼ��dp[i]
			dp[i] = dp[i - 1] + 1;

			// ���sentence.subString(j, i)���ֵ��У�dp[i] = min(dp[i], dp[j])
			Trie cur = root;
			for (int j = i - 1; j >= 0; j--) {
				if (cur.next[sentence.charAt(j) - 'a'] == null) {
					break;
				}
				cur = cur.next[sentence.charAt(j) - 'a'];
				if (cur.isEnd) {
					dp[i] = Math.min(dp[i], dp[j]);
				}
			}
		}

		return dp[sentence.length()];
	}
}

//�����ֵ���
class Trie {
	Trie[] next;
	boolean isEnd;

	public Trie() {
		next = new Trie[26];
	}

	public void insert(String s) {
		Trie curPos = this;
		for (int i = s.length() - 1; i >= 0; i--) {
			int j = s.charAt(i) - 'a';
			if (curPos.next[j] == null) {
				curPos.next[j] = new Trie();
			}
			curPos = curPos.next[j];
		}
		curPos.isEnd = true;
	}

}
