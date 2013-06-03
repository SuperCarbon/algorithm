package com.zj.algorithm;

public class PrimeNumber {

	/**
	 * @Title: 寻找0-100以内的所有素数
	 * @Description: TODO
	 * @param args
	 * @throws
	 */
	public static void main(String[] args) {
		int a[] = new int[101];
		int i = 0;
		int j = 0;
		for (i = 1; i < 101; i++) {
			a[i] = 1;
		}

		for (i = 2; i < 101; i++) {
			if (a[i] != 0) {
				
				for (j = i + i; j < 101; j++) {
					System.out.println(i+"---"+j);
					if (j % i == 0) {
						a[j] = 0;
						j = j + i;
					}
				}
			}
		}
//		for (i = 2; i < 101; i++) {
//			if (a[i] != 0) {
//				//System.out.println(i);
//			}
//		}
	}

}
