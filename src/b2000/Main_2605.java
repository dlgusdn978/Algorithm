package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2605 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		
		for(int i=1; i<=n; i++) {
			// arr[i] = pop count ¼ö
			for(int j=0; j<arr[i]; j++) {
				if(!s1.isEmpty()) s2.push(s1.pop());
			}
			s1.push(i);
			while(!s2.isEmpty()) {
				s1.push(s2.pop());
			}
		}
		for(int a : s1) {
			sb.append(a+" ");
		}
		System.out.println(sb.toString());
	}

}
