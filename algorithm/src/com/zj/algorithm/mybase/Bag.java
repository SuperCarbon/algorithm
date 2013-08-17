package com.zj.algorithm.mybase;

import java.util.Iterator;

/*
 * 基于链表结构的背包
 */
public class Bag<Item> implements Iterable<Item> {
	// 背包的大小
	private int N;
	private Node first;

	// 创建一个背包
	public Bag() {

	}

	private class Node {
		private Item item;
		private Node next;
	}

	// 增加一个元素
	public void add(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	// 背包是否为空
	public boolean isEmpty() {
		return first == null;
	}

	// 迭代背包中的元素
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	public class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current.next != null;
		}

		public Item next() {
			if(!hasNext()){
				
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
}
