package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1182 {

	static int n, s;
	static int[] arr;
	static int count;
	static int sum;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 정수의 개수
		n = Integer.parseInt(st.nextToken());
		// 정수
		s = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		visit = new boolean[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0,0);
		System.out.println(count);
	}

	static void subset(int index, int select) {
		if(index==arr.length+1) return;
		if(sum==s&& select>=1) {
			count++;
		}
		
		for(int i=index; i<n; i++) {
			sum += arr[i];
			visit[i] = true;
			subset(i+1, select+1);
			visit[i] = false;
			sum -= arr[i];
		}
	}
}
