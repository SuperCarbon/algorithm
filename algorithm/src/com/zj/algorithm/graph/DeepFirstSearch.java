package com.zj.algorithm.graph;

public class DeepFirstSearch {
	private boolean[] marked;
	private int count; // 和起点连通（直接或者间接）的顶点数目:如果是连通的则count = G.V()

	public DeepFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	public void dfs(Graph G, int v) {
		marked[v] = true;
		count++;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	public boolean marked(int w) {
		return marked[w];
	}

	public int count() {
		return count;
	}
}
