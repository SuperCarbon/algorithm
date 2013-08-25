package com.zj.algorithm.symboltable;

/**
 * 红黑查找树
 * 
 * @Description:
 * @author zJun
 * @date Aug 24, 2013 11:27:05 PM
 * 
 */
public class BlackRedST<Key extends Comparable<Key>, Value> {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;

	private class Node {
		private Key key;
		private Value value;
		private Node left, right;
		private boolean color;
		private int N;

		public Node(Key key, Value value, int N, boolean color) {
			this.key = key;
			this.value = value;
			this.N = N;
			this.color = color;
		}
	}

	public Node ronateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	public Node ronateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	public void put(Key key, Value value) {
		root = put(key, value, root);
		root.color = BLACK;
	}

	public boolean isRed(Node x) {
		return x.color == RED;
	}

	public Node flipColor(Node x) {
		x.color = RED;
		x.left.color = BLACK;
		x.right.color = BLACK;
		return x;
	}

	private Node put(Key key, Value value, Node x) {
		if (x == null) {
			return new Node(key, value, 1, RED);
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(key, value, x.left);
		} else if (cmp > 0) {
			x.right = put(key, value, x.right);
		} else {
			x.value = value;
		}
		if (!isRed(x.left) && isRed(x.right)) {
			x = ronateLeft(x);
		}

		if (isRed(x.left) && isRed(x.left.left)) {
			x = ronateRight(x);
		}
		if (isRed(x.left) & isRed(x.right)) {
			x = flipColor(x);
		}
		return x;
	}
}
