package com.zj.algorithm.mysort;

/*
 * 归并排序
 */
public class MyMerge {
	// 临时数组
	private static Comparable[] aux;

	public static void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[N];
		sort(a, 0, N - 1);
	}

	public static void sort(Comparable[] a, int lo, int hi) {
		if (hi<=lo) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		// 先排序左边
		sort(a, lo, mid);
		// 排序右边
		sort(a, mid + 1, hi);
		// 合并
		merge(a, lo, mid, hi);
	}

	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;

		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		for (int k = lo; k <= hi; k++) {
			if (j > hi) {
				a[k] = aux[i++];
			} else if (i > mid) {
				a[k] = aux[j++];
			} else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}

		}
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void main(String[] args) {
		Comparable[] a = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L",
				"E" };

		Comparable[] b = { "bac", "bug", "bed", "dad", "yes", "zoo", "all",
				"bad", "abc", "yet" };
		sort(a);
		sort(b);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
	}
}
