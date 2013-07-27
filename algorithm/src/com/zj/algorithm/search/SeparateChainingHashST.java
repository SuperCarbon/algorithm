package com.zj.algorithm.search;

import com.zj.algorithm.chapter3.SequentialSearchST;

public class SeparateChainingHashST<Key, Value> {
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
	}

	public Value get(Key key) {
		return st[hash(key)].get(key);
	}

	public int hash(Key key) {
		return (key.hashCode() & 0x7FFFFFFF) % M;
	}
}
