package com.zj.algorithm.graph;

import com.zj.algorithm.base.Bag;

/**
 * @Description: 加权无向图
 * @author zJun
 * @date Aug 3, 2013 4:25:34 PM
 */
public class EdgeWeightedGraph {
	private int V;// 顶点总数
	private int E;// 边的总数
	private Bag<Edge>[] adj;

	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Edge>();
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;

	}

	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}

	/*
	 * 和v所有关联的边
	 */
	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	/*
	 * 图的所有边
	 */
	public Iterable<Edge> edges() {
		Bag<Edge> edges = new Bag<Edge>();
		for (int v = 0; v < V; v++) {
			for (Edge e : adj[v]) {
				if (e.other(v) > v) {
					edges.add(e);
				}
			}
		}
		return edges;
	}
}
