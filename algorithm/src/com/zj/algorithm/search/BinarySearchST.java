package com.zj.algorithm.search;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys = null;
	private Value[] vals = null;
	private int N;

	@SuppressWarnings("unchecked")
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}

	public Value get(Key key) {
		if (size() == 0) {
			return null;
		}
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			return vals[i];
		} else {
			return null;
		}
	}

	public void put(Key key, Value value) {
		// 第一步，找key是否已经存在于现有数据中，如果存在则更新，否则插入一条新数据
		int i = rank(key);
		if (i < N && key.compareTo(keys[i]) == 0) {
			vals[i] = value;
		} else {
			// 在i的位置插入一条新的数据，i以后的数据全部往后移一位
			// 数组从0开始,所以j=N
			for (int j = N; j > i; j--) {
				vals[j] = vals[j - 1];
				keys[j] = keys[j - 1];
			}
			keys[i] = key;
			vals[i] = value;
			N++;
		}
	}

	// 递归
	public int rank(Key key, int lo, int hi) {
		if (lo > hi) {
			return lo;
		}

		int mid = lo + (hi - lo) / 2;
		int cmp = keys[mid].compareTo(key);
		if (cmp < 0) {
			return rank(key, mid + 1, hi);
		} else if (cmp > 0) {
			return rank(key, lo, mid - 1);
		} else {
			return mid;
		}
	}

	// 迭代
	public int rank(Key key) {
		int lo = 0;
		int hi = N - 1;
		int mid = lo + (hi - lo) / 2;
		while (mid > 0) {
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0) {
				hi = mid - 1;
			} else if (cmp > 0) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return lo;
	}

	public int size() {
		return 0;
	}

}
