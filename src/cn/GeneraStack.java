package cn;

import java.util.LinkedList;

public class GeneraStack<E> {
	LinkedList<E> mList = new LinkedList<>();

	public void push(E element) {
		mList.add(element);
	}

	// 返回顶部的第一个元素
	public E peek() {
		return mList.getLast();
	}

	// 返回并删除第一个元素
	public E pop() {
		return mList.removeLast();
	}

	// 用于判断队列是否为空
	public boolean isEmpty() {
		return mList.isEmpty();
	}
}
