package com.zj.algorithm.sort;

public class Merge extends SortBase {

	public static void main(String[] args) {
		Comparable[] arrayChar = { 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P',
				'L', 'E' };
		sort(arrayChar);
		show(arrayChar);

	}

	private static Comparable[] aux;

	public static void merge(Comparable[] arrayChar, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = arrayChar[k];
		}

		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				arrayChar[k] = aux[j++];
			} else if (j > hi) {
				arrayChar[k] = aux[i++];
			} else if (less(aux[j], aux[i])) {
				arrayChar[k] = aux[j++];
			} else {
				arrayChar[k] = aux[i++];
			}
		}
	}

	public static void sort(Comparable[] arrayChar) {
		aux = new Comparable[arrayChar.length];
		sort(arrayChar, 0, arrayChar.length - 1);
	}

	public static void sort(Comparable[] arrayChar, int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		int mid = lo + (hi - lo) / 2;

		sort(arrayChar, lo, mid);// 左边排序
		sort(arrayChar, mid+1, hi);// 右边排序
		merge(arrayChar, lo, mid, hi);
	}
}
