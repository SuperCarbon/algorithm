package com.zj.algorithm.mysort;

public class MaxPQ<Key> implements Comparable<Key> {
	private Key[] keys;
	private int N;

	@SuppressWarnings("unchecked")
	public MaxPQ(int capacity) {
		keys = (Key[]) new Object[capacity];
		N = 0;
	}

	public void insert(Key x) {
		keys[++N] = x;
		swim(N);
	}

	public Key delMax() {
		Key max = keys[1];
		exch(1, N);
		keys[--N] = null;
		sink(1);
		return max;
	}

	public void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1)) {
				j++;
			}
			if (!less(k, j)) {
				break;
			}
			exch(k, j);
			k = j;
		}
	}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	public boolean less(int i, int j) {
		return ((Comparable<Key>) keys[i]).compareTo(keys[j]) < 0;
	}

	public void exch(int i, int j) {
		Key temp = keys[i];
		keys[i] = keys[j];
		keys[j] = temp;
	}

	public static void main(String[] args) {
		MaxPQ<String> pq = new MaxPQ<String>(12);
		String[] keys = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		for (int i = 0; i < keys.length; i++) {
			pq.insert(keys[i]);
		}

		System.out.println(pq.delMax());
	}

	@Override
	public int compareTo(Key o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
