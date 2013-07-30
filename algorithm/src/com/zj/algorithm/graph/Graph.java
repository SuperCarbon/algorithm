package com.zj.algorithm.graph;

import com.zj.algorithm.base.Bag;
import com.zj.algorithm.base.In;

/**
 * @Description:无向图
 * @author zJun
 * @date Jul 30, 2013 8:45:04 PM
 */
public class Graph {
	private final int V;
	private int E;
	private Bag<Integer>[] adj;

	/*
	 * 从标准输入流中读入一幅图
	 */
	public Graph(In in) {
		this(in.readInt());
	}

	/**
	 * Description: 创建一个有v个顶点，但不包含边的图
	 */
	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.V = v;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int i = 0; i < v; i++) {
			adj[i] = new Bag<Integer>();
		}
	}

	/**
	 * @Description:
	 * @return 返回顶点数量
	 * @throws
	 */
	public int V() {
		return V;
	}

	/**
	 * @Description:
	 * @return 返回边数
	 * @throws
	 */
	public int E() {
		return E;
	}

	public void addEdge(int v, int w) {
		if (v < 0 || v > V) {
			throw new IndexOutOfBoundsException();
		}
		if (w < 0 || w > V) {
			throw new IndexOutOfBoundsException();
		}
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	/**
	 * @Description: 计算顶点V的度数
	 * @param G
	 * @param v
	 * @return
	 * @throws
	 */
	public int degree(Graph G, int v) {
		return adj[v].size();
	}

	/*
	 * 计算所有顶点的最大度数
	 */
	public int maxDegree(Graph G) {
		int maxDegree = 0;
		for (int i = 0; i < G.V(); i++) {
			if (adj[i].size() > maxDegree) {
				maxDegree = adj[i].size();
			}
		}
		return maxDegree;
	}

	public int numberOfSelfLoops(Graph G) {
		int loops = 0;
		for (int i = 0; i < G.V(); i++) {
			for (int w : G.adj(i)) {
				if (w == i) {
					loops++;
				}
			}
		}

		return loops;
	}

}
