package com.google.ex;

class Node {

	int data;
	Node next = null;

	public Node() {
	}

	public Node(int data) {
		this.data = data;
	}

	public String toString() {
		return data + " : "+next;
	}
}

class LinkedList {
	Node head = null;

	public int add(int data) {
		Node temp = new Node(data);
		if (head == null) {
			head = temp;
		}
		else
		{
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = temp;
		}
		return data;
	}

	public Node addAt(int data, int index) {
		int i = 0;
		Node current = head;
		while (i < index) {
			current = current.next;
			i++;
		}
		Node temp = current.next;
		Node newNode = new Node(data);
		current.next = newNode;
		newNode.next = temp;

		return head;
	}

	public Node delete(int index) {
		int i = 0;
		Node current = head;
		Node prev = null;
		while (i < index) {
			prev = current;
			current = current.next;
			i++;
		}

		prev.next = current.next;
		current.next = null;

		return head;
	}

	public void print() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " , ");
			current = current.next;
		}

	}
}

public class App {
	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		list.add(10);
		list.add(20);
		list.add(40);
		list.print();

		System.out.println("\n\n *****  Adding 30 after index 1 " + list.addAt(30, 1));
		System.out.println("\n\n *****  Delete at index 1 " + list.delete(1));
	}
}
