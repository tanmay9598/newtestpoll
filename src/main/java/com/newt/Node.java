package com.newt;

public class Node {
	Node left;
	Node right;
	int data;
	
	Node(Node left, Node right, int data) {
		this.left = left;
		this.right = right;
		this.data = data;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Node) {
			Node node = (Node)obj;
			
			if (node.data == data) {
				return true;
			}
		}
		return false;
	}
	
	public int hashCode() {		
		return System.identityHashCode(this.data);
	}
}
