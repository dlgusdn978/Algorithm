package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2075 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int cur = Integer.parseInt(st.nextToken());
				if(pq.size()<n) {
					pq.add(cur);
				}else {
					if(pq.peek()<cur) {
						pq.poll();
						pq.add(cur);
					}
				}
			}
		}
		System.out.println(pq.poll());
	
		
	}

}
