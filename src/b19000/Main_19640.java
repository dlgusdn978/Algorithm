package b19000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_19640 {

	static class Node{
		int days;
		int level;
		int line;
		boolean isDeka;
		public Node(int days, int level, int line, boolean isDeka) {
			this.days = days;
			this.level = level;
			this.line = line;
			this.isDeka = isDeka;
		}
	}
	public static void main(String[] args) throws IOException {
		// n 명의 줄에서 k+1번째에 줄을 섰다.
		// m개의 줄로 나누어 서라.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<List<Node>> list = new ArrayList<>();
		for(int i=0; i<m; i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int days = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			list.get(i%m).add(new Node(days, level, i%m, i==k ? true : false));
		}
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.days==o2.days ?  o1.level==o2.level ? o1.line-o2.line: o2.level-o1.level : o2.days-o1.days ;
			}
			
		});

		int cnt = 0;
		// 초기세팅
		for(List<Node> l : list) {
			if(!l.isEmpty()) pq.add(l.remove(0));
		}
		while(true) {
			Node cur = pq.poll();
			if(cur.isDeka) break;
			if(!list.get(cur.line).isEmpty()) pq.add(list.get(cur.line).remove(0));
			cnt++;
		}
		System.out.println(cnt);
	}

}
