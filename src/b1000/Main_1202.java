package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1202 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 보석의 개수 n
		int n = Integer.parseInt(st.nextToken());
		
		// 가방의 개수 k
		int k = Integer.parseInt(st.nextToken());
		// 가방 보석 여부
		boolean[] visit = new boolean[k];

		int[][] jewel = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			jewel[i][0] = weight;
			jewel[i][1] = value;
			
		}
		
		Arrays.sort(jewel, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]==o2[0] ? o2[1]-o1[1] : o1[0]-o2[0];
			}
		});
//		
//		for(int[] a : jewel) {
//			System.out.println(a[0]+ " "+a[1]);
//		}
//		
		int[] maxBag = new int[k];
		for(int i=0; i<k; i++) {
			maxBag[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(maxBag);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		long res = 0;
		for(int i=0, j=0; i<k; i++) {
			while(j<n && jewel[j][0]<=maxBag[i]) {
				pq.offer(jewel[j++][1]);
			}
			
			if(!pq.isEmpty()) {
				res += pq.poll();
			}
		}
		
		System.out.println(res);
	}

}
