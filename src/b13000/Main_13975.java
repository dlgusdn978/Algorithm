package b13000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13975 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		// tc ¼ö
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			int n = Integer.parseInt(br.readLine());
			
			PriorityQueue<Long> pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			
			long cost = 0;
			for(int i=0; i<n-1; i++) {
				long left = pq.poll();
				long right = pq.poll();
				long sum = left+right;
				cost+=sum;
				pq.add(sum);
			}
			System.out.println(cost);
		}
	}

}
