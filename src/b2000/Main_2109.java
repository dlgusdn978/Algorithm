package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2109 {

	static class Lecture{
		int val;
		int day;
		public Lecture(int val, int day) {
			this.val = val;
			this.day = day;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		List<Lecture> list = new ArrayList<>();
		
		int maxDay = 0;
		// 값을 오름차순으로 정렬하되, 날짜는 내림차순으로 정렬?
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int val = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());

			list.add(new Lecture(val, day));
			maxDay = Math.max(maxDay, day);
		}
		
		Collections.sort(list, new Comparator<Lecture>() {

			@Override
			public int compare(Lecture o1, Lecture o2) {
				// TODO Auto-generated method stub
				return o2.val==o1.val ? o1.day-o2.day :o2.val-o1.val;
			}
		});
//		for(Lecture a : list) {
//			System.out.println(a.day+" "+a.val);
//		}
		boolean[] checked = new boolean[maxDay+1];
		int count = 0;
		while(!list.isEmpty()) {
			Lecture cur = list.remove(0);
			
			for(int i=cur.day; i>0; i--) {
				if(!checked[i]) {
					checked[i] = true;
					count += cur.val;
					break;
				}
			}
		}

		
		System.out.println(count);
		

	}

}
