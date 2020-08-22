package leetcode_practice;
import java.util.*;
/*
 * 679. 24 ����Ϸ
	���� 4 ��д�� 1 �� 9 ���ֵ��ơ�����Ҫ�ж��Ƿ���ͨ�� *��/��+��-��(��) ������õ� 24��
	
	ʾ�� 1:
	
	����: [4, 1, 8, 7]
	���: True
	����: (8-4) * (7-1) = 24
	ʾ�� 2:
	
	����: [1, 2, 1, 2]
	���: False
	ע��:
	
	��������� / ��ʾʵ���������������������������� 4 / (1 - 2/3) = 12 ��
	ÿ����������������������㡣�ر������ǲ����� - ��ΪһԪ����������磬[1, 1, 1, 1] ��Ϊ����ʱ�����ʽ -1 - 1 - 1 - 1 �ǲ�����ġ�
	�㲻�ܽ�����������һ�����磬����Ϊ [1, 2, 1, 2] ʱ������д�� 12 + 12 ��
 */
class Question679 {
	public boolean judgePoint24(int[] nums) {
		List<Double> list = new ArrayList<>();
		for (int num : nums) {
			list.add((double) num);
		}

		return helper(list);
	}

	//���ݷ��� ���� 12 * 4 * 6 * 4 *  2 * 4 = 9216�ֿ���
	public boolean helper(List<Double> list) {
		if (list.size() == 1) {
			return Math.abs(list.get(0) - 24.0) < 1e-6;
		}

		// ����ѡ��������
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i != j) {
					List<Double> list2 = new ArrayList<>();
					for (int m = 0; m < list.size(); m++) {
						if (m != i && m != j)
							list2.add(list.get(m));
					}
					// ������������
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
