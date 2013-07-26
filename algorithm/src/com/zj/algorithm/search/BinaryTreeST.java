package com.zj.algorithm.search;

/**
 * @ClassName: BinaryTreeST
 * @Description: 基于二叉查找树的符号表
 * @author zJun
 * @date Jul 22, 2013 3:25:54 PM
 */
public class BinaryTreeST<Key extends Comparable<Key>, Value> {

	private Node root;// 根节点

	private class Node {
		private Node left, right;
		private Key key;
		private Value value;
		private int N; // node节点下节点的总数目

		public Node(Key key, Value value, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
		}

		public Value get(Key key) {
			return get(root, key);
		}

		private Value get(Node node, Key key) {
			if (node == null)
				return null;

			int cmp = key.compareTo(node.key);
			if (cmp < 0) {
				return get(node.left, key);
			} else if (cmp > 0) {
				return get(node.right, key);
			} else {
				return node.value;
			}

		}

		public void put(Key key, Value value) {
			root = put(root, key, value);
		}

		private Node put(Node node, Key key, Value value) {
			if (node == null) {
				return new Node(key, value, 1);
			}
			int cmp = key.compareTo(node.key);
			if (cmp < 0) {
				node.left = put(node.left, key, value);
			} else if (cmp > 0) {
				node.right = put(node.right, key, value);
			} else {
				node.value = value;
			}
			node.N = size(node.left) + size(node.right) + 1;
			return node;
		}

		public int size(Node node) {
			return node.N;
		}

	}
}
