package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2304 {

	static class Building{
		int r;
		int c;
		public Building(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Building> s = new Stack<>();
		List<Building> list = new ArrayList<>();
		
		int maxR = 0;
		int maxH = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new Building(r, c));
		}
		Collections.sort(list, new Comparator<Building>() {
			@Override
			public int compare(Building o1, Building o2) {
				return o1.r-o2.r;
			}
		});
//		for(Building a : list) {
//			System.out.println(a.r+" "+a.c);
//		}

		for(int i=0; i<list.size(); i++) {
			if(!s.isEmpty() && list.get(i).c > s.peek().c) {
				if(list.get(i).c > maxH) {
					while(s.peek().c != maxH) {
						s.pop();
					}
				}else {
					while(s.peek().c<list.get(i).c) {
						s.pop();
					}
				}
			}
			maxH = Math.max(maxH, list.get(i).c);
			s.push(list.get(i));
		}
		
		int sum = 0;
		while(!s.isEmpty()) {
			Building cur = s.pop();
			
			sum += cur.c;
			if(s.isEmpty()) continue;
			
			if(cur.c < s.peek().c) {
				sum += (cur.r-(s.peek().r+1))*cur.c;
			}else {
				sum += (cur.r-(s.peek().r+1))*s.peek().c;
			}
		}
		System.out.println(sum);
		
	}

}
