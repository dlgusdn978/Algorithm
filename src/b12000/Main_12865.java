package b12000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865 {

	static int n, k, w, v;
	static int[][] arr;
	static int[] weight, price;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 총 물건의 개수
		n = Integer.parseInt(st.nextToken());
		// 버틸 수 있는 무게 k
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][k+1];
		weight = new int[n+1];
		price = new int[n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				if(weight[i]>j) arr[i][j] = arr[i-1][j];
				else arr[i][j] = Math.max(price[i]+arr[i-1][j-weight[i]], arr[i-1][j]);
			}
		}
		System.out.println(arr[n][k]);
	}

	static void print() {
		for(int[] a : arr) {
			for(int b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
}
