package cn;

import java.util.LinkedList;

public class GeneraStack<E> {
	LinkedList<E> mList = new LinkedList<>();

	public void push(E element) {
		mList.add(element);
	}

	// ���ض����ĵ�һ��Ԫ��
	public E peek() {
		return mList.getLast();
	}

	// ���ز�ɾ����һ��Ԫ��
	public E pop() {
		return mList.removeLast();
	}

	// �����ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return mList.isEmpty();
	}
}
