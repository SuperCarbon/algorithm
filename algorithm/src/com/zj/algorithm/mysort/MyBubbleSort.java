package com.zj.algorithm.mysort;

/*
 * 冒泡排序
 */
public class MyBubbleSort {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (!less(a[j], a[j + 1])) {
					exch(a, j, j + 1);
				}
			}
		}
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
