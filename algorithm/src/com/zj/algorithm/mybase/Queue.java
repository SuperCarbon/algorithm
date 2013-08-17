package com.zj.algorithm.mybase;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private int N;
	private Node first;
	private Node last;

	public Queue() {
		first =null;
		last = null;
		N=0;
	}

	private class Node {
		private Item item;
		private Node next;
	}

	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		N++;
	}

	public Item dequeue() {
		if (isEmpty()) {

		}
		Item item = first.item;
		first = first.next;
		N--;
		if (isEmpty()) {
			last = null;
		}
		return item;

	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public Iterator<Item> iterator() {
		return null;
	}
}
