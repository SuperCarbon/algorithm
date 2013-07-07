package com.zj.algorithm.sort;

public class Selection extends SortBase {

	public static void main(String[] args) {
		Comparable[] arrayChar = { 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P',
				'L', 'E' };

		int length = arrayChar.length;
		for (int i = 0; i < length; i++) {
			int min = i;
			for (int j = i; j < length; j++) {
				if (!less(arrayChar[min], arrayChar[j])) {

					min = j;
				}
			}
			exchange(arrayChar, min, i);
		}
		show(arrayChar);
	}

}
