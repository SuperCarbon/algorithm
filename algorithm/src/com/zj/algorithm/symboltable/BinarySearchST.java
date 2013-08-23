package com.zj.algorithm.symboltable;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;

	private int N;

	// public int rank(Key key) {
	// int lo = 0;
	// int hi = N - 1;
	// return rank(key, lo, hi);
	// }
	//
	// public int rank(Key key, int lo, int hi) {
	// int mid = lo + (hi - lo) / 2;
	// int cmp = key.compareTo(keys[mid]);
	// if (cmp < 0) {
	// return rank(key, lo, mid - 1);
	// } else if (cmp > 0) {
	// return rank(key, mid + 1, hi);
	// } else {
	// return mid;
	// }
	//
	// }

	public int rank(Key key) {
		int lo = 0;
		int hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0) {
				hi = mid - 1;
			} else if (cmp > 0) {
				lo = mid + 1;
			}else{
				return mid;
			}
		}
		return lo;
	}

	public void put(Key key, Value value) {
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			vals[i] = value;
			return;
		}
		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = value;
		N++;
	}

	public Value get(Key key) {
		int i = rank(key);
		return vals[i];
	}

	// private void get(Key key, int lo, int hi) {
	//
	// }

	public void delete(Key key) {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
