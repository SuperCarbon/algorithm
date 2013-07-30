package com.zj.algorithm.search;

import com.zj.algorithm.chapter3.SequentialSearchST;

public class SeparateChainingHashST<Key, Value> {
	private static final int INIT_CAPACITY = 4;

	private int N;// 键值对总数
	private int M;// 散列表大小
	private SequentialSearchST<Key, Value>[] st;

	public SeparateChainingHashST() {

	}

	@SuppressWarnings("unchecked")
	public SeparateChainingHashST(int M) {
		this.M = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for (int i = 0; i < M; i++) {
			st[i] = new SequentialSearchST<Key, Value>();
		}
	}

	public void put(Key key, Value value) {
		st[hash(key)].put(key, value);
		N++;
	}

	public Value get(Key key) {
		return st[hash(key)].get(key);
	}

	public int hash(Key key) {
		return (key.hashCode() & 0x7FFFFFFF) % M;
	}

	public void delete(Key key) {
		int i = hash(key);
		if (st[i].contains(key)) {
			N--;
			st[i].delete(key);
		}

		if (M > INIT_CAPACITY && N < 2 * M) {
			resize(M / 2);
		}

	}

	public void resize(int size) {
		SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(
				size);
		for (int i = 0; i < M; i++) {
			for (Key key : st[i].keys()) {
				temp.put(key, st[i].get(key));
			}
		}

		this.M = temp.M;
		this.N = temp.N;
		this.st = temp.st;

	}

}
