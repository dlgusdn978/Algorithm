package b16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16987 {

	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][2];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			// 내구도
			arr[i][0] = Integer.parseInt(st.nextToken());
			// 무게
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(arr, 0, n);
		System.out.println(max);
	}

	
	static void dfs(int[][] arr, int count, int n) {
		if(count==n) {
			max = Math.max(max, getMax(arr));
			return;
		}
		max = Math.max(max, getMax(arr));
		if(arr[count][0]<=0) dfs(arr, count+1, n);
		else {
			for(int i=0; i<n; i++) {
				if(arr[i][0]<=0 || i==count) continue;
				// 내구도 무게, 내구도 무게
				arr[i][0] -= arr[count][1];
				arr[count][0] -= arr[i][1];
				dfs(arr, count+1, n);
				arr[i][0] += arr[count][1];
				arr[count][0] += arr[i][1];
			}
		}
		
	}
	static void print(int[][] arr) {
		for(int[] a: arr) {
			for(int b: a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
	static int getMax(int[][] arr) {
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i][0]<=0) count++;
		}
		return count;
	}
}
