package b9000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_9934 {

	static class Node{
		int cur, depth;
		Node left, right;
		public Node(int cur, int depth, Node left, Node right) {
			this.cur = cur;
			this.depth = depth;
			this.left = left;
			this.right = right;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int count = (int) Math.pow(2, n)-1;

//		System.out.println(count);
		
		int[] arr = new int[count];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<count; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer>[] list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		makeTree(list, arr, 0, count-1, 0);
		
		for(List<Integer> a : list) {
			for(int b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}

	}

	static void makeTree(List<Integer>[] list, int[] arr, int start, int end, int depth) {
		if(start>end) return;
		
		int mid = (start+end)/2;
		list[depth].add(arr[mid]);
		
		makeTree(list, arr, start, mid-1, depth+1);
		makeTree(list, arr, mid+1, end, depth+1);
	}
	
}
