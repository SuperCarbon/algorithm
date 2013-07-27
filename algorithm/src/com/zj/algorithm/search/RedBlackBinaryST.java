package com.zj.algorithm.search;

/**
 * @Description: 红黑二叉查找树：红黑树
 * @author zJun
 * @date Jul 26, 2013 10:37:59 AM
 * 
 */
public class RedBlackBinaryST<Key extends Comparable<Key>, Value> {
	private final boolean RED = true;
	private final boolean BLACK = false;
	private Node root;

	public class Node {
		private Node left, right;
		private int N;
		private Key key;
		private Value value;
		private boolean color;

		public Node(Key key, Value value, boolean color, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
			this.color = color;
		}

	}

	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	public Node put(Node node, Key key, Value value) {
		if (node == null) {
			return new Node(key, value, RED, 1);
		}
		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			node.left = put(node.left, key, value);
		} else if (cmp > 0) {
			node.right = put(node.right, key, value);
		} else {
			node.value = value;
		}
		node.N = 1 + size(node.left) + size(node.right);
		// 调整树
		// 如果node的左节点为RED，左节点的左节点为RED，则右旋转
		// 如果node的右节点为RED，node的左节点为BLACK，则旋转
		// 如果node的左右节点均为RED，则左右节点均变色

		if (node.right.color == RED && node.left.color == BLACK) {
			node = rotateLeft(node);
		}
		if (node.left.color == RED && node.left.left.color == RED) {
			node = rotateRight(node);
		}
		if (node.left.color == RED && node.right.color == RED) {
			flipColor(node);
		}
		return node;
	}

	public Value get(Key key) {
		return get(root, key);
	}

	public Value get(Node node, Key key) {
		if (node == null) {
			return null;
		}
		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			return get(node.left, key);
		} else if (cmp > 0) {
			return get(node.right, key);
		} else {
			return node.value;
		}
	}

	public boolean isRed(Node node) {
		if (node == null) {
			return false;
		} else {
			return node.color == RED;
		}
	}

	// 向左旋转
	private Node rotateLeft(Node node) {
		Node x = node.right;
		node.right = x.left;
		x.left = node;
		x.color = node.color;
		node.color = RED;
		x.N = node.N;
		node.N = 1 + size(node.left) + size(node.right);
		return x;
	}

	// 右旋转
	private Node rotateRight(Node node) {
		Node x = node.left;
		node.left = x.right;
		x.right = node;
		x.color = node.color;
		x.N = node.N;
		node.N = 1 + size(node.left) + size(node.right);
		return x;
	}

	private void flipColor(Node node) {
		node.color = !node.color;
		node.left.color = !node.left.color;
		node.right.color = !node.right.color;
	}

	public int size(Node node) {
		if (node == null) {
			return 0;
		} else {
			return node.N;
		}

	}
}
