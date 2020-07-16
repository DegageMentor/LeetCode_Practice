package leetcode_practice;

/*
 * 面试题 17.13. 恢复空格
哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。

注意：本题相对原题稍作改动，只需返回未识别的字符数

 

示例：

输入：
dictionary = ["looked","just","like","her","brother"]
sentence = "jesslookedjustliketimherbrother"
输出： 7
解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
提示：

0 <= len(sentence) <= 1000
dictionary中总字符数不超过 150000。
你可以认为dictionary和sentence中只包含小写字母。
 */
class Question17_13 {
	public int respace(String[] dictionary, String sentence) {
		if (dictionary == null || dictionary.length == 0) {
			return sentence.length();
		}
		// 字典树 + 动态规划
		// 字典树初始化
		Trie root = new Trie();
		for (int i = 0; i < dictionary.length; i++) {
			root.insert(dictionary[i]);
		}

		// dp[i] 表示sentence前i个字符最少的未识别字符数
		int dp[] = new int[sentence.length() + 1];
		for (int i = 1; i < dp.length; i++) {
			// 初始化dp[i]
			dp[i] = dp[i - 1] + 1;

			// 如果sentence.subString(j, i)在字典中，dp[i] = min(dp[i], dp[j])
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

//定义字典树
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
