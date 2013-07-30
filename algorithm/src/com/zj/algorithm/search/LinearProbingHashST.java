package com.zj.algorithm.search;

public class LinearProbingHashST<Key, Value> {
	private int M;
	private int N;
	private Key[] keys;
	private Value[] vals;

	public LinearProbingHashST() {
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}

	public Value get(Key key) {
		for (int i = hash(key); keys[i] != key; i = (i + 1) % M) {
			if (keys[i].equals(key)) {
				return vals[i];
			}
		}
		return null;
	}

	public void put(Key key, Value value) {

		for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i] == key) {
				vals[i] = value;
				return;
			}
			keys[i] = key;
			vals[i] = value;
			N++;
		}
	}

	public int hash(Key key) {
		return (key.hashCode() & 0x7FFFFFFF) % M;
	}
}
