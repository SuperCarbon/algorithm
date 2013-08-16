package com.zj.algorithm.string;

/**
 * 低位优先的字符串排序
 * 
 * @Description:
 * @author zJun
 * @date Aug 12, 2013 10:28:53 PM
 * 
 */
public class LSD {

	public static void sort(String[] a, int w) {
		int R = 256;
		int N = a.length;
		String[] aux = new String[N];
		for (int i = w - 1; i >= 0; i--) {
			int[] count = new int[R + 1];
			// 计算出现的频率
			for (int j = 0; j < N; j++) {
				count[a[j].charAt(i) + 1]++;
			}
			// 将频率转换为索引
			for (int k = 0; k < R; k++) {
				count[k + 1] += count[k];
				//System.out.println(count[k]);
			}
			// 将元素分类
			for (int l = 0; l < N; l++) {
				aux[count[a[l].charAt(i)]++] = a[l];
			}
			// 将元素回写
			for (int m = 0; m < N; m++) {
				a[m] = aux[m];
			}
		}
	}

	public static void main(String[] args) {
		String[] a = { "4PGC938", "2IYE230", "3CI0720", "1ICK750", "1OHV845",
				"4JZY524", "1ICK750", "3CIO720", "1OHV845", "1OHV845",
				"2RLA629", "2RLA629", "3ATW723" };
		sort(a, 7);
		// for (int i = 0; i < a.length; i++) {
		// System.out.println(a[i]);
		// }

	}

}
