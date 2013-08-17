package com.zj.algorithm.mybase;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * 可扩展容量的栈：基于数组
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
	private int N;
	private Item[] items;

	@SuppressWarnings("unchecked")
	public ResizingArrayStack() {
		items = (Item[]) new Object[2];
	}

	public void push(Item item) {
		// 首先检查栈的容量,如果栈满了(N=items.length)，则增加栈的容量
		if (N == items.length) {
			resize(2 * items.length);
		}
		items[N++] = item;

	}

	public Item pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("");
		}
		Item item = items[N - 1];
		items[N - 1] = null;
		N--;
		if (N > 0 && N == items.length / 4) {
			resize(items.length / 2);
		}
		return item;
	}

	public void resize(int n) {
		@SuppressWarnings("unchecked")
		Item[] tempItems = (Item[]) new Object[n];
		for (int i = 0; i < N; i++) {
			tempItems[i] = items[i];
		}
		items = tempItems;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public Iterator<Item> iterator() {
		return null;
	}
}
