package b13000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13904 {

	static class Node{
		int day;
		int score;
		public Node(int day, int score) {
			this.day = day;
			this.score = score;
		}
	}
	static boolean[] visit = new boolean[1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {return o1-o2;}) ;
		int n = Integer.parseInt(br.readLine());
		
		Node[] arr = new Node[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Node[] temp = arr.clone();
		Arrays.sort(arr, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.day==o2.day ? o1.score-o2.score : o1.day-o2.day;
			}
		});

//		for(Node node : arr) {
//			System.out.println(node.day+" "+node.score);
//		}
		// 날짜별, 점수별 정렬을 먼저 수행하고
		// 중복되는 날짜가 존재하는 경우 앞에서부터 제거하며 pq에 삽입.
		int curday = 1;
		for(int i=0; i<n; i++) {
			Node cur = arr[i];
			int day = cur.day;
			int score = cur.score;
			
			if(curday<=day) {
				pq.add(score);
				visit[day] = true;
				curday++;
			}
			else {
				int first = pq.poll();
				if(first<score) pq.add(score);
				else pq.add(first);
			}
			
		}
//		System.out.println(pq);
		int total = 0;
		while(!pq.isEmpty()) {
			total+=pq.poll();
		}
		System.out.println(total);
	}

}
