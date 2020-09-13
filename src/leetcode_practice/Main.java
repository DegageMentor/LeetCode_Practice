package leetcode_practice;
import leetcode_practice.Question637.TreeNode;

public class Main {
	public static void main(String[] args) {

		Object obj = new Question79();
		
		//79.单词搜索
		char[][] board = new char[][] {{'A', 'B', 'C', 'E'}, 
										{'S', 'F', 'C', 'S'}, 
										{'A', 'D', 'E', 'E'}};
		String word1 = "ABCCED";
		String word2 = "SEE";
		String word3 = "ABCB";
		System.out.println((((Question79)obj).exist(board, word1)));
		System.out.println((((Question79)obj).exist(board, word2)));
		System.out.println((((Question79)obj).exist(board, word3)));
		
		
		//637.二叉树的层平均值
//		Question637 q = new Question637();
//		TreeNode root = q.new TreeNode(3);
//		root.left = q.new TreeNode(9);
//		root.right = q.new TreeNode(20);
//		root.right.left = q.new TreeNode(15);
//		root.right.right = q.new TreeNode(7);
//		for(double d : q.averageOfLevels(root))
//			System.out.println(d);
		
		//40.组合总和
//		int[] candidates = new int[] {10,1,2,7,6,1,5};
//		int target = 8;
//		for(List<Integer> li: (((Question40)obj).combinationSum2(candidates, target)))
//		{
//			for(int n1 : li)
//			{
//				System.out.print(n1 + " ");
//			}
//			System.out.println();
//		}
		
		//216.组合总和-3
//		int n = 7, k = 3;
//		for(List<Integer> li: (((Question216)obj).combinationSum3(k, n)))
//		{
//			for(int n1 : li)
//			{
//				System.out.print(n1 + " ");
//			}
//			System.out.println();
//		}
		
		
		//39.组合总和
//		int[] candidates = new int[] {2, 3, 6, 7};
//		int target = 7;
//		for(List<Integer> li: (((Question39)obj).combinationSum(candidates, target)))
//		{
//			for(int n1 : li)
//			{
//				System.out.print(n1 + " ");
//			}
//			System.out.println();
//		}
		
		
		//77.组合
//		int n = 4, k = 2;
//		for(List<Integer> li: (((Question77)obj).combine(n, k)))
//		{
//			for(int n1 : li)
//			{
//				System.out.print(n1 + " ");
//			}
//			System.out.println();
//		}
		
		//347.前k个高频元素
//		int[] nums = new int[]{1,1,1,2,2,3};
//		int k = 2;
//		for(int n : ((Question347)obj).topKFrequent(nums, k))
//			System.out.println(n);
		
		// 529. 扫雷游戏
//		char board[][] = new char[][]{{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
//		int[] click = new int[]{3, 0};
//		char[][] newBoard = ((Question529)obj).updateBoard(board, click);
//		for(int i = 0; i < newBoard.length; i++)
//		{
//			for(int j = 0; j < newBoard[i].length; j++)
//			{
//				System.out.print(newBoard[i][j] + " ");
//			}
//			System.out.println();
//		}
			
		
		// 679.24点游戏
//		int[] nums1 = new int[] { 1, 3, 4, 6 };	// 6 / (1 - 3/4)
//		int[] nums2 = new int[] { 3, 8, 3, 8 };	// 8 / (3 - 8/3)
//		System.out.println(((Question679)obj).judgePoint24(nums1));
//		System.out.println(((Question679)obj).judgePoint24(nums2));

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
