package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1991 {

	static class Node{
		char cur;
		Node left, right;
		public Node(char cur, Node left, Node right) {
			this.cur = cur;
			this.left = left;
			this.right = right;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		List<Node> list = new ArrayList<>();
		Node root = new Node('A', null, null);
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			char cur = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			insert(root, cur, left, right);
		}
		
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		
	}
	
	static void insert(Node root, char parent, char left, char right) {
		if(root.cur==parent) {
			root.left = left != '.' ? new Node(left, null, null) : null;
			root.right = right != '.' ? new Node(right, null, null) : null;
		}else {
			if(root.left!=null) insert(root.left, parent, left, right);
			if(root.right!=null) insert(root.right, parent, left, right);
		}
	}
	static void preOrder(Node node) {
		if(node==null) return;
		System.out.print(node.cur);
		preOrder(node.left);
		preOrder(node.right);
	}
	static void inOrder(Node node) {
		if(node==null) return;
		inOrder(node.left);
		System.out.print(node.cur);
		inOrder(node.right);
	}
	static void postOrder(Node node) {
		if(node==null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.cur);
	}
}
