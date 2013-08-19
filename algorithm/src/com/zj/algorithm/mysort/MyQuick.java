package com.zj.algorithm.mysort;

/*
 * 快速排序
 */
public class MyQuick {
	public static void sort(Comparable[] a) {
		int N = a.length;
		sort(a, 0, N - 1);
	}

	public static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	public static int partition(Comparable[] a, int lo, int hi) {
		Comparable v = a[lo];
		int i = lo;
		int j = hi + 1;
		while (true) {
			while (less(a[++i], v)) {
				if (i == hi) {
					break;
				}
			}
			while (less(v, a[--j])) {
				if (j == lo) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			exch(a, i, j);
		}

		exch(a, lo, j);
		return j;
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
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
