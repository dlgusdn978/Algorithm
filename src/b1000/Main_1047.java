package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1047 {

	static class Node{
		int r;
		int c;
		int weight;
		public Node(int r, int c, int weight) {
			this.r = r;
			this.c = c;
			this.weight = weight;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		List<Node> list = new ArrayList<>();
		// 나무 수
		int n = Integer.parseInt(br.readLine());
		// 나무 좌표, 만들 수 있는 울타리 갯수
		int nr = 0;
		int nc = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.add(new Node(r, c, weight));
			if(r>nr) nr = r;
			if(c>nc) nc = c;
		}
		
		System.out.println(nr+" "+nc);
//		Collections.sort(list, new Comparator<Node>() {
//			@Override
//			public int compare(Node o1, Node o2) {
//				// TODO Auto-generated method stub
//				return (Math.abs(nr/2 - o2.r)+Math.abs(nc/2 - o2.c))-(Math.abs(nr/2 - o1.r)+Math.abs(nc/2 - o1.c));
//			}
//		});
		for(Node node: list) {
			System.out.println(node.r+" "+node.c+" "+node.weight);
		}
		int[][] arr = new int[nr+1][nc+1];
		for(Node node : list) {
			arr[node.r][node.c] = node.weight;
		}
	
		for(int[] a : arr) {
			for(int b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}

	}

}
