package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_test {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int total = 0;
		for(int i=0; i<n-1; i++) {
			int left = pq.poll();
			int right = pq.poll();
			total += left+right;
			pq.add(left+right);
		}
		
		System.out.println(total);

	}

}
