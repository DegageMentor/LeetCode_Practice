package leetcode_practice;
import java.util.*;

import leetcode_practice.Question94.TreeNode;

public class Main {	
	// 用例测试
	public static void main(String[] args) {

		Object obj = new Question135();
		
		//135.分发糖果
		int[] ratings1 = new int[] {1, 0, 2};
		int[] ratings2 = new int[] {1, 2, 2};
		System.out.println(((Question135)obj).candy(ratings1));
		System.out.println(((Question135)obj).candy(ratings2));
		
		//714.买卖股票的最佳时机含手续费
//		int[] prices = new int[] {1, 3, 2, 8, 4, 9};
//		int fee = 2;
//		System.out.println(((Question714)obj).maxProfit(prices, fee));
		
		//621.任务调度器
//		char[] tasks = new char[] {'A', 'A', 'A', 'B', 'B', 'B'};
//		int n = 2;
//		System.out.println(((Question621)obj).leastInterval(tasks, n));
		
		
		//204.计数质数
//		int n1 = 10, n2 = 2, n3 = 1, n4 = 5000000;
//		System.out.println(((Question204)obj).countPrimes(n1));
//		System.out.println(((Question204)obj).countPrimes(n2));
//		System.out.println(((Question204)obj).countPrimes(n3));
//		System.out.println(((Question204)obj).countPrimes(n4));
		
		//321.拼接最大数
//		int k = 5;
//		int[] nums1 = new int[] {3, 4, 6, 5};
//		int[] nums2 = new int[] {9, 1, 2, 5, 8, 3};
//		for(int n : ((Question321)obj).maxNumber(nums1, nums2, k))
//			System.out.print(n + " ");
//		System.out.println();
			
		//767.重构字符串
//		String s1 = "aab";
//		String s2 = "aaab";
//		System.out.println(((Question767)obj).reorganizeString(s1));
//		System.out.println(((Question767)obj).reorganizeString(s2));
		
		//493.翻转对
//		int[] nums = new int[] {1, 3, 2, 3, 1};
//		System.out.println(((Question493)obj).reversePairs(nums));
		
		//453.四数相加2
//		int[] A = new int[] {1, 2};
//		int[] B = new int[] {-1, -2};
//		int[] C = new int[] {-1, 2};
//		int[] D = new int[] {0, 2};
//		System.out.println(((Question454)obj).fourSumCount(A, B, C, D));
		
		//164.最大间距
//		int[] nums = new int[] {3, 6, 9, 1};
//		System.out.println(((Question164)obj).maximumGap(nums));
		
		//416.分割等和子集
//		int[] nums1 = new int[] {1, 5, 11, 5};
//		int[] nums2 = new int[] {1, 5, 2, 3};
//		System.out.println(((Question416)obj).canPartition(nums1));
//		System.out.println(((Question416)obj).canPartition(nums2));
		
		//75.颜色分类
//		int[] nums = new int[] {2, 0, 2, 1, 1, 0};
//		((Question75)obj).sortColors(nums);
//		for(int i : nums)
//		{
//			System.out.print(i + " ");
//		}
//		
		//LCP19.秋叶收藏集
//		String s1 = "rrryyyrryyyrr";
//		String s2 = "ryr";
//		System.out.println(((Question_lcp17)obj).minimumOperations(s1));
//		System.out.println(((Question_lcp17)obj).minimumOperations(s2));
		
		//300.最长上升子序列
//		int nums[] = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
//		int nums2[] = new int[] {4,10,4,3,8,9};
//		System.out.println(((Question300)obj).lengthOfLIS(nums));
//		System.out.println(((Question300)obj).lengthOfLIS(nums2));
		
		//701.二叉搜索树的插入操作
		
		//474.一和零
//		String[] strs = new String[] {"10", "0001", "1", "0", "111001"};
//		int m = 5;
//		int n = 3;
//		System.out.println(((Question474)obj).findMaxForm(strs, m, n));
		
		
		//145.二叉树后序遍历
		
		//117. 填充每个节点的下一个右侧节点指针 II		
		
		//235.二叉搜索树的最近公共祖先
		
		//113.路径总和2
		
		//106.从中序和后续遍历序列构造二叉树
		
		//501.二叉搜索树中的众数
		
		//617.合并二叉树
		
		//538.把二叉搜索树转化为累加树
		
		//78.子集
//		int nums[] = new int[] {1, 2, 3};
//		
//		for(List<Integer> li : (((Question78)obj).subsets(nums)))
//		{
//			System.out.print("[");
//			for(int i : li)
//			{
//				System.out.print(i + " ");
//			}
//			System.out.println("]");
//		}
		
		//37.解数独
//		char[][] board = new char[][] {{'5','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'}, {'.','9','8','.','.','.','.','6','.'},
//									   {'8','.','.','.','6','.','.','.','3'}, {'4','.','.','8','.','3','.','.','1'}, {'7','.','.','.','2','.','.','.','6'},
//									   {'.','6','.','.','.','.','2','8','.'}, {'.','.','.','4','1','9','.','.','5'}, {'.','.','.','.','8','.','.','7','9'}};
//		
//		((Question37)obj).solveSudoku(board);
//		for(char[] rows : board)
//		{
//			for(char c : rows)
//			{
//				System.out.print(c + " ");
//			}
//			System.out.println();
//		}
//		

		//94.二叉树的中序遍历
//		Question94 q = new Question94();
//		TreeNode root = q.new TreeNode(1);
//		root.right = q.new TreeNode(2);
//		root.right.left = q.new TreeNode(3);
//		for(int i : (((Question94)obj).inorderTraversal(root)))
//		{
//			System.out.println(i);
//		}
		
		
		//79.单词搜索
//		char[][] board = new char[][] {{'A', 'B', 'C', 'E'}, 
//										{'S', 'F', 'C', 'S'}, 
//										{'A', 'D', 'E', 'E'}};
//		String word1 = "ABCCED";
//		String word2 = "SEE";
//		String word3 = "ABCB";
//		System.out.println((((Question79)obj).exist(board, word1)));
//		System.out.println((((Question79)obj).exist(board, word2)));
//		System.out.println((((Question79)obj).exist(board, word3)));
		
		
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
