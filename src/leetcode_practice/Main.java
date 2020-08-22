package leetcode_practice;

public class Main {
	public static void main(String[] args) {

		Object obj = new Question679();

		// 679.24点游戏
		int[] nums1 = new int[] { 1, 3, 4, 6 };	// 6 / (1 - 3/4)
		int[] nums2 = new int[] { 3, 8, 3, 8 };	// 8 / (3 - 8/3)
		System.out.println(((Question679)obj).judgePoint24(nums1));
		System.out.println(((Question679)obj).judgePoint24(nums2));

		// 97.交错字符串
//		String s1 = "aabcc";
//		String s2 = "dbbca";
//		String s3 = "aadbbcbcac";
//		System.out.println(((Question97)obj).isInterleave(s1, s2, s3));

		// 309.股票最佳买卖时机含冷冻期
//		int[] prices = new int[] {1, 2, 3, 0, 2};
//		System.out.println(((Question309)obj).maxProfit(prices));

		// 17.13恢复空格
//		String[] dictionary = new String[] {"looked","just","like","her","brother"};
//		String sentence = "jesslookedjustliketimherbrother";
//		System.out.println(((Question17_13)obj).respace(dictionary, sentence));

		// 63.不同路径2

		// 50.Pow(x,n)
//		double x = 2.0;
//		int n = 10;
//		System.out.println(((Question50)obj).myPow(x, n));

		// 62.不同路径
//		int m = 10, n = 10;
//		System.out.println(((Question62)obj).uniquePaths(m, n));

	}

}
