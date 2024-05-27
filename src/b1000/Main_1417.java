package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1417 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		//ÇöÀç µæÇ¥¼ö
		int cur = Integer.parseInt(br.readLine());
		int count = 0;
		for(int i=1; i<n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		while(!pq.isEmpty()&&cur<=pq.peek()) {
			int next = pq.poll();
//			System.out.println(next);
			cur++;
			count++;
			next--;
			if(next==0) continue;
			pq.add(next);
		}
		System.out.println(count);

		
	}

}
