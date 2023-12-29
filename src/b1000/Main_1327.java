package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Main_1327 {

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		bfs(arr, n, k);

	}

	static void bfs(int[] arr, int n, int k) {
		int[] sorted = arr.clone();
		Arrays.sort(sorted);
		
		Map<String, Integer> visit = new HashMap<>();
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.add(arr);
		visit.put(Arrays.toString(arr), 0);
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int flips = visit.get(Arrays.toString(cur));
			
			if(Arrays.equals(sorted, cur)) {
				System.out.println(flips);
				return;
			}
			
			for(int i=0; i<=n-k; i++) {
				int[] next = cur.clone();
				for(int j=0; j<k/2; j++) {
					int temp = next[i+j];
					next[i+j] = next[i+k-1-j];
					next[i+k-1-j] = temp;
				}
				if(!visit.containsKey(Arrays.toString(next))) {
					queue.add(next);
					visit.put(Arrays.toString(next), flips+1);
				}
			}
		}
		System.out.println(-1);
	}
}
