package com.zj.algorithm.search;

public class LinerProblingHashST<Key, Value> {
	private static final int INIT_SIZE = 16;

	private int M;
	private int N;
	private Key[] keys;
	private Value[] vals;

	public LinerProblingHashST() {
		this(INIT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public LinerProblingHashST(int size) {
		M = size;
		keys = (Key[]) new Object[M];

		vals = (Value[]) new Object[M];

	}

	public int hash(Key key) {
		return (key.hashCode() & 0x7FFFFFFF) % M;
	}

	public void put(Key key, Value value) {

		int i;
		for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key)) {
				vals[i] = value;
			}
		}

		keys[i] = key;
		vals[i] = value;
		N++;
		if (N > M / 2) {
			resize(2 * M);
		}
	}

	public Value get(Key key) {
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key)) {
				return vals[i];
			}
		}
		return null;
	}

	public void delete(Key key) {
		int i;
		for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key)) {
				keys[i] = null;
				vals[i] = null;
			}
		}

		// 对被删除键的右边的数据进行重新hash
		i = (i + 1) % M;
		while (keys[i] != null) {
			Key tempKey = keys[i];
			Value tempValue = vals[i];
			keys[i] = null;
			vals[i] = null;
			N--;

			put(tempKey, tempValue);
			i = (i + 1) % M;

		}

		N--;
		if (M > INIT_SIZE && N < M / 8) {
			resize(M / 2);
		}

	}

	public void resize(int size) {
		LinerProblingHashST<Key, Value> temp = new LinerProblingHashST<Key, Value>(
				size);
		for (int i = 0; i < M; i++) {
			if (keys[i] != null) {
				temp.put(keys[i], vals[i]);
			}
		}

		this.keys = temp.keys;
		this.vals = temp.vals;
		this.N = temp.N;
	}
}
