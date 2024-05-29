package b18000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_18115 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		// 1 1 1 1 1
		// 1 2 3 4 5
		
		// 5 4 3 2 1
		
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=n; i>=1; i--) {
			int num = n-i+1;
			switch(arr[i-1]) {
			case 1:
				dq.addFirst(num);
				break;
			case 2:
				int top = dq.pollFirst();
				dq.addFirst(num);
				dq.addFirst(top);
				break;
			case 3:
				dq.addLast(num);
				break;
			}
		}
		
		for(int a : dq) {
			sb.append(a+" ");
		}
		System.out.println(sb.toString());

	}

}
