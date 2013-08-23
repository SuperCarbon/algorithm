package com.zj.algorithm.symboltable;

/*
 * 基于链表的符号表查找
 */
public class SequentialSearchST<Key, Value> {
	private Node first;
	private int N;

	private class Node {
		private Key key;
		private Value value;
		private Node next;

		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	public void put(Key key, Value value) {
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.value = value;
			}
		}

		first = new Node(key, value, first);
		N++;
	}

	public Value get(Key key) {
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				return x.value;
			}
		}

		return null;
	}

	public void delete(Key key) {
		 delete(first, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null) {
			return null;
		}
		if (key.equals(x.key)) {

			N--;
			return x.next;
		}

		x.next = delete(x.next, key);
		return x;
	}

	public static void main(String args[]) {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();

		st.put("S", 0);
		st.put("E", 6);
		st.put("A", 8);
		st.put("R", 3);
		st.put("C", 4);
		st.put("H", 5);
		st.put("X", 7);

		System.out.println(st.get("R"));
		st.delete("R");
		System.out.println(st.get("R"));
	}
}
