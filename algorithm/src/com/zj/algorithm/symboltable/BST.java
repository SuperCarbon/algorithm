package com.zj.algorithm.symboltable;

/**
 * 基于二叉查找树的符号表
 * 
 * @Description:
 * @author zJun
 * @date Aug 23, 2013 9:06:40 PM
 * 
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value> {
	// private int N;
	private Node root;

	public class Node {
		private Key key;
		private Value value;
		private Node left, right;
		private int N;

		public Node(Key key, Value value, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}

	public void put(Key key, Value value) {
		put(key, value, root);
	}

	public Node put(Key key, Value value, Node x) {
		if (x == null) {
			return new Node(key, value, 1);
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(key, value, x.left);
		} else if (cmp > 0) {
			x.right = put(key, value, x.right);
		} else {
			x.value = value;

		}

		x.N = 1 + size(x.left) + size(x.right);
		return x;
	}

	public void delete(Key key) {
		root = delete(root, key);
	}

	public Node delete(Node x, Key key) {
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = delete(x.left, key);
		} else if (cmp > 0) {
			x.right = delete(x.right, key);
		} else {
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		return x;
	}

	public Value get(Key key) {

		return get(key, root).value;
	}

	public Node get(Key key, Node x) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = get(key, x.left);
		} else if (cmp > 0) {
			x.right = get(key, x.right);
		} else {
			return x;
		}
		return x;
	}

	public int size(Node x) {
		if (x == null) {
			return 0;
		}
		return x.N;
	}

	public Node min(Node x) {
		if (x.left == null) {
			return x;
		} else {
			return min(x.left);
		}
	}

	public Node deleteMin(Node x) {
		if (x.left == null) {
			return x.right;
		}
		x.left = deleteMin(x.left);
		return x;
	}

	public Node max(Node x) {
		if (x.right == null) {
			return x;
		} else {
			return max(x.right);
		}
	}

	public Node deleteMax(Node x) {
		if (x.right == null) {
			return x.left;
		}

		x.right = deleteMax(x.right);
		return x;
	}

	public static void main(String[] args) {

	}

}
