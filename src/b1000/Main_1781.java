package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1781 {

	static class Node{
		int day;
		int count;
		public Node(int day, int count) {
			this.day = day;
			this.count = count;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.count-o2.count;
			}
		});
		// ¼÷Á¦ÀÇ °³¼ö n
		int n = Integer.parseInt(br.readLine());

		int max= Integer.MIN_VALUE;
		Node[] arr = new Node[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			arr[i] = new Node(day, count);
			max = Math.max(day, max);
		}
		Arrays.sort(arr, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.day-o2.day;
			}
		});
//		for(Node node : arr) {
//			System.out.println(node.day+" "+node.count);
//		}
		int day = 1;
		int sum = 0;
		for(int i=0; i<n; i++) {
			Node cur = arr[i];
			if(day<=cur.day) {
				pq.add(new Node(cur.day, cur.count));
				day++;
			}else {
				Node first = pq.poll();
				if(first.count<cur.count) pq.add(new Node(cur.day, cur.count));
				else pq.add(first);
			}
			
		}

		for(Node node : pq) {
			sum+= node.count;
		}
		System.out.println(sum);
	}

}
