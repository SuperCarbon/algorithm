package com.zj.algorithm.string;

public class EasyStringMatch {

	public static void main(String[] args) {
		String text = "banananobano";
		String pattern = "nano";
		System.out.println(match(text, pattern));
	}

	public static int match(String text, String pattern) {
		int N = text.length();
		int M = pattern.length();
		System.out.println("M=>"+M);
		int result = 0;
		for (int i = 0; i < N; i++) {
			int j = 0;
			while (j < M) {
				if (text.charAt(i + j) == pattern.charAt(j)) {
					j++;
					if (j == M ) {
						System.out.println("i=>"+i);
						System.out.println("j=>"+j);
						result = i;
						return result;
					} else {
						result = -1;
					}
				} else {
					break;
				}
			}
		}

		return result;
	}

}
