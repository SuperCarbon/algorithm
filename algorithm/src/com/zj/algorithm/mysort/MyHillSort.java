package com.zj.algorithm.mysort;

/*
 * 希尔排序
 */
public class MyHillSort {
	public static void sort(Comparable[] a) {
		int N = a.length;
		int w = N / 3;
		while (w >= 1) {
			for (int i = w; i < N; i++) {
				for (int j = i; j >= w && less(a[j], a[j - w]); j -= w) {
					exch(a, j, j - w);
				}
			}
			w = w / 3;
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
