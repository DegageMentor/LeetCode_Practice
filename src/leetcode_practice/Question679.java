package leetcode_practice;
import java.util.*;
/*
 * 679. 24 点游戏
	你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
	
	示例 1:
	
	输入: [4, 1, 8, 7]
	输出: True
	解释: (8-4) * (7-1) = 24
	示例 2:
	
	输入: [1, 2, 1, 2]
	输出: False
	注意:
	
	除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
	每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
	你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 */
class Question679 {
	public boolean judgePoint24(int[] nums) {
		List<Double> list = new ArrayList<>();
		for (int num : nums) {
			list.add((double) num);
		}

		return helper(list);
	}

	//回溯法， 共有 12 * 4 * 6 * 4 *  2 * 4 = 9216种可能
	public boolean helper(List<Double> list) {
		if (list.size() == 1) {
			return Math.abs(list.get(0) - 24.0) < 1e-6;
		}

		// 有序选择两个数
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i != j) {
					List<Double> list2 = new ArrayList<>();
					for (int m = 0; m < list.size(); m++) {
						if (m != i && m != j)
							list2.add(list.get(m));
					}
					// 进行四则运算
					for (int k = 0; k < 4; k++) {
						if (k < 2 && i > j)
							continue;
						if (k == 0)
							list2.add(list.get(i) + list.get(j));
						else if (k == 1)
							list2.add(list.get(i) * list.get(j));
						else if (k == 2)
							list2.add(list.get(i) - list.get(j));
						else if (Math.abs(list.get(j)) < 1e-6)
							break;
						else
							list2.add(list.get(i) / list.get(j));

						if (helper(list2))
							return true;
						list2.remove(list2.size() - 1);
					}
				}
			}
		}
		return false;
	}
}
