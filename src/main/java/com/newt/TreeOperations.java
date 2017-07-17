package com.newt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeOperations {

	public static void main(String[] args) {
		Node root = constructTree();
		// postOrderTraversal(root);
		  levelOrderTraversal(root);
		// zigzagTraversal(root);
		// convertBinaryTreeTODoublyLinkedList(root, "start");
		//inOrderTraversalUsingIterativeApproach(root);
		//preOrderTraversalByIterativeApproach(root);
		//postOrderTraversalByIterativeApproach(root);
		
	}

	public static void postOrderTraversal(Node root) {
		if (root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.println(root.data);
		}
	}

	private static void levelOrderTraversal(Node root) {
		Queue<Node> trackingQueue = new LinkedList<>();
		trackingQueue.add(root);

		while (!trackingQueue.isEmpty()) {
			Node node = trackingQueue.poll();
			if (node != null) {
				System.out.println(node.data);
				trackingQueue.add(node.left);
				trackingQueue.add(node.right);
			}
		}
	}

	private static void zigzagTraversal(Node root) {
		Stack<Node> trackingStackOne = new Stack<>();
		Stack<Node> trackingStackTwo = new Stack<>();

		trackingStackOne.push(root);
		while (!trackingStackOne.isEmpty() || !trackingStackTwo.isEmpty()) {
			while (!trackingStackOne.isEmpty()) {
				Node node = trackingStackOne.pop();
				if (node != null) {
					System.out.println(node.data);
					trackingStackTwo.push(node.left);
					trackingStackTwo.push(node.right);
				}
			}

			while (!trackingStackTwo.isEmpty()) {
				Node node = trackingStackTwo.pop();
				if (node != null) {
					System.out.println(node.data);
					trackingStackOne.push(node.right);
					trackingStackOne.push(node.left);
				}
			}
		}
	}

	public static Node constructTree() {
		Node four = new Node(null, null, 4);
		Node five = new Node(null, null, 5);
		Node six = new Node(null, null, 6);
		Node seven = new Node(null, null, 7);
		Node two = new Node(four, five, 2);
		Node three = new Node(six, seven, 3);
		// root
		return new Node(two, three, 1);

	}

	private static void inOrderTraversalUsingIterativeApproach(Node root) {
		Stack<Node> trackingStack = new Stack<>();
		trackingStack.push(root);

		while (!trackingStack.isEmpty()) {
			if (root.left != null) {
				trackingStack.add(root.left);
				root = root.left;
			} else if (root.left == null) {
				Node node = trackingStack.pop();
				System.out.println(node.data);
				if (node.right != null) {
					trackingStack.push(node.right);
					root = node.right;
				}
			}
		}
	}
	
	private static void preOrderTraversalByIterativeApproach(Node root) {
		Stack<Node> trackingStack = new Stack<>();
		trackingStack.push(root);
		
		while (!trackingStack.isEmpty()) {
			Node node = trackingStack.pop();
			if (node != null) {
				System.out.println(node.data);
				if (node.right != null) {
					trackingStack.push(node.right);
				} 
				if (node.left != null) {
					trackingStack.push(node.left);
				}				
			}
		}
	}
	
	private static void postOrderTraversalByIterativeApproach(Node root) {
		Stack<Node> trackingStackOne = new Stack<>();
		Stack<Node> trackingStackTwo = new Stack<>();
		
		trackingStackOne.add(root);
		while (!trackingStackOne.isEmpty()) {
			Node node = trackingStackOne.pop();
			if (node != null) {
				trackingStackTwo.push(node);
				if (node.left != null) {
					trackingStackOne.push(node.left);
				}
				if (node.right != null) {
					trackingStackOne.push(node.right);
				}				
			}
			
		}
		
		int size = trackingStackTwo.size();
		for (int i = 0; i < size ; i++) {
			System.out.println(trackingStackTwo.pop().data);
		}
		
			
	}
}
