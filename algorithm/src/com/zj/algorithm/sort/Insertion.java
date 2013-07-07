package com.zj.algorithm.sort;

public class Insertion extends SortBase {

	public static void main(String[] args) {
		Comparable[] arrayChar = { 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P',
				'L', 'E' };
		int length = arrayChar.length;
		for (int i = 0; i < length; i++) {
			for (int j = i; j > 0 && less(arrayChar[j], arrayChar[j - 1]); j--) {
				exchange(arrayChar, j, j-1);
			}
		}
		show(arrayChar);
	}
}
