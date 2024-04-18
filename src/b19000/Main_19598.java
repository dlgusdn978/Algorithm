package b19000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19598 {

	static class Meeting{
		int start;
		int end;
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// n개의 회의를 모두 진행할 수 있는 최소 회의실 개수
		// pq 사용
		// 회의 끝나는 시간이 가장 빠른(작은) 회의를 오름차순으로 정렬
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		List<Meeting> list = new ArrayList<>();
		// 회의의 수 n
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Meeting> q = new PriorityQueue<Meeting>( new Comparator<Meeting>() {

			@Override
			public int compare(Meeting o1, Meeting o2) {
				// TODO Auto-generated method stub
				return o1.end-o2.end;
			}
		});
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.add(new Meeting(start, end));
		}
		
		Collections.sort(list, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				return o1.start==o2.start ? o1.end-o2.end : o1.start-o2.start;
			}
		});
//		for(Meeting a : list) {
//			System.out.println(a.start+" "+a.end);
//		}
		int max = 0;
		for(int i=0; i<list.size(); i++) {
			Meeting cur = q.peek();
			if(!q.isEmpty() && cur.end<=list.get(i).start) {
				q.poll();
			}
			q.add(list.get(i));
			max = Math.max(max, q.size());
		}
		
		System.out.println(q.size());
		
	}

}
