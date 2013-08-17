package com.zj.algorithm.mybase;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * 栈：基于链表
 */
public class Stack<Item> implements Iterable<Item> {
	private int N;
	private Node first;

	public Stack() {

	}

	private class Node {
		private Item item;
		private Node next;
	}

	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	public Item pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
