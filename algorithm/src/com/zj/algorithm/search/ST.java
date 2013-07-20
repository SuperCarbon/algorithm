package com.zj.algorithm.search;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class ST<Key, Value> implements Iterable<Key> {
	private TreeMap<Key, Value> st = null;

	// 创建一个字符表
	public ST() {
		st = new TreeMap<Key, Value>();
	}

	// 将一个键值对存入表中，若为value为空，则直接删除
	public void put(Key key, Value value) {
		if (value != null) {
			st.put(key, value);
		}
	}

	// 根据key取value
	public Value get(Key key) {
		return st.get(key);
	}

	// 删除一个键值对
	public void delete(Key key) {
		if (st.containsKey(key)) {
			st.remove(key);
		} else {
			throw new NoSuchElementException("木有这个键值对");
		}
	}

	public boolean ifContains(Key key) {
		return st.containsKey(key);
	}

	public boolean isEmpty() {

		return st.isEmpty();
	}

	public int size() {
		return st.size();

	}

	@Override
	public Iterator<Key> iterator() {
		return st.keySet().iterator();
	}

	public Iterable<Key> keys() {
		return st.keySet();
	}

	public Key min() {
		return st.firstKey();
	}

	public Key max() {
		return st.lastKey();
	}

	public static void main(String[] args) {
		ST<String, Integer> st = new ST<String, Integer>();
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}

//		String[] array = { "S", "E", "B", "R", "C", "H", "E", "X", "A", "M",
//				"P", "L", "E" };
//		for (int i = 0; i < array.length; i++) {
//			String key = array[i];
//			st.put(key, i);
//		}

		for (String key : st.keys()) {
			System.out.println(key + "	" + st.get(key));
		}
	}

}
