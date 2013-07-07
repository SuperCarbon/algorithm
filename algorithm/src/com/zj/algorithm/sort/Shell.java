package com.zj.algorithm.sort;

public class Shell extends SortBase {

	public static void main(String[] args) {
		Comparable[] arrayChar = {'S','H','E','L','L', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P',
				'L', 'E' };
		int length = arrayChar.length;
		int h = 1;
		while (h < length / 3) {
			h = h * 3 + 1;
			System.out.println("top==>"+h);
		}

		while (h >= 1) {
			for (int i = h; i < length; i++) {
				for (int j = i; j >= h && less(arrayChar[j], arrayChar[j - h]); j -= h) {
					exchange(arrayChar, j, j - h);
				}
			}
			h = h / 3;
			System.out.println(h);
		}
		show(arrayChar);
	}

}
