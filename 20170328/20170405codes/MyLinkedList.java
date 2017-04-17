package com._520it.linked;

//����˫����������
public class MyLinkedList {
	protected Node first;//�����ĵ�һ���ڵ�
	protected Node last;//���������һ���ڵ�
	protected int size = 0;//�ڵ������

	public Node search(Object ele) {
		Node current = this.first;
		for (int i = 0; i < size; i++) {
			if (!current.ele.equals(ele)) {
				if (current.next == null) {
					return null;
				}
				current = current.next;

			}
		}
		return current;
	}

	public void remove(Object ele) {
		//�ҵ���ɾ���Ľڵ�
		Node current = this.first;
		for (int i = 0; i < size; i++) {
			if (!current.ele.equals(ele)) {
				if (current.next == null) {
					return;
				}
				current = current.next;

			}
		}
		//ɾ���ڵ�:
		if (current == first) {
			this.first = current.next;
			this.first.prev = null;
		} else if (current == last) {
			this.last = current.prev;
			this.last.next = null;
		} else {
			//��ɾ����ǰ�ڵ����һ���ڵ���Ϊɾ���ڵ���һ���ڵ��next
			current.prev.next = current.next;
			//��ɾ���ڵ����һ���ڵ���Ϊɾ���ڵ���һ���ڵ��prev
			current.next.prev = current.prev;
		}
		size--;
	}

	public void addFirst(Object ele) {
		Node node = new Node(ele);//��Ҫ����Ľڵ����
		if (size == 0) {
			this.first = node;
			this.last = node;
		} else {
			//��֮ǰ��һ����Ϊ�����ڵ����һ���ڵ�
			node.next = this.first;
			//�������ڵ���Ϊ֮ǰ��һ���ڵ����һ���ڵ�
			this.first.prev = node;
			//�������ڵ���Ϊ��һ���ڵ�
			this.first = node;
		}

		size++;
	}

	public void addLast(Object ele) {
		Node node = new Node(ele);//��Ҫ����Ľڵ����
		if (size == 0) {
			this.first = node;
			this.last = node;
		} else {
			//�������ڵ���Ϊ֮ǰ���һ������һ���ڵ�
			this.last.next = node;
			//��֮ǰ���һ���ڵ���Ϊ�����ڵ����һ���ڵ�
			node.prev = this.last;
			//�������ڵ���Ϊ���һ���ڵ�
			this.last = node;
		}
		size++;
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder(size * 2 + 1);
		Node current = this.first;//��һ���ڵ�
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append(current.ele);
			if (i != size - 1) {
				sb.append(",");
			} else {
				sb.append("]");
			}
			current = current.next;//��ȡ�Լ�����һ���ڵ�
		}
		return sb.toString();
	}

	//�����е�ÿһ���ڵ�
	protected class Node {
		Node prev;//��һ���ڵ����
		Node next;//��һ���ڵ����
		public Object ele;//��ǰ�ڵ��д洢������

		public Node(Object ele) {
			this.ele = ele;
		}
	}

}